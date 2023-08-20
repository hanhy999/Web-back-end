/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.controller.api;

import com.Java5.Java5.config.PasswordHelper;
import com.Java5.Java5.config.SendMail;
import com.Java5.Java5.domain.Account;
import com.Java5.Java5.dto.AccountDTO;
import com.Java5.Java5.dto.AccountForgotDTO;
import com.Java5.Java5.dto.LoginDTO;
import com.Java5.Java5.service.AccountService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.Java5.Java5.service.AccountService;
import com.Java5.Java5.utils.JwtHelper;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/account")
public class AccountRestController {

    @Autowired
    AccountService accountService;

    @Autowired
    private HttpSession session;

    JwtHelper JwtHelper;

    @GetMapping("")
    public ResponseEntity<List<Account>> getAll() {
        List<Account> list = accountService.findAll();
        for (var i = 0; i < list.size(); i++) {
            // list.get(i).setPassword(PasswordHelper.decrypt(list.get(i).getPassword()));
            list.get(i).setPassword(list.get(i).getPassword());
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@Valid @RequestBody AccountDTO dto)
            throws MessagingException, UnsupportedEncodingException {
        dto.setRole("user");

        Account account = new Account();
        BeanUtils.copyProperties(dto, account);
        if (dto.getId() == null) {
            Optional<Account> findUserName = accountService.findByUserName(account.getEmail());
            System.out.println(findUserName.isEmpty());
            if (findUserName.isEmpty() == false) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        account.setId(dto.getId());
        account.setPassword(PasswordHelper.encrypt(dto.getPassword()));

        this.accountService.save(account);
        // if (account.getId() == null) {
        SendMail.sendEmail(account.getEmail(), "Sign up success",
                " Hi, " + dto.getName() + " You have successfully created an account ");
        // }

        return ResponseEntity.ok("Success");
    }

    @PostMapping("admin")
    public ResponseEntity<String> createAdmin(@Valid @RequestBody AccountDTO dto)
            throws MessagingException, UnsupportedEncodingException {

        Account account = new Account();
        BeanUtils.copyProperties(dto, account);
        if (dto.getId() == null) {
            Optional<Account> findUserName = accountService.findByUserName(account.getEmail());
            System.out.println(findUserName.isEmpty());
            if (findUserName.isEmpty() == false) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        account.setId(dto.getId());
        account.setPassword(PasswordHelper.encrypt(dto.getPassword()));

        this.accountService.save(account);

        return ResponseEntity.ok("Success");
    }

    @PostMapping("login")
    public ResponseEntity<Account> login(@Valid @RequestBody AccountDTO dto) {
        Account account = new Account();
        BeanUtils.copyProperties(dto, account);
        Example<Account> example = Example.of(account);
        example.getProbe().setPassword(PasswordHelper.encrypt(dto.getPassword()));
        System.out.println(example);
        Optional<Account> currentData = accountService.findOnewhere(example);
        if (currentData.isPresent()) {
            session.setAttribute("username", "authen");
            currentData.get().setPassword("");
            return new ResponseEntity<Account>(currentData.get(), HttpStatus.OK);
        }
        session.removeAttribute("username");
        // return accountService.findAllwhere(example);
        // return ResponseEntity.ok("Success");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("forgot-password")
    public ResponseEntity<Boolean> forgotPassword(@Valid @RequestBody AccountForgotDTO dto)
            throws MessagingException, UnsupportedEncodingException {
        Account account = new Account();
        BeanUtils.copyProperties(dto, account);

        Account findUserName = accountService.checkUsername(dto.getUsername(), dto.getEmail());
        if (findUserName != null) {
            SendMail.sendEmail(account.getEmail(), "Forgot password",
                    "Hi, " + dto.getUsername() + " your password is: "
                            + PasswordHelper.decrypt(findUserName.getPassword()));

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> detail(@PathVariable("id") Long id) {
        Optional<Account> currentData = accountService.findById(id);
        if (currentData.isPresent()) {
            return new ResponseEntity<Account>(currentData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> delete(@PathVariable("id") Long id) {
        Optional<Account> currentData = accountService.findById(id);
        if (currentData.isPresent()) {
            accountService.delete(currentData.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
