package com.colegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.dao.AlumnoDao;
import com.colegio.model.Alumno;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	AlumnoDao alumnodao;
	
	@GetMapping("/listar")
	public List<Alumno> listarAlumno (){
		return alumnodao.findAll();
		
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<String> guardarCliente(@RequestBody Alumno alumno) {
		alumnodao.save(alumno);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Alumno guardado con Exito");
	}

}