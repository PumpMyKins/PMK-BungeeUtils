package fr.pmk_bungeeutils.support;

import java.util.HashMap;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class EnSupportCommand extends Command {

	private static HashMap<ProxiedPlayer,SupportData> supportMap = new HashMap<>();
	
	public EnSupportCommand() {
		super("ensupport");
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if(sender instanceof ProxiedPlayer) {
			
			ProxiedPlayer p = (ProxiedPlayer) sender;
			
			if(supportMap.containsKey(p) & p.hasPermission("support.active")) {
				
				SupportData sD = supportMap.get(p);
				
				if(sD.getState()) {
					
					sD.setState(false);
					// passage en false
					supportMap.replace(p, sD);
					p.sendMessage("Changement du mod de support, message non vissible");
					
				}else {
					
					sD.setState(true);
					// passage en true
					supportMap.replace(p, sD);
					p.sendMessage("Changement du mod de support, message vissible");
				}
				
			}
			
		}

	}

	public static HashMap<ProxiedPlayer,SupportData> getSupportMap() {
		return supportMap;
	}

	public static void setSupportMap(HashMap<ProxiedPlayer,SupportData> supportMap) {
		EnSupportCommand.supportMap = supportMap;
	}

}
