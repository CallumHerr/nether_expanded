package one.callum.nether_expanded.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.entity.custom.NetherCow;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NetherExpanded.MODID);

    public static final RegistryObject<EntityType<NetherCow>> NETHER_COW =
            ENTITY_TYPES.register("nether_cow", () -> EntityType.Builder.of(NetherCow::new, MobCategory.MONSTER)
                    .sized(0.9f, 1.4f).build("nether_cow"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
