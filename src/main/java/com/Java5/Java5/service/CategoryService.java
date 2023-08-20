/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.service;

import com.Java5.Java5.domain.Category;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public interface CategoryService {

    void delete(Category entity);

    List<Category> findAll();

    Optional<Category> findById(Long id);

    <S extends Category> S save(S entity);

    
}
