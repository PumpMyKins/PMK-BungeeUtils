package fr.pmk_bungeeutils;

import java.util.ArrayList;
import java.util.List;

import fr.pmk_bungeeutils.autobroadcast.AutoBroadcastManager;
import fr.pmk_bungeeutils.coins.CoinsManager;
import fr.pmk_bungeeutils.commands.Aide;
import fr.pmk_bungeeutils.commands.BroadcastAll;
import fr.pmk_bungeeutils.commands.Lobby;
import fr.pmk_bungeeutils.commands.MessageServer;
import fr.pmk_bungeeutils.commands.Rules;
import fr.pmk_bungeeutils.config.ConfigPlayerSaveScheduler;
import fr.pmk_bungeeutils.config.ConfigUtils;
import fr.pmk_bungeeutils.config.MySQLConnector;
import fr.pmk_bungeeutils.listener.PlayerListener;
import fr.pmk_bungeeutils.pmkbuy.BuyInfoCommand;
import fr.pmk_bungeeutils.scheduler.BuyCraftScheduler;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		
		instance = this;
		
		//////////////////////// CONFIG /////////////////////////////////////////
		
		configUtils = ConfigUtils.getConfig(this);
		
		configUtils.initDataFolder();
		configUtils.initAndGetFile("config.yml");
		configUtils.initAndGetFile("player.yml");
		configUtils.initAndGetFile("rules.yml");
		configUtils.initAndGetFile("aide.yml");
		
		configUtils.initPlayerLogin();
		
		////////////////////INIT BDD CONNECTOR ///////////////////////////////////////
		
		String url = configUtils.getBddUrl();
	    String user = configUtils.getBddUser();
	    String mdp = configUtils.getBddMdp();
	    String base = configUtils.getBddBase();
	    
	    //initialisation de la class MySQLConnector
	    MySQLConnector.init(url, user, mdp, base);
		
	    // init coins manager
		@SuppressWarnings("unused")
		CoinsManager coinsManager = CoinsManager.init(this);	
	    
		//SessionLoggerUtils.registerCommands();
		
	    String server = "lobby";
	    String message = "default";
		try {
			
			Configuration conf = configUtils.getConfiguration("config.yml");
			
			server = conf.getString("lobby.name");
			message = conf.getString("lobby.message").replace("&", "§");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//commande /lobby
		getProxy().getPluginManager().registerCommand(this, new Lobby("lobby",message,server));
		
		List<String> aide = new ArrayList<>();
		
		try {
			
			aide = (List<String>) MainBungeeUtils.getConfigUtils().getConfiguration("aide.yml").getList("aide");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//commande /aide
		getProxy().getPluginManager().registerCommand(this, new Aide("aide",aide));
		
		List<String> rule = new ArrayList<>();	
		
		try {
			
			rule = (List<String>) MainBungeeUtils.getConfigUtils().getConfiguration("rules.yml").getList("rules");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//commande /rules
		getProxy().getPluginManager().registerCommand(this, new Rules("rules",rule));
		
		//commande /bcall <message>
		getProxy().getPluginManager().registerCommand(this, new BroadcastAll("bcall"));
		
		//commande /msg <joueur> <message>
		getProxy().getPluginManager().registerCommand(this, new MessageServer("msg"));
		
		//init listener
		getProxy().getPluginManager().registerListener(this, new PlayerListener());
		
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
	
	public static void sendAllPlayerMsg(TextComponent t) {
		
		for(ProxiedPlayer p: instance.getProxy().getPlayers()){
			
			p.sendMessage(t);
			
		}
		
	}
	
}
