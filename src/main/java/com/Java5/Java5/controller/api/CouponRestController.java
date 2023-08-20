package com.Java5.Java5.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Java5.Java5.domain.Coupon;
import com.Java5.Java5.service.CouponService;

@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/coupon")
public class CouponRestController {
    @Autowired
    CouponService couponService;

    @GetMapping("")
    public ResponseEntity<List<Coupon>> getAll() {
        return new ResponseEntity<>(couponService.findAll(), HttpStatus.OK);
    }
}
