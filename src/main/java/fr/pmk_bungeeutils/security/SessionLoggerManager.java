package fr.pmk_bungeeutils.security;

import java.util.Collection;

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
				return;
				
			}else if(c.equals("!history")) {
				
				onHistoryAccountCommand(e);
				
			}else if(c.equals("!link")) {
				
				onLinkAccountCommand(e, m.getContentDisplay().split(" "));
				
			}else if(c.equals("!enable-session")) {
				
				onEnableSessionCommand(e,m.getContentDisplay().split(" "));
				
			}else if(c.equals("!disable-session")){
				
				onDisableSessionCommand(e,m.getContentDisplay().split(" "));
				
			}else {
				
				// envoie message de suppression + aide
				
				e.getAuthor().openPrivateChannel().complete()
				.sendMessage("Message envoy� dans le canal **session-logger** non reconnu comme �tant une commande valide, celui-ci a �t� supprim�.")
				.complete();
				
				// commande invalide
				
				m.delete().complete();
				
			}
			
		}else {
			
			// envoie message de suppression + aide
			
			e.getAuthor().openPrivateChannel().complete()
			.sendMessage("Message envoy� dans le canal **session-logger** non reconnu comme �tant une commande valide, celui-ci a �t� supprim�.")
			.complete();
			
			// pas commande alors suppression
			
			m.delete().complete();
			
		}
		
		
	}

	private void onEnableSessionCommand(MessageReceivedEvent e, String[] split) {
		// TODO Auto-generated method stub
		
	}

	private void onDisableSessionCommand(MessageReceivedEvent e, String[] split) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("deprecation")
	private void onLinkAccountCommand(MessageReceivedEvent e, String... args) {
		// TODO Auto-generated method stub
		
		if(args.length != 2) {
			
			e.getMessage().delete().queue();
			
			e.getChannel().sendMessage(new MessageBuilder().append(e.getAuthor())
			.append(" Param�tre de commande invalide, il faut sp�cifi� votre pseudo en jeu lors de l'execution de la commande. \n Exemple : !link Clem_Fern")
			.build())
			.queue();
			
		}else {
			
			String playerName = args[1];
			
			Collection<ProxiedPlayer> cPlayer = ProxyServer.getInstance().matchPlayer(playerName);
			
			if(cPlayer.isEmpty()) {
				
				e.getMessage().delete().queue();
				// pas valide ou non connect�
				e.getChannel().sendMessage(new MessageBuilder().append(e.getAuthor())
						.append(" Param�tre de commande invalide, aucun joueur trouv� !")
						.build())
						.queue();
				
			}else if(cPlayer.size() == 1) {
				
				ProxiedPlayer p = (ProxiedPlayer) cPlayer.toArray()[0];
				
				if(SessionLoggerUtils.getLinkMap().containsKey(p.getUniqueId().toString())) {
					
					e.getMessage().delete().queue();
					// d�j� une requ�te en cours
					e.getChannel().sendMessage(new MessageBuilder().append(e.getAuthor())
							.append(" Une req�te de liaison pour ce joueur est d�j� en attente !")
							.build())
							.queue();
					
				}else {
					
					// player trouv�
					e.getMessage().delete().queue();
					// pas valide ou non connect�
					e.getChannel().sendMessage(new MessageBuilder().append(e.getAuthor())
							.append(" Envoie de la demande de confirmation en jeu ! Vous disposez de 30 secondes pour y r�pondre")
							.build())
							.queue();
					
					// envoie de la demande en jeu
					
					
					SessionLoggerUtils.inGameLink(p,e.getAuthor());
					
				}
				
			}else {
				
				String playerList = "";
				
				for (ProxiedPlayer proxiedPlayer : cPlayer) {
					playerList += " - " + proxiedPlayer.getName() + " \n ";
				}
				
				e.getMessage().delete().queue();
				// pas valide ou non connect�
				e.getChannel().sendMessage(new MessageBuilder().append(e.getAuthor())
						.append(" Plusieurs joueurs trouv�s : \n " + playerList)
						.build())
						.queue();
				
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
