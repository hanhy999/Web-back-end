/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.controller.api;

import com.Java5.Java5.domain.Category;
import com.Java5.Java5.domain.Post;
import com.Java5.Java5.domain.Product;
import com.Java5.Java5.dto.PostDTO;
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
import com.Java5.Java5.service.PostService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@Controller
@RestController
@CrossOrigin
@RequestMapping("api/post")
public class PostRestController {

    @Autowired
    PostService service;

    @GetMapping("")
    public ResponseEntity<List<Post>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@Valid @RequestBody PostDTO dto) throws ParseException {
//        product.setCategory(category);
        System.out.println(dto);
        Post model = new Post();
       
        BeanUtils.copyProperties(dto, model);
         
        Category cat = new Category();
        cat.setId(dto.getCategoryId());
        model.setCategory(cat);
        service.save(model);

        return ResponseEntity.ok("User is valid");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> detail(@PathVariable("id") Long id) {
        Optional<Post> currentData = service.findById(id);
        if (currentData.isPresent()) {
            return new ResponseEntity<Post>(currentData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> delete(@PathVariable("id") Long id) {
        Optional<Post> currentData = service.findById(id);
        if (currentData.isPresent()) {
            service.delete(currentData.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
