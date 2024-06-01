package com.api.filtercars.services;

import com.api.filtercars.common.crudService.CRUDService;
import com.api.filtercars.common.dto.ErrorDTO;
import com.api.filtercars.common.dto.ResponseDTO;
import com.api.filtercars.dto.UserDTO;
import com.api.filtercars.entities.User;
import com.api.filtercars.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserCRUDService {

    private final UserRepository userRepository;
    private final CRUDService crudService;

    public UserCRUDService(UserRepository userRepository, CRUDService crudService) {
        this.userRepository = userRepository;
        this.crudService = crudService;
    }

    public ResponseEntity<ResponseDTO<UserDTO>> saveUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        try {
            userRepository.save(user);
            ResponseDTO<UserDTO> responseDTO = new ResponseDTO<UserDTO>();
            responseDTO.setData(userDTO);
            responseDTO.setSuccess(true);
            return new ResponseEntity<ResponseDTO<UserDTO>>(responseDTO, HttpStatusCode.valueOf(200));
        } catch (DataAccessException e) {
            ResponseDTO<UserDTO> responseDTO = new ResponseDTO<UserDTO>();
            responseDTO.setError(crudService.getError(e.getMessage()));
            responseDTO.setSuccess(false);
            return new ResponseEntity<ResponseDTO<UserDTO>>(responseDTO, HttpStatusCode.valueOf(200));

        }
    }
}
