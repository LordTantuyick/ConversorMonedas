import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ConversorMonedas {
    private List<Moneda> listaMonedas;

    public ConversorMonedas() {
        this.listaMonedas = new ArrayList<>();
        listaMonedas.add(new Moneda("Dólar", "USD"));
        listaMonedas.add(new Moneda("Peso argentino", "ARS"));
        listaMonedas.add(new Moneda("Real brasileño", "BRL"));
        listaMonedas.add(new Moneda("Peso colombiano", "COP"));
        listaMonedas.add(new Moneda("Peso mexicano", "MXN"));
    }

    public List<Moneda> getListaMonedas() {
        return listaMonedas;
    }

    public double convertir(Moneda monedaOrigen, Moneda monedaDestino, double cantidad) {
        double tipoCambioOrigen = monedaOrigen.getTipoDeCambio();
        double tipoCambioDestino = monedaDestino.getTipoDeCambio();
        return cantidad * (tipoCambioDestino / tipoCambioOrigen);
    }

    public void actualizarTipoDeCambioDesdeAPI(String apiKey) {
        StringBuilder respuesta = new StringBuilder();

        try {
            String urlAPI = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

            URL url = new URL(urlAPI);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            while ((linea = lector.readLine()) != null) {
                respuesta.append(linea);
            }
            lector.close();

        } catch (Exception e) {
            System.err.println("Error al obtener los tipos de cambio: " + e.getMessage());
        }

        Gson gson = new Gson();
        TipoCambio tipoCambio = gson.fromJson(respuesta.toString(), TipoCambio.class);

        for (Moneda moneda : listaMonedas) {
            double tipoCambioActual = 0.0;
            switch (moneda.getSimbolo()) {
                case "USD":
                    tipoCambioActual = tipoCambio.conversion_rates().USD();
                    break;
                case "ARS":
                    tipoCambioActual = tipoCambio.conversion_rates().ARS();
                    break;
                case "BRL":
                    tipoCambioActual = tipoCambio.conversion_rates().BRL();
                    break;
                case "COP":
                    tipoCambioActual = tipoCambio.conversion_rates().COP();
                    break;
                case "MXN":
                    tipoCambioActual = tipoCambio.conversion_rates().MXN();
                    break;
            }
            moneda.setTipoDeCambio(tipoCambioActual);
        }
    }
}