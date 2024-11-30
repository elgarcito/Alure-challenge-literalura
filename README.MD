# Alure Challenge: Literalura

### ¡¡¡Hola!!!, Bienvenido a este repositorio

Aquí encontrarás la respuesta al desafío planteado en la tercera parte del curso
**Formaciones en programación** de
[Oracle Next Education](https://www.oracle.com/ar/education/oracle-next-education/).

### Acerca del desafío
El objetivo de este proyecto es poder aplicar cada uno de los módulos aprendidos
en el curso en un proyecto complejo:

### La app Literatura

A continuación, presentaremos cómo se aplicó cada uno de los cursos en la resolución de
este desafío. El orden en que aparecerán a continuación fue en el cual se
resolvió el problema (no el orden propio de la plataforma).
Los pasos son los siguientes:

## Paso 1 diseño de los modelos
Se utilizaron los cursos:
1. Java: Java: trabajando con lambdas, streams y Spring Framework
2. Java: persistencia de datos y consultas con Spring Data JPA

Se crearon los objetos que representan nuestro modelo.
Estos son las clases Autor, Traductor, Libro
Cada uno de estos posee parte de los datos entregado por la [API usada](https://gutendex.com/)
Se realizo la conexion con la api y se trajeron los datos desde la misma

## Paso 2 leyendo opciones de un archivo
Se utilizo el curso:
1. Java: persistencia de datos y consultas con Spring Data JPA

Por medio del siguiente codigo se 


Se utilizó la lectura obtenida de la API y utilizando las anotaciones de
Hibernate logramos establecer los modelos de los objetos en la base de datos
Este método se encuentra en la clase Menu.
Los objetos mapeados fueron los siguientes
```bash
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAPIResponse(
        @JsonAlias("count") int count,
        @JsonAlias("next") String next,
        @JsonAlias("previous") String previous,
        @JsonAlias("results")List<DatosLibro> results
        ) {
}

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") int fechaDeNacimiento,
        @JsonAlias("death_year") int fechaDeFallecimiento
) {
}

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("id") Long identifyer,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> autores,
        @JsonAlias("translators") List<DatosTraductor> traductores,
        @JsonAlias("subjects") List<String> temas,
        @JsonAlias("bookshelves") List<String> estanterias,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("copyright") boolean derechosAutor,
        @JsonAlias("download_count") Long cantidadDescargas
) {
}

```

## Paso 3
Se utilizo el curso:
1. Java: persistencia de datos y consultas con Spring Data JPA

Aqui se utilizo la interfaz 
```bash
 JpaRepository<Autor,Long>
```
Para realizar las consultas.
Las mismas fueron
```bash
Para autores
   @Query(value = "SELECT * FROM autor WHERE " +
            "(ano_de_fallecimiento_autor IS NULL OR ano_de_fallecimiento_autor > :anioABuscar)" ,nativeQuery = true)
    List<Autor> seleccionarAutoresVivosEntreAnos(@Param("anioABuscar") int anioInicio);

    List<Autor> findAll();
    
Para Libros
    List<Libro> findAll();

    @Query(value = "SELECT * FROM public.libro WHERE :idiomaElegido = ANY (idiomas)", nativeQuery = true)
    List<Libro> seleccionarLibroPorIdioma(@Param("idiomaElegido") String idiomaElegido);

    @Query(value = "SELECT * FROM public.libro WHERE LOWER(titulo) LIKE LOWER(CONCAT('%', :tituloBuscado, '%'))", nativeQuery = true)
    List<Libro> buscarLibroPorTitulo(@Param("tituloBuscado") String tituloBuscado);

Para traductores
    List<Traductor> findAll();
```
## Paso 4
Se utilizo el curso:
1. Java: Java: trabajando con lambdas, streams y Spring Framework
2. Java: persistencia de datos y consultas con Spring Data JPA
3. Java: creando tu primera API y conectándola al Front End

Aqui finalmente integramos todas las opciones previamente realizadas
en un menu que permite elegir claramente a las mismas

### Resumen final

Para copiar este repositorio en caso de necesitarlo:
1. Asegúrate de tener instalado Git en tu computadora. Si no lo tienes, puedes descargarlo desde [este link](https://git-scm.com/downloads).
2. Abre una terminal o ventana de comandos y navega hasta la carpeta raíz de tu repositorio local.
2. Ejecuta el siguiente comando para agregar todos los archivos modificados al área de preparación de Git:

```bash
  git clone this-repo-url
```

Tal como se indica en el desafío el proyecto no se deployo.

Como conclusión y a titulo personal, el desafío presento una complejidad acorde a la dificultad de los cursos.
Los contenidos de cada curso fueron aplicados directamente en el proyecto final, lo que indica una gran posibilidad
de aplicación de cada tema.
La complejidad de este proyecto fue alta, debido al material extra a leer para poder realizarlo correctamente
Quedo muy satisfecho con el resultado y espero que ustedes también


### Author
[@Edgar Aguirre](https://github.com/elgarcito)

For educative purpose.

