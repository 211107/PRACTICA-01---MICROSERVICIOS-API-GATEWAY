package com.example.ordenesservice.ordenes.application.usecase.orden;

import com.example.ordenesservice.ordenes.domain.port.IOrdenPort;
import com.example.ordenesservice.ordenes.infrestructure.dtos.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Get {

    @Autowired
    IOrdenPort repository;

    public BaseResponse run(){
        return repository.Listar();
    }
}
