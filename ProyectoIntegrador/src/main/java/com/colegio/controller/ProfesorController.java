package com.colegio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.dao.ProfesorDao;
import com.colegio.model.Profesor;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/profesor")
public class ProfesorController {
	
	@Autowired
	ProfesorDao profesorDao;
	
	@GetMapping("/listar")
	public List<Profesor> listarProfesor(){
		return profesorDao.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Profesor> obtenerProfesorId(@PathVariable("id") Integer id){
		return profesorDao.findById(id);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<String> guardarProfesor(@RequestBody Profesor profesor){
		profesorDao.save(profesor);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Profesor guardado con exito");
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Profesor> editarProfesor(@PathVariable(value="id") Integer profesorId, @RequestBody Profesor profesor) throws Exception{
		Profesor profesorById = profesorDao.findById(profesorId)
				.orElseThrow(() -> new Exception("Profesor no encontrado"));
		
		profesorById.setNombre(profesor.getNombre());
		profesorById.setApellido(profesor.getApellido());
		profesorById.setDni(profesor.getDni());
		profesorById.setDireccion(profesor.getDireccion());
		profesorById.setFecha_nacimiento(profesor.getFecha_nacimiento());
		
		final Profesor updateProfesor = profesorDao.save(profesor);
		return ResponseEntity.ok(updateProfesor);
		
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<String> eliminarProfesor(@PathVariable("id") Integer id){
		profesorDao.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK)
				.body("Profesor eliminado con exito");
	}

}
