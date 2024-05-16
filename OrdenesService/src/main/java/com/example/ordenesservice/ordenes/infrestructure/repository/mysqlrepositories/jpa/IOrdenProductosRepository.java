package com.example.ordenesservice.ordenes.infrestructure.repository.mysqlrepositories.jpa;

import com.example.ordenesservice.ordenes.infrestructure.models.mysqlmodels.OrdenProductosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdenProductosRepository extends JpaRepository<OrdenProductosModel, String> {
}
