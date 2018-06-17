package fr.pmk_bungeeutils;

import fr.pmk_bungeeutils.autobroadcast.AutoBroadcastManager;
import fr.pmk_bungeeutils.blockmod.BlockModCommand;
import fr.pmk_bungeeutils.blockmod.BlockModListener;
import fr.pmk_bungeeutils.blockmod.BlockModManager;
import fr.pmk_bungeeutils.coins.CoinsManager;
import fr.pmk_bungeeutils.commands.Aide;
import fr.pmk_bungeeutils.commands.Lobby;
import fr.pmk_bungeeutils.commands.Rules;
import fr.pmk_bungeeutils.config.ConfigPlayerSaveScheduler;
import fr.pmk_bungeeutils.config.ConfigUtils;
import fr.pmk_bungeeutils.config.MySQLConnector;
import fr.pmk_bungeeutils.discord.MisterPorg;
import fr.pmk_bungeeutils.listener.PlayerListener;
import fr.pmk_bungeeutils.pmkbuy.BuyInfoCommand;
import fr.pmk_bungeeutils.scheduler.BuyCraftScheduler;
import fr.pmk_bungeeutils.security.SessionLoggerUtils;
import fr.pmk_bungeeutils.support.EnSupportCommand;
import fr.pmk_bungeeutils.support.SupportCommand;
import fr.pmk_bungeeutils.support.SupportListener;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

public class MainBungeeUtils extends Plugin{

	private static ConfigUtils configUtils;
	private static MainBungeeUtils instance;
	private static MisterPorg misterPorg;
	
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		
		instance = this;
		
		configUtils = ConfigUtils.getConfig(this);
		
		configUtils.initDataFolder();
		configUtils.initAndGetFile("config.yml");
		configUtils.initAndGetFile("player.yml");
		configUtils.initAndGetFile("rules.yml");
		configUtils.initAndGetFile("aide.yml");
		
		configUtils.initPlayerLogin();
		
		System.out.println("Mister Porg init");
		String token = configUtils.getBotToken();
		
		if(!token.equals("no-token")) {
			System.out.println("Mister Porg token found");
			misterPorg = new MisterPorg();
			
			misterPorg.start(token);
			
		}
		
		BlockModManager.init(configUtils);
		
		String url = configUtils.getBddUrl();
	    String user = configUtils.getBddUser();
	    String mdp = configUtils.getBddMdp();
	    String base = configUtils.getBddBase();
	        
	    //initialisation de la class MySQLConnector
	    MySQLConnector mySqlConnector = MySQLConnector.init(url, user, mdp, base);
		
		CoinsManager coinsManager = CoinsManager.init(this, mySqlConnector);
		
		
		
		SessionLoggerUtils.registerCommands();
		
		//commande /aide
		getProxy().getPluginManager().registerCommand(this, new Aide("aide"));
		
		//commande /lobby
		getProxy().getPluginManager().registerCommand(this, new Lobby("lobby"));
		
		//commande /rules
		getProxy().getPluginManager().registerCommand(this, new Rules("rules"));
		
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
	            	p.disconnect("�4�l[�r�6PUMPMYCORD�r�4�l]�c Le serveur est maintenant indisponible ! (" + BlockModManager.getRaison() + ")");
	            }
	            
	        }
			
		}
		
	}
	
	public static void sendAllPlayerMsg(TextComponent t) {
		
		for(ProxiedPlayer p: instance.getProxy().getPlayers()){
			
			p.sendMessage(t);
			
		}
		
	}

	public static MisterPorg getMisterPorg() {
		return misterPorg;
	}

	public static void setMisterPorg(MisterPorg misterPorg) {
		MainBungeeUtils.misterPorg = misterPorg;
	}
	
}
