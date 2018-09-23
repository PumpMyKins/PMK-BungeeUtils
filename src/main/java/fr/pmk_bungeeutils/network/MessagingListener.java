package fr.pmk_bungeeutils.network;

import net.md_5.bungee.api.event.PluginMessageEvent;

public interface MessagingListener {

	public void onMessagingTagReceive(PluginMessageEvent event);
	
}
