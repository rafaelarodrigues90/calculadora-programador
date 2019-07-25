package app;

import java.util.Scanner;
import java.util.Stack;

public class Decimal {

    final static int OCTAL = 8;
    final static int BINARY = 2;

    public static void mainDecimal() {

        System.out.println("\n\n========== DECIMAL ==> BINÁRIO, OCTAL OU HEXADECIMAL =========\n");
        
        int numero, base;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("\nDigite 0 para voltar ao menu.\nDigite -1 para terminar programa.\n\nDigite um número: ");
            numero = scan.nextInt();

            if (numero > 0) {
                System.out.print("Digite 2 para binário ou 8 para octal: ");
                base = scan.nextInt();

                while (base != OCTAL && base != BINARY) {
                    if (base == 0) {
                        Main.main(null);
                    } else {
                        if (base == -1) {
                            System.out.println("\nSaindo.\n");
                            System.exit(0);
                        }
                    }
                       
                    System.out.print("Digite 2 para binário ou 8 para octal: ");
                    base = scan.nextInt();
                }

                if (base == OCTAL){
                    System.out.print("\nOctal ==>" + converterBinarioOctal(numero, base) + "\n______________________________________________________\n");
                } else {
                    System.out.print("\nBinário ==>" + converterBinarioOctal(numero, base) + "\n______________________________________________________\n");
                }
            }
        } while (numero > 0);

        if (numero == -1) {
            System.out.println("\nSaindo.\n");
            System.exit(0);
        }

        Main.main(null);
        scan.close();
    }


    // binário e octal
    public static String converterBinarioOctal (int numero, int base) {
        Stack<Integer> pilha = new Stack<Integer>();
        int resto;
        String resultado = "";

        // converte para binário
        while(numero > 0) {
            resto = numero % base;
            pilha.add(resto);
            numero /= base;
        }

        // adiciona zeros no fim da pilha se for binário
        while(pilha.size() % 4 != 0 && base == BINARY) {
            resto = 0;
            pilha.add(resto);
        }

        // desempilha (inverte ordem)
        while(!pilha.isEmpty()) {            
            resultado += pilha.pop();
        }

        return resultado;
    }
}