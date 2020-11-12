package com.contrato.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contrato.demo.exceptions.ExceptionBase;
import com.contrato.demo.service.IPersonaService;
import com.contrato.dto.request.PersonaPatchRequest;
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
			@RequestParam(required = false) String apellido1,
			@RequestParam(required = false) String apellido2,
			@RequestParam(required = false) String direccion,
			@RequestParam(required = false) String telefono) throws ExceptionBase{
		
		return new ResponseEntity<List<PersonaResponse>>(service.consultarPersonas(nombre, apellido1, apellido2, direccion, telefono), HttpStatus.OK);
		
	}
	
	/**
	 * Metodo para listar una persona segun su DNI.
	 * @param dni
	 * @return ResponseEntity<PersonaResponse> 200 si todo es correcto.
	 * @throws ExceptionBase
	 */
	@GetMapping(path = "personas/{dni}")
	public ResponseEntity<PersonaResponse> consultarPersona(@PathVariable("dni")Integer dni) throws ExceptionBase{
		
		return new ResponseEntity<PersonaResponse>(service.consultarPersona(dni), HttpStatus.OK);
		
	}
	
	/**
	 * Metodo para eliminar a una persona según su dni
	 * @param dni
	 * @return ResponseEntity<HttpStatus> 204 si todo es correcto.
	 * @throws ExceptionBase
	 */
	@DeleteMapping(path = "personas/{dni}")
	public ResponseEntity<HttpStatus> eliminarPersona(@PathVariable ("dni")Integer dni) throws ExceptionBase{
		service.eliminarPersona(dni);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	}
	
	/**
	 * Metoto para actualizar datos de una persona segun su dni.
	 * @param dni
	 * @param request
	 * @return ResponseEntity<HttpStatus> 204 si todo es correcto.
	 * @throws ExceptionBase
	 */
	@PatchMapping(path = "personas/{dni}")
	public ResponseEntity<HttpStatus> actualizarPersona(@PathVariable("dni")Integer dni, @RequestBody PersonaPatchRequest request) throws ExceptionBase{
		service.actualizarPersona(dni, request);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	}
	
	
	
}
