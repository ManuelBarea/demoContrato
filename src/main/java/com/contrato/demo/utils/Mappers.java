package com.contrato.demo.utils;

import java.util.Random;

import com.contrato.demo.entities.Contrato;
import com.contrato.demo.entities.Persona;
import com.contrato.demo.entities.Producto;
import com.contrato.demo.models.ContratoRequest;
import com.contrato.demo.models.ContratoResponse;
import com.contrato.demo.models.PersonaRequest;
import com.contrato.demo.models.PersonaResponse;
import com.contrato.demo.models.ProductoRequest;
import com.contrato.demo.models.ProductoResponse;

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
		arrendador.setIdPersona(contrato.getArrendador().getDni());
		arrendador.setNombreApellidos(contrato.getArrendador().getNombre() +  " " + contrato.getArrendador().getApellido1());
		
		PersonaResponse contratante = new PersonaResponse();
		contratante.setIdPersona(contrato.getContratante().getDni());
		contratante.setNombreApellidos(contrato.getContratante().getNombre() +  " " + contrato.getContratante().getApellido1());
		
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

	public static Persona mapperPersonaRequestToPersona(PersonaRequest persona) {
		Persona entity = new Persona();
		
		entity.setDni(persona.getDni());
		entity.setApellido1(persona.getApellido());
		entity.setNombre(persona.getNombre());
		entity.setDireccion(persona.getDireccion());
		entity.setTelefono(persona.getTelefono());
		
		return entity;
	}

	public static PersonaResponse mapperPersonaToPersonaResponse(Persona persona) {
		PersonaResponse response = new PersonaResponse();
		response.setIdPersona(persona.getDni());
		response.setNombreApellidos(persona.getNombre() + " " + persona.getApellido1());
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
