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
        System.out.println("Por que medio quiere trabajar en nuestro sistema: Ingrese HASHMAP, TREEMAP o LINKEDHASHMAP");
        String respuesta = in.nextLine();

        
        






    }
}