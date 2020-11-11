package com.contrato.demo.models;

import javax.validation.constraints.NotNull;

public class ContratoRequest {
	
	@NotNull(message = "El idProducto no puede estar vacio.")
	private Integer idProducto;
	@NotNull(message = "El idArrendador no puede estar vacio.")
	private Integer idArrendador;
	@NotNull(message = "El idContratante no puede estar vacio.")
	private Integer idContratante;
	
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Integer getIdArrendador() {
		return idArrendador;
	}
	public void setIdArrendador(Integer idArrendador) {
		this.idArrendador = idArrendador;
	}
	public Integer getIdContratante() {
		return idContratante;
	}
	public void setIdContratante(Integer idContratante) {
		this.idContratante = idContratante;
	}
}
