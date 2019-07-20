package com.womencancode.projetofinal.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
public class Error {
    private int status;
    private String message;
}
