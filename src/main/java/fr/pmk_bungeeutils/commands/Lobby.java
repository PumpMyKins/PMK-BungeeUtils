package fr.pmk_bungeeutils.commands;

import java.util.concurrent.TimeUnit;

import fr.pmk_bungeeutils.MainBungeeUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Lobby extends Command {

	private String message = "default";
	private String server = "lobby";
	
	public Lobby(String name, String msg , String s) {
		super(name);
		this.message = msg;
		this.server = s;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		
		if(sender instanceof ProxiedPlayer) {
			
			ProxiedPlayer player = (ProxiedPlayer) sender;
			String currentServer = player.getServer().getInfo().getName();
			
			System.out.println(currentServer);
			
			if(!currentServer.equals(server)) {
								player.sendMessage(new TextComponent(message));	
			
				MainBungeeUtils.getInstance().getProxy().getScheduler().schedule(MainBungeeUtils.getInstance(), new Runnable() {
		            @Override
		            public void run() {
		                
		            	try {				
		    				player.connect(ProxyServer.getInstance().getServerInfo(server));
		    			} catch (Exception e) {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
		            	
		            }
		        }, 3 , TimeUnit.SECONDS);
					
			}else {
								player.sendMessage(new TextComponent("§cVous etes déjà connecté au serveur lobby"));	
				
			}
		}
			
	}

}
