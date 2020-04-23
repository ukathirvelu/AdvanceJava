package com.demo.ldap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	
	@GetMapping("/")
	  public String index() {
	    return "Welcome to the home page!";
	  }

}
