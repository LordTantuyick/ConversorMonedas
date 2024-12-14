import java.util.Date;

public class DatosConversion {
    public record Conversion(
            String monedaOrigen,
            String monedaDestino,
            double cantidad,
            double tipoCambio,
            double resultado,
            Date fecha
    ) {
    }
}