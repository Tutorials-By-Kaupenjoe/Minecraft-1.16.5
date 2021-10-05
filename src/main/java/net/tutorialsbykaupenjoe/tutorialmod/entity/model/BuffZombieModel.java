package net.tutorialsbykaupenjoe.tutorialmod.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.tutorialsbykaupenjoe.tutorialmod.entity.custom.BuffZombieEntity;

public class BuffZombieModel <T extends BuffZombieEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer rightLeg;
    private final ModelRenderer rightArm;
    private final ModelRenderer bone2;
    private final ModelRenderer rightArm_r1;
    private final ModelRenderer cube_r1_r1;
    private final ModelRenderer bone3;
    private final ModelRenderer rightArm_r2;
    private final ModelRenderer cube_r1_r3;
    private final ModelRenderer leftLeg;
    private final ModelRenderer leftArm;
    private final ModelRenderer bone;
    private final ModelRenderer cube_r1_r2;
    private final ModelRenderer leftArm_r1;

    public BuffZombieModel() {
        textureWidth = 128;
        textureHeight = 128;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.5F, -4.0F, 0.0F);
        head.setTextureOffset(0, 28).addBox(-6.0F, -12.0F, -6.0F, 11.0F, 12.0F, 13.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 26.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-9.0F, -31.0F, -4.0F, 18.0F, 18.0F, 9.0F, 0.0F, false);

        rightLeg = new ModelRenderer(this);
        rightLeg.setRotationPoint(-4.0F, 11.0F, 1.0F);
        rightLeg.setTextureOffset(55, 0).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 13.0F, 7.0F, 0.0F, false);

        rightArm = new ModelRenderer(this);
        rightArm.setRotationPoint(-8.0F, -1.0F, -4.0F);


        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(-17.0F, 27.0F, 0.0F);
        rightArm.addChild(bone2);


        rightArm_r1 = new ModelRenderer(this);
        rightArm_r1.setRotationPoint(25.0F, 0.0F, 0.0F);
        bone2.addChild(rightArm_r1);
        setRotationAngle(rightArm_r1, -1.5708F, 0.0F, 0.0F);
        rightArm_r1.setTextureOffset(42, 47).addBox(-16.0F, -6.0F, -30.0F, 7.0F, 19.0F, 7.0F, 0.0F, false);

        cube_r1_r1 = new ModelRenderer(this);
        cube_r1_r1.setRotationPoint(0.0F, 0.0F, -4.0F);
        bone2.addChild(cube_r1_r1);
        setRotationAngle(cube_r1_r1, 0.3491F, 0.0F, 0.0F);
        cube_r1_r1.setTextureOffset(35, 28).addBox(9.3F, -31.2F, -7.9F, 1.0F, -1.0F, 4.0F, 0.0F, false);
        cube_r1_r1.setTextureOffset(35, 28).addBox(12.1F, -31.2F, -7.9F, 1.0F, -1.0F, 4.0F, 0.0F, false);
        cube_r1_r1.setTextureOffset(35, 28).addBox(14.8F, -31.2F, -7.9F, 1.0F, -1.0F, 4.0F, 0.0F, false);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(-17.0F, 27.0F, 0.0F);
        rightArm.addChild(bone3);
        bone3.setTextureOffset(44, 78).addBox(12.1F, -28.0F, -19.0F, 1.0F, -1.0F, 13.0F, 0.0F, false);
        bone3.setTextureOffset(42, 75).addBox(14.8F, -28.0F, -19.0F, 1.0F, -1.0F, 13.0F, 0.0F, false);
        bone3.setTextureOffset(42, 81).addBox(9.3F, -28.0F, -19.0F, 1.0F, -1.0F, 13.0F, 0.0F, false);

        rightArm_r2 = new ModelRenderer(this);
        rightArm_r2.setRotationPoint(25.0F, 0.0F, 0.0F);
        bone3.addChild(rightArm_r2);
        setRotationAngle(rightArm_r2, -1.5708F, 0.0F, 0.0F);
        rightArm_r2.setTextureOffset(42, 47).addBox(-16.0F, -6.0F, -30.0F, 7.0F, 19.0F, 7.0F, 0.0F, false);

        cube_r1_r3 = new ModelRenderer(this);
        cube_r1_r3.setRotationPoint(0.0F, 0.0F, -4.0F);
        bone3.addChild(cube_r1_r3);
        setRotationAngle(cube_r1_r3, 0.3491F, 0.0F, 0.0F);


        leftLeg = new ModelRenderer(this);
        leftLeg.setRotationPoint(4.0F, 11.0F, 0.0F);
        leftLeg.setTextureOffset(0, 54).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 13.0F, 7.0F, 0.0F, false);

        leftArm = new ModelRenderer(this);
        leftArm.setRotationPoint(8.0F, -1.0F, 0.0F);


        bone = new ModelRenderer(this);
        bone.setRotationPoint(-8.0F, 27.0F, 0.0F);
        leftArm.addChild(bone);
        bone.setTextureOffset(44, 82).addBox(14.8F, -28.0F, -23.0F, 1.0F, -1.0F, 13.0F, 0.0F, false);
        bone.setTextureOffset(44, 82).addBox(12.1F, -28.0F, -23.0F, 1.0F, -1.0F, 13.0F, 0.0F, false);
        bone.setTextureOffset(41, 78).addBox(9.3F, -28.0F, -23.0F, 1.0F, -1.0F, 13.0F, 0.0F, false);

        cube_r1_r2 = new ModelRenderer(this);
        cube_r1_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r1_r2);
        setRotationAngle(cube_r1_r2, 0.3491F, 0.0F, 0.0F);
        cube_r1_r2.setTextureOffset(3, 28).addBox(14.8F, -34.2F, -15.5F, 1.0F, -1.0F, 4.0F, 0.0F, false);
        cube_r1_r2.setTextureOffset(1, 28).addBox(12.1F, -34.2F, -15.5F, 1.0F, -1.0F, 4.0F, 0.0F, false);
        cube_r1_r2.setTextureOffset(0, 32).addBox(9.3F, -34.2F, -15.5F, 1.0F, -1.0F, 4.0F, 0.0F, false);

        leftArm_r1 = new ModelRenderer(this);
        leftArm_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(leftArm_r1);
        setRotationAngle(leftArm_r1, -1.5708F, 0.0F, 0.0F);
        leftArm_r1.setTextureOffset(49, 21).addBox(9.0F, -3.0F, -30.0F, 7.0F, 19.0F, 7.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount,
                                  float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight,
                       int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
        leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
