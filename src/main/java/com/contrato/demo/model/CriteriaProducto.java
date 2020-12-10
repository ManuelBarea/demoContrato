package com.contrato.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * Clase criteria para la consulta personalizada de productos en el repositorio
 * @author manuel.barea.velez
 *
 */
@AllArgsConstructor
@Data
public class CriteriaProducto {

	private String nombre;
	private String noContrato;
	private String tipo;
	
}
