package gloomyfolken.hooklib.example;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.lg.realism.RegBlocks;
import com.lg.realism.RegItems;

import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCustomizeWorldScreen;
import net.minecraft.client.gui.GuiPageButtonList;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
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
					world.getBlockState(pos.east()).getBlock() != RegBlocks.oakbranch &&
					world.getBlockState(pos.west()).getBlock() != RegBlocks.oakbranch &&
					world.getBlockState(pos.south()).getBlock() != RegBlocks.oakbranch &&
					world.getBlockState(pos.north()).getBlock() != RegBlocks.oakbranch && 
					world.getBlockState(pos.up()).getBlock() != RegBlocks.oakbranch &&
					world.getBlockState(pos.down()).getBlock() != RegBlocks.oakbranch &&

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
					world.getBlockState(pos.east()).getBlock() != RegBlocks.connectblock &&
					world.getBlockState(pos.west()).getBlock() != RegBlocks.connectblock &&
					world.getBlockState(pos.south()).getBlock() != RegBlocks.connectblock &&
					world.getBlockState(pos.north()).getBlock() != RegBlocks.connectblock && 
					world.getBlockState(pos.up()).getBlock() != RegBlocks.connectblock &&
					world.getBlockState(pos.down()).getBlock() != RegBlocks.connectblock &&

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




	static Minecraft mc = Minecraft.getMinecraft();
	public static float thirdPersonDistancePrev = 4.0F;
	private static boolean cloudFog;
	//Big classe render
	@Hook(returnCondition = ReturnCondition.ALWAYS)
	public static void updateLightmap(EntityRenderer render, float partialTicks)
	{
	//	System.out.println("ѕездато работет");
		boolean lightmapUpdateNeeded = ObfuscationReflectionHelper.getPrivateValue(EntityRenderer.class, render, "lightmapUpdateNeeded");
		float torchFlickerX = ObfuscationReflectionHelper.getPrivateValue(EntityRenderer.class, render, "torchFlickerX");
		float bossColorModifier = ObfuscationReflectionHelper.getPrivateValue(EntityRenderer.class, render, "bossColorModifier");
		float bossColorModifierPrev = ObfuscationReflectionHelper.getPrivateValue(EntityRenderer.class, render, "bossColorModifierPrev");
		int[] lightmapColors = ObfuscationReflectionHelper.getPrivateValue(EntityRenderer.class, render, "lightmapColors");
		DynamicTexture lightmapTexture = ObfuscationReflectionHelper.getPrivateValue(EntityRenderer.class, render, "lightmapTexture");
		if (lightmapUpdateNeeded)
		{
			Minecraft.getMinecraft().mcProfiler.startSection("lightTex");
			World world = Minecraft.getMinecraft().world;

			if (world != null)
			{
				  float getSunBrightness = world.getSunBrightness(1.0F);
	                float f1 = getSunBrightness * 1F;

	                for (int i = 0; i < 256; ++i)
	                {
	                    float getLightBrightnessTable = world.provider.getLightBrightnessTable()[i / 16] * f1;
	                    float getLightBrightnessTableT = world.provider.getLightBrightnessTable()[i % 16] * (torchFlickerX * 0.1F + 1.5F);

	                    if (world.getLastLightningBolt() > 0)
	                    {
	                    	getLightBrightnessTable = world.provider.getLightBrightnessTable()[i / 16];
	                    }

	                    float f4 = getLightBrightnessTable * (getSunBrightness * 0.65F + 0.35F);
	                    float f5 = getLightBrightnessTable * (getSunBrightness * 0.65F + 0.35F);
	                    float f6 = getLightBrightnessTableT * ((getLightBrightnessTableT * 0.6F + 0.4F) * 0.6F + 0.4F);
	                    float f7 = getLightBrightnessTableT * (getLightBrightnessTableT * getLightBrightnessTableT * 0.6F + 0.4F);
	                    float f8 = f4 + getLightBrightnessTableT;
	                    float f9 = f5 + f6;
	                    float f10 = getLightBrightnessTable + f7;
	                    f8 = f8 * 0.96F + 0.03F;
	                    f9 = f9 * 0.96F + 0.03F;
	                    f10 = f10 * 0.96F + 0.03F;


	                    if (bossColorModifier > 0.0F)
	                    {
	                        float f11 = bossColorModifierPrev + (bossColorModifier - bossColorModifierPrev) * partialTicks;
	                        f8 = f8 * (1.0F - f11) + f8 * 0.7F * f11;
	                        f9 = f9 * (1.0F - f11) + f9 * 0.6F * f11;
	                        f10 = f10 * (1.0F - f11) + f10 * 0.6F * f11;
	                    }
	                    if (world.provider.getDimensionType().getId() == 1)
	                    {
	                        f8 = 0.22F + getLightBrightnessTableT * 0.75F;
	                        f9 = 0.28F + f6 * 0.75F;
	                        f10 = 0.25F + f7 * 0.75F;
	                    }
	                    
	                    if (f8 > 1.0F)
	                    {
	                        f8 = 1.0F;
	                    }

	                    if (f9 > 1.0F)
	                    {
	                        f9 = 1.0F;
	                    }

	                    if (f10 > 1.0F)
	                    {
	                        f10 = 1.0F;
	                    }

	                    float f16 = mc.gameSettings.gammaSetting;
	                    float f17 = 1.0F - f8;
	                    float f13 = 1.0F - f9;
	                    float f14 = 1.0F - f10;
	                    f17 = 1.0F - f17 * f17 * f17 * f17;
	                    f13 = 1.0F - f13 * f13 * f13 * f13;
	                    f14 = 1.0F - f14 * f14 * f14 * f14;
	                    f8 = f8 * (1.0F - f16) + f17 * f16;
	                    f9 = f9 * (1.0F - f16) + f13 * f16;
	                    f10 = f10 * (1.0F - f16) + f14 * f16;
	                    f8 = f8 * 0.96F + 0.03F;
	                    f9 = f9 * 0.96F + 0.03F;
	                    f10 = f10 * 0.96F + 0.03F;

	                    if (f8 > 1.0F)
	                    {
	                        f8 = 1.0F;
	                    }

	                    if (f9 > 1.0F)
	                    {
	                        f9 = 1.0F;
	                    }

	                    if (f10 > 1.0F)
	                    {
	                        f10 = 1.0F;
	                    }

	                    if (f8 < 0.0F)
	                    {
	                        f8 = 0.0F;
	                    }

	                    if (f9 < 0.0F)
	                    {
	                        f9 = 0.0F;
	                    }

	                    if (f10 < 0.0F)
	                    {
	                        f10 = 0.0F;
	                    }

	                    
	                    //цвета?!
	                    int j = 255;
	                    int k = (int)(f8 * 255.0F);
	                    int l = (int)(f9 * 255.0F);
	                    int i1 = (int)(f10 * 255.0F);
	        
	                    lightmapColors[i] = -16777216 | k << 16 | l << 8 | i1;
	                    
	                    
	                    if (mc.player.isPotionActive(MobEffects.NIGHT_VISION))
	                    {
	        
	                    	
	                        float getNightVis = getNightVisionBrightness(mc.player, partialTicks);
	                        float f12 = 4.0F / f8;

	                        if (f12 > 1.0F / f9)
	                        {
	                            f12 = 1.0F / f9;
	                        }
	             
	                        if (f12 > 1.0F / f10)
	                        {
	                            f12 = 1.0F / f10;
	                        }

	                        f8 = f8 * (1.0F - getNightVis) + f8 * f12 * getNightVis;
	                        f9 = f9 * (1.0F - getNightVis) + f9 * f12 * getNightVis;
	                        f10 = f10 * (1.0F - getNightVis) + f10 * f12 * getNightVis;
	                        lightmapColors[i] = -40293745 | k << 16 | l << 8 | i1;
	                     
	            			//¬еселые комбинации
	        				/*
	        				 * 16777216 - норма
	        				 * 25500139 - €рко-темнозеленый
	        				 * 15678234 - сочно-зеленый
	        				 * 40293745 - кроваво -красный цвет €рости
	        				 */
	                    }
				}					   //12345678
				//¬еселые комбинации
				/*
				 * 16777216 - норма
				 * 25500139 - €рко-темнозеленый
				 * 15678234 - сочно-зеленый
				 * 40293745 - кроваво -красный цвет €рости
				 */

				lightmapTexture.updateDynamicTexture();
				lightmapUpdateNeeded = false;
				Minecraft.getMinecraft().mcProfiler.endSection();
			}
		}
		return;
	}
    public static float getNightVisionBrightness(EntityLivingBase entitylivingbaseIn, float partialTicks)
    {
        int i = entitylivingbaseIn.getActivePotionEffect(MobEffects.NIGHT_VISION).getDuration();
        return i > 200 ? 1.0F : 0.7F + MathHelper.sin(((float)i - partialTicks) * (float)Math.PI * 0.2F) * 0.3F;
    }
    public static void getLightmapColors(float partialTicks, float sunBrightness, float skyLight, float blockLight, float[] colors) {
    	
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
