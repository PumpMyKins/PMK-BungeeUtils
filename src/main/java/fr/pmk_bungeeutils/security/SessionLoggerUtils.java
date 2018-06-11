package fr.pmk_bungeeutils.security;

import java.util.HashMap;

import net.dv8tion.jda.core.entities.User;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class SessionLoggerUtils {

	private static HashMap<String, LinkSessionData> linkMap = new HashMap<>();
	
	public static void registerCommands() {
		
		
		
	}
	
	public static void registerListeners() {
		
		
		
	}
	
	@SuppressWarnings("deprecation")
	public static void inGameLink(ProxiedPlayer p , User u) {
		// TODO Auto-generated method stub
		
		p.sendMessage("§9[PumpMyStaff] Liaison discord §a" + u.getName() + "#" + u.getDiscriminator());
		
		LinkSessionData l = new LinkSessionData(u);
		
		TextComponent refuse = new TextComponent("REFUSER");
		
		refuse.setColor(ChatColor.RED);
		refuse.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/link " + l.getRefuse_UUID()));
		
		TextComponent accept = new TextComponent("CONFIRMER");
		
		accept.setColor(ChatColor.GREEN);
		accept.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/link " + l.getAccept_UUID()));
		
		TextComponent t = new TextComponent("");
		
		t.addExtra(refuse);
		t.addExtra(" / ");
		t.addExtra(accept);
		
		p.sendMessage(t.duplicate());
		
		linkMap.put(p.getUniqueId().toString(), l);
		
	}

	public static HashMap<String, LinkSessionData> getLinkMap() {
		return linkMap;
	}

}
