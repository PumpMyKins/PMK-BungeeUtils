package fr.pmk_bungeeutils.security;

import java.util.UUID;

import net.dv8tion.jda.core.entities.User;

public class LinkSessionData {

	private boolean used;
	
	private UUID accept_UUID;
	private UUID refuse_UUID;

	private User user;	
	
	public LinkSessionData(User u) {
		
		this.used = false;
		this.user = u;
		
		generateUUID();
		
	}
	
	private void generateUUID() {
		
		this.accept_UUID = UUID.randomUUID();
		this.refuse_UUID = UUID.randomUUID();
		
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public UUID getAccept_UUID() {
		return accept_UUID;
	}

	public UUID getRefuse_UUID() {
		return refuse_UUID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}