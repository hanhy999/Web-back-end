/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.controller.api;

import com.Java5.Java5.domain.Category;
import com.Java5.Java5.domain.Product;
import com.Java5.Java5.dto.CategoryDTO;
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
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/category")
public class CategoryRestController {

    @Autowired
    CategoryService roleService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@Valid @RequestBody CategoryDTO dto) {

        Category cat = new Category();
        BeanUtils.copyProperties(dto, cat);

        roleService.save(cat);
//        
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> detail(@PathVariable("id") Long id) {
        Optional<Category> currentData = roleService.findById(id);
        if (currentData.isPresent()) {
            return new ResponseEntity<Category>(currentData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") Long id) {
        Optional<Category> currentData = roleService.findById(id);
        if (currentData.isPresent()) {
            roleService.delete(currentData.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
