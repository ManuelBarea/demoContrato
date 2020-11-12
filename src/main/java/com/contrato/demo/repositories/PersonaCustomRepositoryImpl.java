package com.contrato.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.contrato.demo.entities.Persona;
import com.contrato.demo.model.CriteriaPersona;
import com.contrato.demo.utils.Constants;
import com.contrato.demo.utils.Utils;
/**
 * Implementacion de la interfaz ContratoCustomRepository
 * @author manuel.barea.velez
 *
 */
@Repository
public class PersonaCustomRepositoryImpl implements PersonaCustomRepository{

	@Autowired
	EntityManager em;
	
	@Override
	public List<Persona> findPersonasByCriteria(CriteriaPersona criteria) {
		  CriteriaBuilder cb = em.getCriteriaBuilder();
	      CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
	      
	      Root<Persona> persona = cq.from(Persona.class);
	      List<Predicate> predicates = new ArrayList<>();
	      
	      if(!StringUtils.isEmpty(criteria.getNombre())) {
	    	  predicates.add(cb.like(persona.get(Constants.TABLE_PERSONAS_CAMP_NOMBRE), Utils.convertToLike(criteria.getNombre())));	
	      }
	      
	      if(!StringUtils.isEmpty(criteria.getApellido1())) {
	    	  predicates.add(cb.like(persona.get(Constants.TABLE_PERSONAS_CAMP_APELLIDO1), Utils.convertToLike(criteria.getApellido1())));
	      }
	      
	      if(!StringUtils.isEmpty(criteria.getApellido2())) {
	    	  predicates.add(cb.like(persona.get(Constants.TABLE_PERSONAS_CAMP_APELLIDO2), Utils.convertToLike(criteria.getApellido2())));
	    	  
	      }
	      
	      if(!StringUtils.isEmpty(criteria.getTelefono())) {
	    	  predicates.add(cb.like(persona.get(Constants.TABLE_PERSONAS_CAMP_TELEFONO), Utils.convertToLike(criteria.getTelefono())));
	    	  
	      }
	      
	      if(!StringUtils.isEmpty(criteria.getDireccion())) {
	    	  predicates.add(cb.like(persona.get(Constants.TABLE_PERSONAS_CAMP_DIRECCION), Utils.convertToLike(criteria.getDireccion())));
	      }
		
	      cq.where(predicates.toArray(new Predicate[0]));
	      
	      List<Persona> personas = em.createQuery(cq).getResultList();
	      
	      return personas;
	}

}
