package fr.pmk_bungeeutils.coins;

import net.md_5.bungee.api.plugin.Listener;

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

	
	
}
