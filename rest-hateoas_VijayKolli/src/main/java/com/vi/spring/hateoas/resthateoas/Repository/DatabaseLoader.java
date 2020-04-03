package com.vi.spring.hateoas.resthateoas.Repository;

import com.vi.spring.hateoas.resthateoas.model.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Pre-load some data using a Spring Boot {@link CommandLineRunner}.
 *
 */
@Component
class DatabaseLoader {

	@Bean
	CommandLineRunner init(UsersRepository repository) {
		return args -> {
			repository.save(new Users("Vijay",2300L,"admin"));
			repository.save(new Users("Kolli",2500L,"management"));
			repository.save(new Users("Kumar",3000L,"user"));
		};
	}

}
