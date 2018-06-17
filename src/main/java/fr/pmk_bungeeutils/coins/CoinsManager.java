package fr.pmk_bungeeutils.coins;

import fr.pmk_bungeeutils.MainBungeeUtils;
import fr.pmk_bungeeutils.config.MySQLConnector;

public class CoinsManager {

	private static MainBungeeUtils m;

	public static CoinsConnector init(MainBungeeUtils mainBungeeUtils, MySQLConnector sql) {
		// TODO Auto-generated method stub
		m = mainBungeeUtils;
		
		registerCommands();
		registerMessagingPluginEvent();
		
		return new CoinsConnector(sql);
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
	
	private static class CoinsConnector {

		private MySQLConnector mySqlConnector;
		
		public CoinsConnector(MySQLConnector sql) {
			// TODO Auto-generated constructor stub
			this.mySqlConnector = sql;		
		}
		
		public int getPlayerCoins() {
			return 0;
		}

		public MySQLConnector getMySqlConnector() {
			return mySqlConnector;
		}

		public void setMySqlConnector(MySQLConnector mySqlConnector) {
			this.mySqlConnector = mySqlConnector;
		}
		
		
		
	}
	
}
