package com.testing.demo.Models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.testing.demo.Models.Persona;

// JpaRepository
@NoRepositoryBean
public interface PersonaRepositorio extends CrudRepository<Persona, String> {
}
