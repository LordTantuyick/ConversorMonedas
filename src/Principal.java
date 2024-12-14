import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMonedas conversor = new ConversorMonedas();
        GestorJSON gestorJSON = new GestorJSON();

        System.out.print("Introduce tu clave de API de ExchangeRate-API: ");
        String apiKey = scanner.nextLine();

        conversor.actualizarTipoDeCambioDesdeAPI(apiKey);

        int opcion;
        do {
            System.out.println("**************************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Dólar =>> Peso mexicano");
            System.out.println("8) Peso mexicano =>> Dólar");
            System.out.println("9) Salir");
            System.out.println("Elija una opción válida: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion >= 1 && opcion <= 8) {
                Moneda monedaOrigen = conversor.getListaMonedas().get(0);
                Moneda monedaDestino = null;
                switch (opcion) {
                    case 1:
                    case 2:
                        monedaDestino = conversor.getListaMonedas().get(1);
                        break;
                    case 3:
                    case 4:
                        monedaDestino = conversor.getListaMonedas().get(2);
                        break;
                    case 5:
                    case 6:
                        monedaDestino = conversor.getListaMonedas().get(3);
                        break;
                    case 7:
                    case 8:
                        monedaDestino = conversor.getListaMonedas().get(4);
                        break;
                }

                if (opcion % 2 == 0) {
                    Moneda temp = monedaOrigen;
                    monedaOrigen = monedaDestino;
                    monedaDestino = temp;
                }

                System.out.print("Introduce la cantidad a convertir: ");
                double cantidad = scanner.nextDouble();
                scanner.nextLine();

                double resultado = conversor.convertir(monedaOrigen, monedaDestino, cantidad);

                System.out.println(cantidad + " " + monedaOrigen.getSimbolo() + " = " + resultado + " " + monedaDestino.getSimbolo());

                gestorJSON.guardarConversion(monedaOrigen, monedaDestino, cantidad, monedaDestino.getTipoDeCambio(), resultado);
            } else if (opcion != 9) {
                System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }

        } while (opcion != 9);

        System.out.println("¡Hasta luego!");
        scanner.close();
    }
}