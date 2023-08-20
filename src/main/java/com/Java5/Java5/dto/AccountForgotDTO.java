package com.Java5.Java5.dto;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AccountForgotDTO {
    private Long id;

    private String username;
    private String email;
}
