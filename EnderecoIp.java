public class EnderecoIp {
    private Octeto primeiroOcteto;
    private Octeto segundoOcteto;
    private Octeto terceiroOcteto;
    private Octeto quartoOcteto;

    public EnderecoIp(String ip) {
        boolean oArgumentoVeioVazio = (ip == null || ip.isBlank());
        if(oArgumentoVeioVazio) {
            throw new IllegalArgumentException("O endereço IP não pode ser nulo ou vazio.");
        }
        if(!this.oIpEhValido(ip)) {
            throw new FormatoInvalidoException();
        }
        String[] octetos = ip.split("\\.");
        int quantidadeDeOctetos = octetos.length;
        if(quantidadeDeOctetos != 4) {
            throw new FormatoInvalidoException();
        }

        try {
            this.primeiroOcteto = new Octeto(Integer.parseInt(octetos[0]));
            this.segundoOcteto = new Octeto(Integer.parseInt(octetos[1]));
            this.terceiroOcteto = new Octeto(Integer.parseInt(octetos[2]));
            this.quartoOcteto = new Octeto(Integer.parseInt(octetos[3]));
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Todos os octetos devem ser números inteiros.");
        } catch(ValorDecimalForaDosLimitesException e) {
            throw new IllegalArgumentException("Um dos octetos está fora do intervalo válido");
        }
    }

    public Octeto getPrimeiroOcteto() {
        return this.primeiroOcteto;
    }

    public void setPrimeiroOcteto(Octeto novoOcteto) {
        this.primeiroOcteto = novoOcteto;
    }

    public Octeto getSegundoOcteto() {
        return this.segundoOcteto;
    }

    public void setSegundoOcteto(Octeto novoOcteto) {
        this.segundoOcteto = novoOcteto;
    }

    public Octeto getTerceiroOcteto() {
        return this.terceiroOcteto;
    }

    public void setTerceiroOcteto(Octeto novoOcteto) {
        this.terceiroOcteto = novoOcteto;
    }

    public Octeto getQuartoOcteto() {
        return this.quartoOcteto;
    }

    public void setQuartoOcteto(Octeto novoOcteto) {
        this.quartoOcteto = novoOcteto;
    }
    
    public boolean oIpEhValido(String ip) {
        String mascaraRegex = "^(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2}|0)(\\.(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2}|0)){3}$";
        return ip.matches(mascaraRegex);
    }
    
    public String transformarEmBinario() {
        return String.join(".", primeiroOcteto.transformarEmBinario(), segundoOcteto.transformarEmBinario(), terceiroOcteto.transformarEmBinario(), quartoOcteto.transformarEmBinario());
    }

    public String toString() {
        String retorno = String.format("%d.%d.%d.%d", this.getPrimeiroOcteto().getValorDecimal(), this.getSegundoOcteto().getValorDecimal(), this.getTerceiroOcteto().getValorDecimal(), this.getQuartoOcteto().getValorDecimal());
        return retorno;
    }
}