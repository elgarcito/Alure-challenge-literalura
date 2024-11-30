package com.alura.literalura.main;

import com.alura.literalura.model.*;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.repository.TraductorRepository;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class MenuPrincipal {
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;
    private TraductorRepository traductorRepository;


    private Scanner teclado=new Scanner(System.in);
    private ConsumoAPI consumoAPI =new ConsumoAPI();
    private final String URL_BASE="https://gutendex.com/books/";
    private ConvierteDatos conversor=new ConvierteDatos();
    private List<Libro> listaDeLibros =new ArrayList<>();
    private List<Autor> listaDeAutores=new ArrayList<>();
    private List<Traductor> listaDeTraductores=new ArrayList<>();

    public MenuPrincipal(LibroRepository libroRepository,AutorRepository autorRepository,TraductorRepository traductorRepository) {
        this.libroRepository=libroRepository;
        this.autorRepository=autorRepository;
        this.traductorRepository=traductorRepository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por titulo registrados
                    2 - Buscar libros registrados
                    3 - Listar autores registrados
                    4 - Buscar autores vivos en un determinado año
                    5 - Listar libros registrados por idioma
                    6 - Buscar autores vivos en un determinado año desde la base de datos
                    7 - Agregar un libro a la base de datos
                    8 - Ver todos los libros guardados
                    9 - Ver todos los traductores guardados
                   
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
//                    buscarSerieWeb();
                    //buscarLibroPorTitulo();
                    break;
                case 2:
//                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    buscarAutoresVivosEnUnDeterminadoAno();
                    break;
                case 5:
                    buscarLibroPorIdioma();
                    break;
                case 6:
                    buscarAutoresVivosPorAnosEnLaBaseDeDatos();
                    break;
                case 7:
                    agregarLibroALaBaseDeDatos();
                    break;
                case 8:
                    verTodosLosLibrosGuardados();
                    break;
                case 9:
                   listarTraductoresRegistrados();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }

    }

    private void buscarAutoresVivosPorAnosEnLaBaseDeDatos() {
        System.out.println("Escribe el año de inicio que deseas buscar");
        var anoDeInicio = elegirOpcionNumericaCorrecta();
        autorRepository.seleccionarAutoresVivosEntreAnos(anoDeInicio).forEach(autor -> System.out.println(autor.toString()));
    }

    private void buscarLibroPorIdioma() {
            System.out.println("Elegir opcion 1-ingles 2-español");
            var idiomaElegido = elegirOpcionNumericaCorrecta();
            switch (idiomaElegido){
                case 1:
                    libroRepository.seleccionarLibroPorIdioma("en").forEach(s -> System.out.println(s.toString()));
                    break;
                case 2:
                    libroRepository.seleccionarLibroPorIdioma("es").forEach(s -> System.out.println(s.toString()));
                    break;
            }
    }


    private DatosLibro agregarLibroALaBaseDeDatos() {
        System.out.println("Escribe el titulo del libro que deseas buscar");
        var nombreLibro = escribirBusquedaCorrectamente();
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search="+nombreLibro.replace(" ", "+"));
        DatosAPIResponse datosAPIResponse=conversor.obtenerDatos(json, DatosAPIResponse.class);
        if (datosAPIResponse.results().isEmpty()){
            System.out.println("No se encuentra informacion disponible sobre el libro buscado");
            return null;
        }
        AtomicInteger contador = new AtomicInteger(0);
        System.out.println("Resultados encontrados: "+"\n");
        datosAPIResponse.results().stream().forEach(book-> {
            int index = contador.incrementAndGet();
            System.out.println("Opcion: "+index+" "+book+"\n");
        });
        System.out.println("Escriba el numero de la opcion que desea guardar en la base de datos"+"\n");
        System.out.println("Si desea cancelar la operacion seleccione 0");

       int opcionElegida= elegirOpcionNumericaCorrecta();
            if (opcionElegida == 0) {
                System.out.println("Eligio no guardar ningun libro en la base de datos, muchas gracias");
                return null;
            } else {
                agregarUnLibroALaBaseDeDatos(datosAPIResponse,opcionElegida);
            }
        return null;

    }

    private void verTodosLosLibrosGuardados() {
       // listaDeLibros.forEach(book-> System.out.println(book.toString()));
        libroRepository.findAll().stream().forEach(libro -> System.out.println(libro.toString()));
    }

    private void buscarAutoresVivosEnUnDeterminadoAno() {
        System.out.println("Escribe el titulo del año de inicio que deseas buscar");
        var anoDeInicio = elegirOpcionNumericaCorrecta();
        System.out.println("Escribe el titulo del año de finalizacion que deseas buscar");
        var anoFinalizacion = elegirOpcionNumericaCorrecta();
        var json = consumoAPI.obtenerDatos(URL_BASE + "?author_year_start=" + anoDeInicio + "&author_year_end=" + anoFinalizacion);
        DatosAPIResponse datosAPIResponse = conversor.obtenerDatos(json, DatosAPIResponse.class);
        if (datosAPIResponse.results().isEmpty()) {
            System.out.println("No hay autores registrados entre esas fechas");
            return;
        }
        System.out.println("Resultados encontrados: "+"\n");
//        datosAPIResponse.results().stream().forEach(book-> System.out.println(book+"\n"));

//        datosAPIResponse.results().stream().forEach(book->{
          //  book.autores().stream().forEach(autor->listaDeAutores.add(autor));
//            listaDeAutores.add(book.autores().get(0));//Elijo solo el primer autor segun consigna
//        });
        datosAPIResponse.results().stream().map(dBook->new Libro(dBook))
                .forEach(book-> System.out.println(book.toString()));

        System.out.println("¿Desea guardar la seleccion en la base de datos? 1-Si 0-No"+"\n");

        int opcionElegida= elegirOpcionNumericaCorrecta();
        if (opcionElegida == 0) {
            System.out.println("Eligio no guardar ningun libro en la base de datos, muchas gracias");
        } else {
            agregarMultiplesLibrosALaBaseDeDatos(datosAPIResponse);
        }



    }

    private void listarAutoresRegistrados() {
        listaDeAutores.stream().forEach(autor-> System.out.println(autor));
    }

    private void listarTraductoresRegistrados() {
        listaDeTraductores.stream().forEach(traductor-> System.out.println(traductor));
    }


    private int elegirOpcionNumericaCorrecta(){
        int numeroEntero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print("Por favor,recuerde ingresar solo números enteros: ");
            String entrada = teclado.nextLine();
            try {
                numeroEntero = Integer.parseInt(entrada);
                valido = true; // Si la conversión fue exitosa, se marca como válido
            } catch (NumberFormatException e) {
                System.out.println("Error: eso no es un número entero. Inténtalo de nuevo.");
            }
        }
        return numeroEntero;
    }

    private String escribirBusquedaCorrectamente(){
        String entrada = "";
        boolean valido = false;

        // Expresión regular para validar que solo contenga letras y números
        String patron = "^[a-zA-Z0-9 ]+$";

        while (!valido) {
            System.out.print("Por favor, solo letras y números, sin caracteres especiales: ");
            entrada = teclado.nextLine();

            if (entrada.matches(patron)) {
                valido = true; // Si la cadena es válida, se marca como válido
            } else {
                System.out.println("Error: la entrada contiene caracteres no permitidos. Intenta de nuevo.");
            }
        }
        return entrada;
    }

    private void agregarUnLibroALaBaseDeDatos(DatosAPIResponse datosAPIResponse,int opcionElegida){
       List<Autor> listaDeAutoresEncontrados = new ArrayList<>();
       List<Traductor> listaDeTraductorEncontrado=new ArrayList<>();
       List<Libro> listaDeLibrosEncontrados=new ArrayList<>();
        datosAPIResponse.results().stream()
                .skip(opcionElegida-1)
                .findFirst()
                // .forEach(book->{
                .ifPresent(book->{


                    book.autores().stream()
                            .filter(Objects::nonNull)
                            .forEach(autor->{
                                Autor nuevoAutor=new Autor(autor);
                                listaDeAutoresEncontrados.add(nuevoAutor);
//                                listaDeAutores.add(nuevoAutor);
                            });
                    book.traductores().stream()
                            .filter(Objects::nonNull)
                            .forEach(traductor->{
                                Traductor nuevoTraductor=new Traductor(traductor);
                                listaDeTraductorEncontrado.add(nuevoTraductor);
//                                listaDeTraductores.add(nuevoTraductor);
                            });
                    Libro nuevoLibro= new Libro(book);
                    listaDeLibrosEncontrados.add(nuevoLibro);
//                    listaDeLibros.add(nuevoLibro);
                });
        listaDeLibrosEncontrados.forEach(libro -> {
            try {
                libroRepository.save(libro);
            }catch (Exception ignored){
                System.out.println("Libro ya registrado");
            }

        });
        listaDeAutoresEncontrados.forEach(autor->{
            try {
                autorRepository.save(autor);
            }catch (Exception ignored){
                System.out.println("Autor ya registrado");
            }

        });
        listaDeTraductorEncontrado.forEach(traductor->{
            try {
                traductorRepository.save(traductor);
            }catch (Exception ignored){
                System.out.println("Traductor ya registrado");
            }
        });

    }

    private void agregarMultiplesLibrosALaBaseDeDatos(DatosAPIResponse datosAPIResponse){
        datosAPIResponse.results().stream()
                .forEach(book->{
                    Libro nuevoLibro= new Libro(book);
                    libroRepository.save(nuevoLibro);
                    book.autores().stream()
                            .filter(Objects::nonNull)
                            .forEach(autor->{
                                Autor nuevoAutor=new Autor(autor);
                                listaDeAutores.add(nuevoAutor);
                            });
                    book.traductores().stream()
                            .filter(Objects::nonNull)
                            .forEach(traductor->{
                                Traductor nuevoTraductor=new Traductor(traductor);
                                listaDeTraductores.add(nuevoTraductor);
                            });
                });
    }
}

