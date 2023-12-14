package one.callum.nether_expanded.entity.client.model;// Made with Blockbench 4.9.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Cow;
import one.callum.nether_expanded.entity.animations.NetherCowAnimations;
import org.joml.Vector3f;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;

public class NetherCowModel<T extends Entity> extends HierarchicalModel<T> {
	private static final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();
	private final ModelPart nether_cow;
	private final ModelPart head;

	public NetherCowModel(ModelPart root) {
		this.nether_cow = root.getChild("nether_cow");
		this.head = root.getChild("nether_cow").getChild("head");
	}

	@Override
	public ModelPart root() {
		return this.nether_cow;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch);

		this.animateWalk(NetherCowAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
	}

	protected void animateWalk(AnimationDefinition pAnimationDefinition, float pLimbSwing, float pLimbSwingAmount, float pMaxAnimationSpeed, float pAnimationScaleFactor) {
		long i = (long)(pLimbSwing * 50.0F * pMaxAnimationSpeed);
		float f = Math.min(pLimbSwingAmount * pAnimationScaleFactor, 1.0F);
		KeyframeAnimations.animate(this, pAnimationDefinition, i, f, ANIMATION_VECTOR_CACHE);
	}

	public void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30f, 30f);
		pHeadPitch	= Mth.clamp(pHeadPitch, -25f, 45f);

		this.head.yRot = pNetHeadYaw * ((float) Math.PI / 180f);
		this.head.xRot = pHeadPitch * ((float) Math.PI / 180f);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition nether_cow = partdefinition.addOrReplaceChild("nether_cow", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_legs = nether_cow.addOrReplaceChild("right_legs", CubeListBuilder.create(), PartPose.offset(-8.0F, 0.0F, 0.0F));

		PartDefinition front_leg_r = right_legs.addOrReplaceChild("front_leg_r", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -11.0F, -5.0F));

		PartDefinition back_leg_r = right_legs.addOrReplaceChild("back_leg_r", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -12.0F, 7.0F));

		PartDefinition left_legs = nether_cow.addOrReplaceChild("left_legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition front_leg_l = left_legs.addOrReplaceChild("front_leg_l", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -12.0F, -5.0F));

		PartDefinition back_leg_l = left_legs.addOrReplaceChild("back_leg_l", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -12.0F, 7.0F));

		PartDefinition head = nether_cow.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 28).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(12, 0).addBox(-5.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.0F, -8.0F));

		PartDefinition body = nether_cow.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -22.0F, -8.0F, 12.0F, 10.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(28, 28).addBox(-2.0F, -12.0F, 4.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		nether_cow.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}