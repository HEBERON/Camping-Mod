package rikmuld.item.tool;

import rikmuld.core.helper.ToolHelper;
import rikmuld.core.lib.Config;
import rikmuld.core.lib.Items;
import rikmuld.item.CampingItem;

public class ToolCamping extends CampingItem {

	public ToolCamping(int i) 
	{
		super(i);
		maxStackSize = 1;
		setUnlocalizedName(Items.ITEM_TOOL_CAMP_NAME);
		setMaxDamage(Config.GENERAL_CAMPTOOL_MAX_DURABILATY);
		isDamageable();
		ToolHelper.addTool(itemID);
	}
}

