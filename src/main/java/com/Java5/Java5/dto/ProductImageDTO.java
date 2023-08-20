package com.Java5.Java5.dto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageDTO {
    private long id;

    private String name;

    private String descriptions;
 
    private MultipartFile image;

    private Double price;
  

 
  
    private Long categoryId;

}
