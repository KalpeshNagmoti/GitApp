package com.telstra.codechallenge.zerofollower;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.codechallenge.exceptions.ResourceNotFoundException;

@RestController
public class ZeroFollowersController {

	private static final Logger logger = Logger.getLogger(ZeroFollowersController.class.getName());

	@Autowired
	ZeroFollowersService zeroFollowersService;

	public ZeroFollowersController(ZeroFollowersService zeroFollowersService) {
		this.zeroFollowersService = zeroFollowersService;
	}

	@RequestMapping(path = "/zeroFollowers/{count}", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity findOldestAccount(@PathVariable String count, HttpServletResponse response)
			throws ResourceNotFoundException, Exception {

		if (!isNumeric(count)) {
			throw new ResourceNotFoundException("Wrong Input!Please enter numeric value");
		}
		int count1 = Integer.parseInt(count);
		List<OwnerData> lst = zeroFollowersService.findOldestAccount(count1);
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
