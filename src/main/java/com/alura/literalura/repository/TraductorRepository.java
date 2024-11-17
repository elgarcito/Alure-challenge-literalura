package com.alura.literalura.repository;

import com.alura.literalura.model.Libro;
import com.alura.literalura.model.Traductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraductorRepository extends JpaRepository<Traductor,Long> {
}
