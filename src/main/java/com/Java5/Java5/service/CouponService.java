/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Java5.Java5.service;

import com.Java5.Java5.domain.Coupon;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public interface CouponService {

    List<Coupon> findAll();
    
}
