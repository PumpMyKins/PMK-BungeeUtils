package fr.pmk_bungeeutils.config;

import java.util.concurrent.TimeUnit;

import fr.pmk_bungeeutils.MainBungeeUtils;

public class ConfigPlayerSaveScheduler {

	public void start() {
		
		MainBungeeUtils.getInstance().getProxy().getScheduler().schedule(MainBungeeUtils.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("Synchronisation de la liste des joueurs en config...");
				ConfigUtils.savePlayer();
				
			}
		}, 1 , TimeUnit.MINUTES);
		
	}
	
}
