package com.alura.literalura.repository;

import com.alura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    List<Libro> findAll();

    @Query(value = "SELECT * FROM public.libro WHERE :idiomaElegido = ANY (idiomas)", nativeQuery = true)
    List<Libro> seleccionarLibroPorIdioma(@Param("idiomaElegido") String idiomaElegido);

    @Query(value = "SELECT * FROM public.libro WHERE LOWER(titulo) LIKE LOWER(CONCAT('%', :tituloBuscado, '%'))", nativeQuery = true)
    List<Libro> buscarLibroPorTitulo(@Param("tituloBuscado") String tituloBuscado);



}
