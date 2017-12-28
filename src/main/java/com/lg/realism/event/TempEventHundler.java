package com.lg.realism.event;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.PSystem.ColdMessageClient;
import com.lg.realism.PSystem.NetworkHandler;
import com.lg.realism.PSystem.TemperatureBodyClientMessage;
import com.lg.realism.Realism;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;

public class TempEventHundler {
	public static final ResourceLocation LEVEL_CAP = new ResourceLocation(Realism.MODID ,"tempBody");

	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent event) {
		if(event.getObject() instanceof EntityPlayer){
			event.addCapability(LEVEL_CAP, new WaterBarProv());
		}
	}

	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event) {
		EntityPlayer player = event.getEntityPlayer();
		IBarLevel newCap = player.getCapability(WaterBarProv.LEVEL_CAP, null);
		IBarLevel oldCap = event.getOriginal().getCapability(WaterBarProv.LEVEL_CAP, null);
		newCap.copyCapabilities(oldCap);
	}
	@SubscribeEvent
	public void syncInvHUD(PlayerChangedDimensionEvent event) {  

		EntityPlayer player = (EntityPlayer)event.player;

		if(!player.world.isRemote){
			IBarLevel capabilities = player.getCapability(WaterBarProv.LEVEL_CAP, null);  
			NetworkHandler.NETWORK.sendTo(new TemperatureBodyClientMessage(capabilities.getTempBody()), (EntityPlayerMP)player);
		} 
	}

	@SubscribeEvent
	public void onDeath(LivingDeathEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {

			EntityPlayer player = (EntityPlayer) event.getEntity();
			IBarLevel capabilities = player.getCapability(WaterBarProv.LEVEL_CAP, null);

			NetworkHandler.NETWORK.sendTo(new TemperatureBodyClientMessage(capabilities.getTempBody()), (EntityPlayerMP)player);
		}
	}
	@SubscribeEvent
	public void onSick(LivingUpdateEvent event) {
		if(event.getEntity() instanceof EntityPlayer && !FMLCommonHandler.instance().getEffectiveSide().isClient()) {

			EntityPlayer player = (EntityPlayer) event.getEntity();
			IBarLevel capabilities = player.getCapability(WaterBarProv.LEVEL_CAP, null);

			if(player.ticksExisted % 80 == 0) {
				Biome biome = player.getEntityWorld().getBiomeForCoordsBody(new BlockPos(player));

				int variator = player.getEntityWorld().rand.nextInt(40);

				if((biome == Biomes.TAIGA || biome == Biomes.COLD_TAIGA || biome == Biomes.COLD_TAIGA_HILLS || biome == Biomes.TAIGA_HILLS || biome == Biomes.COLD_BEACH)&& variator == 32){
					capabilities.setTempBody(37.8F);
					capabilities.setCommonCold(true);
				}
				if((biome == Biomes.TAIGA || biome == Biomes.COLD_TAIGA || biome == Biomes.COLD_TAIGA_HILLS || biome == Biomes.TAIGA_HILLS || biome == Biomes.COLD_BEACH)&& variator == 24){
					capabilities.setTempBody(39.1F);
					int intovariator = player.getEntityWorld().rand.nextInt(3);
					if(intovariator == 2){
						capabilities.setTempBody(38.8F);
					}
					if(intovariator == 1){
						capabilities.setTempBody(38.6F);
					}
					if(intovariator == 0){
						capabilities.setTempBody(38.9F);
					}
					capabilities.setGrippe(true);
				}


				if(variator == 34){
					capabilities.setTempBody(36.6F);
					int intovariator = player.getEntityWorld().rand.nextInt(3);
					if(intovariator == 2){
						capabilities.setTempBody(36.7F);
					}
					if(intovariator == 1){
						capabilities.setTempBody(36.5F);
					}
					if(intovariator == 0){
						capabilities.setTempBody(36.4F);
					}
					capabilities.setCommonCold(false);
				}
				if(variator == 13){
					capabilities.setTempBody(36.6F);
					int intovariator = player.getEntityWorld().rand.nextInt(3);
					if(intovariator == 2){
						capabilities.setTempBody(36.7F);
					}
					if(intovariator == 1){
						capabilities.setTempBody(36.5F);
					}
					if(intovariator == 0){
						capabilities.setTempBody(36.4F);
					}
					capabilities.setGrippe(false);
				}

				//System.out.println("pre b " + capabilities.getCommonCold());
			//	System.out.println("pre " + capabilities.getTempBody());
				NetworkHandler.NETWORK.sendTo(new TemperatureBodyClientMessage(capabilities.getTempBody()), (EntityPlayerMP)player);
				NetworkHandler.NETWORK.sendTo(new ColdMessageClient(capabilities.getCommonCold()), (EntityPlayerMP)player);
			//	System.out.println("post " + capabilities.getTempBody());
			//	System.out.println("post b " + capabilities.getCommonCold());
			}
		}

	}
}
