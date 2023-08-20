/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.serviceImp;

import com.Java5.Java5.domain.Product;
import com.Java5.Java5.dto.ProductDTO;
import com.Java5.Java5.repository.ProductRepository;
import com.Java5.Java5.service.ProductService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    public List<Product> searchProducts(String name) {
        return productRepository.searchProducts(name);
    }

    public List<Product> listProductCategory(Long categoryId) {
        return productRepository.listProductCategory(categoryId);
    }
    
    
    // public ProductServiceImpl(ProductRepository productRepository) {
    //     this.productRepository = productRepository;
    // }

    // @Override
    // public List<Product> searchProducts(String query) {
    //     List<Product> products = productRepository.searchProducts(query);
    //     return products;
    // }
    
    public <S extends Product> List<S> findAll(Example<S> example) {

        return productRepository.findAll(example);
    }

    public <S extends Product> S save(S entity) {
        return productRepository.save(entity);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void delete(Product entity) {
        productRepository.delete(entity);
    }



    // public List<ProductDTO> search(String name) {
    //     Connection conn = DBProvider.getConnection();
    //     List<ProductDTO> ListCat = new ArrayList<ProductDTO>();
    //     try {
    //         String sql = "SELECT * FROM product where name like  ?";
    //         PreparedStatement pst = conn.prepareStatement(sql);
    //         pst.setString(1, name);

    //         ResultSet rst = pst.executeQuery();
    //         while (rst.next()) {
    //             ProductDTO posts = new ProductDTO(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
    //                     rst.getDouble(5), rst.getLong(6));
    //             ListCat.add(posts);
    //         }
    //         return ListCat;

    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }

}
