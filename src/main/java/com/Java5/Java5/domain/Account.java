/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Admin
 */
@Data
@Entity
@Table(name = "accounts")
// @JsonIdentityInfo(
// generator = ObjectIdGenerators.PropertyGenerator.class,
// property = "id")
public class Account implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  // @Column(length = 50, nullable = false)
  // private String username;
  @Column(length = 200, nullable = true)
  private String password;

  @Column(length = 200, nullable = true)
  private String username;

  @Column(length = 200, nullable = false)
  private String email;

  @Column(length = 200, nullable = true)
  private String name;

  private String role;
}
