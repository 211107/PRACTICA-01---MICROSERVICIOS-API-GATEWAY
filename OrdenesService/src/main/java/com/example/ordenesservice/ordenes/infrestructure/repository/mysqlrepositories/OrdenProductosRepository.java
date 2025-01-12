package com.example.ordenesservice.ordenes.infrestructure.repository.mysqlrepositories;

import com.example.ordenesservice.ordenes.domain.entities.OrdenProductos;
import com.example.ordenesservice.ordenes.domain.port.IOrdenProductosPort;
import com.example.ordenesservice.ordenes.infrestructure.models.mysqlmodels.OrdenProductosModel;
import com.example.ordenesservice.ordenes.infrestructure.dtos.responses.OrdenProductosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdenProductosRepository implements IOrdenProductosPort {

    @Autowired
    OrdenRepository ordenRepository = new OrdenRepository();

    @Override
    public OrdenProductosResponse CrearOrdenProducto(OrdenProductos ordenProductos) {
        OrdenProductosModel model = new OrdenProductosModel();
        model.setId(ordenProductos.getId());
        model.setProducto_id(ordenProductos.getProductoId());
        model.setOrden(ordenRepository.findAndEnsureExist(ordenProductos.getOrdenId()));
        model.setCantidad(ordenProductos.getCantidad());
        return from(model);
    }

    OrdenProductosResponse from(OrdenProductosModel ordenProductos) {
        OrdenProductosResponse resp = new OrdenProductosResponse();
        resp.setId(ordenProductos.getId());
        resp.setProductoId(ordenProductos.getProducto_id());
        resp.setOrdenId(ordenProductos.getOrden().getId());
        resp.setCantidad(ordenProductos.getCantidad());
        resp.setTotal(ordenProductos.getTotal());
        return resp;
    }
}
