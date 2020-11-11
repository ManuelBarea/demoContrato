package com.contrato.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contrato.demo.entities.Contrato;
@Repository 
public interface ContratoRepository extends JpaRepository<Contrato, Integer>{

}
