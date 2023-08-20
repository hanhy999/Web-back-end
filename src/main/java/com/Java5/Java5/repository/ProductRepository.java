/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.repository;

import com.Java5.Java5.domain.Product;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // @Query("SELECT p FROM products p WHERE " +
    // "p.name LIKE CONCAT('%',:name, '%')")
    // public List<Product> searchProducts(String name);
    @Query("SELECT a FROM Product a WHERE a.name LIKE CONCAT('%',:name, '%') ")
    public List<Product> searchProducts(String name);

    @Query("SELECT a FROM Product a WHERE a.category.id = :idCategory")
    public List<Product> listProductCategory(Long idCategory);

//   @Query("SELECT p.id, p.price , p.descriptions, p.image, p.name, p.categoryId FROM Product p INNER JOIN Category c on p.categoryId = c.categoryId WHERE p.categoryId = :category")
//     public List<Product> list(int category);
}
