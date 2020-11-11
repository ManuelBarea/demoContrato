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
import com.contrato.demo.models.PersonaRequest;
import com.contrato.demo.models.PersonaResponse;
import com.contrato.demo.service.IPersonaService;

@RestController
public class PersonaController {

	@Autowired
	private IPersonaService service;
	
	@PostMapping(path = "personas")
	public ResponseEntity<Integer> insertaPersona(@Valid @RequestBody(required = true) PersonaRequest persona) throws ExceptionBase{
		
		return new ResponseEntity<Integer>(service.crearPersona(persona), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "personas")
	public ResponseEntity<List<PersonaResponse>> consultarPersonas(@RequestParam(required = false)String nombre,
			@RequestParam(required = false) String apellido) throws ExceptionBase{
		
		return new ResponseEntity<List<PersonaResponse>>(service.consultarPersonas(nombre, apellido), HttpStatus.OK);
		
	}
	@GetMapping(path = "personas/{idPersona}")
	public ResponseEntity<PersonaResponse> consultarPersona(@PathParam("idPersona")Integer idPersona) throws ExceptionBase{
		
		return new ResponseEntity<PersonaResponse>(service.consultarPersona(idPersona), HttpStatus.OK);
		
	}
	@DeleteMapping(path = "personas/{idPersona}")
	public ResponseEntity<HttpStatus> eliminarPersona(@PathParam("idPersona")Integer idPersona) throws ExceptionBase{
		service.eliminarPersona(idPersona);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	}
	@PatchMapping(path = "personas/{idPersona}")
	public ResponseEntity<HttpStatus> actualizarPersona(@PathParam("idPersona")Integer idPersona, @RequestBody PersonaRequest request) throws ExceptionBase{
		service.actualizarPersona(idPersona, request);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	}
	
	
	
}
