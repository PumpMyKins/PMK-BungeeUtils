package fr.pmk_bungeeutils.blockmod;

import fr.pmk_bungeeutils.MainBungeeUtils;
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
			
			if(!p.hasPermission("blockmod.set")) {
				p.sendMessage("Pas la perm !");
				return;
			}
			
			p.sendMessage("[BLOCKMOD] option de la commande : -s true/false ( activé ou non ) / -r raison de blockage / -p permissions ( permissions d'overpass ) / -u pour update les joueurs");
			
			//if(!(args.length  <= 2)) {
				
				String param = args[0];
				
				if(param.equalsIgnoreCase("-s")) {
					
					String state = args[1];
					
					if(state.equalsIgnoreCase("true")) {
						
						BlockModManager.setActive(true);
						return;
						
					}else if (state.equalsIgnoreCase("false")) {
						
						BlockModManager.setActive(false);
						return;
						
					}else {
						p.sendMessage("Mauvaise argument !");
						return;
					}
					
				}else if (param.equalsIgnoreCase("-p")) {
					
					String perm = args[1];
					System.out.println("p : " + perm);
					
					BlockModManager.setOverPerm(perm);
					return;
					
				}else if (param.equalsIgnoreCase("-r")) {
					
					String raison = "";
					
					for (int i = 1; i < args.length; i++) {
						raison += args[i] + " ";
					}
					
					System.out.println("r : " + raison);
					
					BlockModManager.setRaison(raison);
					return;
					
				}if (param.equalsIgnoreCase("-i")) {
					
					p.sendMessage("Perm " + BlockModManager.getOverPerm());
					p.sendMessage("Raison " + BlockModManager.getRaison());
					p.sendMessage("State " + BlockModManager.isActive());
					return;
					
				}else if (param.equalsIgnoreCase("-u")) {
					
					// update des joueurs
					MainBungeeUtils.updatePlayer();
					return;
					
				}else {
					p.sendMessage("Mauvaise argument !");
					return;
				}
				
			}
			return;
			/*
			String arg = "";
			
			for (String string : args) {
				arg += string + " ";
			}
			
			System.out.println(arg);
			
			*/
		//}

	}

}
