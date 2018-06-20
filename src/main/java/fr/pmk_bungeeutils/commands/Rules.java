package fr.pmk_bungeeutils.commands;

import java.util.List;

import fr.pmk_bungeeutils.MainBungeeUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Rules extends Command {

	private List<String> list;
	
	public Rules(String name , List<String> l) {
		super(name);
		this.list = l;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) sender;
			try {
				player.sendMessage(new TextComponent(MainBungeeUtils.getConfigUtils().getConfiguration("rules.yml").getString("rules")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
