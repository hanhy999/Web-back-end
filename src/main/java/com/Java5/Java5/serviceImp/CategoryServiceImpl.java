/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.serviceImp;

import com.Java5.Java5.domain.Category;
import com.Java5.Java5.repository.CategoryRepository;
import com.Java5.Java5.service.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public <S extends Category> S save(S entity) {
        return categoryRepository.save(entity);
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public void delete(Category entity) {
        categoryRepository.delete(entity);
    }
    
    
}
