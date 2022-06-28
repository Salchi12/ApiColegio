package com.colegio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}")
	public Optional<Alumno> obtenerAlumnoId(@PathVariable("id") Integer id) {
		return alumnodao.findById(id);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<String> guardarCliente(@RequestBody Alumno alumno) {
		alumnodao.save(alumno);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Alumno guardado con Exito");
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Alumno> editarAlumno(@PathVariable(value="id") Integer alumnoId, @RequestBody Alumno alumno) throws Exception{
		Alumno alumnoById = alumnodao.findById(alumnoId)
				.orElseThrow(() -> new Exception("Alumno no encontrado"));
		
		alumnoById.setNombre(alumno.getNombre());
		alumnoById.setApellido(alumno.getApellido());
		alumnoById.setDni(alumno.getDni());
		alumnoById.setDireccion(alumno.getDireccion());
		alumnoById.setFecha_nacimiento(alumno.getFecha_nacimiento());
		alumnoById.setMorosos(alumno.getMorosos());
		
		final Alumno updateAlumno = alumnodao.save(alumno);
		return ResponseEntity.ok(updateAlumno);
		
	}
	
	
	
	
	

}