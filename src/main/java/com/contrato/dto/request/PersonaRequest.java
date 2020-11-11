package com.contrato.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
/**
 * Request para insertar una persona.
 * @author manuel.barea.velez
 *
 */
@Data
public class PersonaRequest {

	@NotNull(message = "El parámetro dni no pude ser nulo")
	@Max(99999999)
	private Integer dni;
	@NotEmpty(message = "El parámetro nombre no puede ser nulo")
	private String nombre;
	@NotEmpty(message = "El parámetro apellido1 no puede ser nulo")
	private String apellido1;
	@NotEmpty(message = "El parámetro apellido2 no puede ser nulo")
	private String apellido2;
	@NotEmpty(message = "El parámetro direccion no pude ser nulo")
	private String direccion;
	@NotEmpty(message = "El parámetro telefono no pude ser nulo")
	@Size(max = 9)
	private String telefono;
	

}
