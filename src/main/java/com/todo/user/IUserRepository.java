package com.todo.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, UUID> {
  /*
   * Método customizado findBy<nome do atributo>
   */
  User findByUsername(String username);
}
