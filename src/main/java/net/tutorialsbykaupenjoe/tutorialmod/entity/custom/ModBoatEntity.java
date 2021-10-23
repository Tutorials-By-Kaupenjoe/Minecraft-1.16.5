package net.tutorialsbykaupenjoe.tutorialmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;
import net.tutorialsbykaupenjoe.tutorialmod.entity.ModEntityTypes;
import net.tutorialsbykaupenjoe.tutorialmod.item.ModItems;

import javax.annotation.Nonnull;

public class ModBoatEntity extends BoatEntity {
    private static final DataParameter<String> WOOD_TYPE
            = EntityDataManager.createKey(ModBoatEntity.class, DataSerializers.STRING);

    public ModBoatEntity(EntityType<? extends BoatEntity> type, World world) {
        super(type, world);
        this.preventEntitySpawning = true;
    }

    public ModBoatEntity(World worldIn, double x, double y, double z) {
        this(ModEntityTypes.REDWOOD_BOAT.get(), worldIn);
        this.setPosition(x, y, z);
        this.setMotion(Vector3d.ZERO);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(WOOD_TYPE, "redwood");
    }

    @Override
    protected void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        compound.putString("Type", this.getWoodType());
    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putString("Type", this.getWoodType());
    }

    public String getWoodType() {
        return this.dataManager.get(WOOD_TYPE);
    }

    public void setWoodType(String wood) {
        this.dataManager.set(WOOD_TYPE, wood);
    }

    @Override
    public Item getItemBoat() {
        switch(this.getWoodType()) {
            case "redwood":
                return ModItems.REDWOOD_BOAT.get();
            default:
                return ModItems.REDWOOD_BOAT.get();
        }
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(ForgeRegistries.ITEMS.getValue(
                new ResourceLocation(TutorialMod.MOD_ID, this.getWoodType() + "_boat")));
    }

    @Nonnull
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
