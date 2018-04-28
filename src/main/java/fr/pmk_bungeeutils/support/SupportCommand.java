package fr.pmk_bungeeutils.support;

import java.util.HashMap;
import java.util.Map.Entry;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class SupportCommand extends Command {

	public SupportCommand() {
		super("support");
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if(sender instanceof ProxiedPlayer) {
			
			ProxiedPlayer p = (ProxiedPlayer) sender;
			
			String msg = "";
			
			if(args.length <= 4) {
				p.sendMessage("§c Votre message au support doit contenir plus de 4 mots !");
			}
			
			for (String a : args) {
				msg += a + " ";
			}
			
			HashMap<ProxiedPlayer, SupportData> h = EnSupportCommand.getSupportMap();
			
			for (Entry<ProxiedPlayer, SupportData> e : h.entrySet()) {
				
				if(e.getValue().getState()) {
					if(!e.getKey().equals(p)) {
						e.getKey().sendMessage("§9[SUPPORT]§7§l<§r§1" + p.getDisplayName() + "§7§l>§r " + msg);
					}
				}
				
			}
			
		}

	}

}
