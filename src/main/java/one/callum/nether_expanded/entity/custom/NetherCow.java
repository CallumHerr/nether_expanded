package one.callum.nether_expanded.entity.custom;

import com.mojang.logging.LogUtils;
import net.minecraft.Util;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.CowModel;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.BiomeSources;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import one.callum.nether_expanded.entity.ModEntities;
import one.callum.nether_expanded.entity.variant.NetherCowVariant;
import one.callum.nether_expanded.item.ModItems;
import one.callum.nether_expanded.util.ModTags;
import org.jetbrains.annotations.Nullable;

public class NetherCow extends Animal {

    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(NetherCow.class, EntityDataSerializers.INT);

    public NetherCow(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D,
                Ingredient.of(Items.CRIMSON_FUNGUS, Items.WARPED_FUNGUS),false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    public static boolean checkSpawnRules(EntityType<NetherCow> pAnimal, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return true;
    }


    @Override
    public float getWalkTargetValue(BlockPos pPos, LevelReader pLevel) {
        return 10f;
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.CRIMSON_FUNGUS) || pStack.is(Items.WARPED_FUNGUS);
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (itemStack.is(Items.GLASS_BOTTLE) && !this.isBaby()) {
            pPlayer.hurt(this.damageSources().inFire(), 1);
            itemStack.shrink(1);
            if (itemStack.isEmpty()) {
                pPlayer.setItemInHand(pHand, new ItemStack(ModItems.LAVA_WAX.get()));
            } else if (!pPlayer.getInventory().add(new ItemStack(ModItems.LAVA_WAX.get()))) {
                pPlayer.drop(new ItemStack(ModItems.LAVA_WAX.get()), false);
            }

            if (this.level().isClientSide()) pPlayer.awardStat(Stats.ITEM_USED.get(Items.GLASS_BOTTLE));
            return InteractionResult.sidedSuccess(this.level().isClientSide());
        }
        return super.mobInteract(pPlayer, pHand);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.2F);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource.is(DamageTypes.ON_FIRE) || pSource.is(DamageTypes.IN_FIRE)) return false;
        return super.hurt(pSource, pAmount);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("variant"));
        this.setTypeVariant(tag.getInt("variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("variant", this.getTypeVariant());
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.COW_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.COW_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.COW_DEATH;
    }

    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
        this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        NetherCowVariant otherVariant = ((NetherCow) pOtherParent).getVariant();
        if (otherVariant != this.getVariant()) {
            return EntityType.MOOSHROOM.create(pLevel);
        } else {
            NetherCow baby = ModEntities.NETHER_COW.get().create(pLevel);
            baby.setVariant(this.getVariant());
            return baby ;
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        if (pLevel.getBiome(this.blockPosition()).is(Biomes.CRIMSON_FOREST)) {
            setVariant(NetherCowVariant.CRIMSON);
        } else if (pLevel.getBiome(this.blockPosition()).is(Biomes.WARPED_FOREST)) {
            setVariant(NetherCowVariant.WARPED);
        } else {
            NetherCowVariant variant = Util.getRandom(NetherCowVariant.values(), this.random);
            setVariant(variant);
        }
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    public NetherCowVariant getVariant() {
        return NetherCowVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(NetherCowVariant variant) {
        this.setTypeVariant(variant.getId() & 255 | variant.getId() & -256);
    }

    private void setTypeVariant(int id) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, id);
    }
}
