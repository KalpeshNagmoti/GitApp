package com.telstra.codechallenge.zerofollower;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZeroFollowers {
	
	
	private String id;
	private String login;
	private String html_url;
	
	private OwnerData owner;
	
	public ZeroFollowers() {
		
	}
	
	/*public ZeroFollowers(String id, String login, String html_url) {
		this.id = id;
		this.login = login;
		this.html_url = html_url;
	}*/
	
	

	public ZeroFollowers(String id, String login, String html_url, OwnerData owner) {
		super();
		this.id = id;
		this.login = login;
		this.html_url = html_url;
		this.owner = owner;
	}

	public OwnerData getOwner() {
		return owner;
	}

	public void setOwner(OwnerData owner) {
		this.owner = owner;
	}

	public String getId() {
		return id;
	}
	

	public void setId(String id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	

}
