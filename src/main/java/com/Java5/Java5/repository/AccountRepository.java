/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.repository;

import com.Java5.Java5.domain.Account;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Admin
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM `accounts` WHERE email= ?1", nativeQuery = true)
    Optional<Account> findByUserName(String userName);

    @Query("SELECT a FROM Account a WHERE a.username = :username and a.password = :password ")
    public Account checkLogin(@Param("username") String username, @Param("password") String password);

    @Query("SELECT a FROM Account a WHERE a.username = :username and a.email = :email ")
    public Account checkUsername(@Param("username") String username, @Param("email") String password);

}
