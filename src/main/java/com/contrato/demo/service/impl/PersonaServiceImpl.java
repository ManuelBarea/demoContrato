package com.contrato.demo.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.contrato.demo.entities.Persona;
import com.contrato.demo.exceptions.ExceptionBase;
import com.contrato.demo.repositories.PersonaRepository;
import com.contrato.demo.service.IPersonaService;
import com.contrato.demo.utils.ErrorMessages;
import com.contrato.demo.utils.Mappers;
import com.contrato.dto.request.PersonaRequest;
import com.contrato.dto.response.PersonaResponse;
/**
 * Clase que implementa la interfaz IPersonaService. ( Los metodos tienen sus Javadocs en la Interfaz )
 * @author manuel.barea.velez
 *
 */
@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private PersonaRepository repoPersona;
	
	@Override
	public Integer crearPersona(PersonaRequest persona) throws ExceptionBase {
		
		Persona entity = Mappers.mapperPersonaRequestToPersona(persona);
		repoPersona.save(entity);
		
		return entity.getDni();
	}

	@Override
	public void eliminarPersona(Integer idPersona) throws ExceptionBase {
		
		if(repoPersona.existsById(idPersona)) {
			repoPersona.deleteById(idPersona);
		}else {
			throw new ExceptionBase(MessageFormat.format(ErrorMessages.NOT_FOUND_PERSONA, idPersona), HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public List<PersonaResponse> consultarPersonas(String nombre, String apellido) throws ExceptionBase {
		// FIXME : Consultar con criterios
		List<PersonaResponse> response = null;
		List<Persona> entitiesPersona = repoPersona.findAll();
		if(!CollectionUtils.isEmpty(entitiesPersona)) {
			response = new ArrayList<>();
			for(Persona entity : entitiesPersona) {
				PersonaResponse persona =Mappers.mapperPersonaToPersonaResponse(entity);
				response.add(persona);
			}
		}else {
			throw new ExceptionBase(ErrorMessages.NOT_FOUND_PERSONA_PARAMS, HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}

	@Override
	public PersonaResponse consultarPersona(Integer idPersona) throws ExceptionBase {
		Optional<Persona> entity = repoPersona.findById(idPersona);
		
		PersonaResponse response = null;
		
		if(entity.isPresent()) {
			response = Mappers.mapperPersonaToPersonaResponse(entity.get());
		}else {
			throw new ExceptionBase(MessageFormat.format(ErrorMessages.NOT_FOUND_PERSONA, idPersona), HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@Override
	public void actualizarPersona(Integer idPersona, PersonaRequest request) throws ExceptionBase {
		
		if(repoPersona.existsById(idPersona)) {
			Optional<Persona> entity = repoPersona.findById(idPersona);
			mapperNoNulosPersona(entity.get(), request);
			repoPersona.save(entity.get());
		}else {
			throw new ExceptionBase(MessageFormat.format(ErrorMessages.NOT_FOUND_PERSONA, idPersona), HttpStatus.NOT_FOUND);
		}
		
	}
	
	private void mapperNoNulosPersona(Persona entity, PersonaRequest request) {
		if(!StringUtils.isEmpty(request.getNombre())) {
			entity.setNombre(request.getNombre());
		}
		if(!StringUtils.isEmpty(request.getApellido1())) {
			entity.setApellido1(request.getApellido1());
		}
	}

}
