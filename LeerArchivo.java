import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeerArchivo {
    public static Map<String, List<String>> leerArchivo(String nombreArchivo) {
        Map<String, List<String>> mapa = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                String llave = datos[0].trim();
                String valor = datos[1].trim();

                if (mapa.containsKey(llave)) {
                    mapa.get(llave).add(valor);
                } else {
                    List<String> valores = new ArrayList<>();
                    valores.add(valor);
                    mapa.put(llave, valores);
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapa;
    }
}
