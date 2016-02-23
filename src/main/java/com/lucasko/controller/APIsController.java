package com.lucasko.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucasko.model.User;

@Controller
@RequestMapping("/api")
public class APIsController {

	@RequestMapping(value = "/users", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<User> users() {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("visitor is " + userDetails.getUsername());
		List<User> userList = new ArrayList<User>();
		userList.add(new User(1, "user001", "user001@example.com", "0123456789"));
		userList.add(new User(2, "user002", "user002@example.com", "9876543210"));
		userList.add(new User(3, "user003", "user003@example.com", "0000000000"));
		return userList;

	}
}
