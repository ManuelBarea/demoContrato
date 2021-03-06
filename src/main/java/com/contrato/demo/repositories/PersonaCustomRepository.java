package com.contrato.demo.repositories;

import java.util.List;

import com.contrato.demo.entities.Persona;
import com.contrato.demo.model.CriteriaPersona;
/**
 * Intyerfaz de repositorio personalizado para personas.
 * @author manuel.barea.velez
 *
 */
public interface PersonaCustomRepository {

	/**
	 * Consulta Personas con los criterios informados en el objeto recibido.
	 * @param criteria
	 * @return List<Persona>
	 */
	List<Persona> findPersonasByCriteria(CriteriaPersona criteria);
	
}
