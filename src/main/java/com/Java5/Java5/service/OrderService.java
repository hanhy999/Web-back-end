/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.service;

import com.Java5.Java5.domain.Account;
import com.Java5.Java5.domain.Order;
import com.Java5.Java5.domain.Product;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public interface OrderService {

    void delete(Order entity);

     <S extends Order> List<S> findAll(Example<S> example);

    Optional<Order> findById(Long id);

    <S extends Order> S save(S entity);

}
