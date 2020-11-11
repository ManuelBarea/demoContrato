package com.contrato.demo.service;
import java.util.List;

import com.contrato.demo.exceptions.ExceptionBase;
import com.contrato.demo.models.PersonaRequest;
import com.contrato.demo.models.PersonaResponse;

public interface IPersonaService {
	Integer crearPersona(PersonaRequest persona) throws ExceptionBase;
	
	void eliminarPersona(Integer idPersona) throws ExceptionBase;
	
	List<PersonaResponse> consultarPersonas(String nombre, String apellido) throws ExceptionBase;
	
	PersonaResponse consultarPersona(Integer idPersona) throws ExceptionBase;
	
	void actualizarPersona(Integer idPersona, PersonaRequest request) throws ExceptionBase;
}
