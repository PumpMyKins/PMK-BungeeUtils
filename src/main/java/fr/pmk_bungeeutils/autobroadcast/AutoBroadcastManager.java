package fr.pmk_bungeeutils.autobroadcast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import fr.pmk_bungeeutils.MainBungeeUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;

public class AutoBroadcastManager {
	
	private static List<TextComponent> msgList = new ArrayList<TextComponent>();
	
	public static void init() {
		
		// discord
		TextComponent url = new TextComponent("DISCORD");
							
		url.setColor(ChatColor.RED);
		url.setClickEvent(new ClickEvent(Action.OPEN_URL, "https://discord.gg/VedSyV7"));
		
		TextComponent t = new TextComponent("[Discord] Tenez vous au courant des actualités en rejoignant le ");
		t.setColor(ChatColor.LIGHT_PURPLE);
		
		t.addExtra(url);
		
		
		addMessageClass((TextComponent) t.duplicate());
		
		
		// boutique
		
		url = new TextComponent("BOUTIQUE");
		
		url.setColor(ChatColor.RED);
		url.setClickEvent(new ClickEvent(Action.OPEN_URL, "https://pumpmykins.buycraft.net/"));
		
		t = new TextComponent("[Boutique] Achetez vos grades / avantages sur la ");
		t.setColor(ChatColor.YELLOW);
		
		t.addExtra(url);
		
		addMessageClass((TextComponent) t.duplicate());
		
		// site / forum
		
		url = new TextComponent("SITE / FORUM");
		
		url.setColor(ChatColor.RED);
		url.setClickEvent(new ClickEvent(Action.OPEN_URL, "http://pumpmykins.eu"));
		
		t = new TextComponent("[PumpMyKins] ");
		t.setColor(ChatColor.GREEN);
		
		t.addExtra(url);
		
		addMessageClass((TextComponent) t.duplicate());
		
		//support
		
		url = new TextComponent("/SUPPORT");
		
		url.setColor(ChatColor.RED);
		url.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/support"));
		
		t = new TextComponent("[PumpMyStaff] En cas de problème, le staff est là pour vous via la commande ");
		t.setColor(ChatColor.AQUA);
		
		t.addExtra(url);
		
		addMessageClass((TextComponent) t.duplicate());
		
		// aide
		
		url = new TextComponent("/AIDE");
		
		url.setColor(ChatColor.RED);
		url.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/aide"));
		
		t = new TextComponent("[PumpMyHelp] Pour consulter la liste des commandes disponibles, faites ");
		t.setColor(ChatColor.BLUE);
		
		t.addExtra(url);
		
		addMessageClass((TextComponent) t.duplicate());
		
		// rules 
		
		url = new TextComponent("/RULES");
		
		url.setColor(ChatColor.RED);
		url.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/rules"));
		
		t = new TextComponent("[PumpMyHelp] Pour consulter la liste des règles du serveur, faites ");
		t.setColor(ChatColor.BLUE);
		
		t.addExtra(url);
		
		addMessageClass((TextComponent) t.duplicate());
		
	}
	
	public static void addMessageClass(TextComponent m) {
		if(!msgList.contains(m))
			msgList.add(m);
	}
	
	public static TextComponent getRandomText() {
		
		Random r = new Random();
		
		return msgList.get(r.nextInt(msgList.size()));
		
	}

	public static List<TextComponent> getMsgList() {
		return msgList;
	}

	public static void setMsgList(List<TextComponent> msgList) {
		AutoBroadcastManager.msgList = msgList;
	}

	public void startScheduler() {
		// TODO Auto-generated method stub
		
		MainBungeeUtils.getInstance().getProxy().getScheduler().schedule(MainBungeeUtils.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				TextComponent t = AutoBroadcastManager.getRandomText();
				
				System.out.println(t.toPlainText());
				
				MainBungeeUtils.sendAllPlayerMsg(t);
				
				TextComponent t2 = AutoBroadcastManager.getRandomText();				
				while (t == t2) {
					t2 = AutoBroadcastManager.getRandomText();
				}
				
				System.out.println(t2.toPlainText());
				MainBungeeUtils.sendAllPlayerMsg(t2);
				
				
			}
		}, 1 , 6 , TimeUnit.MINUTES);
		
	}
	
}
