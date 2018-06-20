package fr.pmk_bungeeutils.coins;

import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class CoinsMessagingService implements Listener {

	private CoinsManager cm;
	
	public CoinsMessagingService(CoinsManager cm) {
		// TODO Auto-generated constructor stub
		this.cm = cm;
	}

	@EventHandler
	public void OnMessagingServiceReceive(PluginMessageEvent e) throws Exception {
		
		
		
	}

	public CoinsManager getCoinsManager() {
		return cm;
	}

	public void setCoinsManager(CoinsManager cm) {
		this.cm = cm;
	}
	
}
