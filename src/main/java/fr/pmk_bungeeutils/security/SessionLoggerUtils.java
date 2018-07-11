package fr.pmk_bungeeutils.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.pmk_bungeeutils.MainBungeeUtils;
import fr.pmk_bungeeutils.security.commands.LinkCommand;
import net.md_5.bungee.api.ProxyServer;

public class SessionLoggerUtils {

	private static HashMap<String, LinkSessionData> linkMap = new HashMap<>();
	private static List<String> userLinkList = new ArrayList<>();
	
	public static void registerCommands() {
		
		ProxyServer proxy = ProxyServer.getInstance();
		MainBungeeUtils m = MainBungeeUtils.getInstance();
		
		proxy.getPluginManager().registerCommand(m, new LinkCommand("link"));
		
	}

	public static HashMap<String, LinkSessionData> getLinkMap() {
		return linkMap;
	}

	public static List<String> getUserLinkList() {
		return userLinkList;
	}
	
}
