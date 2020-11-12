package com.contrato.demo.utils;

import com.contrato.demo.entities.Contrato;
import com.contrato.demo.entities.Persona;
import com.contrato.demo.entities.Producto;
import com.contrato.dto.request.ContratoRequest;
import com.contrato.dto.request.PersonaRequest;
import com.contrato.dto.request.ProductoRequest;
import com.contrato.dto.response.ContratoResponse;
import com.contrato.dto.response.PersonaResponse;
import com.contrato.dto.response.ProductoResponse;

public class Mappers {
	public static Contrato mapeoContratoRequestToContrato(ContratoRequest contrato) {
		Contrato entity = new Contrato();
		Producto producto = new Producto();
		producto.setIdProducto(contrato.getIdProducto());
		entity.setIdProducto(producto);
		Persona contratante = new Persona();
		contratante.setDni(contrato.getIdContratante());
		entity.setContratante(contratante);
		Persona arrendador = new Persona();
		arrendador.setDni(contrato.getIdArrendador());
		entity.setArrendador(arrendador);
		return entity;
	}

	public static ContratoResponse mappearControToContratoResponse(Contrato contrato) {
	
		ContratoResponse response = new ContratoResponse();
		PersonaResponse arrendador = new PersonaResponse();
		arrendador.setDni(contrato.getArrendador().getDni());
		arrendador.setNombre(contrato.getArrendador().getNombre());
		
		PersonaResponse contratante = new PersonaResponse();
		contratante.setDni(contrato.getContratante().getDni());
		contratante.setNombre(contrato.getContratante().getNombre());
		
		response.setArrendador(arrendador);
		response.setContratante(contratante);
		
		ProductoResponse producto = new ProductoResponse();
		producto.setIdProducto(contrato.getIdProducto().getIdProducto());
		producto.setDireccion(contrato.getIdProducto().getDireccion());
		producto.setValor(contrato.getIdProducto().getValor());
		response.setProducto(producto);
		response.setIdContrato(contrato.getIdContrato());
		return response;
	}

	/**
	 * Mapea a la entidad de Persona para insertar en BBDD
	 * @param persona
	 * @return Persona
	 */
	public static Persona mapperPersonaRequestToPersona(PersonaRequest persona) {
		Persona entity = new Persona();
		
		entity.setDni(persona.getDni());
		entity.setApellido1(persona.getApellido1());
		entity.setApellido2(persona.getApellido2());
		entity.setNombre(persona.getNombre());
		entity.setDireccion(persona.getDireccion());
		entity.setTelefono(persona.getTelefono());
		
		return entity;
	}

	/**
	 * Mapea la entidad a PersonaResponse.
	 * @param persona
	 * @return PersonaResponse
	 */
	public static PersonaResponse mapperPersonaToPersonaResponse(Persona persona) {
		PersonaResponse response = new PersonaResponse();
		response.setDni(persona.getDni());
		response.setNombre(persona.getNombre());
		response.setApellido1(persona.getApellido1());
		response.setApellido2(persona.getApellido2());
		response.setDireccion(persona.getDireccion());
		response.setTelefono(persona.getTelefono());
		return response;
	}

	public static Producto mapperProductoRequestToProducto(ProductoRequest request) {
		Producto producto = new Producto();
		producto.setDireccion(request.getDireccion());
		producto.setValor(request.getValor());
		return producto;
	}

	public static ProductoResponse mapperProductoToProductoResponse(Producto producto) {
		ProductoResponse response = new ProductoResponse();
		response.setDireccion(producto.getDireccion());
		response.setIdProducto(producto.getIdProducto());
		response.setValor(producto.getValor());
		return response;
	}
}
