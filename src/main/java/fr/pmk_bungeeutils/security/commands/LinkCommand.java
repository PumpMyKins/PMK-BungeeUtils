package fr.pmk_bungeeutils.security.commands;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import fr.pmk_bungeeutils.security.LinkSessionData;
import fr.pmk_bungeeutils.security.SessionLoggerUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class LinkCommand extends Command {

	public LinkCommand(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		// TODO Auto-generated method stub
		
		if(!(sender instanceof ProxiedPlayer))
			return;
		
		ProxiedPlayer p = (ProxiedPlayer) sender;
			
		HashMap<String, LinkSessionData> h = SessionLoggerUtils.getLinkMap();
		List<String> l = SessionLoggerUtils.getUserLinkList();
		
		if(l.contains(p.getUniqueId().toString())) {
			// demande déjà en cours
			
			p.sendMessage(new TextComponent("§d§l[Discord]§r§c Vous avez déjà une requête de liaison en cours, merci de patienter !"));
			
			return;
			
		}else {
			// génération de la demande
			
			String token = UUID.randomUUID().toString();
			
			while (h.containsKey(token)) {
				
				token = UUID.randomUUID().toString();
				
			}
			
			// ajout des infos
			l.add(p.getUniqueId().toString());			
			h.put(token, new LinkSessionData(p));
			
			p.sendMessage(new TextComponent("§d§l[Discord]§r§a Entrez \"!link " + token + "\" dans le canal prevu à cette effet !"));
			
			// lancement du scheduler de suppression du token
			
			
			
		}
		
	}

}
