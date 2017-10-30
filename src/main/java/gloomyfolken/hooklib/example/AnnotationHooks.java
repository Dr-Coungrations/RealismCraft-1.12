package gloomyfolken.hooklib.example;

import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenCactus;

import com.google.common.base.Predicate;
import com.lg.realism.RegBlocks;
import com.lg.realism.RegItems;
public class AnnotationHooks {

	public static final AxisAlignedBB NULL_AABB = null;
	public static boolean fallInstantly;
	public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class);
	public static final PropertyEnum<BlockPlanks.EnumType> VARIANT = PropertyEnum.<BlockPlanks.EnumType>create("variant", BlockPlanks.EnumType.class, new Predicate<BlockPlanks.EnumType>()
			{
		public boolean apply(@Nullable BlockPlanks.EnumType p_apply_1_)
		{
			return p_apply_1_.getMetadata() < 4;
		}
			});



	@Hook(createMethod = true, returnCondition = ReturnCondition.ALWAYS)
	public static void onEntityWalk(BlockPane pb,World worldIn, BlockPos pos, Entity entityIn) {
		worldIn.destroyBlock(pos, false);
	}
	@Hook(createMethod = true, returnCondition = ReturnCondition.ALWAYS)
	public static AxisAlignedBB getCollisionBoundingBox(BlockLeaves bl,IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Hook(returnCondition = ReturnCondition.ALWAYS)
	public static boolean generate(WorldGenCactus wgc,World worldIn, Random rand, BlockPos position)
	{
		return true;
	}
	@Hook(returnCondition = ReturnCondition.ALWAYS)
	public static void dropApple(BlockOldLeaf hhfg, World world, BlockPos pos, IBlockState state, int chance)
	{
		if (state.getValue(VARIANT) == BlockPlanks.EnumType.OAK)
		{
			if ( world.rand.nextInt(4) == 2){
				Block.spawnAsEntity(world, pos, new ItemStack(Items.STICK));
			}
			if ( world.rand.nextInt(3) == 2){
				Block.spawnAsEntity(world, pos, new ItemStack(RegItems.acorn));
			}
			if ( world.rand.nextInt(5) == 2){
				Block.spawnAsEntity(world, pos, new ItemStack(RegItems.oaksapling));
			}
		}else
			if( state.getValue(VARIANT) == BlockPlanks.EnumType.SPRUCE){
				if ( world.rand.nextInt(4) == 2){
					Block.spawnAsEntity(world, pos, new ItemStack(Items.STICK));
				}
				if ( world.rand.nextInt(6) == 2){
					Block.spawnAsEntity(world, pos, new ItemStack(RegItems.sprucesapling));
				}
			}
	}

	@Hook(createMethod = true, returnCondition = ReturnCondition.ALWAYS)
	public static void onEntityCollidedWithBlock(BlockLeaves bl,World world, BlockPos pos, IBlockState state, Entity entity) {
		entity.motionX *= 0.5D;
		entity.motionZ *= 0.5D;
	}

	@Hook(returnCondition = ReturnCondition.ALWAYS)
	public static void neighborChanged(BlockCactus bc, IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
	}

	@Hook(createMethod = true, returnCondition = ReturnCondition.ALWAYS)
	public static void onBlockAdded(BlockLeaves bl,World world, BlockPos pos, IBlockState state) {
		world.scheduleBlockUpdate(pos, Blocks.LEAVES, 1, 0);
		world.scheduleBlockUpdate(pos, Blocks.LEAVES2, 1, 0);
	}
	@Hook(returnCondition = ReturnCondition.ALWAYS)
	public static void updateTick(BlockLeaves bl,World world, BlockPos pos, IBlockState state, Random rand)
	{ 
		world.scheduleBlockUpdate(pos, Blocks.LEAVES, 1, 0);
		world.scheduleBlockUpdate(pos, Blocks.LEAVES2, 1, 0);
		if (!world.isRemote)
		{
			//great indian code, beach :D
			if(world.getBlockState(pos.east()).getBlock() != Blocks.LOG &&
					world.getBlockState(pos.west()).getBlock() != Blocks.LOG &&
					world.getBlockState(pos.south()).getBlock() != Blocks.LOG &&
					world.getBlockState(pos.north()).getBlock() != Blocks.LOG && 
					world.getBlockState(pos.up()).getBlock() != Blocks.LOG &&
					world.getBlockState(pos.down()).getBlock() != Blocks.LOG &&

					world.getBlockState(pos.east()).getBlock() != Blocks.LEAVES &&
					world.getBlockState(pos.west()).getBlock() != Blocks.LEAVES &&
					world.getBlockState(pos.south()).getBlock() != Blocks.LEAVES &&
					world.getBlockState(pos.north()).getBlock() != Blocks.LEAVES && 
					world.getBlockState(pos.up()).getBlock() != Blocks.LEAVES &&
					world.getBlockState(pos.down()).getBlock() != Blocks.LEAVES &&
					//oak
					world.getBlockState(pos.east()).getBlock() != RegBlocks.branchoak &&
					world.getBlockState(pos.west()).getBlock() != RegBlocks.branchoak &&
					world.getBlockState(pos.south()).getBlock() != RegBlocks.branchoak &&
					world.getBlockState(pos.north()).getBlock() != RegBlocks.branchoak && 
					world.getBlockState(pos.up()).getBlock() != RegBlocks.branchoak &&
					world.getBlockState(pos.down()).getBlock() != RegBlocks.branchoak &&

					world.getBlockState(pos.east()).getBlock() != RegBlocks.growtreeone &&
					world.getBlockState(pos.west()).getBlock() != RegBlocks.growtreeone &&
					world.getBlockState(pos.south()).getBlock() != RegBlocks.growtreeone &&
					world.getBlockState(pos.north()).getBlock() != RegBlocks.growtreeone && 
					world.getBlockState(pos.up()).getBlock() != RegBlocks.growtreeone &&
					world.getBlockState(pos.down()).getBlock() != RegBlocks.growtreeone &&

					world.getBlockState(pos.east()).getBlock() != RegBlocks.growtreetwo &&
					world.getBlockState(pos.west()).getBlock() != RegBlocks.growtreetwo &&
					world.getBlockState(pos.south()).getBlock() != RegBlocks.growtreetwo &&
					world.getBlockState(pos.north()).getBlock() != RegBlocks.growtreetwo && 
					world.getBlockState(pos.up()).getBlock() != RegBlocks.growtreetwo &&
					world.getBlockState(pos.down()).getBlock() != RegBlocks.growtreetwo &&
					//birch
					world.getBlockState(pos.east()).getBlock() != RegBlocks.branchbirch &&
					world.getBlockState(pos.west()).getBlock() != RegBlocks.branchbirch &&
					world.getBlockState(pos.south()).getBlock() != RegBlocks.branchbirch &&
					world.getBlockState(pos.north()).getBlock() != RegBlocks.branchbirch && 
					world.getBlockState(pos.up()).getBlock() != RegBlocks.branchbirch &&
					world.getBlockState(pos.down()).getBlock() != RegBlocks.branchbirch &&

					world.getBlockState(pos.east()).getBlock() != RegBlocks.growtreeonebirch &&
					world.getBlockState(pos.west()).getBlock() != RegBlocks.growtreeonebirch &&
					world.getBlockState(pos.south()).getBlock() != RegBlocks.growtreeonebirch &&
					world.getBlockState(pos.north()).getBlock() != RegBlocks.growtreeonebirch && 
					world.getBlockState(pos.up()).getBlock() != RegBlocks.growtreeonebirch &&
					world.getBlockState(pos.down()).getBlock() != RegBlocks.growtreeonebirch &&

					world.getBlockState(pos.east()).getBlock() != RegBlocks.growtreetwobirch &&
					world.getBlockState(pos.west()).getBlock() != RegBlocks.growtreetwobirch &&
					world.getBlockState(pos.south()).getBlock() != RegBlocks.growtreetwobirch &&
					world.getBlockState(pos.north()).getBlock() != RegBlocks.growtreetwobirch && 
					world.getBlockState(pos.up()).getBlock() != RegBlocks.growtreetwobirch &&
					world.getBlockState(pos.down()).getBlock() != RegBlocks.growtreetwobirch &&

					world.getBlockState(pos.east()).getBlock() != RegBlocks.smallleavesbirch &&
					world.getBlockState(pos.west()).getBlock() != RegBlocks.smallleavesbirch &&
					world.getBlockState(pos.south()).getBlock() != RegBlocks.smallleavesbirch &&
					world.getBlockState(pos.north()).getBlock() != RegBlocks.smallleavesbirch && 
					world.getBlockState(pos.up()).getBlock() != RegBlocks.smallleavesbirch &&
					world.getBlockState(pos.down()).getBlock() != RegBlocks.smallleavesbirch &&

					world.getBlockState(pos.east()).getBlock() != Blocks.LEAVES2 &&
					world.getBlockState(pos.west()).getBlock() != Blocks.LEAVES2 &&
					world.getBlockState(pos.south()).getBlock() != Blocks.LEAVES2 &&
					world.getBlockState(pos.north()).getBlock() != Blocks.LEAVES2 && 
					world.getBlockState(pos.up()).getBlock() != Blocks.LEAVES2 &&
					world.getBlockState(pos.down()).getBlock() != Blocks.LEAVES2){
				world.destroyBlock(pos, false);
			}
		}

	}


}
/*
 * получить игрока из ентиту
if (entity instanceof EntityPlayer) {
   EntityPlayer player = (EntityPlayer) entity;

  }
  получить игрока из мира
world.loadedEntityList
 */
