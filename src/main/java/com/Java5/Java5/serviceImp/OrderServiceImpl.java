/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.serviceImp;

import com.Java5.Java5.domain.Order;
import com.Java5.Java5.domain.Product;
import com.Java5.Java5.repository.OrderRepository;
import com.Java5.Java5.repository.ProductRepository;
import com.Java5.Java5.service.OrderService;
import com.Java5.Java5.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository repository;

    public <S extends Order> List<S> findAll(Example<S> example) {

        return repository.findAll(example);
    }


    public <S extends Order> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Order entity) {
        repository.delete(entity);
    }
    
}
