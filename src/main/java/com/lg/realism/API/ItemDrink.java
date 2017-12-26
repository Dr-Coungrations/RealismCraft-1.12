package com.lg.realism.API;

import com.lg.realism.Capability.CapabilitiesSA.IBarLevel;
import com.lg.realism.Capability.CapabilitiesSA.WaterBarProv;
import com.lg.realism.Realism;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * The base class of the object-drink. You simply extend from this class and set the name of the number of recoverable water. Full scale - 100 units. 10 - one "droplet"
 * Хватит писать в говно эклипсе на русском! Пишите на английском раз такие сложности!!!!!
 * �������� �����������
 * ������� ����� ��������-�������. ��� ���������� ��������� �� ����� ������ � ���������� ��� ���������� ����������������� ����. ������ ����� - 100 ������. 10 - ���� "��������"
 * @author LegendGamer
 */
public class ItemDrink extends Item
{
	private int thirstAdd;
    private Item backItem;

	public ItemDrink(String name,int maxStackSize, int thirstAdd, Item backItem)
    {
		super();
		this.setRegistryName(name);
		this.setCreativeTab(Realism.tabMain);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(maxStackSize);
		this.thirstAdd = thirstAdd;
		this.backItem = backItem;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
		return 32;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
		return EnumAction.DRINK;
	}

	@Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entityLiving;

            IBarLevel bar = player.getCapability(WaterBarProv.LEVEL_CAP, null);

            if (!player.capabilities.isCreativeMode)
            {
                stack.shrink(1);
                bar.reduceWaterLevel(thirstAdd);

                if (stack.isEmpty())
                    return new ItemStack(backItem);

                player.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(backItem));
            }
            return stack;
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

	@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        playerIn.setActiveHand(handIn);
        return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

	@Override
	public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, net.minecraft.nbt.NBTTagCompound nbt)
    {
		return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
	}
}