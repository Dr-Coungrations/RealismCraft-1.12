package com.lg.realism.fire;

import com.google.common.collect.Maps;
import com.lg.realism.RegItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Map;
import java.util.Map.Entry;

public class FireRecipeManager {
	
	public static final FireRecipeManager RECIPES = new FireRecipeManager();
	
	private final Map<ItemStack, ItemStack> recipes = Maps.newHashMap();

	public static FireRecipeManager getInstance(){
		return RECIPES;
	}
		
	private FireRecipeManager(){
		//������ �������� - ����, ������ - �����
		recipes.put(new ItemStack(RegItems.claycup), new ItemStack(RegItems.annealedclaycup));
		recipes.put(new ItemStack(RegItems.clayplate), new ItemStack(RegItems.annealedclayplate));
		recipes.put(new ItemStack(Items.PORKCHOP), new ItemStack(Items.COOKED_PORKCHOP));
		recipes.put(new ItemStack(Items.BEEF), new ItemStack(Items.COOKED_BEEF));
		recipes.put(new ItemStack(Items.FISH), new ItemStack(Items.COOKED_FISH));
		recipes.put(new ItemStack(Items.RABBIT), new ItemStack(Items.COOKED_RABBIT));
		recipes.put(new ItemStack(Items.CHICKEN), new ItemStack(Items.COOKED_CHICKEN));
		recipes.put(new ItemStack(Items.MUTTON), new ItemStack(Items.COOKED_MUTTON));
	}
	
    public ItemStack getSmeltingResult(ItemStack stack) {
    	
        for (Entry<ItemStack, ItemStack> entry : this.recipes.entrySet()) {
        	
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }

        return ItemStack.EMPTY;
    }
    
    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

}
