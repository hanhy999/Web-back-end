/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.controller.api;

import com.Java5.Java5.domain.Category;
import com.Java5.Java5.domain.Order;
import com.Java5.Java5.domain.OrderDetail;
import com.Java5.Java5.domain.Product;
import com.Java5.Java5.dto.OrderDetailDTO;
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
import com.Java5.Java5.service.OrderDetailService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("api/order-detail")
public class OrderDetailRestController {

    @Autowired
    OrderDetailService service;

    @PostMapping("filter")
    public ResponseEntity<List<OrderDetail>> getAll(@Valid @RequestBody OrderDetailDTO dto) {
        OrderDetail orderDetail = new OrderDetail();

//        BeanUtils.copyProperties(dto, product);
        Example<OrderDetail> example = Example.of(orderDetail);
        Category category = new Category();
//        if (dto.getCategoryId() != null) {
//            category.setId(dto.getCategoryId());
//            example.getProbe().setCategory(category);
//
//        }
        System.out.println(example);

        return new ResponseEntity<>(service.findAll(example), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@Valid @RequestBody OrderDetailDTO productDTO) throws ParseException {
//        product.setCategory(category);
        System.out.println(productDTO);
        OrderDetail orderDetail = new OrderDetail();

//        BeanUtils.copyProperties(productDTO, orderDetail);

        Product product = new Product();

        product.setId(productDTO.getProductId());
      
//        Order order = new Order();
//        order.setId(productDTO.getOrderId());
//       order.setAddress("");
//       order.setEmail("");
//       order.setPhoneNumber("");
       orderDetail.setPrice(productDTO.getPrice());
//        cat.setId(productDTO.getCategoryId());
//        order.setCategory(cat);

//  orderDetail.setOrder(order);
        orderDetail.setProduct(product);
        orderDetail.setOrderId(productDTO.getOrderId());
          System.out.println(product);
        service.save(orderDetail);

        return ResponseEntity.ok("Success");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> detail(@PathVariable("id") Long id) {
        Optional<OrderDetail> currentData = service.findById(id);
        if (currentData.isPresent()) {
            return new ResponseEntity<OrderDetail>(currentData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") Long id) {
        Optional<OrderDetail> currentData = service.findById(id);
        if (currentData.isPresent()) {
            service.delete(currentData.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
