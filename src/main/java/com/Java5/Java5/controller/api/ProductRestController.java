/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.controller.api;

import com.Java5.Java5.domain.Category;
import com.Java5.Java5.domain.Product;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@Controller
@RestController
@CrossOrigin(origins = "*")

@RequestMapping("api/product")
public class ProductRestController {

    @Autowired
    ProductService roleService;

    @Autowired
    ProductService productService;

    @PostMapping("list")
    public ResponseEntity<List<Product>> getAll(@Valid @RequestBody ProductDTO dto) {
        Product product = new Product();

        // BeanUtils.copyProperties(dto, product);
        Example<Product> example = Example.of(product);
        Category category = new Category();
        if (dto.getCategoryId() != null) {
            category.setId(dto.getCategoryId());
            example.getProbe().setCategory(category);

        }
        System.out.println(example);

        return new ResponseEntity<>(productService.findAll(example), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@Valid @RequestBody ProductDTO productDTO) throws ParseException {
        // product.setCategory(category);
    	
    	 if (productDTO.getName() == null || productDTO.getName().isEmpty()) {
    	        return ResponseEntity
    	                .status(HttpStatus.NOT_FOUND)
    	                .body("Name field is required");
    	    }
    	  
        System.out.println(productDTO);
        Product product = new Product();

        BeanUtils.copyProperties(productDTO, product);
        Category cat = new Category();
        cat.setId(productDTO.getCategoryId());
        product.setCategory(cat);
        productService.save(product);

        return ResponseEntity.ok("Success");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> detail(@PathVariable("id") Long id) {
        Optional<Product> currentData = productService.findById(id);
        if (currentData.isPresent()) {
            return new ResponseEntity<Product>(currentData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // @GetMapping("search/{name}")
    // public ResponseEntity<Product> search(@PathVariable("name") String  name) {
    //     Optional<Product> currentData = roleService.search(name);
    //     if (currentData.isPresent()) {
    //         return new ResponseEntity<Product>(currentData.get(), HttpStatus.OK);
    //     }
    //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }



    @GetMapping("search/{name}")
    public ResponseEntity<List<Product>> searchProducts(@PathVariable("name") String name) {
        return ResponseEntity.ok(productService.searchProducts(name));
    }
    
     @GetMapping("listProductCategory/{categoryId}")
    public ResponseEntity<List<Product>> getlistProductCate(@PathVariable("categoryId") Long categoryId) {
        return ResponseEntity.ok(productService.listProductCategory(categoryId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") Long id) {
        Optional<Product> currentData = productService.findById(id);
        if (currentData.isPresent()) {
            productService.delete(currentData.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
