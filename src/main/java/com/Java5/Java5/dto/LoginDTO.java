/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Java5.Java5.dto;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author PC
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class LoginDTO {

    @NotEmpty(message = "khong dc de trong username")
    private String username;

    @NotEmpty(message = "khong dc de trong paas")

    private String password;
}
