public class Moneda {
    private String nombre;
    private String simbolo;
    private double tipoDeCambio;

    public Moneda(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.tipoDeCambio = 1.0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public double getTipoDeCambio() {
        return tipoDeCambio;
    }

    public void setTipoDeCambio(double tipoDeCambio) {
        this.tipoDeCambio = tipoDeCambio;
    }
}