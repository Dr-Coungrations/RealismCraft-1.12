package com.lg.realism.Items.Backpacks.Slots;

import com.lg.realism.Items.Backpacks.ItemBackpack;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class StorageSlot extends Slot {

	public StorageSlot(IInventory inv, int id, int x, int y) {
		super(inv, id, x, y);
	}

	//������ ��������� � ���� ���� ������� � ����������� ItemBackpack.
	//� ���������� � ��� ���� ���������, ����� ������ �� ������ ����� ��������� �������� � ��������� �����.
	@Override
	public boolean isItemValid(ItemStack is) {
		return (is != null && is.getItem() instanceof ItemBackpack) ? false : super.isItemValid(is);
	}

}