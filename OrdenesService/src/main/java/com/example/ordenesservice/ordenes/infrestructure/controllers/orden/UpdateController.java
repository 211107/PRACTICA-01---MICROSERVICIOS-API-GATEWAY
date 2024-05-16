package com.example.ordenesservice.ordenes.infrestructure.controllers.orden;

import com.example.ordenesservice.ordenes.application.usecase.orden.Update;
import com.example.ordenesservice.ordenes.infrestructure.dtos.requests.UpdateOrdenRequest;
import com.example.ordenesservice.ordenes.infrestructure.dtos.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordenes")
public class UpdateController {

    @Autowired
    private Update useCase;

    @PutMapping
    public BaseResponse update(@RequestBody UpdateOrdenRequest request) {return useCase.run(request);}

}
