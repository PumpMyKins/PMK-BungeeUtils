package fr.pmk_bungeeutils.discord;

import fr.pmk_bungeeutils.security.SessionLoggerManager;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class DiscordEvent implements EventListener{

	@Override
	public void onEvent(Event e) {
		// TODO Auto-generated method stub
		
		if(e instanceof MessageReceivedEvent) {
			
			onMessageReceivedEvent((MessageReceivedEvent) e);
			
		}else {
			
			
			
		}
		
	}

	private void onMessageReceivedEvent(MessageReceivedEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getAuthor().isBot())
			return;
		
		if(e.getChannel().getId().equals(SessionLoggerManager.channelID)) {
			// session logger canal
			new SessionLoggerManager().onDiscordReceivedLogger(e);			
			
		}else if(e.getChannel().getId().equals("")){
			// général bot canal
			
			
		}else {
			//nothing
		}
		
	}

	
	
}
