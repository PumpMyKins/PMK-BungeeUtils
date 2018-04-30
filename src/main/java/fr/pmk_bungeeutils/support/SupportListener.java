package fr.pmk_bungeeutils.support;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class SupportListener implements Listener {

	@EventHandler
	public void OnPlayerJoin(PostLoginEvent e) {
		
		ProxiedPlayer p = e.getPlayer();
		
		if(p.hasPermission("support.view")) {
			if(!EnSupportCommand.getSupportMap().containsKey(p)) {
				EnSupportCommand.getSupportMap().put(p, new SupportData(true));
			}
		}
		
	}
	
	@EventHandler
	public void OnPlayerQuit(PlayerDisconnectEvent e) {
		
		ProxiedPlayer p = e.getPlayer();
		
		if(EnSupportCommand.getSupportMap().containsKey(p)) {
			EnSupportCommand.getSupportMap().remove(p);
		}
	}
	
}
