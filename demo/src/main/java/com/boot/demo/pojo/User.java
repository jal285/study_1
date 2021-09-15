package com.boot.demo.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author badpoone
 */
@Data
@ToString
@Component
public class User {
    private String name;
    private String password;
    private String token ;
    private String role ;
}
