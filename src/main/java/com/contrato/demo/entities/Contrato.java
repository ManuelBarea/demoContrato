package com.contrato.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRATO")
public class Contrato {

	private Integer idContrato;
	private Persona contratante;
	private Persona arrendador;
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CONTRATANTE",referencedColumnName = "DNI", nullable = false)
	public Persona getContratante() {
		return contratante;
	}

	public void setContratante(Persona contratante) {
		this.contratante = contratante;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ARRENDADOR",referencedColumnName = "DNI", nullable = false)
	public Persona getArrendador() {
		return arrendador;
	}

	public void setArrendador(Persona arrendador) {
		this.arrendador = arrendador;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDPRODUCTO", nullable = false)
	public Producto getIdProducto() {
		return producto;
	}

	public void setIdProducto(Producto producto) {
		this.producto = producto;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDCONTRATO", unique = true, nullable = false)
	public Integer getIdContrato() {
		return this.idContrato;
	}
	
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}

}
