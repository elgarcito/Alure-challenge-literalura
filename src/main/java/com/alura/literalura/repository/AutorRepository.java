package com.alura.literalura.repository;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor,Long> {

    @Query(value = "SELECT * FROM autor WHERE " +
            "(ano_de_fallecimiento_autor IS NULL OR ano_de_fallecimiento_autor > :anioABuscar)" ,nativeQuery = true)
    List<Autor> seleccionarAutoresVivosEntreAnos(@Param("anioABuscar") int anioInicio);

}
