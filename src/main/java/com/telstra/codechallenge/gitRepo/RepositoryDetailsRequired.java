package com.telstra.codechallenge.gitRepo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RepositoryDetailsRequired {

	private String html_url;
	private long watchers_count;
	private String language;
	private String description;
	private String name;

	public RepositoryDetailsRequired() {

	}

	/**
	 * @param html_url
	 * @param watchers_count
	 * @param language
	 * @param description
	 * @param name
	 */
	public RepositoryDetailsRequired(String html_url, long watchers_count, String language, String description,
			String name) {
		super();
		this.html_url = html_url;
		this.watchers_count = watchers_count;
		this.language = language;
		this.description = description;
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	public long getWatchers_count() {
		return watchers_count;
	}

	public void setWatchers_count(long watchers_count) {
		this.watchers_count = watchers_count;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
