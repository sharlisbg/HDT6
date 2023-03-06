import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Factory {
    
    public static <K, V> Map<K, V> setMap(String type) {
        switch (type) {
            case "HASHMAP":
                return new HashMap<>();
            case "TREEMAP":
                return new TreeMap<>();
            case "LINKEDHASHMAP":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Tipo de mapa desconocido: " + type);
        }
    }
}

