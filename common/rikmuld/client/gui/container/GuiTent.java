package rikmuld.client.gui.container;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import rikmuld.core.lib.Textures;
import rikmuld.inventory.container.ContainerTent;
import rikmuld.tileentity.TileEntityTent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTent extends GuiContainer {

	public int xSize = 212;
	public int ySize = 184;
	
	public GuiTent(InventoryPlayer par1InventoryPlayer,	TileEntityTent par2TileEntitycampfire) 
	{
		super(new ContainerTent(par1InventoryPlayer, par2TileEntitycampfire));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) 
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(Textures.GUI_LOCATION + Textures.GUI_TENT);
		int var5 = (this.width - this.xSize) / 2;
		int var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
	}

	protected void keyTyped(char par1, int par2) 
	{
		if (par2 == 18 || par2 == 1) 
		{
			super.mc.setIngameFocus();
		}
	}
}