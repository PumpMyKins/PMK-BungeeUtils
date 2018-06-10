package fr.pmk_bungeeutils.discord;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class SessionLoggerManager {
	
	public void onReceivedLogger(MessageReceivedEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getMessage().getContentDisplay().startsWith("!")) {
			// commande reconnu
			
			
		}else {
			// pas commande alors suppression
			
			e.getMessage().delete().complete();
			
			// envoie message de suppression + aide
			
			e.getMessage().getAuthor().openPrivateChannel().complete()
			.sendMessage("Message envoyé dans le canal **session-logger** non reconnu comme étant une commande valide, celui-ci a été supprimé.")
			.complete();
			
		}
		
		
	}

}
