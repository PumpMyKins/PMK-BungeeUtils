package fr.pmk_bungeeutils.commands;

import fr.pmk_bungeeutils.MainBungeeUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Lobby extends Command {

	public Lobby(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) sender;
			try {
				player.sendMessage(new TextComponent(MainBungeeUtils.getConfigUtils().getConfiguration("config.yml").getString("lobby.message").replace("&", "§")));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				player.connect(ProxyServer.getInstance().getServerInfo(MainBungeeUtils.getConfigUtils().getConfiguration("config.yml").getString("lobby.name")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
