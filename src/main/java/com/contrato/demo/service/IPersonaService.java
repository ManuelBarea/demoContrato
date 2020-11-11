package com.contrato.demo.service;
import java.util.List;

import com.contrato.demo.exceptions.ExceptionBase;
import com.contrato.dto.request.PersonaRequest;
import com.contrato.dto.response.PersonaResponse;
/**
 * Interfaz para la gestion del negocio de Personas.
 * @author manuel.barea.velez
 *
 */
public interface IPersonaService {
	
	/**
	 * Crea una persona y devuelve si DNI si todo es correcto.
	 * @param persona
	 * @return Integer
	 * @throws ExceptionBase
	 */
	Integer crearPersona(PersonaRequest persona) throws ExceptionBase;
	
	/**
	 * Elimina una persona mediante su dni.
	 * @param dni
	 * @throws ExceptionBase
	 */
	void eliminarPersona(Integer dni) throws ExceptionBase;
	
	/**
	 * Consulta un listado de personas segun los criterios indicados.
	 * @param nombre
	 * @param apellido
	 * @return List<PersonaResponse>
	 * @throws ExceptionBase
	 */
	List<PersonaResponse> consultarPersonas(String nombre, String apellido) throws ExceptionBase;
	
	/**
	 * Consulta una persona mediante su dni
	 * @param idPersona
	 * @return PersonaResponse
	 * @throws ExceptionBase
	 */
	PersonaResponse consultarPersona(Integer dni) throws ExceptionBase;
	
	/**
	 * Actualiza los datos que venga informados de una persona mediante su dni
	 * @param idPersona
	 * @param request
	 * @throws ExceptionBase
	 */
	void actualizarPersona(Integer dni, PersonaRequest request) throws ExceptionBase;
}
