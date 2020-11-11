package com.contrato.demo.models;

public class ContratoResponse {

	private Integer idContrato;
	private PersonaResponse contratante;
	private PersonaResponse arrendador;
	private ProductoResponse producto;
	
	public Integer getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	public PersonaResponse getContratante() {
		return contratante;
	}
	public void setContratante(PersonaResponse contratante) {
		this.contratante = contratante;
	}
	public PersonaResponse getArrendador() {
		return arrendador;
	}
	public void setArrendador(PersonaResponse arrendador) {
		this.arrendador = arrendador;
	}
	public ProductoResponse getProducto() {
		return producto;
	}
	public void setProducto(ProductoResponse producto) {
		this.producto = producto;
	}
	
	
	
}
