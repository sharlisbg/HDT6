import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class TiendaOnline {
    private Map<String, String> catalogo; 
    private Map<String, String> coleccion;

    /*
     * Constructor de Tienda Online del usuario
     */
    public TiendaOnline() {
    }

    
    
    /** 
     * Agregar un producto a la colección del usuario. 
     * @param tipoMapa
     * @return Map<String, String>
     */
    public Map<String, String> crearMap(String tipoMapa) {
        Map<String, String> mapa = Factory.setMap(tipoMapa);
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese la cantidad de categorías que desea agregar al mapa:");
        int cantCategorias = scanner.nextInt();
        scanner.nextLine();
    
        for (int i = 0; i < cantCategorias; i++) {
            System.out.println("Ingrese el nombre de la categoría:");
            String categoria = scanner.nextLine();
    
            System.out.println("Ingrese la cantidad de productos que desea agregar a la categoría " + categoria + ":");
            int cantProductos = scanner.nextInt();
            scanner.nextLine();
    
            for (int j = 0; j < cantProductos; j++) {
                System.out.println("Ingrese el nombre del producto:");
                String producto = scanner.nextLine();
    
                mapa.put(categoria, producto);
            }
        }
        return mapa;
    }


    
    /** 
     * Obtener la categoría del producto ingresado
     * @param producto
     * @param catalogo
     * @return String
     */
    public String obtenerCategoria(String producto, Map<String, String> catalogo) {
        for (Map.Entry<String, String> entry : catalogo.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(producto)) {
                return entry.getKey();
            }
        }
        return null; // si no se encuentra el producto en el HashMap, se devuelve null
    }


    
    /** 
     * Mostrar los datos del producto, categoría y la cantidad de cada artículo que el usuario tiene en su colección.
     * @param coleccion
     */
    public void mostrarColeccion(Map<String, String> coleccion) {
        Map<String, Integer> cantidadProductos = new HashMap<>();
    
        for (String producto : coleccion.values()) {
            cantidadProductos.merge(producto, 1, Integer::sum);
        }
    
        for (String categoria : coleccion.keySet()) {
            String producto = coleccion.get(categoria);
            int cantidad = cantidadProductos.get(producto);
    
            System.out.println("Categoría: " + categoria + " | Producto: " + producto + " | Cantidad: " + cantidad);
        }
    }


    
    /** 
     * Mostrar los datos del producto, categoría y la cantidad de cada artículo que el usuario tiene en su colección, ordenadas por tipo. 
     * @param coleccion
     */
    public void mostrarColeccionOrdenada(Map<String, String> coleccion) {
        Map<String, Map<String, Integer>> coleccionOrdenada = new TreeMap<>();
    
        for (String categoria : coleccion.keySet()) {
            String producto = coleccion.get(categoria);
    
            if (!coleccionOrdenada.containsKey(producto)) {
                coleccionOrdenada.put(producto, new HashMap<>());
            }
    
            Map<String, Integer> cantidadProductos = coleccionOrdenada.get(producto);
            cantidadProductos.merge(categoria, 1, Integer::sum);
        }
    
        for (String producto : coleccionOrdenada.keySet()) {
            Map<String, Integer> cantidadProductos = coleccionOrdenada.get(producto);
    
            for (String categoria : cantidadProductos.keySet()) {
                int cantidad = cantidadProductos.get(categoria);
    
                System.out.println("Producto: " + producto + " | Categoría: " + categoria + " | Cantidad: " + cantidad);
            }
        }
    }
    
    // Mostrar el producto y la categoría de todo el inventario. 
    public void mostrarInventarioCompleto() {
        System.out.println("Inventario completo:");
    
        for (Map.Entry<String, String> entry : catalogo.entrySet()) {
            System.out.println("Categoría: " + entry.getKey() + " - Producto: " + entry.getValue());
        }
    }

    // Mostrar el producto y la categoría de todo el inventario ordenado por tipo
    public void mostrarInventarioPorCategoria() {
        System.out.println("Inventario por categoría:");
    
        // Crear una lista de categorías únicas
        List<String> categoriasUnicas = new ArrayList<>(new HashSet<>(catalogo.values()));
    
        // Iterar a través de las categorías y mostrar los productos correspondientes
        for (String categoria : categoriasUnicas) {
            System.out.println("Categoria: " + categoria);
            for (Map.Entry<String, String> entry : catalogo.entrySet()) {
                if (entry.getValue().equals(categoria)) {
                    System.out.println("    Producto: " + entry.getKey());
                }
            }
        }
    }
    


    
    /** 
     * @return Map<String, String>
     */
    public Map<String,String> getCatalogo() {
        return this.catalogo;
    }
    
    /** 
     * @param catalogo
     */
    public void setCatalogo(Map<String,String> catalogo) {
        this.catalogo = catalogo;
    }

    /** 
     * @return Map<String, String>
     */
    public Map<String,String> getColeccionUsuario() {
        return this.coleccion;
    }

    /** 
     * @param coleccion
     */
    public void setColeccionUsuario(Map<String,String> coleccion) {
        this.coleccion = coleccion;
    }


}
