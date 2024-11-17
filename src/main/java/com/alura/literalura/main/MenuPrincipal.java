package com.alura.literalura.main;

import com.alura.literalura.model.DatosAPIResponse;
import com.alura.literalura.model.DatosLibro;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MenuPrincipal {
    private Scanner teclado=new Scanner(System.in);
    private ConsumoAPI consumoAPI =new ConsumoAPI();
    private final String URL_BASE="https://gutendex.com/books/";
    private ConvierteDatos conversor=new ConvierteDatos();
    private List<DatosLibro> listaDeLibros =new ArrayList<>();


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
                    8 - Ver todos los libros guardados
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
                    buscarAutoresVivosEnUnDeterminadoAno();
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
                    verTodosLosLibrosGuardados();
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
        var nombreLibro = escribirBusquedaCorrectamente();
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search="+nombreLibro.replace(" ", "+"));
        //System.out.println(json);
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
        System.out.println(contador);
        System.out.println("Escriba el numero de la opcion que desea guardar en la base de datos"+"\n");
        System.out.println("Si desea cancelar la operacion seleccione 0");

       int opcionElegida= elegirOpcionNumericaCorrecta();
            if (opcionElegida == 0) {
                System.out.println("Eligio no guardar ningun libro en la base de datos, muchas gracias");
                return null;
            } else {
                listaDeLibros.add(datosAPIResponse.results().get(opcionElegida-1));
                System.out.println(listaDeLibros.get(0));
            }
        return null;

    }

    private void verTodosLosLibrosGuardados() {
        listaDeLibros.forEach(book-> System.out.println(book+"\n"));
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
        AtomicInteger contador = new AtomicInteger(0);

        System.out.println("Resultados encontrados: "+"\n");
        datosAPIResponse.results().stream().forEach(book-> {
            int index = contador.incrementAndGet();
            System.out.println("Opcion: "+index+" "+book+"\n");
        });

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
        String patron = "^[a-zA-Z0-9]+$";

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
}

