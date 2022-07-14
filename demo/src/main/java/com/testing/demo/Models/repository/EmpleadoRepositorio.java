package com.testing.demo.Models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testing.demo.Models.Empleado;

@Repository
public interface EmpleadoRepositorio extends  JpaRepository<Empleado, Long>  {

}
