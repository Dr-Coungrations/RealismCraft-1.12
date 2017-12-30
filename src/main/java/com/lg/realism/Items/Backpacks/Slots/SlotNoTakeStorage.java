package com.lg.realism.Items.Backpacks.Slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotNoTakeStorage extends Slot {

	public SlotNoTakeStorage(IInventory inv, int id, int x, int y) {
		super(inv, id, x, y);
	}

	//Ќельз€ вз€ть из этого слота, если это находитьс€ в руке игрока.
	//’от€ по стандарту, можно только дл€ хот-бара, но € не уверен на счЄт других модов.
	@Override
	public boolean canTakeStack(EntityPlayer player) {
		ItemStack is = inventory.getStackInSlot(getSlotIndex());
		if (is != null && is == player.getHeldItemMainhand()) return false;
		return super.canTakeStack(player);
	}

}
