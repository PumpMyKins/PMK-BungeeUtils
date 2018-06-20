package fr.pmk_bungeeutils.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {

	private Connection connector;
	
	private static String url;
	private static int port;
	private static String user,mdp,base;
	
	public static void init(String url, String user, String mdp, String base) {
		MySQLConnector.setUrl(url);
		MySQLConnector.setUser(user);
		MySQLConnector.setMdp(mdp);
		MySQLConnector.setPort(3306);
		MySQLConnector.setBase(base);
		
	}
	
	public MySQLConnector() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mariadb://"+ url  + ":" + port + "/" + base + "?user=" + user + "&password=" + mdp);	//init connector
			connector = connection;
		} catch (SQLException e) {
			System.out.println("MySQL execption message : " + e.getMessage());
			System.out.println("MySQL execption error code : " + e.getErrorCode());
			System.out.println("MySQL execption SQLState : " + e.getSQLState());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendUpdate(String command) {
		try {
			Statement statement = connector.createStatement();	//create statement
			statement.executeUpdate(command);	//send statement
			
			// close
			statement.close();
			connector.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//close if error
		try {
			if(!connector.isClosed()) {
				connector.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet sendQuery(String command) {
		try {
			Statement statement = connector.createStatement();	//create statement
			ResultSet rs = statement.executeQuery(command);	//send statement
			
			// close
			statement.close();
			connector.close();	
			
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//close if error
		try {
			if(!connector.isClosed()) {
				connector.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null; // return null if error
	}

	public Connection getConnector() {
		return connector;
	}

	public void setConnector(Connection connector) {
		this.connector = connector;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		MySQLConnector.url = url;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		MySQLConnector.port = port;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		MySQLConnector.user = user;
	}

	public static String getMdp() {
		return mdp;
	}

	public static void setMdp(String mdp) {
		MySQLConnector.mdp = mdp;
	}

	public static String getBase() {
		return base;
	}

	public static void setBase(String base1) {
		base = base1;
	}
	
}