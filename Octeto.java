public class Octeto {
    private int valorDecimal;

    public Octeto(int valorDecimal) {
        boolean valorDecimalEstaNosLimites = (valorDecimal >= 0 && valorDecimal <= 255);
        if(valorDecimalEstaNosLimites) {
            this.setValorDecimal(valorDecimal);
        } else {
            throw new ValorDecimalForaDosLimitesException();
        }
    }

    public int getValorDecimal() {
        return this.valorDecimal;
    }

    private void setValorDecimal(int valorDecimal) {
        this.valorDecimal = valorDecimal;
    }
}