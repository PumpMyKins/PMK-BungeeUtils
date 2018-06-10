package fr.pmk_bungeeutils.security;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class SessionLoggerManager {
	
	public void onDiscordReceivedLogger(MessageReceivedEvent e) {
		// TODO Auto-generated method stub
		
		Message m = e.getMessage();
		
		if(m.getContentDisplay().startsWith("!")) {
			// commande reconnu
			
			String c = m.getContentDisplay().split(" ")[0];
			//System.out.println(c);
			
			if(c.equals("!open-session")) {
				
				onOpenSessionCommand(e);
				
			}else if(c.equals("!history")) {
				
				onHistoryAccountCommand(e);
				
			}else if(c.equals("!link")) {
				
				onLinkAccountCommand(e, m.getContentDisplay().split(" "));
				
			}else if(c.equals("!enable-session")) {
				
				onEnableSessionCommand(e,m.getContentDisplay().split(" "));
				
			}else if(c.equals("!disable-session")){
				
				onDisableSessionCommand(e,m.getContentDisplay().split(" "));
				
			}else {
				// commande invalide
				
				m.delete().complete();
				
				// envoie message de suppression + aide
				
				m.getAuthor().openPrivateChannel().complete()
				.sendMessage("Message envoy� dans le canal **session-logger** non reconnu comme �tant une commande valide, celui-ci a �t� supprim�.")
				.queue();
				
			}
			
		}else {
			// pas commande alors suppression
			
			m.delete().complete();
			
			// envoie message de suppression + aide
			
			m.getAuthor().openPrivateChannel().complete()
			.sendMessage("Message envoy� dans le canal **session-logger** non reconnu comme �tant une commande valide, celui-ci a �t� supprim�.")
			.queue();
			
		}
		
		
	}

	private void onEnableSessionCommand(MessageReceivedEvent e, String[] split) {
		// TODO Auto-generated method stub
		
	}

	private void onDisableSessionCommand(MessageReceivedEvent e, String[] split) {
		// TODO Auto-generated method stub
		
	}

	private void onLinkAccountCommand(MessageReceivedEvent e, String... args) {
		// TODO Auto-generated method stub
		
		String playerName = args[1];
		
		if(playerName == null) {
			
			e.getMessage().delete().queue();
			
			e.getChannel().sendMessage(new MessageBuilder().append(e.getAuthor())
			.append(" Param�tre de commande invalide, il faut sp�cifi� votre pseudo en jeu lors de l'execution de la commande. \n Exemple : !link Clem_Fern")
			.build())
			.queue();
			
		}else {
			
			ProxiedPlayer p = ProxyServer.getInstance().getPlayer(playerName);
			
			if(p == null | !p.isConnected()) {				
				
				e.getMessage().delete().queue();
				// pas valide ou non connect�
				e.getChannel().sendMessage(new MessageBuilder().append(e.getAuthor())
						.append(" Param�tre de commande invalide, le speudo sp�cifi� n'est pas valide ou alors r�f�re � un joueur non connect� !")
						.build())
						.queue();
				
			}else {
				
				e.getMessage().delete().queue();
				// pas valide ou non connect�
				e.getChannel().sendMessage(new MessageBuilder().append(e.getAuthor())
						.append(" Envoie de la demande de confirmation en jeu ! Vous disposez de 30 secondes pour y r�pondre")
						.build())
						.queue();
				
				// envoie de la demande en jeu
				
				
			}
			
		}
		
	}

	private void onHistoryAccountCommand(MessageReceivedEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void onOpenSessionCommand(MessageReceivedEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
