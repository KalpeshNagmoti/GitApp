package com.telstra.codechallenge.gitRepo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryDetails implements Serializable {

	private int total_count;

	private String incomplete_results;

	private List<RepositoryDetailsRequired> items;

	public RepositoryDetails() {

	}

	/**
	 * @param total_count
	 * @param incomplete_results
	 * @param items
	 */
	public RepositoryDetails(int total_count, String incomplete_results, List<RepositoryDetailsRequired> items) {
		super();
		this.total_count = total_count;
		this.incomplete_results = incomplete_results;
		this.items = items;
	}

	/**
	 * @return
	 */
	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public String getIncomplete_results() {
		return incomplete_results;
	}

	public void setIncomplete_results(String incomplete_results) {
		this.incomplete_results = incomplete_results;
	}

	public List<RepositoryDetailsRequired> getItems() {
		return items;
	}

	public void setItems(List<RepositoryDetailsRequired> items) {
		this.items = items;
	}
}
