package com.slomaxonical.croptopia.chocolaterie.blocks;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.slomaxonical.croptopia.chocolaterie.registry.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class CandleChocolateCakeBlock extends AbstractCandleBlock {
    public static final BooleanProperty LIT = AbstractCandleBlock.LIT;
    protected static final float AABB_OFFSET = 1.0F;
    protected static final VoxelShape CAKE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
    protected static final VoxelShape CANDLE_SHAPE = Block.box(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D);
    protected static final VoxelShape SHAPE = Shapes.or(CAKE_SHAPE, CANDLE_SHAPE);
    private static final Map<Block, CandleChocolateCakeBlock> BY_CANDLE = Maps.newHashMap();
    private static final Iterable<Vec3> PARTICLE_OFFSETS = ImmutableList.of(new Vec3(0.5D, 1.0D, 0.5D));

    public CandleChocolateCakeBlock(Block candle, Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false));
        BY_CANDLE.put(candle, this);
    }

    @Override
    protected Iterable<Vec3> getParticleOffsets(BlockState state) {
        return PARTICLE_OFFSETS;
    }
    public VoxelShape getShape(BlockState state, BlockGetter p_152876_, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!itemstack.is(Items.FLINT_AND_STEEL) && !itemstack.is(Items.FIRE_CHARGE)) {
            if (candleHit(hitResult) && player.getItemInHand(hand).isEmpty() && state.getValue(LIT)) {
                extinguish(player, state, world, pos);
                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                InteractionResult interactionresult = ChocolateCakeBlock.eat(world, pos, BlockRegistry.CHOCOLATE_CAKE.get().defaultBlockState(), player);
                if (interactionresult.consumesAction()) {
                    dropResources(state, world, pos);
                }

                return interactionresult;
            }
        } else {
            return InteractionResult.PASS;
        }
    }
    private static boolean candleHit(BlockHitResult p_152907_) {
        return p_152907_.getLocation().y - (double)p_152907_.getBlockPos().getY() > 0.5D;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_152905_) {
        p_152905_.add(LIT);
    }

    public ItemStack getCloneItemStack(BlockGetter p_152862_, BlockPos p_152863_, BlockState p_152864_) {
        return new ItemStack(BlockRegistry.CHOCOLATE_CAKE.get());
    }

    public BlockState updateShape(BlockState p_152898_, Direction p_152899_, BlockState p_152900_, LevelAccessor p_152901_, BlockPos p_152902_, BlockPos p_152903_) {
        return p_152899_ == Direction.DOWN && !p_152898_.canSurvive(p_152901_, p_152902_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_152898_, p_152899_, p_152900_, p_152901_, p_152902_, p_152903_);
    }

    public boolean canSurvive(BlockState p_152891_, LevelReader p_152892_, BlockPos p_152893_) {
        return p_152892_.getBlockState(p_152893_.below()).isSolid();
    }

    public int getAnalogOutputSignal(BlockState p_152880_, Level p_152881_, BlockPos p_152882_) {
        return CakeBlock.FULL_CAKE_SIGNAL;
    }

    public boolean hasAnalogOutputSignal(BlockState p_152909_) {
        return true;
    }

    public boolean isPathfindable(BlockState p_152870_, BlockGetter p_152871_, BlockPos p_152872_, PathComputationType p_152873_) {
        return false;
    }

    public static BlockState byCandle(Block p_152866_) {
        return BY_CANDLE.get(p_152866_).defaultBlockState();
    }

    public static boolean canLight(BlockState state) {
        return state.is(BlockTags.CANDLE_CAKES, (p_152896_) -> {
            return p_152896_.hasProperty(LIT) && !state.getValue(LIT);
        });
    }
}
