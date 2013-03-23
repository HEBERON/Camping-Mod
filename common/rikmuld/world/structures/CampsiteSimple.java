package rikmuld.world.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import rikmuld.core.lib.Config;
import rikmuld.core.register.ModBlocks;
import rikmuld.entity.Camper;

public class CampsiteSimple extends WorldGenerator {
	
	public static Minecraft mc;
    Random generator = new Random();
    int randomcamp = generator.nextInt(100) + 1;
    int RandomCampfire = 0;
    int Randommetadata = 0;
    
	public CampsiteSimple() {}
	
	public boolean LocationIsValidSpawn(World world, int i, int j, int k)
	{
		int Blocknorm = world.getBlockId(i,j,k);

		if (Blocknorm==Block.grass.blockID)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
    {
		RandomCampfire = ModBlocks.campfire.blockID;
		
    	if (randomcamp>=0&&randomcamp<70)
    	{
			Randommetadata = 0;
    	}
    	
    	if (randomcamp>=70&&randomcamp<79)
    	{
			Randommetadata = 1;
    	}
    	
    	if (randomcamp>=79&&randomcamp<88)
    	{
			Randommetadata = 2;
    	}
    	
    	if (randomcamp>=88&&randomcamp<97)
    	{
    		Randommetadata = 3;
    	}
    	
		if (randomcamp>=97&&randomcamp<=100)
		{
			Randommetadata = 4;
		}
    }
    
	public boolean generate(World world, Random rand, int i, int j, int k) 
	{		
		if ((world.getBiomeGenForCoords(i, k)==BiomeGenBase.forest||world.getBiomeGenForCoords(i, k)==BiomeGenBase.plains)&&Config.WORLD_GEN_SMALL_CAMP_CANT_SPAWN_ANYWERE)
		{
			int BlockUp = world.getBlockId(i,j+1,k);
			int BlockUp2 = world.getBlockId(i,j+2,k);

			while(BlockUp!=0||BlockUp2!=0)
			{
				j++;
				BlockUp = world.getBlockId(i,j+1,k);
				BlockUp2 = world.getBlockId(i,j+2,k);
			}
			
			if(!LocationIsValidSpawn(world, i-1, j, k-1) || !LocationIsValidSpawn(world, i + 5, j, k) || !LocationIsValidSpawn(world, i + 5, j, k + 3) || !LocationIsValidSpawn(world, i, j, k + 3))
	 		{
	 	    	return false;
	 		}
	   
			for (int f = 0; f<Config.WORLD_GEN_SMALL_CAMP_CAMPER_SPAWNRATE; f++)
			{
				Camper var4 = new Camper(world, true);
				var4.setPosition(i, j+1, k);
				world.spawnEntityInWorld(var4);
			}    
			
			world.setBlock(i + 0, j + 0, k + 1, Block.grass.blockID,0 , 2);
			world.setBlock(i + 2, j + 0, k + 0, Block.grass.blockID,0 , 2);
			world.setBlock(i + 2, j + 0, k + 1, Block.grass.blockID,0 , 2);
			world.setBlock(i + 2, j + 0, k + 2, Block.grass.blockID,0 , 2);
			world.setBlock(i + 3, j + 0, k + 0, Block.grass.blockID,0 , 2);
			world.setBlock(i + 3, j + 0, k + 1, Block.grass.blockID,0 , 2);
			world.setBlock(i + 3, j + 0, k + 2, Block.grass.blockID,0 , 2);
			world.setBlock(i + 4, j + 0, k + 0, Block.grass.blockID,0 , 2);
			world.setBlock(i + 4, j + 0, k + 1, Block.grass.blockID,0 , 2);
			world.setBlock(i + 4, j + 0, k + 2, Block.grass.blockID,0 , 2);
		
			world.setBlock(i + 0, j + 1, k + 1, RandomCampfire, Randommetadata, 2);
		
			world.setBlock(i + 0, j + 2, k + 1, 0,0 , 2);
			world.setBlock(i + 1, j + 2, k + 1, 0,0 , 2);
			world.setBlock(i + 1, j + 2, k + 2, 0,0 , 2);
			world.setBlock(i + 1, j + 2, k + 0, 0,0 , 2);
			world.setBlock(i + 0, j + 2, k + 2, 0,0 , 2);
			world.setBlock(i + 0, j + 2, k + 0, 0,0 , 2);
			world.setBlock(i + 1, j + 1, k + 1, 0,0 , 2);
			world.setBlock(i + 1, j + 1, k + 2, 0,0 , 2);
			world.setBlock(i + 1, j + 1, k + 0, 0,0 , 2);
			world.setBlock(i + 0, j + 1, k + 2, 0,0 , 2);
			world.setBlock(i + 0, j + 1, k + 0, 0,0 , 2);
			world.setBlock(i + 4, j + 2, k + 2, 0,0 , 2);
			world.setBlock(i + 2, j + 2, k + 2, 0,0 , 2);
			world.setBlock(i + 3, j + 2, k + 2, 0,0 , 2);
			world.setBlock(i + 4, j + 2, k + 0, 0,0 , 2);
			world.setBlock(i + 2, j + 2, k + 0, 0,0 , 2);
			world.setBlock(i + 3, j + 2, k + 0, 0,0 , 2);
			
			world.setBlock(i + 2, j + 1, k + 1, ModBlocks.tent.blockID, 2, 2);
		
			world.setBlock(i + 2, j + 1, k + 0, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 2, j + 1, k + 2, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 3, j + 1, k + 0, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 4, j + 1, k + 2, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 3, j + 1, k + 2, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 4, j + 1, k + 0, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 3, j + 1, k + 1, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 4, j + 1, k + 1, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 4, j + 2, k + 1, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 2, j + 2, k + 1, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 3, j + 2, k + 1, ModBlocks.ghostBlock.blockID,0 , 2);
		}
		
		if (Config.WORLD_GEN_SMALL_CAMP_CANT_SPAWN_ANYWERE==false)
		{
			int BlockUp = world.getBlockId(i,j+1,k);
			int BlockUp2 = world.getBlockId(i,j+2,k);

			while(BlockUp!=0||BlockUp2!=0)
			{
				j++;
				BlockUp = world.getBlockId(i,j+1,k);
				BlockUp2 = world.getBlockId(i,j+2,k);
			}
			
			if(!LocationIsValidSpawn(world, i-1, j, k-1) || !LocationIsValidSpawn(world, i + 5, j, k) || !LocationIsValidSpawn(world, i + 5, j, k + 3) || !LocationIsValidSpawn(world, i, j, k + 3))
	 		{
	 	    	return false;
	 		}
	   
			for (int f = 0; f<Config.WORLD_GEN_SMALL_CAMP_CAMPER_SPAWNRATE; f++)
			{
				Camper var4 = new Camper(world, true);
				var4.setPosition(i, j+1, k);
				world.spawnEntityInWorld(var4);
			}    
			
			world.setBlock(i + 0, j + 0, k + 1, Block.grass.blockID,0 , 2);
			world.setBlock(i + 2, j + 0, k + 0, Block.grass.blockID,0 , 2);
			world.setBlock(i + 2, j + 0, k + 1, Block.grass.blockID,0 , 2);
			world.setBlock(i + 2, j + 0, k + 2, Block.grass.blockID,0 , 2);
			world.setBlock(i + 3, j + 0, k + 0, Block.grass.blockID,0 , 2);
			world.setBlock(i + 3, j + 0, k + 1, Block.grass.blockID,0 , 2);
			world.setBlock(i + 3, j + 0, k + 2, Block.grass.blockID,0 , 2);
			world.setBlock(i + 4, j + 0, k + 0, Block.grass.blockID,0 , 2);
			world.setBlock(i + 4, j + 0, k + 1, Block.grass.blockID,0 , 2);
			world.setBlock(i + 4, j + 0, k + 2, Block.grass.blockID,0 , 2);
		
			world.setBlock(i + 0, j + 1, k + 1, RandomCampfire, Randommetadata, 2);
		
			world.setBlock(i + 0, j + 2, k + 1, 0,0 , 2);
			world.setBlock(i + 1, j + 2, k + 1, 0,0 , 2);
			world.setBlock(i + 1, j + 2, k + 2, 0,0 , 2);
			world.setBlock(i + 1, j + 2, k + 0, 0,0 , 2);
			world.setBlock(i + 0, j + 2, k + 2, 0,0 , 2);
			world.setBlock(i + 0, j + 2, k + 0, 0,0 , 2);
			world.setBlock(i + 1, j + 1, k + 1, 0,0 , 2);
			world.setBlock(i + 1, j + 1, k + 2, 0,0 , 2);
			world.setBlock(i + 1, j + 1, k + 0, 0,0 , 2);
			world.setBlock(i + 0, j + 1, k + 2, 0,0 , 2);
			world.setBlock(i + 0, j + 1, k + 0, 0,0 , 2);
			world.setBlock(i + 4, j + 2, k + 2, 0,0 , 2);
			world.setBlock(i + 2, j + 2, k + 2, 0,0 , 2);
			world.setBlock(i + 3, j + 2, k + 2, 0,0 , 2);
			world.setBlock(i + 4, j + 2, k + 0, 0,0 , 2);
			world.setBlock(i + 2, j + 2, k + 0, 0,0 , 2);
			world.setBlock(i + 3, j + 2, k + 0, 0,0 , 2);
			
			world.setBlock(i + 2, j + 1, k + 1, ModBlocks.tent.blockID, 2, 2);
		
			world.setBlock(i + 2, j + 1, k + 0, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 2, j + 1, k + 2, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 3, j + 1, k + 0, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 4, j + 1, k + 2, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 3, j + 1, k + 2, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 4, j + 1, k + 0, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 3, j + 1, k + 1, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 4, j + 1, k + 1, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 4, j + 2, k + 1, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 2, j + 2, k + 1, ModBlocks.ghostBlock.blockID,0 , 2);
			world.setBlock(i + 3, j + 2, k + 1, ModBlocks.ghostBlock.blockID,0 , 2);
		}
	return true;
	}
}
	
