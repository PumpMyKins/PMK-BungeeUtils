package fr.pmk_bungeeutils.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BroadcastAll extends Command {

	public BroadcastAll(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) sender;
			
			if(player.hasPermission("bcall.use")) {
				if(args.length == 0) {
					player.sendMessage(new TextComponent("�cEssayez /bcall <message>"));
				}
				if(args.length >= 1) {
					StringBuilder bc = new StringBuilder();
					for(String port : args) {
						bc.append(port + " ");
					}
					
					ProxyServer.getInstance().broadcast(new TextComponent("�9[Broadcast] " + bc.toString()));
				}
			}else {
				player.sendMessage(new TextComponent("�cVous n'avez pas la permission !"));
			}
		}

	}

}
