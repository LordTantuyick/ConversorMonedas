import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class GestorJSON {

    public void guardarConversion(Moneda monedaOrigen, Moneda monedaDestino, double cantidad, double tipoCambio, double resultado) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            DatosConversion.Conversion conversion = new DatosConversion.Conversion(monedaOrigen.getNombre(), monedaDestino.getNombre(), cantidad, tipoCambio, resultado, new Date());
            String json = gson.toJson(conversion);

            String nombreArchivo = "Conversion_" + monedaOrigen.getSimbolo() + "-" + monedaDestino.getSimbolo() + "_" + new Date().getTime() + ".json";

            FileWriter archivo = new FileWriter(nombreArchivo);
            archivo.write(json);
            archivo.close();

        } catch (IOException e) {
            System.err.println("Error al guardar la conversión en JSON: " + e.getMessage());
        }
    }
}