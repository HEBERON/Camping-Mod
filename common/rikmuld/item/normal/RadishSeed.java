package rikmuld.item.normal;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import rikmuld.core.lib.Items;
import rikmuld.core.register.ModAchievements;
import rikmuld.item.CampingItem;

public class RadishSeed extends CampingItem implements IPlantable
{
	    private int blockType;

	    public RadishSeed(int par1, int par2, int par3)
	    {
	        super(par1);
	        this.blockType = par2;
	        setUnlocalizedName(Items.ITEM_RADISH_SEED_NAME);
	        
	    }

	    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	    {
	        if (par7 != 1)
	        {
	            return false;
	        }
	        else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
	        {
	            int var11 = par3World.getBlockId(par4, par5, par6);
	            Block soil = Block.blocksList[var11];

	            if (soil != null && soil.canSustainPlant(par3World, par4, par5, par6, ForgeDirection.UP, this) && par3World.isAirBlock(par4, par5 + 1, par6))
	            {
	                par3World.setBlock(par4, par5 + 1, par6, this.blockType, 0, 2);
	                --par1ItemStack.stackSize;
	    	        par2EntityPlayer.addStat(ModAchievements.Radish, 1);
	                return true;
	            }
	            else
	            {
	                return false;
	            }
	        }
	        else
	        {
	            return false;
	        }
	    }

	    @Override
	    public EnumPlantType getPlantType(World world, int x, int y, int z)
	    {
	        return EnumPlantType.Plains;
	    }

	    @Override
	    public int getPlantID(World world, int x, int y, int z)
	    {
	        return blockType;
	    }

	    @Override
	    public int getPlantMetadata(World world, int x, int y, int z)
	    {
	        return 0;
	    }
	}
