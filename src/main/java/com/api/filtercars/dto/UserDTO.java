package com.api.filtercars.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class UserDTO implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Timestamp creationTimestamp;
    private Timestamp updationTimestamp;
}
