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
					player.sendMessage(new TextComponent("§cEssayez /bcall <message>"));
				}
				if(args.length >= 1) {
					StringBuilder bc = new StringBuilder();
					for(String port : args) {
						port = port.replace("&", "§");
						bc.append(port + " ");
					}
					
					ProxyServer.getInstance().broadcast(new TextComponent("§6§l[§r§2Pump§eMy§aKins§r§6§l]§r " + bc.toString()));
				}
			}else {
				player.sendMessage(new TextComponent("§cVous n'avez pas la permission !"));
			}
		}else {
			
			if(args.length == 0) {
				sender.sendMessage(new TextComponent("§cEssayez /bcall <message>"));
				return;
			}
			
			if(args.length >= 1) {
				StringBuilder bc = new StringBuilder();
				for(String port : args) {
					port = port.replace("&", "§");
					bc.append(port + " ");
				}
				
				ProxyServer.getInstance().broadcast(new TextComponent("§6§l[§r§2Pump§eMy§aKins§r§6§l]§r " + bc.toString()));
			}
			
		}

	}

}
