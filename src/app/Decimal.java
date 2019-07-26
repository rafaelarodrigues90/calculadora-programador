package app;

import java.util.Scanner;
import java.util.Stack;

public class Decimal {

    // pega número
    public static void inputDecimal() {
    
        Scanner scan = new Scanner(System.in);
        int numero;
            
        try {
            System.out.println("\n\n========== DECIMAL ==> BINÁRIO, OCTAL OU HEXADECIMAL =========\n");
            System.out.println("\nDigite 0 para voltar ao menu.\nDigite -1 para terminar programa.\n\nDigite um número: ");
            numero = scan.nextInt();

            if (numero > 0) {
                base(numero);
            } else if (numero == 0) {
                Main.main(null);
            } else if (numero == -1) {
                System.out.println("\nSaindo.\n");
                System.exit(0);
            } 
        } catch(Exception e) {
            inputDecimal();
        }

        scan.close();
    }

    final static int OCTAL = 8;
    final static int BINARY = 2;
    final static int HEXADECIMAL = 16;

    // pega base
    public static void base(int numero) {
        
        Scanner scan = new Scanner(System.in);
        int base;

        try {
            System.out.println("\nDigite uma opção:");
            System.out.println(" 2 - decimal para binário\n 8 - decimal para octal\n16 - decimal para hexadecimal");
            System.out.println(" 0 - Voltar ao menu principal\n-1 - Sair\n");
            base = scan.nextInt();

            switch(base) {
                case BINARY:
                    System.out.print("\nBINÁRIO ==> " + toBinOctHex(numero, BINARY));
                    inputDecimal();
                    break;
                case OCTAL:
                    System.out.print("\nOCTAL ==> " + toBinOctHex(numero, OCTAL));    
                    inputDecimal();
                    break;
                case HEXADECIMAL:
                    System.out.print("\nHEXADECIMAL ==> " + toBinOctHex(numero, HEXADECIMAL));
                    inputDecimal();
                    break;
                case 0:
                    Main.main(null);
                    break;
                case -1:
                    System.out.println("\nSaindo.\n");
                    System.exit(0);
                    break;
                default:
                    base(numero);
                break;
            }
        } catch(Exception e) {;
            base(numero);
        }
        
        scan.close();
    }


    // converte para binário ou octal
    public static String toBinOctHex(int numero, int base) {
        
        Stack<Integer> pilha = new Stack<Integer>();
        int resto;
        String resultado = "";
        String bases = "0123456789ABCDEF";

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

        // desempilha (inverte ordem) e converte os restos para char bases
        while(!pilha.isEmpty()) {
            resultado += bases.charAt(pilha.pop());
        }

        return resultado;
    }
}