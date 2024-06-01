package com.api.filtercars.controllers;

import com.api.filtercars.common.dto.ResponseDTO;
import com.api.filtercars.dto.UserDTO;
import com.api.filtercars.services.UserCRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    public final UserCRUDService userCRUDService;

    public UserController(UserCRUDService userCRUDService) {
        this.userCRUDService = userCRUDService;
    }

    @GetMapping("/")
    public String sayHi(Principal principal) {
        return "hello, " + principal.getName();
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<UserDTO>> saveUser(@RequestBody UserDTO userDTO) {
        return userCRUDService.saveUser(userDTO);
    }
}
