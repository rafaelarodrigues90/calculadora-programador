package app;

import java.util.Scanner;
import java.util.Stack;

public class Decimal {

    // pega número
    public static void mainDecimal() {
    
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
            mainDecimal();
        }

        scan.close();
    }

    final static int OCTAL = 8;
    final static int BINARY = 2;

    // pega base
    public static void base(int numero) {
        
        Scanner scan = new Scanner(System.in);
        int base;

        try{        
            do{
                System.out.print("Digite 2 para binário ou 8 para octal: ");
                base = scan.nextInt();

                if(base == 0) {
                    Main.main(null);
                } else if (base == -1) {
                    System.out.println("\nSaindo.\n");
                    System.exit(0);
                }
                
            } while(base != BINARY && base != OCTAL);
        
        } catch(Exception e) {
            base(numero);
        }
        
        scan.close();
    }


    // converte para binário ou octal
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