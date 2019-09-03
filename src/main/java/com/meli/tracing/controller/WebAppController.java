package com.meli.tracing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebAppController {
	
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}

}
