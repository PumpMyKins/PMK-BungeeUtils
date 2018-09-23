package fr.pmk_bungeeutils.network;

import fr.pmk_bungeeutils.MainBungeeUtils;
import net.md_5.bungee.api.plugin.Listener;

public class PluginMessagingManager implements Listener {

	private static MainBungeeUtils main;
	private static PluginMessagingManager plgM;

	public static PluginMessagingManager init(MainBungeeUtils m) {
		
		plgM = new PluginMessagingManager(m);		
		
		startListen();
		
		return plgM;		
	}
	
	public static void startListen() {
		
		main.getProxy().getPluginManager().registerListener(main, plgM);	// register event
		
	}
	
	public static void stopListen() {
		
		main.getProxy().getPluginManager().unregisterListener(plgM); 	// unregister event
		
	}
	
	public PluginMessagingManager(MainBungeeUtils m) {
		// TODO Auto-generated constructor stub
		
	}
	
}
