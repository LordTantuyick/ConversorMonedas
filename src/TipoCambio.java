public record TipoCambio(
        TipoCambio.Rates conversion_rates
) {
    public record Rates(
            double USD,
            double ARS,
            double BRL,
            double COP,
            double MXN
    ) {
    }
}
