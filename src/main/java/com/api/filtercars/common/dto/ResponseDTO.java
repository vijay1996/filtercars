package com.api.filtercars.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseDTO<DTO> implements Serializable {
    private DTO data;
    private Boolean success;
    private ErrorDTO error;
}
