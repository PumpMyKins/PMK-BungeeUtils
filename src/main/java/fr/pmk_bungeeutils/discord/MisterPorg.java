package fr.pmk_bungeeutils.discord;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.hooks.EventListener;

public class MisterPorg {

	private static JDA jda;
	private boolean isInit;
	
	public void start(String token) {
		
		if(token.isEmpty()) {
			return;
		}
		
		try {
			
			jda = new JDABuilder(AccountType.BOT).setToken(token).buildBlocking();
			jda.addEventListener(new DiscordEvent());
			this.isInit = true;
			return;
			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static JDA getJda() {
		return jda;
	}

	public static void setJda(JDA jda) {
		MisterPorg.jda = jda;
	}

	public boolean isInit() {
		return isInit;
	}

	public void setInit(boolean isInit) {
		this.isInit = isInit;
	}
	
}
