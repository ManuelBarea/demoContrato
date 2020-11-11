package com.contrato.demo.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PersonaRequest {

	@NotNull(message = "El parámetro dni no pude ser nulo")
	private Integer dni;
	@NotEmpty(message = "El parámetro nombre no puede ser nulo")
	private String nombre;
	@NotEmpty(message = "El parámetro apellido no puede ser nulo")
	private String apellido;
	@NotEmpty(message = "El parámetro direccion no pude ser nulo")
	private String direccion;
	@NotEmpty(message = "El parámetro telefono no pude ser nulo")
	private String telefono;
	

}
