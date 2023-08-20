/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.serviceImp;

import com.Java5.Java5.domain.Account;

import com.Java5.Java5.repository.AccountRepository;

import com.Java5.Java5.service.AccountService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Java5.Java5.service.AccountService;
import org.springframework.data.domain.Example;

/**
 *
 * @author Admin
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    
     public Account checkLogin(String username, String password) {
        return accountRepository.checkLogin(username, password);
    }

    public Account checkUsername(String username, String email) {
        return accountRepository.checkUsername(username, email);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public <S extends Account> S save(S entity) {
        return accountRepository.save(entity);
    }

    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }
//     public Optional<Account> findUserName(String userName) {
////        return accountRepository.findByName(userName);
//    }

    public void delete(Account entity) {
        accountRepository.delete(entity);
    }
    
   public <S extends Account> List<S> findAllwhere(Example<S> example) {
        return accountRepository.findAll(example);
    }

    @Override
    public <S extends Account> Optional<S> findOnewhere(Example<S> example) {
        return accountRepository.findOne(example); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Account> findByUserName(String userName) {
      return accountRepository.findByUserName(userName);  // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
   
  
  
}
