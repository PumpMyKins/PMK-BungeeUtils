package fr.pmk_bungeeutils.commands;

import java.util.List;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Aide extends Command {

	private List<String> list;
	
	public Aide(String name, List<String> l) {
		super(name);
		this.list = l;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) sender;
				
			player.sendMessage(new TextComponent("§3§l=======§r§b PumpMyAide§r§3§l ======="));
			
			for (String string : list) {
				
				player.sendMessage(new TextComponent("- " + string.replace("&", "§")));
				
			}
			
			player.sendMessage(new TextComponent("§3§l=========================="));
			
		}

	}

}
