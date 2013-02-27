package camping.common.rikmuld.core.register;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

import camping.common.rikmuld.core.lib.ModInfo;

public class ModLogger {

	private static Logger campLogger = Logger.getLogger(ModInfo.MOD_ID);
	
	public static void preinit()
	{
		 campLogger.setParent(FMLLog.getLogger());
	}
	
	 public static void log(Level logLevel, String message)
	 {
		 campLogger.log(logLevel, message);
	 }
}