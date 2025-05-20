public class ValorDecimalForaDosLimitesException extends RuntimeException {
    public ValorDecimalForaDosLimitesException() {
        super("O valor decimal deve estar entre 0 e 255, inclusive.");
    }
}