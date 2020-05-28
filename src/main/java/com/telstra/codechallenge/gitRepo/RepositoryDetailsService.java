package com.telstra.codechallenge.gitRepo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RepositoryDetailsService {

	private static final Logger LOGGER = Logger.getLogger(RepositoryDetailsService.class.getName());

	@Value("${repo.base.url}")
	private String repoURL;

	private RestTemplate restTemplate;

	public RepositoryDetailsService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<RepositoryDetailsRequired> getHotRepositoryDetails(int count1) {

		LOGGER.info("Logger Name: " + LOGGER.getName());

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		Date toDate1 = cal.getTime();
		String fromDate = dateFormat.format(toDate1);

		RepositoryDetails repositoryDetails = restTemplate.getForObject(
				repoURL + "/search/repositories?q=created:>" + fromDate + "&sort=star&order=desc",
				RepositoryDetails.class);

		LOGGER.info("totalcount : " + repositoryDetails.getTotal_count());
		LOGGER.info("incomplete result : " + repositoryDetails.getIncomplete_results());
		LOGGER.info("getItem : " + repositoryDetails.getItems());

		List<RepositoryDetailsRequired> lst = repositoryDetails.getItems();
		List<RepositoryDetailsRequired> finalList = new ArrayList<RepositoryDetailsRequired>();
		LOGGER.info("List : " + finalList);
		if (lst.size() < count1) {
			for (int i = 0; i < lst.size(); i++) {
				finalList.add(lst.get(i));
			}
		} else {
			for (int i = 0; i < count1; i++) {
				finalList.add(lst.get(i));
			}
		}

		return finalList;
	}
}
