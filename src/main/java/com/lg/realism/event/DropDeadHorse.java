package com.lg.realism.event;

import com.lg.realism.RegItems;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DropDeadHorse {

	@SubscribeEvent
	public void onDeath(LivingDeathEvent event) {
		if(!event.getEntityLiving().getEntityWorld().isRemote){
			
			if (event.getEntity() instanceof EntityHorse) {
				EntityHorse horse = (EntityHorse) event.getEntity();
				event.getEntity().dropItem(RegItems.konin,1 + event.getEntityLiving().getEntityWorld().rand.nextInt(2));
				event.getEntity().dropItem(Items.BONE,16);
			}
			if (event.getEntity() instanceof EntityDonkey) {
				EntityDonkey horse = (EntityDonkey) event.getEntity();
				event.getEntity().dropItem(RegItems.konin,2 + event.getEntityLiving().getEntityWorld().rand.nextInt(2));
				event.getEntity().dropItem(Items.BONE,10);
			}
			if (event.getEntity() instanceof EntityMule) {
				EntityMule horse = (EntityMule) event.getEntity();
				event.getEntity().dropItem(RegItems.konin,6 + event.getEntityLiving().getEntityWorld().rand.nextInt(3));
				event.getEntity().dropItem(Items.BONE,32);
			}
			if (event.getEntity() instanceof EntityPlayer) {
				EntityPlayer horse = (EntityPlayer) event.getEntity();
				event.getEntity().dropItem(RegItems.playermeat,1 + event.getEntityLiving().getEntityWorld().rand.nextInt(2));
				event.getEntity().dropItem(Items.BONE,8);
			}
		}
	}
}
