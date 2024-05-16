package com.example.ordenesservice.ordenes.infrestructure.repository.mysqlrepositories.jpa;

import com.example.ordenesservice.ordenes.infrestructure.models.mysqlmodels.OrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdenRepository extends JpaRepository<OrdenModel, String> {

}
