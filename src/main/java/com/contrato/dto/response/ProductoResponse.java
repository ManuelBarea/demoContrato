package com.contrato.dto.response;

import lombok.Data;
/**
 * Dto de respuesta para la consulta de productos
 * @author manuel.barea.velez
 *
 */
@Data
public class ProductoResponse {
	private Integer idProducto;
	private String nombre;
	private String tipo;
	private String noContrado;
}
