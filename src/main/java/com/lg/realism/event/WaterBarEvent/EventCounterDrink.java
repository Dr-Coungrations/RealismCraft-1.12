package com.lg.realism.event.WaterBarEvent;

import com.lg.realism.Realism;
import com.lg.realism.RegItems;
import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.Config.ConfigManager;
import com.lg.realism.PSystem.HUDSyncMessage;
import com.lg.realism.PSystem.NetworkHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventCounterDrink {

	@SubscribeEvent
	public void counterDrinkFinish(LivingEntityUseItemEvent.Finish event) {
		EntityPlayer player = (EntityPlayer) event.getEntity();


		if(!player.world.isRemote) {

			IBarLevel capabilities = event.getEntity().getCapability(WaterBarProv.LEVEL_CAP, null);

			if (event.getItem().getItemUseAction() == EnumAction.DRINK) {
				if (event.getItem().getItem() != null && event.getItem().getItem() == RegItems.itemcupfill) {
					capabilities.reduceWaterLevel(30);
					event.getItem().shrink(1);
					player.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(RegItems.itemcup));
				}

				NetworkHandler.INSTANCE.sendToAll(new HUDSyncMessage(capabilities.getWaterLevel()));
	
			}
		}
	}


}



