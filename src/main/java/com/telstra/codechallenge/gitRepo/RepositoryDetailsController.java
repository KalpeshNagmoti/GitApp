package com.telstra.codechallenge.gitRepo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.codechallenge.exceptions.ResourceNotFoundException;


@RestController
@Component
public class RepositoryDetailsController {

	private static final Logger logger = Logger.getLogger(RepositoryDetailsController.class.getName());

	@Autowired
	RepositoryDetailsService repositoryDetailsService;

	public RepositoryDetailsController(RepositoryDetailsService repositoryDetailsService) {
		this.repositoryDetailsService = repositoryDetailsService;
	}
	
	@RequestMapping(path = "/hotRepo/{count}", method = RequestMethod.GET)
	public ResponseEntity getHotRepositoryDetails(@PathVariable String count,
			HttpServletResponse response) throws ResourceNotFoundException,Exception  {
			if(!isNumeric(count)){
				throw new ResourceNotFoundException("Wrong Input!Please enter numeric value");
			}
			int count1 = Integer.parseInt(count);
		List<RepositoryDetailsRequired> lst = repositoryDetailsService.getHotRepositoryDetails(count1);
				logger.info("List : " + lst);
				return ResponseEntity.ok(lst);
	}
	
	public static boolean isNumeric(final String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return str.chars().allMatch(Character::isDigit);

    }
}
