package com.telstra.codechallenge.zerofollower;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZeroFollowersService {

	private static final Logger logger = Logger.getLogger(ZeroFollowersService.class.getName());

	@Value("${repo.base.url}")
	private String repoURL;

	private RestTemplate restTemplate;

	public ZeroFollowersService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<OwnerData> findOldestAccount(int count1) {

		logger.info("Logger Name: " + logger.getName());

		ZeroRepositoryDetails rd = restTemplate.getForObject(
				repoURL + "/search/repositories?q=followers:0&sort=joined&order=desc", ZeroRepositoryDetails.class);

		logger.info("totalcount : " + rd.getTotal_count());
		logger.info("incomplete result : " + rd.getIncomplete_results());
		logger.info("getItem : " + rd.getItems());
		
		List<ZeroFollowers> lst = rd.getItems();
		List<OwnerData> finalList = new ArrayList<OwnerData>();
		logger.info("List : " + finalList);
		if (lst.size() < count1) {
			for (int i = 0; i < lst.size(); i++) {
				ZeroFollowers zeroFollowers = lst.get(i);
				OwnerData ownerData = new OwnerData();
				ownerData.setId(zeroFollowers.getOwner().getId());
				ownerData.setLogin(zeroFollowers.getOwner().getLogin());
				ownerData.setHtml_url(zeroFollowers.getOwner().getHtml_url());
				finalList.add(ownerData);
			}
		} else {
			for (int i = 0; i < count1; i++) {
				ZeroFollowers zeroFollowers = lst.get(i);
				OwnerData ownerData = new OwnerData();
				ownerData.setId(zeroFollowers.getOwner().getId());
				ownerData.setLogin(zeroFollowers.getOwner().getLogin());
				ownerData.setHtml_url(zeroFollowers.getOwner().getHtml_url());
				finalList.add(ownerData);
			}
		}
		return finalList;

	}

}
