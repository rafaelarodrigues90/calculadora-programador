package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        try{
            System.out.println("\n\n========== CALCULADORA PROGRAMADOR =========\n");
            System.out.println("1 - Decimal para binário, octal e hexadecimal");
            System.out.println("2 - Binário para decimal, octal e hexadecimal");
            System.out.println("3 - Octal para binário, decimal e hexadecimal");
            System.out.println("3 - Hexadecimal para binário, decimal e octal");
            System.out.println("0 - Sair\n");
            
            int key = scan.nextInt();
            
            switch (key) {
                case 1:
                    Decimal.inputDecimal();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("\nSaindo.\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nDigite uma das opções, por favor!");
                    main(null);
                break;
            }
        } catch (Exception e) {
            System.out.println("\nDigite uma das opções, por favor!");
            main(args);
        }

        scan.close();
    }
}