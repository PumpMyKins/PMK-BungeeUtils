package fr.pmk_bungeeutils.coins;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.pmk_bungeeutils.MainBungeeUtils;
import fr.pmk_bungeeutils.config.MySQLConnector;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class CoinsManager {

	private static MainBungeeUtils m;

	public static CoinsManager init(MainBungeeUtils mainBungeeUtils, MySQLConnector sql) {
		// TODO Auto-generated method stub
		m = mainBungeeUtils;
		
		registerCommands();
		registerMessagingPluginEvent();
		
		return new CoinsManager(sql);
	}
	
	private static void registerCommands() {
		
		
		
	}
	
	private static void registerMessagingPluginEvent() {
		m.getProxy().getPluginManager().registerListener(m, new CoinsMessagingService());
	}

	public static MainBungeeUtils getMainInstance() {
		return m;
	}

	public static void setMainInstance(MainBungeeUtils m) {
		CoinsManager.m = m;
	}

	private MySQLConnector sql;
	
	public CoinsManager(MySQLConnector s) {
		// TODO Auto-generated constructor stub
		this.setSql(s);
	}
	
	public void initPlayer(ProxiedPlayer p) {
		
		
		
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
		
		ResultSet r = sql.sendQuery("SELECT coin FROM coins WHERE uuid=\"abcd\"");	
		
		if(r.next()) {
			
			r.next();
			
			int coin = r.getInt("coin");
			
			return coin;
			
		}
		
		return -1;
		
	}
	
	public void setPlayerCoins(ProxiedPlayer p, int c) {
		
		sql.sendUpdate("UPDATE coins SET coin="+ c +" WHERE uuid=" + p.getUniqueId().toString());
		
	}

	public MySQLConnector getSql() {
		return sql;
	}

	public void setSql(MySQLConnector sql) {
		this.sql = sql;
	}
	
}
