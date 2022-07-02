package com.colegio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colegio.model.Profesor;

public interface ProfesorDao extends JpaRepository<Profesor, Integer> {

}
