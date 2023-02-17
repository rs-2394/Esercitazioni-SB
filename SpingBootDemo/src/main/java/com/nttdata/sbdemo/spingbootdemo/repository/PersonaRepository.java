package com.nttdata.sbdemo.spingbootdemo.repository;

import com.nttdata.sbdemo.spingbootdemo.dominio.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}