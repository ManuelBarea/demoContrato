package com.contrato.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * Request para insertar una persona.
 * @author manuel.barea.velez
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PersonaRequest  extends PersonaPatchRequest{

	@NotNull(message = "El parámetro dni no pude ser nulo")
	@Max(99999999)
	private Integer dni;

}
