package com.kjquito.estudio.entity;

import java.io.Serializable;

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
@Table(name = "estudio")
public class EstudioEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "precio")
	private double precio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_id", updatable = false, nullable = false)
	private CategoriaEntity categoria_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public CategoriaEntity getCategoriaEntity() {
		return categoria_id;
	}

	public void setCategoriaEntity(CategoriaEntity categoriaEntity) {
		this.categoria_id = categoriaEntity;
	}

	private static final long serialVersionUID = 4594491127731149403L;

}
