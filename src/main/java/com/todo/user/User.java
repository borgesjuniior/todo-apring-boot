package com.todo.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/* 
 * A anotação @Data do Lombok gera automaticamente 
 * getters, setters, equals, hashCode e toString.
*/
@Data
@Entity(name = "tb_users")
public class User {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @Column(unique = true)
  private String username;
  private String name;
  private String password;

  /*
   * @CreationTimestamp gera automaticamente a data e hora atuais
   */
  @CreationTimestamp
  private LocalDateTime created_at;
}
