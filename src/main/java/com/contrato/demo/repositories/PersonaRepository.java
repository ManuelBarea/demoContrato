package com.contrato.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contrato.demo.entities.Persona;
@Repository 
public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
