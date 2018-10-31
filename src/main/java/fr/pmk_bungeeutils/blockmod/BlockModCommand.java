package fr.pmk_bungeeutils.blockmod;

import fr.pmk_bungeeutils.MainBungeeUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BlockModCommand extends Command {

	public BlockModCommand() {
		super("blockmod");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if ((sender instanceof ProxiedPlayer)) {
			
			ProxiedPlayer p = (ProxiedPlayer)sender;
			
			if(!p.hasPermission("blockmod.set")) {
				p.sendMessage(new TextComponent("§cPas la perm !"));
				return;
			}
			
			p.sendMessage(new TextComponent("§4======================"));
			p.sendMessage(new TextComponent("§4[BLOCKMOD] option de la commande :"));
			p.sendMessage(new TextComponent("§c-s true/false"));
			p.sendMessage(new TextComponent("§c-r raison de blockage"));
			p.sendMessage(new TextComponent("§c-p permissions d'overpass"));
			p.sendMessage(new TextComponent("§c-u pour update les joueurs"));
			p.sendMessage(new TextComponent("§4======================"));
			
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
						p.sendMessage(new TextComponent("§cMauvaise argument !"));
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
					
					p.sendMessage(new TextComponent("§cPerm " + BlockModManager.getOverPerm()));
					p.sendMessage(new TextComponent("§4======================"));
					p.sendMessage(new TextComponent("§cRaison " + BlockModManager.getRaison()));
					p.sendMessage(new TextComponent("§4======================"));
					p.sendMessage(new TextComponent("§cState " + BlockModManager.isActive()));
					return;
					
				}else if (param.equalsIgnoreCase("-u")) {
					
					// update des joueurs
					MainBungeeUtils.updatePlayer();
					p.sendMessage(new TextComponent("§cUpdate des joueurs !"));
					return;
					
				}else {
					p.sendMessage(new TextComponent("§cMauvaise argument !"));
					return;
				}
				
			}
			return;
	}

}
