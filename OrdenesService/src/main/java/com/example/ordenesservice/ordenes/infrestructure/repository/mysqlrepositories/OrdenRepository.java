package com.example.ordenesservice.ordenes.infrestructure.repository.mysqlrepositories;

import com.example.ordenesservice.ordenes.domain.entities.Orden;
import com.example.ordenesservice.ordenes.domain.port.IOrdenPort;
import com.example.ordenesservice.ordenes.infrestructure.models.mysqlmodels.OrdenModel;
import com.example.ordenesservice.ordenes.infrestructure.repository.mysqlrepositories.jpa.IOrdenRepository;
import com.example.ordenesservice.ordenes.infrestructure.dtos.responses.BaseResponse;
import com.example.ordenesservice.ordenes.infrestructure.dtos.responses.OrdenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdenRepository implements IOrdenPort {

    @Autowired
    private IOrdenRepository repository;

    @Override
    public BaseResponse Listar() {
        return from(repository.findAll().stream().map(this::from).toList(),
                "ordenes listadas correctamente", true, 200);
    }

    @Override
    public OrdenResponse Crear(Orden orden) {
        OrdenModel model = new OrdenModel();
        model.setId(orden.getId());
        model.setFecha(orden.getFecha());
        model.setStatus(orden.getStatus());
        model.setTotal(orden.getTotal());
        return from(repository.save(model));
    }

    @Override
    public BaseResponse ActualizarStatus(String id, String status) {
        OrdenModel model = findAndEnsureExist(id);
        model.setStatus(status);
        return from(from(repository.save(model)),
                "Status actualizado exitosamente", true, 200);
    }

    private BaseResponse from(OrdenResponse response, String message, boolean success, int code) {
        BaseResponse base = new BaseResponse();
        base.setData(response);
        base.setMessage(message);
        base.setSuccess(success);
        base.setHttpStatus(HttpStatus.valueOf(code));
        return base;
    }

    public OrdenModel findAndEnsureExist(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    OrdenResponse from(OrdenModel ordenModel) {
        OrdenResponse ordenResponse = new OrdenResponse();
        ordenResponse.setId(ordenModel.getId());
        ordenResponse.setStatus(ordenModel.getStatus());
        ordenResponse.setFecha(ordenModel.getFecha());
        ordenResponse.setTotal(ordenModel.getTotal());
        return ordenResponse;
    }

    BaseResponse from(List<OrdenResponse> responses, String message, boolean success, int code) {
        BaseResponse base = new BaseResponse();
        base.setData(responses);
        base.setMessage(message);
        base.setSuccess(success);
        base.setHttpStatus(HttpStatus.valueOf(code));
        return base;
    }



}
