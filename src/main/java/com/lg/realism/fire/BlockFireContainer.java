package com.lg.realism.fire;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockFireContainer extends Container{
	
	private final IInventory tile;
	private int [] fields;
    
    private EntityPlayer player;

    public BlockFireContainer(InventoryPlayer playerInventory, IInventory stationInventory){
    	
        this.tile = stationInventory;
        this.player = playerInventory.player;
        this.fields = new int[tile.getFieldCount()];
        //1
        this.addSlotToContainer(new Slot(stationInventory, 0, 62, 11){  public int getSlotStackLimit() {return 1;}});//0
        //2
        this.addSlotToContainer(new Slot(stationInventory, 1, 80, 29){  public int getSlotStackLimit() {return 1;}});//1
        //3
        this.addSlotToContainer(new Slot(stationInventory, 2, 98, 11){  public int getSlotStackLimit() {return 1;}});//2
        //fuel1
        this.addSlotToContainer(new SlotFurnaceFuel(stationInventory, 3, 62, 29));//3
        //fuel2
        this.addSlotToContainer(new SlotFurnaceFuel(stationInventory, 4, 80, 47));//4
        //fuel3
        this.addSlotToContainer(new SlotFurnaceFuel(stationInventory, 5, 98, 29));//5

        for (int i = 0; i < 3; ++i){
            for (int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k){
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }
    
    public void addListener(IContainerListener listener){
    	
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tile);
    }

    public void detectAndSendChanges(){
    	
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i){
        	
            IContainerListener icontainerlistener = this.listeners.get(i);
            
            for(int j = 0; j < tile.getFieldCount(); j++){
				 
				 if(this.fields[j] != tile.getField(j)){
					 icontainerlistener.sendWindowProperty(this, j, this.tile.getField(j));
				 }
			 }
        }
        
        for(int i = 0; i < this.fields.length; i++){
			 
			 this.fields[i] = this.tile.getField(i);
		}
        
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data){
    	
        this.tile.setField(id, data);
    }

    public boolean canInteractWith(EntityPlayer playerIn){
    	
        return this.tile.isUsableByPlayer(playerIn);
    }

    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index){
    	
    	ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
                        
            if (index < 3){
       
                if (!this.mergeItemStack(itemstack1, 6, 42, true)){
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index > 5){

            	if (BlockFireTileEntity.isItemFuel(itemstack1)){
                    if (!this.mergeItemStack(itemstack1, 3, 6, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }else if (index >= 6 && index < 33){
                    if (!this.mergeItemStack(itemstack1, 33, 42, false)){
                        return ItemStack.EMPTY;
                    }
                }else if (index >= 33 && index < 42 && !this.mergeItemStack(itemstack1, 6, 33, false)){
                    return ItemStack.EMPTY;
                }
            }else if (!this.mergeItemStack(itemstack1, 6, 42, false)){
                return ItemStack.EMPTY;
            }                  

            if (itemstack1.getCount() == 0){
                slot.putStack(ItemStack.EMPTY);
            }
            else{
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()){
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

}
