/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.serviceImp;

import com.Java5.Java5.domain.Post;
import com.Java5.Java5.domain.Product;
import com.Java5.Java5.repository.PostRepository;
import com.Java5.Java5.repository.ProductRepository;
import com.Java5.Java5.service.PostService;
import com.Java5.Java5.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public <S extends Post> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<Post> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Post entity) {
        repository.delete(entity);
    }
    
}
