package com.alura.literalura.main;

import com.alura.literalura.model.DatosAPIResponse;
import com.alura.literalura.model.DatosLibro;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner teclado=new Scanner(System.in);
    private ConsumoAPI consumoAPI =new ConsumoAPI();
    private final String URL_BASE="https://gutendex.com/books/";
    private ConvierteDatos conversor=new ConvierteDatos();


    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por titulo registraos
                    2 - Buscar libros registrados
                    3 - Listar autores registrados
                    4 - Buscar autores vivos en un determinado año
                    5 - Listar libros registrados por idioma
                    7 - Agregar un libro a la base de datos
                    6 - Salir
                                  
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
//                    mostrarSeriesBuscadas();
                    break;
                case 4:
//                    buscarSeriesPorTitulo();
                    break;
                case 5:
//                    buscarTop5Series();
                    break;
                case 6:
//                    buscarseriesPorCategoria();
                    break;
                case 7:
                    agregarLibroALaBaseDeDatos();
                case 8:
//                    buscarEpisodiosPorTitulo();
                    break;
                case 9:
//                    buscarTop5Episodios();
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

    private DatosLibro agregarLibroALaBaseDeDatos() {
        System.out.println("Escribe el titulo del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search="+nombreLibro.replace(" ", "+"));
        System.out.println(json);
        DatosAPIResponse datosAPIResponse=conversor.obtenerDatos(json, DatosAPIResponse.class);
        System.out.println(datosAPIResponse.results());
        return null;
    }
}
