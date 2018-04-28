package fr.pmk_bungeeutils.blockmod;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BlockModCommand extends Command {

	public BlockModCommand() {
		super("blockmod");
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if ((sender instanceof ProxiedPlayer)) {
			
			ProxiedPlayer p = (ProxiedPlayer)sender;
			
			p.sendMessage("[BLOCKMOD] option de la commande : -s true/false ( activé ou non ) / -r raison de blockage / -p permissions ( permissions d'overpass )");
			
			String arg = "";
			
			for (String string : args) {
				arg += string + " ";
			}
			
			System.out.println(arg);
			
			
		}

	}

}
