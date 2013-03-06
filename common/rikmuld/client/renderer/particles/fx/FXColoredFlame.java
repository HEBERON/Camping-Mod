package rikmuld.client.renderer.particles.fx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import rikmuld.core.lib.Textures;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FXColoredFlame extends EntityFX
{	
	public FXColoredFlame(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, int color)
	{
	super(par1World, par2, par4, par6, par8, par10, par12);
	this.motionX = this.motionX * 0.009999999776482582D + par8;
	this.motionY = this.motionY * 0.009999999776482582D + par10;
	this.motionZ = this.motionZ * 0.009999999776482582D + par12;
	this.particleMaxAge = 20;
	this.setParticleTextureIndex(color);
	
	}
	@Override
	public int getFXLayer()
	{
	return 1;
	}
	
	public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
	{
	Tessellator tessellator1 = Tessellator.instance;
	tessellator1.draw();
	tessellator1.startDrawingQuads();
	tessellator1.setBrightness(getBrightnessForRender(par2));
	Minecraft mc = FMLClientHandler.instance().getClient();
	GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTexture(Textures.SPRITE_LOCATION + Textures.SPRITE_PARTICLES));
	float f8 = 1.0F;
	tessellator1.setColorOpaque_F(particleRed * f8, particleGreen * f8, particleBlue * f8);
	super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
	tessellator1.draw();
	GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTexture("/terrain.png"));
	tessellator1.startDrawingQuads();
	}
	
	public int getBrightnessForRender(float par1)
	{
	float var2 = ((float)this.particleAge + par1) / (float)this.particleMaxAge;
	
	if (var2 < 0.0F)
	{
	var2 = 0.0F;
	}
	
	if (var2 > 1.0F)
	{
	var2 = 1.0F;
	}
	
	int var3 = super.getBrightnessForRender(par1);
	int var4 = var3 & 255;
	int var5 = var3 >> 16 & 255;
	var4 += (int)(var2 * 15.0F * 16.0F);
	
	if (var4 > 240)
	{
	var4 = 240;
	}
	
	return var4 | var5 << 16;
	}
	
	
	public float getBrightness(float par1)
	{
	float var2 = ((float)this.particleAge + par1) / (float)this.particleMaxAge;
	
	if (var2 < 0.0F)
	{
	var2 = 0.0F;
	}
	
	if (var2 > 1.0F)
	{
	var2 = 1.0F;
	}
	
	float var3 = super.getBrightness(par1);
	return var3 * var2 + (1.0F - var2);
	}
	
	
	public void onUpdate()
	{
	this.prevPosX = this.posX;
	this.prevPosY = this.posY;
	this.prevPosZ = this.posZ;
	
	if (this.particleAge++ >= this.particleMaxAge)
	{
	this.setDead();
	}
	
	this.moveEntity(this.motionX, this.motionY, this.motionZ);
	this.motionX *= 0.9599999785423279D;
	this.motionY *= 0.9599999785423279D;
	this.motionZ *= 0.9599999785423279D;
	
	if (this.onGround)
	{
	this.motionX *= 0.699999988079071D;
	this.motionZ *= 0.699999988079071D;
	}
	}
}