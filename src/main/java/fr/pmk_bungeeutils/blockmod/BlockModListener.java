package fr.pmk_bungeeutils.blockmod;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class BlockModListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void OnPlayerLog(PostLoginEvent e) {
		
		ProxiedPlayer p = e.getPlayer();
		
		if(BlockModManager.isActive()) {
			if(!p.hasPermission(BlockModManager.getOverPerm())) {

				p.disconnect("[PUMPMYCORD] Vous ne pouvez pas vous connecter au serveur ! (" + BlockModManager.getRaison() + ")");
			}
		}
		
	}
	
}
