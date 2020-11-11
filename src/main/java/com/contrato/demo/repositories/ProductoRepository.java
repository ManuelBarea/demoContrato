package com.contrato.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contrato.demo.entities.Producto;
@Repository 
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
