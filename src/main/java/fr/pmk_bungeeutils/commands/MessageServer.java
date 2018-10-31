package fr.pmk_bungeeutils.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing.PlayerInfo;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MessageServer extends Command {

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
					
					msg = msg + args[i];
				}
				
				try {
					player.sendMessage(new TextComponent("§2[§r§9Toi§r§4->§r§b"
					+ProxyServer.getInstance().getPlayer(args[0]).getName()
					+"§r§2]§r"
					+msg));
					
					ProxyServer.getInstance().getPlayer(args[0]).sendMessage(new TextComponent("§2[§r§b"
					+player.getName()
					+"§r§4->§2[§r§9Toi§r§2]§r"
					+msg));
				} catch (NullPointerException e) {
					player.sendMessage(new TextComponent("§c Joueurs introuvable"));
				}
			}
			
		}

	}

}
