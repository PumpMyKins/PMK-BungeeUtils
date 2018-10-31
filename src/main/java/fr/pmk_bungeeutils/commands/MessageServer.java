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
				for(int i = 2; i<= args.length - 1; i++) {
					
					msg = msg + args[i];
				}
				
				try {
					player.sendMessage(new TextComponent("§7[Toi->"
					+ProxyServer.getInstance().getPlayer(args[1]).getName()
					+"§7] "
					+msg));
					
					ProxyServer.getInstance().getPlayer(args[1]).sendMessage(new TextComponent("§7["
					+player.getName()
					+"§7->Toi] "
					+msg));
				} catch (NullPointerException e) {
					player.sendMessage(new TextComponent("§c Joueurs introuvable"));
				}
			}
			
		}

	}

}
