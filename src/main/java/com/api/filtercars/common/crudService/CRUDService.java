package com.api.filtercars.common.crudService;

import com.api.filtercars.common.dto.ErrorDTO;
import org.springframework.stereotype.Service;

@Service
public class CRUDService {
    public final ErrorDTO getError(String errorMessage) {
        if (errorMessage.contains("already exists")) {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setErrorMessage("Record already exists.");
            errorDTO.setErrorCode("DUPLICATE");
            return errorDTO;
        }
        return new ErrorDTO();
    }
}
