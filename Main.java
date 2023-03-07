import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Se crea el scanner
        String fileName = "ListadoProducto.txt"; // nombre del archivo
        Map<String, List<String>> catalogo = LeerArchivo.leerArchivo(fileName);

        
        //Crear Tienda online
        TiendaOnline miTienda = new TiendaOnline(); 
        miTienda.setCatalogo(catalogo); // Establecemos nuestro catalogo global el leído por el archivo txt

        System.out.println("Bienvenido a Su Tienda Online");

        System.out.println("Menu");
        System.out.println("Seleccione la opcion que desea visualizar: ");
        String menu = "  \n"+ 
        "1. Agregar un producto a la coleccion del usuario. \n"+ 
        "2.	Mostrar la categoria del producto. \n"+ 
        "3.	Mostrar los datos del producto, categoria y la cantidad de cada articulo de su coleccion. \n"+ 
        "4.	Mostrar los datos del producto, categoria y la cantidad de cada articulo de su coleccion, ordenadas por tipo. \n"+ 
        "5.	Mostrar el producto y la categoria de todo el inventario. \n"+ 
        "6.	Mostrar el producto y la categoria existentes, ordenadas por tipo.";
        System.out.println(menu);
        int opcion = in.nextInt();
        in.nextLine(); 
        while(opcion <7){
            switch (opcion){
                case 1:{
                    System.out.println("Ingrese el nombre del medio por el cual quiere trabajar en nuestro sistema:\nIngrese HASHMAP, TREEMAP o LINKEDHASHMAP");
                    String respuesta = in.nextLine();
                    miTienda.setColeccion(miTienda.crearMap(respuesta, miTienda.getCatalogo()));
                    break;
                }

                case 2:{
                    System.out.println("Ingrese el nombre del producto");
                    String producto = in.nextLine();
                    miTienda.obtenerCategoria(producto, catalogo);
                    break;
                }

                case 3:{
                    miTienda.mostrarColeccion(miTienda.getColeccion());
                    break;
                }

                case 4:{
                    miTienda.mostrarColeccionOrdenada(miTienda.getColeccion());
                    break;
                }

                case 5:{
                    miTienda.mostrarInventarioCompleto();
                    break;
                }

                case 6:{
                    miTienda.mostrarInventarioOrdenado();
                    break;
                }

                default: {
                    System.out.println("Opcion no disponible en este menu");
                }

            }

            System.out.println(menu);
            System.out.println("Ingrese la opcion que desea: ");
            opcion = in.nextInt();
            in.nextLine();
        }
    }
}