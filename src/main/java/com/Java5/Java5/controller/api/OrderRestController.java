/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.controller.api;

import com.Java5.Java5.config.SendMail;
import com.Java5.Java5.domain.Category;
import com.Java5.Java5.domain.Order;

import com.Java5.Java5.domain.Product;
import com.Java5.Java5.dto.CategoryDTO;
import com.Java5.Java5.dto.OrderDTO;
import com.Java5.Java5.dto.ProductDTO;
import com.Java5.Java5.service.ProductService;
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
import com.Java5.Java5.service.CategoryService;
import com.Java5.Java5.service.OrderService;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.mail.MessagingException;
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
@CrossOrigin
@RequestMapping("api/order")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @PostMapping("filter")
    public ResponseEntity<List<Order>> getAll(@Valid @RequestBody OrderDTO dto) {
        Order order1 = new Order();
        System.out.println(order1);
//        BeanUtils.copyProperties(order1, dto);
        Example<Order> example = Example.of(order1);
//        Category category = new Category();
        if (dto.getId() != null) {
            order1.setId(dto.getId());
//            example.getProbe().set(category);

        }

        return new ResponseEntity<>(orderService.findAll(example), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@Valid @RequestBody OrderDTO dto) throws MessagingException, UnsupportedEncodingException {
        System.out.println(dto);
        Order model = new Order();

//        BeanUtils.copyProperties(dto, model);
        Date date = new Date();
        System.out.println(date);
        model.setId(dto.getId());
        model.setAccountID(dto.getAccountId());
        model.setAddress(dto.getAddress());
        model.setEmail(dto.getEmail());
        model.setCreateDate(date);
        model.setPhoneNumber(dto.getPhoneNumber());
        System.out.println(model);
        orderService.save(model);
        SendMail.sendEmail(dto.getEmail(), "Tạo order thành công", "Bạn đã tạo thành công 1 order #" + dto.getId());

        return ResponseEntity.ok("Success");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> detail(@PathVariable("id") Long id) {
        Optional<Order> currentData = orderService.findById(id);
        if (currentData.isPresent()) {
            return new ResponseEntity<Order>(currentData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") Long id) {
        Optional<Order> currentData = orderService.findById(id);
        if (currentData.isPresent()) {
            orderService.delete(currentData.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
