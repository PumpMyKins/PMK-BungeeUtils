package fr.pmk_bungeeutils.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

import fr.pmk_bungeeutils.MainBungeeUtils;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

/** 
 * Classe de methods utiles pour l'utilisation des configurations BungeeCord
 * @author Clem-Fern
 */

public class ConfigUtils {

	private static ConfigUtils config = new ConfigUtils(); // variable instancier de la class ConfigUtils par defaut
	private static MainBungeeUtils main;	// variable contenant une instance courante du Main
	private static List<String> playerList;
	
	/**
	 * 
	 * @param m MainBungeeMotd / instance de la class principale
	 * @return Instance de ConfigUtils initialisé au paramètre MainBungeeMotd donné
	 */
	public static ConfigUtils getConfig(MainBungeeUtils m) {		//Methods d'initialisation de la class ConfigUtils
		main = m;
		return config; // retournant
	}

	public void initDataFolder() {
		
		if(!main.getDataFolder().exists()) {
			main.getDataFolder().mkdir();
		}
		
	}
	
	public File initAndGetFile(String fileName) {
		
		File file = new File(main.getDataFolder(),fileName);
		
		if(!file.exists()) {
			try (InputStream in = main.getResourceAsStream(fileName)){
				Files.copy(in, file.toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return file;
	}
	
	public void initPlayerLogin() {
		
		playerList = getConfigPlayerList();
		
	}
	
	public Configuration getConfiguration(String fileName) throws Exception {
		
		File file = new File(main.getDataFolder(),fileName);
		
		try {
			return ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
		} catch (Exception e) {
			throw new Exception( fileName + " impossible de récupérer la configuration" );
		}		
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getConfigPlayerList(){
		try {
			return (List<String>) getConfiguration("player.yml").getList("playerlogin");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void setConfigPlayerList(List<String> l){
		try {
			Configuration c = getConfiguration("player.yml");			
			c.set("playerlogin", l);
			
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(c, initAndGetFile("player.yml"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }	
	}
	
	public boolean getBlockModState() {
		try {
			return getConfiguration("config.yml").getBoolean("blockmod.active");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public String getBlockModOverridePerm() {
		try {
			return getConfiguration("config.yml").getString("blockmod.override_perm");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String getBlockModRaison() {
		try {
			return getConfiguration("config.yml").getString("blockmod.raison");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "[DEFAULT-RAISON-ERROR] Serveur non disponible, tenez vous au courant sur le forum/discord";
	}
	
	public void setBlockModState(boolean b) {
		try {
			Configuration c = getConfiguration("config.yml");			
			c.set("blockmod.active", b);
			
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(c, initAndGetFile("config.yml"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}
	
	public void setBlockModRaison(String r) {
		try {
			Configuration c = getConfiguration("config.yml");			
			c.set("blockmod.raison", r);
			
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(c, initAndGetFile("config.yml"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }		
	}
	
	public void setBlockModOverridePerm(String p) {
		try {
			Configuration c = getConfiguration("config.yml");			
			c.set("blockmod.override_perm", p);
			
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(c, initAndGetFile("config.yml"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}

	public static List<String> getPlayerList() {
		return playerList;
	}
	
	public static void savePlayer() {
		
		config.setConfigPlayerList(getPlayerList());
		
	}
	
}