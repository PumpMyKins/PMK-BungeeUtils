package fr.pmk_bungeeutils.hotbarconnect;

import java.util.HashMap;

import fr.pmk_bungeeutils.hotbarconnect.data.HbcServer;

public class HotBarConnectManager {

	private static HashMap<String, HbcServer> hashServer = new HashMap<>();

	public static HashMap<String, HbcServer> getServers() {
		return hashServer;
	}

	public static void setHashServers(HashMap<String, HbcServer> hashServer) {
		HotBarConnectManager.hashServer = hashServer;
	}
	
	
}
