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
				p.sendMessage("§cPas la perm !");
				return;
			}
			
			p.sendMessage("§4======================");
			p.sendMessage("§4[BLOCKMOD] option de la commande :");
			p.sendMessage("§c-s true/false");
			p.sendMessage("§c-r raison de blockage");
			p.sendMessage("§c-p permissions d'overpass");
			p.sendMessage("§c-u pour update les joueurs");
			p.sendMessage("§4======================");
			
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
						p.sendMessage("§cMauvaise argument !");
						return;
					}
					
				}else if (param.equalsIgnoreCase("-p")) {
					
					String perm = args[1];
					//System.out.println("p : " + perm);
					
					BlockModManager.setOverPerm(perm);
					return;
					
				}else if (param.equalsIgnoreCase("-r")) {
					
					String raison = "";
					
					for (int i = 1; i < args.length; i++) {
						raison += args[i] + " ";
					}
					
					//System.out.println("r : " + raison);
					
					BlockModManager.setRaison(raison);
					return;
					
				}if (param.equalsIgnoreCase("-i")) {
					
					p.sendMessage("§cPerm " + BlockModManager.getOverPerm());
					p.sendMessage("§4======================");
					p.sendMessage("§cRaison " + BlockModManager.getRaison());
					p.sendMessage("§4======================");
					p.sendMessage("§cState " + BlockModManager.isActive());
					return;
					
				}else if (param.equalsIgnoreCase("-u")) {
					
					// update des joueurs
					MainBungeeUtils.updatePlayer();
					return;
					
				}else {
					p.sendMessage("§cMauvaise argument !");
					return;
				}
				
			}
			return;
	}

}
