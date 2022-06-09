package com.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/classified")
	public String classified() {
		return "classified";
	}
}
