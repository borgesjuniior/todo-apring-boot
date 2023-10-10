package com.todo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

  /*
   * Injeção de dependências
   */
  @Autowired
  private IUserRepository userRepository;

  @PostMapping
  public ResponseEntity create(@RequestBody User user, UriComponentsBuilder uriBuilder) {
    var foundUser = userRepository.findByUsername(user.getUsername());

    if (foundUser != null) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body("Username already exists. Please choose a different username.");
    }

    var userCreated = userRepository.save(user);
    var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(userCreated.getId()).toUri();

    return ResponseEntity.created(uri).body(userCreated);
  }
}
