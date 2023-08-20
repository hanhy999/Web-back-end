/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.service;

import com.Java5.Java5.domain.Category;
import com.Java5.Java5.domain.Product;
import com.Java5.Java5.dto.ProductDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public interface ProductService {

    void delete(Product entity);

    <S extends Product> List<S> findAll(Example<S> example);

    Optional<Product> findById(Long id);

    <S extends Product> S save(S entity);

    // List<ProductDTO> search(String name);
    List<Product> searchProducts(String name);

    List<Product> listProductCategory(Long categoryId);

}
