package com.lg.realism.event;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.lg.realism.Realism;
import com.lg.realism.RegItems;
import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.Config.ConfigManager;
import com.lg.realism.PSystem.HUDSyncMessageServer;
import com.lg.realism.PSystem.NetworkHandler;

public class EventHandThirstUpdate {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void hadDrinken(PlayerInteractEvent.RightClickBlock event){

		final World world = (World)Minecraft.getMinecraft().world;
		EntityPlayer player = (EntityPlayer) event.getEntity();
		ItemStack is = player.getHeldItem(EnumHand.MAIN_HAND);
		RayTraceResult raytraceresult = this.rayTrace(world, player, true);
		if (raytraceresult == null) return; // MP's fix
			if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK)
			{
				BlockPos blockpos = raytraceresult.getBlockPos();

				IBarLevel capabilities = event.getEntity().getCapability(WaterBarProv.LEVEL_CAP, null);

				if (world.getBlockState(blockpos).getMaterial() == Material.WATER)
				{
					if(is.isEmpty()){
					capabilities.reduceWaterLevel(5);
		
					player.world.playSound(player, blockpos, SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.NEUTRAL, 0.8F, 1.0F);
			
					if(ConfigManager.thirstDebug){
						Realism.LOGGER.info("(EventHandThirstUpdate) WaterLevel PreMessage: " + capabilities.getWaterLevel());
					}
				
					NetworkHandler.INSTANCE.sendToServer(new HUDSyncMessageServer(capabilities.getWaterLevel()));
					if(ConfigManager.thirstDebug){
						Realism.LOGGER.info("(EventHandThirstUpdate) WaterLevel PostMessage: " + capabilities.getWaterLevel());
					}
				}
				}
			}
	}
	protected RayTraceResult rayTrace(World worldIn, EntityPlayer playerIn, boolean useLiquids)
	{
		float f = playerIn.rotationPitch;
		float f1 = playerIn.rotationYaw;
		double d0 = playerIn.posX;
		double d1 = playerIn.posY + (double)playerIn.getEyeHeight();
		double d2 = playerIn.posZ;
		Vec3d vec3d = new Vec3d(d0, d1, d2);
		float f2 = MathHelper.cos(-f1 * 0.017453292F - (float)Math.PI);
		float f3 = MathHelper.sin(-f1 * 0.017453292F - (float)Math.PI);
		float f4 = -MathHelper.cos(-f * 0.017453292F);
		float f5 = MathHelper.sin(-f * 0.017453292F);
		float f6 = f3 * f4;
		float f7 = f2 * f4;
		double d3 = 5.0D;
		if (playerIn instanceof net.minecraft.entity.player.EntityPlayerMP)
		{
			d3 = ((net.minecraft.entity.player.EntityPlayerMP)playerIn).interactionManager.getBlockReachDistance();
		}
		Vec3d vec3d1 = vec3d.addVector((double)f6 * d3, (double)f5 * d3, (double)f7 * d3);
		return worldIn.rayTraceBlocks(vec3d, vec3d1, useLiquids, !useLiquids, false);
	}
}
