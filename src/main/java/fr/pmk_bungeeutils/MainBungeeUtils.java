package fr.pmk_bungeeutils;

import fr.pmk_bungeeutils.blockmod.BlockModCommand;
import fr.pmk_bungeeutils.blockmod.BlockModListener;
import fr.pmk_bungeeutils.blockmod.BlockModManager;
import fr.pmk_bungeeutils.config.ConfigUtils;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;

public class MainBungeeUtils extends Plugin{

	private static ConfigUtils configUtils;
	private static MainBungeeUtils instance;
	
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		
		instance = this;
		
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

	@SuppressWarnings("deprecation")
	public static void updatePlayer() {
		// TODO Auto-generated method stub
		if(BlockModManager.isActive()) {
			
			for(ProxiedPlayer p: instance.getProxy().getPlayers()){
	        	
	            if(!p.hasPermission(BlockModManager.getOverPerm())) {
	            	p.disconnect("[PUMPMYCORD] Vous ne pouvez pas vous connecter au serveur ! (" + BlockModManager.getRaison() + ")");
	            }
	            
	        }
			
		}
		
	}
	
}
