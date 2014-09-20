package net.rk.struts2.action;
import java.lang.*;

public class WelcomeUserAction{
 
	private String username;
 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	// all struts logic here
	public String execute() {
		if(username.length()==0){
			return "Error";
		}
		if(username.substring(0, 2).equals("br"))
		return "Broker";
		if(username.substring(0, 2).equals("cl"))
			return "Client";
		if(username.substring(0, 2).equals("ad"))
			return "Admin";
		return "Error";
 
	}
}