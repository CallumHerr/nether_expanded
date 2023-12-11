package one.callum.nether_expanded.entity.client.renderer;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.entity.client.ModModelLayers;
import one.callum.nether_expanded.entity.client.model.NetherCowModel;
import one.callum.nether_expanded.entity.custom.NetherCow;
import one.callum.nether_expanded.entity.variant.NetherCowVariant;

import java.util.Map;

public class NetherCowRenderer extends MobRenderer<NetherCow, NetherCowModel<NetherCow>> {
    public static final Map<NetherCowVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(NetherCowVariant.class), (map) -> {
                map.put(NetherCowVariant.CRIMSON,
                        new ResourceLocation(NetherExpanded.MODID, "textures/entity/crimson_cow.png"));
                map.put(NetherCowVariant.WARPED,
                        new ResourceLocation(NetherExpanded.MODID, "textures/entity/warped_cow.png"));
            });

    public NetherCowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,
                new NetherCowModel<>(pContext.bakeLayer(ModModelLayers.WARPED_COW)),
                2f);
    }

    @Override
    public void render(NetherCow pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(NetherCow pEntity) {
        return LOCATION_BY_VARIANT.get(pEntity.getVariant());
    }
}
