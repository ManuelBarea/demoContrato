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
import org.springframework.web.bind.annotation.RestController;

import com.contrato.demo.exceptions.ExceptionBase;
import com.contrato.demo.models.ContratoRequest;
import com.contrato.demo.models.ContratoResponse;
import com.contrato.demo.service.IContratoService;

@RestController
public class ContratoController {

	@Autowired
	private IContratoService service;
	
	@GetMapping(path = "contratos")
	public ResponseEntity<List<ContratoResponse>> consultarContratos() throws ExceptionBase{
		
		return new ResponseEntity<List<ContratoResponse>>(service.consultarContratos(), HttpStatus.OK);
		
	}

	@PostMapping(path = "contratos")
	public ResponseEntity<Integer> insertaContrato(@Valid @RequestBody(required = true) ContratoRequest contrato) throws ExceptionBase{
		
		return new ResponseEntity<Integer>(service.insertaContrato(contrato), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "contratos/{idContrato}")
	public ResponseEntity<ContratoResponse> consultarContrato(@PathVariable("idContrato") Integer idContrato) throws ExceptionBase{
		
		
		return new ResponseEntity<ContratoResponse>(service.consultarContrato(idContrato), HttpStatus.OK);
	}
	@DeleteMapping(path = "contratos/{idContrato}")
	public ResponseEntity<HttpStatus> eliminaContrato(@PathVariable("idContrato") Integer idContrato) throws ExceptionBase{
		
		service.eliminaContrato(idContrato);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(path = "contratos/{idContrato}")
	public  ResponseEntity<HttpStatus> modificarContrato(@PathVariable(name = "idContrato", required = true) Integer idContrato,
			@RequestBody(required = true) ContratoRequest contrato) throws ExceptionBase{
		
		service.modificarContrato(idContrato, contrato);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
