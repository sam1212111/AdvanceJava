package com.user.notification;

public class UserNotify {
	
	private NotificationService ns;
	
	public UserNotify(NotificationService ns) {
		this.ns = ns;
	}
	
	public void registerUser(String username) {
		ns.sendNotification("Welcome "+username);
	}

}
