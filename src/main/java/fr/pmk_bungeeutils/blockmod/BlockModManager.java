package fr.pmk_bungeeutils.blockmod;

import fr.pmk_bungeeutils.config.ConfigUtils;

public class BlockModManager {

	private static String raison;
	private static boolean active;
	private static String overPerm;
	
	public static void init(ConfigUtils c) {
		
		raison = c.getBlockModRaison();
		active = c.getBlockModState();
		overPerm = c.getBlockModOverridePerm();
		
	}
	
	public static String getRaison() {
		return raison;
	}
	public static void setRaison(String raison) {
		BlockModManager.raison = raison;
	}
	public static boolean isActive() {
		return active;
	}
	public static void setActive(boolean active) {
		BlockModManager.active = active;
	}
	public static String getOverPerm() {
		return overPerm;
	}
	public static void setOverPerm(String overPerm) {
		BlockModManager.overPerm = overPerm;
	}
	
}
