public class FormatoInvalidoException extends RuntimeException {
    public FormatoInvalidoException() {
        super("Formato inválido. Um endereço IP deve conter 4 octetos.");
    }
}