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
import com.contrato.demo.exceptions.NotFoundException;
import com.contrato.demo.model.CriteriaPersona;
import com.contrato.demo.repositories.PersonaCustomRepository;
import com.contrato.demo.repositories.PersonaRepository;
import com.contrato.demo.service.IPersonaService;
import com.contrato.demo.utils.ErrorMessages;
import com.contrato.demo.utils.Mappers;
import com.contrato.dto.request.PersonaPatchRequest;
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
	
	@Autowired
	private PersonaCustomRepository repoCustomPersona;
	
	@Override
	public Integer crearPersona(PersonaRequest persona) throws ExceptionBase {
		
		Persona entity = Mappers.mapperPersonaRequestToPersona(persona);
		repoPersona.save(entity);
		
		return entity.getDni();
	}

	@Override
	public void eliminarPersona(Integer dni) throws ExceptionBase {
		
		if(repoPersona.existsById(dni)) {
			repoPersona.deleteById(dni);
		}else {
			throw new NotFoundException(MessageFormat.format(ErrorMessages.NOT_FOUND_PERSONA, dni));
		}
		
	}

	@Override
	public List<PersonaResponse> consultarPersonas(String nombre, String apellido1, String apellido2, String direccion, String telefono) throws ExceptionBase {
		List<PersonaResponse> response = null;
		CriteriaPersona criteria = new CriteriaPersona(nombre, apellido1, apellido2, direccion, telefono);
		List<Persona> entitiesPersona = repoCustomPersona.findPersonasByCriteria(criteria);
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
	public PersonaResponse consultarPersona(Integer dni) throws ExceptionBase {
		Optional<Persona> entity = repoPersona.findById(dni);
		
		PersonaResponse response = null;
		
		if(entity.isPresent()) {
			response = Mappers.mapperPersonaToPersonaResponse(entity.get());
		}else {
			throw new NotFoundException(MessageFormat.format(ErrorMessages.NOT_FOUND_PERSONA, dni));
		}
		return response;
	}

	@Override
	public void actualizarPersona(Integer dni, PersonaPatchRequest request) throws ExceptionBase {
		
		if(repoPersona.existsById(dni)) {
			Optional<Persona> entity = repoPersona.findById(dni);
			mapperNoNulosPersona(entity.get(), request);
			repoPersona.save(entity.get());
		}else {
			throw new NotFoundException(MessageFormat.format(ErrorMessages.NOT_FOUND_PERSONA, dni));
		}
		
	}
	
	/**
	 * Mapea los campos no nulos del request para actualizar la entidad
	 * @param entity
	 * @param request
	 */
	private void mapperNoNulosPersona(Persona entity, PersonaPatchRequest request) {
		if(!StringUtils.isEmpty(request.getNombre())) {
			entity.setNombre(request.getNombre());
		}
		
		if(!StringUtils.isEmpty(request.getApellido1())) {
			entity.setApellido1(request.getApellido1());
		}
		
		if(!StringUtils.isEmpty(request.getApellido2())) {
			entity.setApellido2(request.getApellido2());
		}
		
		if(!StringUtils.isEmpty(request.getDireccion())) {
			entity.setDireccion(request.getDireccion());
		}
		
		if(!StringUtils.isEmpty(request.getTelefono())) {
			entity.setTelefono(request.getTelefono());
		}
	}

}
