package rikmuld.block;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import rikmuld.core.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class CampingBlockPlant extends BlockFlower {

	public int metadata;
	public static Icon[] icon;
	
	protected CampingBlockPlant(int par1, Material material)
	{
		super(par1, material);
	}
	
	@Override
    public Icon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 > this.metadata)
        {
            par2 = metadata;
        }
        return icon[par2];
    }
    
    public int setGrowStates(int Metadata)
    {
    	this.metadata = Metadata;
    	return metadata;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.icon= new Icon[this.metadata+1];

        for (int i = 0; i < this.icon.length; ++i)
        {
            this.icon[i] = iconRegister.registerIcon(ModInfo.MOD_ID+":"+this.getUnlocalizedName().substring(5)+"_"+i);
        }
    }
}
