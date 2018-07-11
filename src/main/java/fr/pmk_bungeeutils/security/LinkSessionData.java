package fr.pmk_bungeeutils.security;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class LinkSessionData {

	private ProxiedPlayer player;
	private String uuid;
	
	public LinkSessionData(ProxiedPlayer p) {
		
		this.player = p;
		this.uuid = p.getUniqueId().toString();
		
		
	}

	public ProxiedPlayer getPlayer() {
		return player;
	}

	public void setPlayer(ProxiedPlayer player) {
		this.player = player;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
