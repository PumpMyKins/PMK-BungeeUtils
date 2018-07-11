package fr.pmk_bungeeutils.security;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class SessionLoggerManager {
	
	public final static String channelID = "453229576269725726";
	
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
				.sendMessage("Message envoyé dans le canal **session-logger** non reconnu comme étant une commande valide, celui-ci a été supprimé.")
				.complete();
				
				// commande invalide
				
				m.delete().complete();
				
			}
			
		}else {
			
			// envoie message de suppression + aide
			
			e.getAuthor().openPrivateChannel().complete()
			.sendMessage("Message envoyé dans le canal **session-logger** non reconnu comme étant une commande valide, celui-ci a été supprimé.")
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

	private void onLinkAccountCommand(MessageReceivedEvent e, String... args) {
		// TODO Auto-generated method stub
		
		if(args.length != 2) {
			
			e.getMessage().delete().queue();
			
			e.getChannel().sendMessage(new MessageBuilder().append(e.getAuthor())
			.append(" Paramètre de commande invalide, il faut spécifié votre pseudo en jeu lors de l'execution de la commande. \n Exemple : !link Clem_Fern")
			.build())
			.queue();
			
		}else {
			
			/*if(linkMap.containsKey(e.getAuthor().getId())) {
				// requête déjà en cours
				
				e.getMessage().delete().queue();
				
				e.getChannel().sendMessage(new MessageBuilder().append(e.getAuthor())
				.append(" Vous avez déjà générer un token de liaison pour votre compte discord, merci de patienter !")
				.build())
				.queue();
				
			}else {
				
				// récupération du token
				
				
				
			}*/
			
		}
		
	}

	private void onHistoryAccountCommand(MessageReceivedEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void onOpenSessionCommand(MessageReceivedEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
