package fr.pmk_bungeeutils.scheduler;

import java.util.concurrent.TimeUnit;

import fr.pmk_bungeeutils.MainBungeeUtils;

public class BuyCraftScheduler {

	public void start() {
		
		MainBungeeUtils.getInstance().getProxy().getScheduler().schedule(MainBungeeUtils.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				MainBungeeUtils.getInstance().getProxy().getPluginManager().dispatchCommand(MainBungeeUtils.getInstance().getProxy().getConsole(), "buycraft forcecheck");
				
			}
			
		}, 5 , 5 , TimeUnit.MINUTES);
		
	}
	
}
