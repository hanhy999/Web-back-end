/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java5.Java5.service;

import com.Java5.Java5.domain.OrderDetail;
import com.Java5.Java5.domain.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public interface PostService {
void delete(Post entity);

    List<Post> findAll();

    Optional<Post> findById(Long id);

    <S extends Post> S save(S entity);
    
}
