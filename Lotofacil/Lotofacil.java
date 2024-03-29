import java.util.Scanner;
import java.util.Random;

public class LotoFacil {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int menu = -1;

        do {
            imprimirSeparador();
            System.out.println("                 MENU LOTOFÁCIL DO GUSTAVO ");
            System.out.println(" Escolha uma opção de 1 a 3 (0 para sair)");
            System.out.println("[1] - Apostar em um número de 0 a 100");
            System.out.println("[2] - Apostar em uma letra de A á Z");
            System.out.println("[3] - Apostar em um número par ou ímpar");
            System.out.println("[0] - Sair do Menu");
            imprimirSeparador();
            
            try {
                menu = Integer.parseInt(scn.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Opção inválida, tente novamente.");
                continue;
            }
            

            switch (menu) {
                case 1:
                    apostaDe0a100(scn);
                    break;
                case 2:
                    apostaAZ(scn);
                    break;
                case 3:
                    apostaParOuImpar(scn);
                    break;
                case 0:
                    System.out.println("Saindo do Menu. Volte sempre!");
                    break;
                default:
                    System.err.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (menu != 0);

        scn.close();
    }

    public static void imprimirSeparador() {
        System.out.println("**************************************************************************************************");
    }

    public static void apostaDe0a100(Scanner scn) {
        try {
            Random random = new Random();
            int numeroSorteado = random.nextInt(101);

            System.out.print("Digite um número de 0 a 100: ");
            int numeroEscolhido = scn.nextInt();
            scn.nextLine(); 

            if (numeroEscolhido < 0 || numeroEscolhido > 100) {
                throw new IllegalArgumentException("Aposta inválida. Digite um número de 0 a 100.");
            }

            if (numeroEscolhido == numeroSorteado) {
                System.out.println("Parabéns. Você ganhou R$ 1.000,00 reais, aproveite o seu prêmio :).");               
            } else {
                System.out.println("Que pena :C ! O número sorteado foi " + numeroSorteado + ". A sorte estará com você na próxima vez, não desista.");
            }
        } catch (Exception e) {
            scn.nextLine();
            if (e != null && e.getMessage() != null) {
                System.err.println(e.getMessage());
            } else {
                System.err.println("Digite um número inteiro de 0 a 100.");
            }
        }
    }


    public static void apostaAZ(Scanner scn) {
        try {
            System.out.print("Digite uma letra de A à Z: ");
            char letraEscolhida = Character.toUpperCase((char) System.in.read());
            scn.nextLine(); 

            if (!Character.isLetter(letraEscolhida)) {
                throw new IllegalArgumentException("Aposta inválida. Digite uma letra de A á Z sem acentos.");
            }

            char letraPremiada = 'G'; 

            if (letraEscolhida == letraPremiada) {
                System.out.println("Parabéns. Você ganhou R$ 500,00 reais, aproveite bem o seu prêmio :).");
            } else {
                System.out.println("Que pena :C ! A letra sorteada foi " + letraPremiada + ", sorte na próxima vez.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void apostaParOuImpar(Scanner scn) {
        try {
            System.out.print("Digite um número inteiro: ");
            int numeroDigitado = scn.nextInt();
            scn.nextLine(); 

            if (numeroDigitado % 2 == 0) {
                System.out.println("Parabéns sortudo :). Você ganhou R$ 100,00 reais, aproveite seu prêmio.");
            } else {
                System.out.println("Que pena :C ! O número digitado é ímpar e a premiação foi para números pares. Sorte na próxima vez");
            }
        } catch (Exception e) {
            scn.nextLine(); 
            System.err.println("Aposta inválida. Digite um número inteiro.");
        }
    }
}

