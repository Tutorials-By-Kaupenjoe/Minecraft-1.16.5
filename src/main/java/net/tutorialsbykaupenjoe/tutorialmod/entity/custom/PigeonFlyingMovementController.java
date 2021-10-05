package net.tutorialsbykaupenjoe.tutorialmod.entity.custom;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.util.math.MathHelper;

public class PigeonFlyingMovementController extends FlyingMovementController
{
    private int field_226323_i_ = 0;
    private boolean field_226324_j_ = false;

    public PigeonFlyingMovementController(MobEntity p_i225710_1_, int p_i225710_2_, boolean p_i225710_3_)
    {
        super(p_i225710_1_, p_i225710_2_, p_i225710_3_);
        this.field_226323_i_ = field_226323_i_;
        this.field_226324_j_ = field_226324_j_;
    }

    @Override
    public void tick()
    {
        if (this.action == Action.MOVE_TO)
        {
            this.action = Action.WAIT;
            this.mob.setNoGravity(true);
            double d0 = this.posX - this.mob.getPosX();
            double d1 = this.posY - this.mob.getPosY();
            double d2 = this.posZ - this.mob.getPosZ();
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            if (d3 < (double)2.5000003E-7F)
            {
                this.mob.setMoveVertical(2.0F);
                this.mob.setMoveForward(2.0F);
                return;
            }

            float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
            this.mob.rotationYaw = this.limitAngle(this.mob.rotationYaw, f, 90.0F);
            float f1;
            if (this.mob.isOnGround())
            {
                f1 = (float)(this.speed * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED));
            }
            else
            {
                f1 = (float)(this.speed * this.mob.getAttributeValue(Attributes.FLYING_SPEED));
            }

            this.mob.setAIMoveSpeed(f1);
            double d4 = MathHelper.sqrt(d0 * d0 + d2 * d2);
            float f2 = (float)(-(MathHelper.atan2(d1, d4) * (double)(180F / (float)Math.PI)));
            this.mob.rotationPitch = this.limitAngle(this.mob.rotationPitch, f2, (float)this.field_226323_i_);
            this.mob.setMoveVertical(d1 > 0.0D ? f1 : -f1);
        }
        else
        {
            if (!this.field_226324_j_)
            {
                this.mob.setNoGravity(false);
            }

            this.mob.setMoveVertical(2.0F);
            this.mob.setMoveForward(2.0F);
        }
    }
}
