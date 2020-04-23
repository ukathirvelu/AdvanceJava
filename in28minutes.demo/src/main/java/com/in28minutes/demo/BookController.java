package com.in28minutes.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@GetMapping("/books")
	public List<Book> getAllBoooks()
	{
		return Arrays.asList(new Book(1,"Aru Book1", "Aru"));
	}
}
