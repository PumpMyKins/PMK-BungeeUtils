package fr.pmk_bungeeutils.network;

import java.util.HashMap;
import java.util.Map.Entry;

import fr.pmk_bungeeutils.MainBungeeUtils;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

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
	
///////////////////////////////////////////////////////////////////////////////////////////
	
	private HashMap<String, MessagingListener> hashListener;

	public void addMessage(String tag , MessagingListener ml) {
		
		main.getProxy().registerChannel(tag);
		hashListener.put(tag, ml);
		
	}
	
	public void removeMessage(String tag) {
		
		main.getProxy().unregisterChannel(tag);
		hashListener.remove(tag);
		
	}
	
	public PluginMessagingManager(MainBungeeUtils m) {
		// TODO Auto-generated constructor stub
		this.hashListener = new HashMap<>();
	}
	
	@EventHandler
	public void onPluginMessage(PluginMessageEvent event) {
		
		for (Entry<String, MessagingListener> entry : hashListener.entrySet()) {
			
			String tag = entry.getKey();
			
			if(event.getTag().equals(tag)) {
				
				entry.getValue().onMessagingTagReceive(event);
				return;
				
			}
			
		}
		
	}
	
}
