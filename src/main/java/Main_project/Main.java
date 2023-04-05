package Main_project;

import java.util.*;

public class Main {
    public static int inputMode(Scanner input) {
        int mode = input.nextInt();
        switch(mode){
            case 1:
                System.out.println("Entering Encryption Module...");
                System.out.print("Enter a String to Encrypt : ");
                break;

            case 2:
                System.out.println("Entering Decryption Module...");
                System.out.print("Enter encrypted string to decrypt : ");
                break;

            case 3:
                System.out.println("Closing the running console...");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid module selected...");
                break;
        }
        return mode;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("---------------------------------");
            System.out.println("Choose a module to get started...\n1. Encryption\n2. Decryption\n3. Exit");
            System.out.println("---------------------------------");
            System.out.print("Enter mode : ");
            int mode = inputMode(input);
            input.nextLine();
            String inputStr = input.nextLine();

            if (mode == 1) {
                if (inputStr.trim().length() == 0) {
                    System.out.println("Empty String can't be encrypted");
                    System.exit(0);
                }
                Encryption encMod = new Encryption(inputStr);
                System.out.println("Original String : "+encMod.getOriginalString());
                System.out.println("Encrypted String : "+encMod.getEncryptedString());
            } else {
                Decryption decMod = new Decryption(inputStr);
                System.out.println("Original String (Encrypted String) : "+decMod.getOriginalString());
                System.out.println("Decrpted String : "+decMod.getDecryptedString());
            }

            System.out.println();
            System.out.println("---------------------------------");
            System.out.println();
        }

    }
}
