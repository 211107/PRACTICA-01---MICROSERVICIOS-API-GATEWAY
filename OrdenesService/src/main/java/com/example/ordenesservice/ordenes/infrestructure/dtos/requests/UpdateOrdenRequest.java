package com.example.ordenesservice.ordenes.infrestructure.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateOrdenRequest {
    private String id;
    private String status;
}
