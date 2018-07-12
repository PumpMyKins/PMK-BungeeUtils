package fr.pmk_bungeeutils.security.commands;

import java.util.HashMap;

import fr.pmk_bungeeutils.security.LinkSessionData;
import fr.pmk_bungeeutils.security.SessionLoggerUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class LinkCommand extends Command {

	public LinkCommand(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		// TODO Auto-generated method stub
		
		if(!(sender instanceof ProxiedPlayer))
			return;
		
		ProxiedPlayer p = (ProxiedPlayer) sender;
		
		if(args.length == 1) {
			
			String uuid = args[0];
			
			HashMap<String, LinkSessionData> h = SessionLoggerUtils.getLinkMap();
			
			if(h.containsKey(p.getUniqueId().toString())) {
				
				LinkSessionData d = h.get(p.getUniqueId().toString());
				
				String r = d.getRefuse_UUID().toString();
				String a = d.getAccept_UUID().toString();
				
				if(uuid.equals(r)) {
					// refus
					p.sendMessage("§9[PumpMyStaff] refus");
					
				}else if(uuid.equals(a)){
					// accept
					p.sendMessage("§9[PumpMyStaff] accept");
					
				}else {
					// invalide
					p.sendMessage("§9[PumpMyStaff]§c Requête non valide !");
					
				}
				
			}else {
				
				// pas de demande
				p.sendMessage("§9[PumpMyStaff] pas de demande");
				
			}
			
			
		}else {
			return;
		}
		
	}

}