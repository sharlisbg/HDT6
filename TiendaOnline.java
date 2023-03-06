import java.util.Map;
import java.util.HashMap;

public class TiendaOnline {
    private Map<String, String> catalogo; 
    private Map<String, String> coleccionUsuario;

    /*
     * Constructor de Tienda Online del usuario
     */
    public TiendaOnline() {
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
        return this.coleccionUsuario;
    }

    /** 
     * @param coleccionUsuario
     */
    public void setColeccionUsuario(Map<String,String> coleccionUsuario) {
        this.coleccionUsuario = coleccionUsuario;
    }


}
