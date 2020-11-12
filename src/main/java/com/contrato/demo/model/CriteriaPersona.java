package com.contrato.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * Objeto que contiene los filtros de personas.
 * @author manuel.barea.velez
 *
 */
@Data
@AllArgsConstructor
public class CriteriaPersona {

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion;
	private String telefono;
	
}
