package com.lg.realism.Items.Backpacks;

import com.lg.realism.Items.Backpacks.Slots.SlotNoTakeStorage;
import com.lg.realism.Items.Backpacks.Slots.StorageSlot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ItemStorageContainer extends net.minecraft.inventory.Container {

	private InventoryItemStorage inv;
	private int numRows;

	public ItemStorageContainer(EntityPlayer player, InventoryItemStorage inventoryItemStorage) {
		inv = inventoryItemStorage;
		inv.openInventory(player);//���� �������������� �������� ���������
		numRows = inv.getSizeInventory() / 9;
		int i = (numRows - 4) * 18;
		int j;
		int k;

		//����� ��������� Item Storage
		for (int id = 0; id < inv.getSizeInventory(); ++id) {
			addSlotToContainer(new StorageSlot(inv, id, 8 + (id % 9) * 18, 18 + (id / 9) * 18));
		}

		//����� ��������� ������
		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				addSlotToContainer(new SlotNoTakeStorage(player.inventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
			}
		}

		//����� ���-���� ������
		for (j = 0; j < 9; ++j) {
			addSlotToContainer(new SlotNoTakeStorage(player.inventory, j, 8 + j * 18, 161 + i));
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return inv.isUsableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot_i) {
		ItemStack is = null;
		Slot slot = (Slot)inventorySlots.get(slot_i);

		if (slot != null && slot.getHasStack()) {
			ItemStack is1 = slot.getStack();
			is = is1.copy();

			//��� ����� �� ����-����� ����� ���� �������� � ��� ������ ��� ���� ������.
			if (is1.getItem() instanceof ItemBackpack) return null;

			if (slot_i < inv.getSizeInventory()) {
				if (!mergeItemStack(is1, inv.getSizeInventory(), inventorySlots.size(), true)) return null;
			} else if (!mergeItemStack(is1, 0, inv.getSizeInventory(), false))
				return null;

			if (is1.getMaxStackSize() == 0) slot.putStack((ItemStack)null);
			else slot.onSlotChanged();
		}

		return is;
	}



	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		inv.closeInventory(player);//���� �������������� �������� ���������
	}

	public void update(EntityPlayer player) {
		if (inv != null);
	}

}