package fr.pmk_bungeeutils.coins;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class CoinsListener implements Listener {

	private CoinsManager cm;
	
	public CoinsListener(CoinsManager cm) {
		// TODO Auto-generated constructor stub
		this.cm = cm;
	}

	public CoinsManager getCoinsManager() {
		return cm;
	}

	public void setCoinsManager(CoinsManager cm) {
		this.cm = cm;
	}

	@EventHandler
	public void onPlayerJoin(PostLoginEvent e) {
		
		ProxiedPlayer p = e.getPlayer();
		
		if(!cm.containPlayer(p)) {
			
			cm.initPlayer(p);
			
		}
		
	}
	
}
