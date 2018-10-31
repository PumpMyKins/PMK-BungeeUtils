package fr.pmk_bungeeutils.coins;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.pmk_bungeeutils.MainBungeeUtils;
import fr.pmk_bungeeutils.config.MySQLConnector;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class CoinsManager {

	private static MainBungeeUtils m;

	public static CoinsManager init(MainBungeeUtils mainBungeeUtils) {
		// TODO Auto-generated method stub
		m = mainBungeeUtils;
		
		CoinsManager cm = new CoinsManager();
		
		registerCommands(cm);
		registerMessagingPluginEvent(cm);
		
		return cm;
		
	}
	
	private static void registerCommands(CoinsManager cm) {
		
		m.getProxy().getPluginManager().registerCommand(m, new CoinsCommand("coins",cm));
		
	}
	
	private static void registerMessagingPluginEvent(CoinsManager cm) {
		
		m.getProxy().getPluginManager().registerListener(m, new CoinsMessagingService(cm));
		m.getProxy().getPluginManager().registerListener(m, new CoinsListener(cm));
		
	}

	public static MainBungeeUtils getMainInstance() {
		
		return m;
		
	}

	public static void setMainInstance(MainBungeeUtils m) {
		
		CoinsManager.m = m;
		
	}
	
	public void initPlayer(ProxiedPlayer p) {
		
		new MySQLConnector().sendUpdate("INSERT INTO `coins`(`uuid`) VALUES (\"" + p.getUniqueId().toString() + "\")");
		
	}
	
	public boolean containPlayer(ProxiedPlayer p) {
		
		try {
			if(getPlayerCoins(p) == -1) {
				
				return false;
				
			}else {
				
				return true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public int getPlayerCoins(ProxiedPlayer p) throws SQLException {
		
		ResultSet r = new MySQLConnector().sendQuery("SELECT coin FROM coins WHERE uuid=\"" + p.getUniqueId().toString() + "\"");	
		
		if(r.next()) {
			
			int coin = r.getInt("coin");
			
			return coin;
			
		}
		
		return -1;
		
	}
	
	public void setPlayerCoins(ProxiedPlayer p, int c) {
		
		new MySQLConnector().sendUpdate("UPDATE coins SET coin="+ c +" WHERE uuid=" + p.getUniqueId().toString());
		
	}
	
}
