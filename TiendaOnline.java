import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class TiendaOnline {
    private Map<String, List<String>> catalogo; 
    private Map<String, List<String>> coleccion;

    /*
     * Constructor de Tienda Online del usuario
     */
    public TiendaOnline(String tipoMapa) {
        this.coleccion = Factory.setMap(tipoMapa);
    }

    
    
    /** 
     * Agregar un producto a la colección del usuario. 
     * @param tipoMapa, mapaInventario
     * @return Map<String, String>
     */

    public Map<String, List<String>> crearMap(Map<String, List<String>> coleccion, Map<String, List<String>> catalogo) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese la cantidad de categorias que desea agregar al mapa:");
        int cantCategorias = scanner.nextInt();
        scanner.nextLine();
    
        for (int i = 0; i < cantCategorias; i++) {
            System.out.println("Ingrese el nombre de la categoria:");
            String categoria = scanner.nextLine();
    
            if (!catalogo.containsKey(categoria)) {
                System.out.println("La categoria " + categoria + " no es valida.");
                continue;
            }
    
            System.out.println("Ingrese la cantidad de productos que desea agregar a la categoria " + categoria + ":");
            int cantProductos = scanner.nextInt();
            scanner.nextLine();
    
            List<String> productos = new ArrayList<>();
            for (int j = 0; j < cantProductos; j++) {
                System.out.println("Ingrese el nombre del producto:");
                String producto = scanner.nextLine();
    
                List<String> productosValidos = catalogo.get(categoria);
                if (!productosValidos.contains(producto)) {
                    System.out.println("El producto " + producto + " no es valido para la categoria " + categoria + ".");
                    continue;
                }
    
                productos.add(producto);
            }
    
            if (!productos.isEmpty()) {
                coleccion.put(categoria, productos);
            }
        }
        return coleccion;
    }
    
    

    
    /** 
     * Obtener la categoría del producto ingresado
     * @param producto
     * @param catalogo
     * @return String
     */
    public String obtenerCategoria(String producto, Map<String, List<String>> catalogo) {
        for (Map.Entry<String, List<String>> entry : catalogo.entrySet()) {
            List<String> productosEnCategoria = entry.getValue();
            if (productosEnCategoria.contains(producto)) {
                return entry.getKey();
            }
        }
        return null;
    }


    
    /** 
     * Mostrar los datos del producto, categoría y la cantidad de cada artículo que el usuario tiene en su colección.
     * @param coleccion
     */
    public void mostrarColeccion(Map<String, List<String>> coleccion) {
        Map<String, Integer> cantidadProductos = new HashMap<>();
        
        for (List<String> productos : coleccion.values()) {
            for (String producto : productos) {
                cantidadProductos.merge(producto, 1, Integer::sum);
            }
        }
        
        for (String categoria : coleccion.keySet()) {
            List<String> productos = coleccion.get(categoria);
            for (String producto : productos) {
                int cantidad = cantidadProductos.get(producto);
                System.out.println("Categoria: " + categoria + " | Producto: " + producto + " | Cantidad: " + cantidad);
            }
        }
    }


    
    /** 
     * Mostrar los datos del producto, categoría y la cantidad de cada artículo que el usuario tiene en su colección, ordenadas por tipo. 
     * @param coleccion
     */
    public void mostrarColeccionOrdenada(Map<String, List<String>> coleccion) {
        // Obtener una lista ordenada de las categorías
        List<String> categoriasOrdenadas = new ArrayList<>(coleccion.keySet());
        Collections.sort(categoriasOrdenadas);
        
        // Mapa para almacenar la cantidad de productos por categoría
        Map<String, Integer> cantidadProductos = new HashMap<>();
        
        // Contar la cantidad de productos por categoría
        for (List<String> productos : coleccion.values()) {
            for (String producto : productos) {
                cantidadProductos.merge(producto, 1, Integer::sum);
            }
        }
        
        // Mostrar los productos ordenados por categoría
        for (String categoria : categoriasOrdenadas) {
            List<String> productos = coleccion.get(categoria);
            for (String producto : productos) {
                int cantidad = cantidadProductos.get(producto);
                System.out.println("Categoria: " + categoria + " | Producto: " + producto + " | Cantidad: " + cantidad);
            }
        }
    } 




    // Mostrar el producto y la categoría de todo el inventario. 
    public void mostrarInventarioCompleto() {
        for (String llave : catalogo.keySet()) {
            System.out.println("Categoria: " + llave);
            List<String> valores = catalogo.get(llave);
            for (String valor : valores) {
                System.out.println("\tProducto: " + valor);
            }
        }
    }

    // Mostrar el producto y la categoría de todo el inventario ordenado por tipo
    public void mostrarInventarioOrdenado() {
        List<String> categoriasOrdenadas = new ArrayList<>(catalogo.keySet());
        Collections.sort(categoriasOrdenadas);
        
        for (String categoria : categoriasOrdenadas) {
            System.out.println("Categoria: " + categoria);
            List<String> productos = catalogo.get(categoria);
            for (String producto : productos) {
                System.out.println("\tProducto: " + producto);
            }
        }
    }
    

    
    /** 
     * @return Map<String, List<String>>
     */
    public Map<String,List<String>> getCatalogo() {
        return this.catalogo;
    }

    
    /** 
     * @param catalogo
     */
    public void setCatalogo(Map<String,List<String>> catalogo) {
        this.catalogo = catalogo;
    }

    
    /** 
     * @return Map<String, List<String>>
     */
    public Map<String,List<String>> getColeccion() {
        return this.coleccion;
    }

    
    /** 
     * @param coleccion
     */
    public void setColeccion(Map<String,List<String>> coleccion) {
        this.coleccion = coleccion;
    }



}
