package com.vi.spring.hateoas.resthateoas.controller;

import com.vi.spring.hateoas.resthateoas.Repository.UsersRepository;
import com.vi.spring.hateoas.resthateoas.model.Users;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/v1")
public class UsersController {
    private final UsersRepository repository;
    public UsersController(UsersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users/all")
    public List<Users> getAllUsers(){
        Users user1 = new Users("Vijay",2300L,"admin");
        Users user2 = new Users("Kolli",2500L,"management");
        Users user3 = new Users("Kumar",3000L,"user");
        return Arrays.asList(user1,user2,user3);
    }

    @GetMapping("/hateoas/all")
    public CollectionModel<List<Users>> getAllHateoasUsers(){
        Class<UsersController> controllerClass = UsersController.class;
        Users user1 = new Users("Vijay",2300L,"admin");
        Users user2 = new Users("Kolli",2500L,"management");
        Users user3 = new Users("Kumar",3000L,"user");
        List<Users> users = new ArrayList<>();
        users.add(user1); users.add(user2); users.add(user3);
        Link getUserLink = linkTo(methodOn(controllerClass).getAllHateoasUsers()).withSelfRel();
        return new CollectionModel(users, getUserLink);
    }

    @GetMapping("/hateoas/users/all")
    ResponseEntity<CollectionModel<EntityModel<Users>>> findAll() {

        List<EntityModel<Users>> users = StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(user -> new EntityModel<>(user,
                        linkTo(methodOn(UsersController.class).findOne(user.getId())).withSelfRel(),
                        linkTo(methodOn(UsersController.class).findAll()).withRel("users"),
                        linkTo(methodOn(UsersController.class).updateUser(user,user.getId())).withRel("update")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                new CollectionModel<>(users,
                        linkTo(methodOn(UsersController.class).findAll()).withSelfRel()));
    }
    @GetMapping("/users/{id}")
    ResponseEntity<EntityModel<Users>> findOne(@PathVariable long id) {
        return repository.findById(id)
                .map(user -> new EntityModel<>(user,
                        linkTo(methodOn(UsersController.class).findOne(user.getId())).withSelfRel(),
                        linkTo(methodOn(UsersController.class).findAll()).withRel("users")))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/user/add")
    ResponseEntity<?> newUser(@RequestBody Users user) {
        try {
            Users savedUser = repository.save(user);
            EntityModel<Users> userResource = new EntityModel<>(savedUser,
                    linkTo(methodOn(UsersController.class).findOne(savedUser.getId())).withSelfRel());
            return ResponseEntity
                    .created(new URI(userResource.getRequiredLink(IanaLinkRelations.SELF).getHref()))
                    .body(userResource);
        } catch (URISyntaxException e) {
            return ResponseEntity.badRequest().body("Unable to create " + user);
        }
    }

    @PutMapping("/users/{id}")
    ResponseEntity<?> updateUser(@RequestBody Users user, @PathVariable long id) {

        Users userToUpdate = user;
        userToUpdate.setId(id);
        repository.save(userToUpdate);

        Link newlyCreatedLink = linkTo(methodOn(UsersController.class).findOne(id)).withSelfRel();
        try {
            return ResponseEntity.noContent().location(new URI(newlyCreatedLink.getHref())).build();
        } catch (URISyntaxException e) {
            return ResponseEntity.badRequest().body("Unable to update " + userToUpdate);
        }
    }

}
