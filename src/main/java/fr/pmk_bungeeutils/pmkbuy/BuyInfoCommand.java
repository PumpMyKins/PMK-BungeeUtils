package fr.pmk_bungeeutils.pmkbuy;

import fr.pmk_bungeeutils.MainBungeeUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BuyInfoCommand extends Command {

	public BuyInfoCommand() {
		super("pmkbuyinfo");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		String username = args[0];
		String montant = args[1] + args[2];
		
		if(Integer.valueOf(args[1]).intValue() > 1) {
			
			System.out.println("§l§2[ §aBoutique §2] §r§dMerci à §r§l§n§c#" + username + "# §r§dpour son soutien au serveur de §r§l§n§c#" + montant + "# §r§d!!!");
			
			for(ProxiedPlayer p: MainBungeeUtils.getInstance().getProxy().getPlayers()){
				
				p.sendMessage(new TextComponent("§l§2[ §aBoutique §2] §r§dMerci à §r§l§n§c#" + username + "# §r§dpour son soutien au serveur de §r§l§n§c#" + montant + "# §r§d!!!"));
		
			}
		}

	}

}
