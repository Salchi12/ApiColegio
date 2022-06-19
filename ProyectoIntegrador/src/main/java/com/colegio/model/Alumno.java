package com.colegio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="alumnos")
@Getter
@Setter
public class Alumno {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idalumnos;
	
	@Column
	private String dni;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String direccion;
	
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha_nacimiento;
	
	private Integer morosos;

}
