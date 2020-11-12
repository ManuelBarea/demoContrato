package com.contrato.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
/**
 * Dto para la actualizacion de una persona
 * @author manuel.barea.velez
 *
 */
@Data
public class PersonaPatchRequest {
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
