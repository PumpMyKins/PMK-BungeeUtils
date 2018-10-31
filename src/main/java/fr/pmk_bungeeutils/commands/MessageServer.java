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
			
			if(args.length <= 1) {
				player.sendMessage(new TextComponent("�cEssayez /msg <joueur> <message>"));
			}
			if(args.length >= 1 && args[1].equalsIgnoreCase(ProxyServer.getInstance().getPlayer(args[1]).getName())) {
				StringBuilder msg = new StringBuilder();
				for(String msgs : args) {
					msg.append(msgs.replace(args[0], null).replace(args[1], null) + " ");
				}
				
				player.sendMessage(new TextComponent("�7[Toi->"
				+ProxyServer.getInstance().getPlayer(args[1]).getName()
				+"�7] "
				+msg.toString()));
				
				ProxyServer.getInstance().getPlayer(args[1]).sendMessage(new TextComponent("�7["
				+player.getName()
				+"�7->Toi] "
				+msg.toString()));
			}
			
		}

	}

}