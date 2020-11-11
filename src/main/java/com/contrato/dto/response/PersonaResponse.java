package com.contrato.dto.response;

import lombok.Data;
/**
 * Dto para devolver datos de una persona.
 * @author manuel.barea.velez
 *
 */
@Data
public class PersonaResponse {
	private Integer dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion;
	private String telefono;
	
	}
