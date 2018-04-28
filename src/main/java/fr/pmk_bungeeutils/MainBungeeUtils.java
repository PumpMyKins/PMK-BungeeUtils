package fr.pmk_bungeeutils;

import fr.pmk_bungeeutils.blockmod.BlockModCommand;
import fr.pmk_bungeeutils.blockmod.BlockModListener;
import fr.pmk_bungeeutils.blockmod.BlockModManager;
import fr.pmk_bungeeutils.config.ConfigUtils;
import net.md_5.bungee.api.plugin.Plugin;

public class MainBungeeUtils extends Plugin{

	private static ConfigUtils configUtils;
	
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		
		configUtils = ConfigUtils.getConfig(this);
		
		configUtils.initDataFolder();
		configUtils.initAndGetFile("config.yml");		
		
		BlockModManager.init(configUtils);
		
		//initiasliation
		getProxy().getPluginManager().registerListener(this, new BlockModListener());
		getProxy().getPluginManager().registerCommand(this, new BlockModCommand());
	}
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		BlockModManager.save(configUtils);
	}
	
	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
	}

	public static ConfigUtils getConfigUtils() {
		return configUtils;
	}

	public static void setConfigUtils(ConfigUtils configUtils) {
		MainBungeeUtils.configUtils = configUtils;
	}
	
}
