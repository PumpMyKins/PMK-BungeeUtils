package fr.pmk_bungeeutils.security;

import fr.pmk_bungeeutils.MainBungeeUtils;
import fr.pmk_bungeeutils.security.commands.SecureCommand;
import net.md_5.bungee.api.ProxyServer;

public class ProxySecureManager {

	public static void registerInGameCommands() {
		
		ProxyServer proxy = ProxyServer.getInstance();
		MainBungeeUtils m = MainBungeeUtils.getInstance();
		
		proxy.getPluginManager().registerCommand(m, new SecureCommand("s"));
		
	}

	public static void registerListeners() {
	
	
	
	}
	
}
