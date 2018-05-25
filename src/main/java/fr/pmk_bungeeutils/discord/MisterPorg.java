package fr.pmk_bungeeutils.discord;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class MisterPorg {

	private static JDA jda;
	
	public void start(String token) {
		
		if(token.isEmpty()) {
			return;
		}
		
		try {
			
			jda = new JDABuilder(AccountType.BOT).setToken(token).buildBlocking();
			
			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
