package com.example.ordenesservice.ordenes.infrestructure.controllers.orden;

import com.example.ordenesservice.ordenes.application.usecase.orden.Get;
import com.example.ordenesservice.ordenes.infrestructure.dtos.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordenes")
public class GetController {
    @Autowired
    private Get useCase;

    @GetMapping
    public BaseResponse run(){return useCase.run();}

}
