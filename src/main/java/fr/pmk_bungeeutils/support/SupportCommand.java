package fr.pmk_bungeeutils.support;

import java.util.HashMap;
import java.util.Map.Entry;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class SupportCommand extends Command {

	public SupportCommand() {
		super("support");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if(sender instanceof ProxiedPlayer) {
			
			ProxiedPlayer p = (ProxiedPlayer) sender;
			
			String msg = "";
			
			if(args.length <= 4) {
				p.sendMessage(new TextComponent("§c Votre message au support doit contenir plus de 4 mots !"));
				return;
			}
			
			for (String a : args) {
				msg += a + " ";
			}
			
			HashMap<ProxiedPlayer, SupportData> h = EnSupportCommand.getSupportMap();
			
			p.sendMessage(new TextComponent("§9[SUPPORT]§7§l<§r§1" + p.getDisplayName() + "§7§l>§r Votre message à bien été envoyé au support. Il y a actuellement " + h.size() + " personnes connectées pour répondre à votre demande !"));
			
			for (Entry<ProxiedPlayer, SupportData> e : h.entrySet()) {
				
				if(e.getValue().getState()) {
						e.getKey().sendMessage(new TextComponent("§9[SUPPORT]§7§l<§r§1" + p.getDisplayName() + "§7§l>§r " + msg));
				}
				
			}
			
		}

	}

}
