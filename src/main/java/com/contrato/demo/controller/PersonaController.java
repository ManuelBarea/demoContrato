package com.contrato.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contrato.demo.exceptions.ExceptionBase;
import com.contrato.demo.service.IPersonaService;
import com.contrato.dto.request.PersonaRequest;
import com.contrato.dto.response.PersonaResponse;
/**
 * Clase Controller para Personas.
 * @author manuel.barea.velez
 *
 */
@RestController
public class PersonaController {

	@Autowired
	private IPersonaService service;
	
	/**
	 * Metodo para insertar una persona.
	 * @param persona
	 * @return ResponseEntity<Integer> 201 si todo es correcto.
	 * @throws ExceptionBase
	 */
	@PostMapping(path = "personas")
	public ResponseEntity<Integer> insertaPersona(@Valid @RequestBody(required = true) PersonaRequest persona) throws ExceptionBase{
		
		return new ResponseEntity<Integer>(service.crearPersona(persona), HttpStatus.CREATED);
	}
	
	/**
	 * Metodo para listar personas con o sin filtros
	 * @param nombre
	 * @param apellido
	 * @return ResponseEntity<List<PersonaResponse>> 200 si todo es correcto.
	 * @throws ExceptionBase
	 */
	@GetMapping(path = "personas")
	public ResponseEntity<List<PersonaResponse>> consultarPersonas(@RequestParam(required = false)String nombre,
			@RequestParam(required = false) String apellido) throws ExceptionBase{
		
		return new ResponseEntity<List<PersonaResponse>>(service.consultarPersonas(nombre, apellido), HttpStatus.OK);
		
	}
	
	/**
	 * Metodo para listar una persona segun su DNI.
	 * @param idPersona
	 * @return ResponseEntity<PersonaResponse> 200 si todo es correcto.
	 * @throws ExceptionBase
	 */
	@GetMapping(path = "personas/{dni}")
	public ResponseEntity<PersonaResponse> consultarPersona(@PathParam("dni")Integer dni) throws ExceptionBase{
		
		return new ResponseEntity<PersonaResponse>(service.consultarPersona(dni), HttpStatus.OK);
		
	}
	
	/**
	 * Metodo para eliminar a una persona según su dni
	 * @param idPersona
	 * @return ResponseEntity<HttpStatus> 204 si todo es correcto.
	 * @throws ExceptionBase
	 */
	@DeleteMapping(path = "personas/{idPersona}")
	public ResponseEntity<HttpStatus> eliminarPersona(@PathParam("idPersona")Integer idPersona) throws ExceptionBase{
		service.eliminarPersona(idPersona);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	}
	
	/**
	 * Metoto para actualizar datos de una persona segun su dni.
	 * @param idPersona
	 * @param request
	 * @return ResponseEntity<HttpStatus> 204 si todo es correcto.
	 * @throws ExceptionBase
	 */
	@PatchMapping(path = "personas/{idPersona}")
	public ResponseEntity<HttpStatus> actualizarPersona(@PathParam("idPersona")Integer idPersona, @RequestBody PersonaRequest request) throws ExceptionBase{
		service.actualizarPersona(idPersona, request);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	}
	
	
	
}
