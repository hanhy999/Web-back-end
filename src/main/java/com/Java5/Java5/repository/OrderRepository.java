/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.repository;

import com.Java5.Java5.domain.Order;
import com.Java5.Java5.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Admin
 */
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
