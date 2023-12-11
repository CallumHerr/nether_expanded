package one.callum.nether_expanded.event;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import one.callum.nether_expanded.NetherExpanded;
import one.callum.nether_expanded.entity.ModEntities;
import one.callum.nether_expanded.entity.custom.NetherCow;

@Mod.EventBusSubscriber(modid = NetherExpanded.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.NETHER_COW.get(), NetherCow.createAttributes().build());
    }

    @SubscribeEvent
    public static void entitySpawnRestrictions(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.NETHER_COW.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                NetherCow::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
