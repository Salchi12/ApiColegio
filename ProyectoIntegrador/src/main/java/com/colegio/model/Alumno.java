package com.colegio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="alumnos")
@Getter
@Setter
public class Alumno {
	
	@Id
	@Column
	private Integer idalumnos;
	
	@Column
	private String dni;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String direccion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date privatefechaNacimiento;
	
	private Integer morosos;

}
