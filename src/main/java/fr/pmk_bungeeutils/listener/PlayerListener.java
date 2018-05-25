package fr.pmk_bungeeutils.listener;

import java.util.List;

import fr.pmk_bungeeutils.MainBungeeUtils;
import fr.pmk_bungeeutils.config.ConfigUtils;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void OnPlayerFirstJoin(PostLoginEvent e) {
		
		ProxiedPlayer p = e.getPlayer();
		
		//if(!BlockModManager.isActive() & !p.hasPermission("blockmod.over")) {
			
			String pUUID = p.getUniqueId().toString();
			String pName = p.getDisplayName();
			
			List<String> listPlayer = ConfigUtils.getPlayerList();
			
			if(!listPlayer.contains(pUUID)) {
				
				listPlayer.add(pUUID);
				//affichage du message de bienvenue
				for(ProxiedPlayer pList: MainBungeeUtils.getInstance().getProxy().getPlayers()){	        	
					pList.sendMessage("§2§kab§r" + "§6Bienvenue à §e§l" + pName + "§r§6, le §b§l" + (listPlayer.size()-1) + "§r§6ème joueurs ! §2§kab");
		        }
			}
			
		//}
		
	}
	
}
