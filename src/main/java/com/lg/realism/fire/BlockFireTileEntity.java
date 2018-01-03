package com.lg.realism.fire;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFireTileEntity extends TileEntityLockable implements ITickable, ISidedInventory{
	
	//это слоты где будут предметы - т.е. 0 - первый слот дл€ жарки, 1 - второй и 2 - третий
	private static final int[] SLOTS_TOP = new int[] {0, 1, 2};
	//тут лежит топливо - 4 п€тый и 6 слоты(снизу)
    private static final int[] SLOTS_BOTTOM = new int[] {3, 4, 5};
    private static final int[] SLOTS_SIDES = new int[] {3, 4, 5};
    
    private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(6, ItemStack.EMPTY);
    
    // Ќ≈ «јЅ”ƒ№ «ј–≈√ј“№ “ј…Ћ » √”» ’≈ЌƒЋ≈–)
   
    private int fSlotBurnTime;
    private int fSlotProcTime;
    private int fSlotTotalTime;
    
    private int sSlotProcTime;
    private int sSlotTotalTime;
    private int sSlotBurnTime;
   
    private int tSlotProcTime;
    private int tSlotTotalTime;
    private int tSlotBurnTime;
    
    
    private String stationCustomName;
       
    public int getSizeInventory(){
    	
        return this.inventory.size();
    }

    @Nullable
    public ItemStack getStackInSlot(int index){
    	
        return this.inventory.get(index);
    }

    @Nullable
    public ItemStack decrStackSize(int index, int count){
    	
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }

    @Nullable
    public ItemStack removeStackFromSlot(int index){
    	
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }
    
    public boolean isEmpty()
    {
        for (ItemStack itemstack : this.inventory)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    public void setInventorySlotContents(int index, @Nullable ItemStack stack){
    	
    	ItemStack itemstack = (ItemStack)this.inventory.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.inventory.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit())
        {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag){
        	//сбиваем процесс если что-то потрогал входщий стак
            this.fSlotTotalTime = this.getProcessTime(stack);
            this.fSlotProcTime = 0;
            this.markDirty();
        }
        if (index == 1 && !flag){
            this.sSlotTotalTime = this.getProcessTime(stack);
            this.sSlotProcTime = 0;
            this.markDirty();
        }
        if (index == 2 && !flag){
        	this.tSlotTotalTime = this.getProcessTime(stack);
            this.tSlotProcTime = 0;
            this.markDirty();
        }
    }

    public String getName(){
    	
    	return "gui.fire.name";
    }

    public boolean hasCustomName(){
    	
        return this.stationCustomName != null && !this.stationCustomName.isEmpty();
    }

    public void setCustomInventoryName(String p_145951_1_){
    	
        this.stationCustomName = p_145951_1_;
    }

    public void readFromNBT(NBTTagCompound compound){
    	
    	super.readFromNBT(compound);
        this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inventory);
        
        this.fSlotProcTime = compound.getInteger("fSlotProcTime");
        this.fSlotTotalTime = compound.getInteger("fSlotTotalTime");
        
        this.sSlotProcTime = compound.getInteger("sSlotProcTime");
        this.sSlotTotalTime = compound.getInteger("sSlotTotalTime");
        
        this.tSlotProcTime = compound.getInteger("tSlotProcTime");
        this.tSlotTotalTime = compound.getInteger("tSlotTotalTime");

 
        this.fSlotBurnTime = getItemBurnTime((ItemStack)this.inventory.get(3));
        this.sSlotBurnTime = getItemBurnTime((ItemStack)this.inventory.get(4));
        this.tSlotBurnTime = getItemBurnTime((ItemStack)this.inventory.get(5));

        if (compound.hasKey("CustomName", 8))
        {
            this.stationCustomName = compound.getString("CustomName");
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound){
    	
    	super.writeToNBT(compound);
        
    	compound.setInteger("fSlotProcTime", this.fSlotProcTime);
    	compound.setInteger("fSlotTotalTime", this.fSlotTotalTime);
    	
    	compound.setInteger("sSlotProcTime", this.sSlotProcTime);
    	compound.setInteger("sSlotTotalTime", this.sSlotTotalTime);
    	
    	compound.setInteger("tSlotProcTime", this.tSlotProcTime);
    	compound.setInteger("tSlotTotalTime", this.tSlotTotalTime);
    	
        ItemStackHelper.saveAllItems(compound, this.inventory);

        if (this.hasCustomName())
        {
            compound.setString("CustomName", this.stationCustomName);
        }

        return compound;
    }

    public int getInventoryStackLimit(){
    	
        return 64;
    }


    @SideOnly(Side.CLIENT)
    public static boolean isProcessing(IInventory inventory){
    	
        return inventory.getField(0) > 0;
    }

    public void update(){
    	
    	boolean flag = this.isProcessing(0);
        boolean flag1 = false;
        
        boolean flags = this.isProcessing(1);
        boolean flag2 = false;
        
        boolean flagt = this.isProcessing(2);
        boolean flag3 = false;
        
        for(int i = 0; i < 3; i++){
    		//тут уменьшаем врем€ топлива
    		if(this.isProcessing(i)){
    			this.decrement(i);
    		}
    	}

        if (!this.world.isRemote) {
        	    	
        	//достаем топливо
        	ItemStack fuel1 = this.inventory.get(3);
        	ItemStack fuel2 = this.inventory.get(4);
        	ItemStack fuel3 = this.inventory.get(5);
        	
        	//first slot
        	//дл€ первого слота
        	//смотрим работает ли топливо в первом слоте, есть ли оно там и не равна ли наша еда нулю
        	 if (this.isProcessing(0) || !fuel1.isEmpty() && !((ItemStack)this.inventory.get(0)).isEmpty()){
        		 //если топливо исчерпалось Ќќ можно продолжить процесс
                 if (!this.isProcessing(0) && this.canProcess(0)) {
                	 
                	 //берем из метода врем€ топлива т.е. сколько оно должно прожить
                     this.fSlotBurnTime = getItemBurnTime(fuel1);

                     //если это врем€ больше 0
                     if (this.isProcessing(0)) {
                         flag1 = true;

                         //короче уменьшаем на единицу кол-во топлива)
                         if (!fuel1.isEmpty()) {
                             Item item = fuel1.getItem();
                             fuel1.shrink(1);

                             if (fuel1.isEmpty()){
                                 ItemStack item1 = item.getContainerItem(fuel1);
                                 this.inventory.set(3, item1);
                             }
                         }
                     }
                 }

                 //теперь если у нас наконец-то есть работающее топливо и можно выполнить процесс
                 if (this.isProcessing(0) && this.canProcess(0)) {
 
                	 //приьавл€ем переменную нашего процесса
                     ++this.fSlotProcTime;

                     //если она будет равна максимальному значению, т.е. предмет уже готов к жарке
                     if (this.fSlotProcTime == this.fSlotTotalTime){
                    	 //ставим ее на 0 и вызываем метод который дает резулльтат
                         this.fSlotProcTime = 0;
                         this.fSlotTotalTime = this.getProcessTime((ItemStack)this.inventory.get(0));
                         this.processStacks(0);
                         flag1 = true;
                     }
                 }//иначе если что-то пошло не так сбиваем процесс
                 else {
                     this.fSlotProcTime = 0;
                 }
             }//а тут  хз что происходит)
             else if (!this.isProcessing(0) && this.fSlotProcTime > 0) {
                 this.fSlotProcTime = MathHelper.clamp(this.fSlotProcTime - 2, 0, this.fSlotTotalTime);
             }
        	 
        	 //дл€ второго и третьего слотов нанлогично первому
        	 
        	 //second slot
        	 if (this.isProcessing(1) || !fuel2.isEmpty() && !((ItemStack)this.inventory.get(1)).isEmpty()){
                 if (!this.isProcessing(1) && this.canProcess(1)) {
                     this.sSlotBurnTime = getItemBurnTime(fuel2);

                     if (this.isProcessing(1)) {
                         flag2 = true;

                         if (!fuel2.isEmpty()) {
                             Item item = fuel2.getItem();
                             fuel2.shrink(1);

                             if (fuel2.isEmpty()){
                                 ItemStack item2 = item.getContainerItem(fuel2);
                                 this.inventory.set(4, item2);
                             }
                         }
                     }
                 }

                 if (this.isProcessing(1) && this.canProcess(1)) {
 
                     ++this.sSlotProcTime;

                     if (this.sSlotProcTime == this.sSlotTotalTime)
                     {
                         this.sSlotProcTime = 0;
                         this.sSlotTotalTime = this.getProcessTime((ItemStack)this.inventory.get(1));
                         this.processStacks(1);
                         flag2 = true;
                     }
                 }
                 else {
                     this.sSlotProcTime = 0;
                 }
             }
             else if (!this.isProcessing(1) && this.sSlotProcTime > 0) {
                 this.sSlotProcTime = MathHelper.clamp(this.sSlotProcTime - 2, 0, this.sSlotTotalTime);
             }
        	 //third slot
        	 if (this.isProcessing(2) || !fuel3.isEmpty() && !((ItemStack)this.inventory.get(2)).isEmpty()){
                 if (!this.isProcessing(2) && this.canProcess(2)) {
                     this.tSlotBurnTime = getItemBurnTime(fuel3);

                     if (this.isProcessing(2)) {
                         flag3 = true;

                         if (!fuel3.isEmpty()) {
                             Item item = fuel3.getItem();
                             fuel3.shrink(1);

                             if (fuel3.isEmpty()){
                                 ItemStack item3 = item.getContainerItem(fuel3);
                                 this.inventory.set(5, item3);
                             }
                         }
                     }
                 }

                 if (this.isProcessing(2) && this.canProcess(2)) {
 
                     ++this.tSlotProcTime;

                     if (this.tSlotProcTime == this.tSlotTotalTime){
                         this.tSlotProcTime = 0;
                         this.tSlotTotalTime = this.getProcessTime((ItemStack)this.inventory.get(2));
                         this.processStacks(2);
                         flag3 = true;
                     }
                 }
                 else {
                     this.tSlotProcTime = 0;
                 }
             }
             else if (!this.isProcessing(2) && this.tSlotProcTime > 0) {
                 this.tSlotProcTime = MathHelper.clamp(this.tSlotProcTime - 2, 0, this.tSlotTotalTime);
             }
         
        	 //помечаем что инвентарь был изменен
             if (flag != this.isProcessing(0)){
                 flag1 = true;
             }
             if (flags != this.isProcessing(1)){
                 flag2 = true;
             }
             if (flagt != this.isProcessing(2)){
                 flag3 = true;
             }
        }     
        
        
        if (flag || flags || flagt){
            this.markDirty();
        }
    }
    
    public boolean isProcessing(int i){
    	
    	 switch (i){
         
         case 0:
             return this.fSlotBurnTime > 0;
         case 1:
             return this.sSlotBurnTime > 0;
         case 2:
             return this.tSlotBurnTime > 0;
         default:
             return false;
    	 }
    }
    
    public void decrement(int i){
    	
   	 switch (i){
        
        case 0:
           this.fSlotBurnTime--;
           break;
        case 1:
           this.sSlotBurnTime--;
           break;
        case 2:
           this.tSlotBurnTime--;
           break;
        default:
            break;
   	 }
   }

    public int getProcessTime(@Nullable ItemStack stack){
    	
    	//сколько тиков будет занимать жарка предметов
        return 480;
    }

    private boolean canProcess(int i){
    	
    	switch (i){
        
        case 0:
        	if(this.inventory.get(0).isEmpty()){
        		return false;
        	}

        	ItemStack itemstack1 = FireRecipeManager.getInstance().getSmeltingResult(this.inventory.get(0));
        	if (itemstack1.isEmpty()) return false;  	
        	return true;
        case 1:
        	if(this.inventory.get(1).isEmpty()){
        		return false;
        	}

        	ItemStack itemstack2 = FireRecipeManager.getInstance().getSmeltingResult(this.inventory.get(1));
        	if (itemstack2.isEmpty()) return false;
        	return true;
        case 2:
        	if(this.inventory.get(2).isEmpty()){
        		return false;
        	}
        	
        	ItemStack itemstack3 = FireRecipeManager.getInstance().getSmeltingResult(this.inventory.get(2));
        	if (itemstack3.isEmpty()) return false;
        	return true;
        default:
        	return true;
    	}          
    }

    public void processStacks(int i){
    	
        if (this.canProcess(i)){    	
        	//тут осторожно, если ты поставил рецепт что с 1 €блока дает 2 золота, а кто-то положит 2 €блока то вместо 4 золота всеравно выйдет 2. —ам подумай как исправить)
        	ItemStack itemstack = FireRecipeManager.getInstance().getSmeltingResult(this.inventory.get(i)).copy(); 
        	this.setInventorySlotContents(i, itemstack);
        }
    }

    public static int getItemBurnTime(ItemStack stack){
    	
        if (stack.isEmpty()){
            return 0;
        }else{
        	
            Item item = stack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR){
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.WOODEN_SLAB){
                    return 150;
                }

                if (block.getDefaultState().getMaterial() == Material.WOOD){
                    return 300;
                }

                if (block == Blocks.COAL_BLOCK){
                    return 16000;
                }
            }

            if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200;
            if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 200;
            if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName())) return 200;
            if (item == Items.STICK) return 100;
            if (item == Items.COAL) return 1600;
         //   if (item == Items.LAVA_BUCKET) return 20000;
            if (item == Item.getItemFromBlock(Blocks.SAPLING)) return 100;
            if (item == Items.BLAZE_ROD) return 2400;
            return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack);
        }
    }

    public static boolean isItemFuel(ItemStack stack){
    	
        return getItemBurnTime(stack) > 0;
    }

    public boolean isUsableByPlayer(EntityPlayer player){
    	
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public void openInventory(EntityPlayer player){
    	
    }

    public void closeInventory(EntityPlayer player){
    	
    }

    public boolean isItemValidForSlot(int index, ItemStack stack){
    	
        if (index < 3){
            return true;
        }
        return false;
    }

    public int[] getSlotsForFace(EnumFacing side){
    	
        return side == EnumFacing.DOWN ? SLOTS_BOTTOM : (side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES);
    }

    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction){
    	
        return this.isItemValidForSlot(index, itemStackIn);
    }

    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction){
    	
        if (direction == EnumFacing.DOWN && (index < 3)){
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET){
                return false;
            }
        }

        return true;
    }

    public String getGuiID(){
    	
        return "";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn){
    	
        return new BlockFireContainer(playerInventory, this);
    }

    public int getField(int id){
    	
        switch (id){
        	case 0: return this.fSlotBurnTime;
        	case 1: return this.fSlotProcTime;
        	case 2: return this.fSlotTotalTime;
        	case 3: return this.sSlotBurnTime;
        	case 4: return this.sSlotProcTime;
        	case 5: return this.sSlotTotalTime;
        	case 6: return this.tSlotBurnTime;
        	case 7: return this.tSlotProcTime;
        	case 8: return this.tSlotTotalTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value){
    	
    	switch (id){
    	case 0: this.fSlotBurnTime = value; break;
    	case 1: this.fSlotProcTime = value; break;
    	case 2: this.fSlotTotalTime = value; break;
    	case 3: this.sSlotBurnTime = value; break;
    	case 4: this.sSlotProcTime = value; break;
    	case 5: this.sSlotTotalTime = value; break;
    	case 6: this.tSlotBurnTime = value; break;
    	case 7: this.tSlotProcTime = value; break;
    	case 8: this.tSlotTotalTime = value; break;
        default:
            return;
    }
    }

    public int getFieldCount(){
    	
        return 9;
    }

    public void clear(){
    	
    	this.inventory.clear();
    }

    net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
    net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
    net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);

    @Override
    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.EnumFacing facing){
    	
        if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            if (facing == EnumFacing.DOWN)
                return (T) handlerBottom;
            else if (facing == EnumFacing.UP)
                return (T) handlerTop;
            else
                return (T) handlerSide;
        return super.getCapability(capability, facing);
    }


}
