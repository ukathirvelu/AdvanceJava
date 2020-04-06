package com.cei.training.spring;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.client.RestTemplate;

@ShellComponent
public class CustomShellCommands {

	@Autowired
	private RestTemplate restTemplate;

	@ShellMethod(value = "sum of two numbers", key = "sum")
	private int add(int a, int b) {
		return a + b;
	}

	@ShellMethod(value = "change to upperCase")
	private String change(@ShellOption(defaultValue = "edi") @Size(min = 1, max = 3) String name) {
		return name.toUpperCase();
	}

	@ShellMethod(value = "test REST API call")
	private String rest() {
		String url = "http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo";
		return restTemplate.getForObject(url, String.class);
	}

}
