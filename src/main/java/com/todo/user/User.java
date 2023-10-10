package com.todo.user;

import lombok.Data;

/* 
 * A anotação @Data do Lombok gera automaticamente 
 * getters, setters, equals, hashCode e toString.
*/
@Data
public class User {
  private String username;
  private String name;
  private String password;
}
