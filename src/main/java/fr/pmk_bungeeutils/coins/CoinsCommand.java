package fr.pmk_bungeeutils.coins;

import java.sql.SQLException;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CoinsCommand extends Command {

	private CoinsManager cm;
	
	public CoinsCommand(String name , CoinsManager cm) {
		super(name);
		this.cm = cm;
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		// TODO Auto-generated method stub

		if(sender instanceof ProxiedPlayer) {
			
			ProxiedPlayer p = (ProxiedPlayer) sender;
			
			try {
				
				int coins = cm.getPlayerCoins(p);
				p.sendMessage("�a�l[ PumpMyCoins ]�r�2 Vous avez �b" + coins + "�2 coins !");	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				p.sendMessage("�a�l[ PumpMyCoins ]�r�c Erreur de r�cup�ration des coins, contactez le staff !");
				
			}
			
		}else {
			
			sender.sendMessage("�a�l[ PumpMyCoins ]�r�cImpossible ici !");
			return;
			
		}
		
	}

}
