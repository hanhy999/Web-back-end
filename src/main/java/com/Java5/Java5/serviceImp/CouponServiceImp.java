/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Java5.Java5.serviceImp;

import com.Java5.Java5.domain.Coupon;
import com.Java5.Java5.repository.CouponRespository;
import com.Java5.Java5.service.CouponService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class CouponServiceImp implements CouponService {

    @Autowired
    CouponRespository couponRespository;

    public List<Coupon> findAll() {
        return couponRespository.findAll();
    }

    public List<Coupon> findAll(Sort sort) {
        return couponRespository.findAll(sort);
    }

    public List<Coupon> findAllById(Iterable<Integer> ids) {
        return couponRespository.findAllById(ids);
    }

    public Coupon getById(Integer id) {
        return couponRespository.getById(id);
    }

    public <S extends Coupon> List<S> findAll(Example<S> example) {
        return couponRespository.findAll(example);
    }

    public <S extends Coupon> List<S> findAll(Example<S> example, Sort sort) {
        return couponRespository.findAll(example, sort);
    }

   
    
}
