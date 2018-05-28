package fr.pmk_bungeeutils;

import fr.pmk_bungeeutils.autobroadcast.AutoBroadcastManager;
import fr.pmk_bungeeutils.blockmod.BlockModCommand;
import fr.pmk_bungeeutils.blockmod.BlockModListener;
import fr.pmk_bungeeutils.blockmod.BlockModManager;
import fr.pmk_bungeeutils.commands.Lobby;
import fr.pmk_bungeeutils.config.ConfigPlayerSaveScheduler;
import fr.pmk_bungeeutils.config.ConfigUtils;
import fr.pmk_bungeeutils.listener.PlayerListener;
import fr.pmk_bungeeutils.pmkbuy.BuyInfoCommand;
import fr.pmk_bungeeutils.scheduler.BuyCraftScheduler;
import fr.pmk_bungeeutils.support.EnSupportCommand;
import fr.pmk_bungeeutils.support.SupportCommand;
import fr.pmk_bungeeutils.support.SupportListener;
import net.md_5.bungee.api.chat.TextComponent;
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
		configUtils.initAndGetFile("player.yml");
		
		configUtils.initPlayerLogin();
		
		BlockModManager.init(configUtils);
		
		//commande /lobby
		getProxy().getPluginManager().registerCommand(this, new Lobby("lobby"));
		
		//init listener
		getProxy().getPluginManager().registerListener(this, new PlayerListener());
		
		//init BlockMod
		getProxy().getPluginManager().registerListener(this, new BlockModListener());
		getProxy().getPluginManager().registerCommand(this, new BlockModCommand());
		
		// init support
		getProxy().getPluginManager().registerCommand(this, new EnSupportCommand());
		getProxy().getPluginManager().registerCommand(this, new SupportCommand());
		getProxy().getPluginManager().registerListener(this, new SupportListener());
		
		// buy info commande
		getProxy().getPluginManager().registerCommand(this, new BuyInfoCommand());
		
		new ConfigPlayerSaveScheduler().start();
		
		AutoBroadcastManager.init();
		new AutoBroadcastManager().startScheduler();
		
		new BuyCraftScheduler().start();
		
	
		
		
		
	}
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		configUtils.setConfigPlayerList(ConfigUtils.getPlayerList());
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
	
	public static MainBungeeUtils getInstance() {
		return instance;
	}

	@SuppressWarnings("deprecation")
	public static void updatePlayer() {
		// TODO Auto-generated method stub
		if(BlockModManager.isActive()) {
			
			for(ProxiedPlayer p: instance.getProxy().getPlayers()){
	        	
	            if(!p.hasPermission(BlockModManager.getOverPerm())) {
	            	p.disconnect("§4§l[§r§6PUMPMYCORD§r§4§l]§c Le serveur est maintenant indisponible ! (" + BlockModManager.getRaison() + ")");
	            }
	            
	        }
			
		}
		
	}
	
	public static void sendAllPlayerMsg(TextComponent t) {
		
		for(ProxiedPlayer p: instance.getProxy().getPlayers()){
			
			p.sendMessage(t);
			
		}
		
	}
	
}
