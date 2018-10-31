package fr.pmk_bungeeutils.commands;

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing.PlayerInfo;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

public class MessageServer extends Command implements TabExecutor{

	public MessageServer(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) sender;
			
			if(args.length <= 1 ) {
				
				player.sendMessage(new TextComponent("§cEssayez /msg <joueur> <message>"));
				
			}else {
				
				String msg = new String();
				for(int i = 1; i<= args.length - 1; i++) {
					
					msg += args[i] + " ";
				}
				
				try {
					player.sendMessage(new TextComponent("§1[§r§9Toi§r§4->§r§b"
					+ProxyServer.getInstance().getPlayer(args[0]).getName()
					+"§r§1]§r"
					+msg));
					
					ProxyServer.getInstance().getPlayer(args[0]).sendMessage(new TextComponent("§1[§r§b"
					+player.getName()
					+"§r§4->§r§9Toi§r§1]§r"
					+msg));
				} catch (NullPointerException e) {
					player.sendMessage(new TextComponent("§c Joueurs introuvable"));
				}
			}
			
		}

	}

	@Override
	public Iterable<String> onTabComplete(CommandSender sender, String[] args) {		
		// TODO Auto-generated method stub
		ArrayList<String> l = new ArrayList<>();
		
		for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
			
			l.add(player.getDisplayName());
			
		}
		
		return l;
		
	}

}
