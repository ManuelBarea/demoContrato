package com.contrato.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto {

	private Integer id;
	private String nombre;
	private String tipo;
	private String noContrato;
	@Id
	@Column(name = "ID",nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "NOMBRE",nullable = false)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(name = "TIPO",nullable = false)
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Column(name = "NOCONTRATO",nullable = false)
	public String getNoContrato() {
		return noContrato;
	}
	public void setNoContrato(String noContrato) {
		this.noContrato = noContrato;
	}
}
