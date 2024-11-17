package com.alura.literalura.main;

import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner teclado=new Scanner(System.in);
    private ConsumoAPI consumoAPI =new ConsumoAPI();
    private final String URL_BASE="https://gutendex.com";
    private ConvierteDatos conversor=new ConvierteDatos();


    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por titulo 
                    2 - Buscar libros registrados
                    3 - Listar autores registrados
                    4 - Buscar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    6 - Salir
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
//                    buscarSerieWeb();
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
//                    filtrarSeriePorTemporadaYEvaluaion();
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
            }
        }

    }
}
