/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.service;

import com.Java5.Java5.domain.Account;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public interface AccountService {

    Account checkLogin(String username, String password);

    Account checkUsername(String username, String email);

    void delete(Account entity);

    List<Account> findAll();

    Optional<Account> findById(Long id);

    Optional<Account> findByUserName(String userName);

    <S extends Account> S save(S entity);

    <S extends Account> List<S> findAllwhere(Example<S> example);

    <S extends Account> Optional<S> findOnewhere(Example<S> example);

}
