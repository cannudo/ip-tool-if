import java.util.Scanner;

public class Main {

    public static Scanner instanciarScanner() {
        Scanner instancia = new Scanner(System.in);
        return instancia;
    }

    public static void limparBufferDoScanner(Scanner leitor) {
        leitor.nextLine();
    }

    public static void desinstanciarScanner(Scanner leitor) {
        leitor.close();
    }

    public static int lerInteiro(Scanner leitor) {
        int retorno = 0;

        retorno = leitor.nextInt();
        limparBufferDoScanner(leitor);

        return retorno;
    }

    public static String lerString(Scanner leitor) {
        String retorno = null;

        retorno = leitor.nextLine();

        return retorno;
    }

    public static boolean aStringPodeSerUmIp(String ip) {
        String mascaraRegex = "^(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2}|0)(\\.(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2}|0)){3}$";
        return ip.matches(mascaraRegex);
    }

    public static void menu() {
        System.out.println("-- ip-tool-if --");
        System.out.println("0. Sair");
        System.out.println("1. Verificar um IP");
        
        System.out.print("Qual opção você escolhe? ");
    }


    public static void main(String args[]) {
        Scanner leitor = instanciarScanner();
        EnderecoIp ip = null;
        String ipString = null;
        int opcao = 99;
        while(opcao != 0) {
            menu();
            opcao = lerInteiro(leitor);

            switch(opcao) {
                case 1:
                    System.out.print("Digite um endereço IPv4 no formato legível, separando cada um dos quatro octetos com ponto (ex.: 192.168.0.1): ");
                    ipString = lerString(leitor);
                    if(aStringPodeSerUmIp(ipString)) {
                        ip = new EnderecoIp(ipString);
                        System.out.println("IP válido! (" + ip.toString() +")");
                    } else {
                        System.out.println("Formato inválido.");
                    }
                    break;
            }
        }

        desinstanciarScanner(leitor);
    }
}