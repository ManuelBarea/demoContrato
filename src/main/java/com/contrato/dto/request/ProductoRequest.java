package com.contrato.dto.request;

import lombok.Data;

@Data
public class ProductoRequest {

	private String valor;
	private String direccion;
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
