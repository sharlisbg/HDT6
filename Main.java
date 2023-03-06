import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Se crea el scanner
        String fileName = "ListadoProducto.txt"; // nombre del archivo
        Map<String, String> catalogo = new HashMap<>(); // HashMap para guardar la información

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|"); // separar la línea por el caracter |
                String key = parts[0].trim(); // obtener la primera parte como clave
                String value = parts[1].trim(); // obtener la segunda parte como valor
                catalogo.put(key, value); // agregar al HashMap
            }
        } catch (IOException e) {
            System.err.format("Error de E/S: %s%n", e);
        }

        // imprimir el HashMap
        for (Map.Entry<String, String> entry : catalogo.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        //Crear Tienda online
        TiendaOnline miTienda = new TiendaOnline(); 
        miTienda.setCatalogo(catalogo); // Establecemos nuestro catalogo global el leído por el archivo txt

        System.out.println("Bienvenido a Su Tienda Online");

        System.out.println("Menu");
        System.out.println("Seleccione la opcion que desea visualizar: ");
        System.out.println("1.Agregar un producto a la coleccion del usuario. \n"+ 
        "2.	Mostrar la categoria del producto. \n"+ 
        "3.	Mostrar los datos del producto, categoria y la cantidad de cada articulo de su coleccion. \n"+ 
        "4.	Mostrar los datos del producto, categoria y la cantidad de cada articulo de su coleccion, ordenadas por tipo. \n"+ 
        "5.	Mostrar el producto y la categoria de todo el inventario. \n"+ 
        "6.	Mostrar el producto y la categoria existentes, ordenadas por tipo.");
        int opcion = in.nextInt();
        in.nextLine(); 

        switch (opcion){
            case 1:{
                System.out.println("Ingrese el nombre del medio por el cual quiere trabajar en nuestro sistema:\n Ingrese HASHMAP, TREEMAP o LINKEDHASHMAP");
                String respuesta = in.nextLine();
                miTienda.setColeccionUsuario(miTienda.crearMap(respuesta));
                break;
            }

            case 2:{
                System.out.println("Ingrese el nombre del producto");
                String producto = in.nextLine();
                miTienda.obtenerCategoria(producto, catalogo);
                break;
            }

            case 3:{
                miTienda.mostrarColeccion(miTienda.getColeccionUsuario());
                break;
            }

            case 4:{
                miTienda.mostrarColeccionOrdenada(miTienda.getColeccionUsuario());
                break;
            }

            case 5:{
                miTienda.mostrarInventarioCompleto();
                break;
            }

            case 6:{
                miTienda.mostrarInventarioPorCategoria();
                break;
            }

            default: {
                System.out.println("Opcion no disponible en este menu");
            }

      }
    }
}