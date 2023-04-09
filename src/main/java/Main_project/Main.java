package Main_project;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.*;

public class Main {

    static Scanner input = new Scanner(System.in);
    static String encryptedOutStr;
    static String decryptedOutStr;

    public static int inputMode(Scanner input) { //Method Intended for terminal input
        int mode = input.nextInt();
        switch (mode) {
            case 1 -> {
                System.out.println("Entering Encryption Module...");
                System.out.print("Enter a String to Encrypt : ");
            }
            case 2 -> {
                System.out.println("Entering Decryption Module...");
                System.out.print("Enter encrypted string to decrypt : ");
            }
            case 3 -> {
                System.out.println("Closing the running console...");
                System.exit(0);
            }
            default -> System.out.println("Invalid module selected...");
        }
        return mode;
    }

    private static void guiMode() { //Method for launching GUI
        //Main frame
        JFrame frame = new JFrame("Dynamic Plaintext Encryption");
        frame.setSize(1400,650);
        frame.getContentPane().setBackground(Color.white);

        JPanel encPanel = new JPanel();
        JPanel decPanel = new JPanel();

        //--- Encryption Panel in frame ---
        encPanel.setBackground(Color.decode("#00ABB3"));
        encPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#146C94")));
        encPanel.setLayout(new BoxLayout(encPanel, BoxLayout.Y_AXIS));
        JLabel encLabel = new JLabel("Encryption Tab");
        encLabel.setFont(new Font("Comic Sans MS",Font.BOLD,24));
        encLabel.setBounds(150,10,500,40);
        encLabel.setForeground(Color.decode("#FFFFFF"));

        JPanel encInputPanel = new JPanel();
        encInputPanel.setLayout(new GridLayout(1,2));
        encInputPanel.setBackground(Color.decode("#00ABB3"));
        encInputPanel.setMaximumSize(new Dimension(500,40));
        JLabel label1 = new JLabel("Enter the text to encrypt → ");
        label1.setFont(new Font("Times New Roman",Font.PLAIN,17));
        label1.setForeground(Color.white);
        JTextField encText = new JTextField(); //Original String Input Area
        encText.setColumns(12);
        encText.setFont(new Font("Times New Roman",Font.PLAIN,16));
        encInputPanel.add(label1);
        encInputPanel.add(encText);

        JButton encButton = new JButton("\uD83D\uDD12  Encrypt! ");
        encButton.setBackground(Color.decode("#57C5B6"));
        encButton.setForeground(Color.white);

        JPanel encOutputPanel = new JPanel();
        encOutputPanel.setLayout(new GridLayout(1,2));
        encOutputPanel.setBackground(Color.white);
        encOutputPanel.setMaximumSize(new Dimension(500,40));
        JLabel label2 = new JLabel("     Encrypted Text : ");
        label2.setBackground(Color.decode("#00ABB3"));
        label2.setFont(new Font("Times New Roman",Font.PLAIN,17));
        JLabel outText = new JLabel(""); //Encrypted Text String as Output
        outText.setFont(new Font("Times New Roman",Font.BOLD,16));
        outText.setForeground(Color.decode("#0E8388"));
        encOutputPanel.add(label2);
        encOutputPanel.add(outText);

        encButton.addActionListener(e -> {
            encryptedOutStr = encText.getText();
            Encryption encMod = new Encryption(encryptedOutStr);
            encryptedOutStr = encMod.getEncryptedString();
            outText.setText(encryptedOutStr);
        });

        JButton pasteEnc = new JButton("\uD83D\uDCCB    Encrypted Text!");
        pasteEnc.setBackground(Color.decode("#3E54AC"));
        pasteEnc.setForeground(Color.white);

        pasteEnc.addActionListener(e -> {
            String copyString = encryptedOutStr;
            StringSelection stringSelection = new StringSelection(copyString);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        });

        encPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        encPanel.add(encLabel);
        encPanel.add(Box.createRigidArea(new Dimension(0, 60)));
        encPanel.add(encInputPanel);
        encPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        encPanel.add(encButton);
        encPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        encPanel.add(encOutputPanel);
        encPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        encPanel.add(pasteEnc);

        // --- End of Encryption Panel Code ---

        // --- Decryption Panel in frame ---
        decPanel.setBackground(Color.decode("#EFA3C8"));
        decPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#146C94")));
        decPanel.setLayout(new BoxLayout(decPanel, BoxLayout.Y_AXIS));
        JLabel decLabel = new JLabel("Decryption Tab");
        decLabel.setFont(new Font("Comic Sans MS",Font.BOLD,24));
        decLabel.setBounds(150,10,500,40);
        decLabel.setForeground(Color.decode("#FFFFFF"));

        JPanel decInputPanel = new JPanel();
        decInputPanel.setLayout(new GridLayout(1,2));
        decInputPanel.setBackground(Color.decode("#EFA3C8"));
        decInputPanel.setMaximumSize(new Dimension(500,40));
        JLabel label3 = new JLabel("Enter the text to decrypt → ");
        label3.setFont(new Font("Times New Roman",Font.PLAIN,17));
        label3.setForeground(Color.white);
        JTextField decText = new JTextField(); //Original String Input Area
        decText.setColumns(12);
        decText.setFont(new Font("Times New Roman",Font.PLAIN,16));
        decInputPanel.add(label3);
        decInputPanel.add(decText);

        JButton decButton = new JButton("\uD83D\uDD10  Decrypt!");
        decButton.setBackground(Color.decode("#C85C8E"));
        decButton.setForeground(Color.white);

        JPanel decOutputPanel = new JPanel();
        decOutputPanel.setLayout(new GridLayout(1,2));
        decOutputPanel.setBackground(Color.white);
        decOutputPanel.setMaximumSize(new Dimension(500,40));
        JLabel label4 = new JLabel("     Decrypted Text : ");
        label4.setFont(new Font("Times New Roman",Font.PLAIN,17));
        JLabel outTextDec = new JLabel(""); //Decrypted Text String as Output
        outTextDec.setFont(new Font("Times New Roman",Font.BOLD,16));
        outTextDec.setForeground(Color.decode("#EB455F"));
        decOutputPanel.add(label4);
        decOutputPanel.add(outTextDec);

        decButton.addActionListener(e -> {
            decryptedOutStr = decText.getText();
            Decryption decMod = new Decryption(decryptedOutStr);
            decryptedOutStr = decMod.getDecryptedString();
            outTextDec.setText(decryptedOutStr);
        });

        JButton pasteDec = new JButton("\uD83D\uDCCB    Decrypted Text!");
        pasteDec.setBackground(Color.decode("#DA0037"));
        pasteDec.setForeground(Color.white);

        decPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        decPanel.add(decLabel);
        decPanel.add(Box.createRigidArea(new Dimension(0, 60)));
        decPanel.add(decInputPanel);
        decPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        decPanel.add(decButton);
        decPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        decPanel.add(decOutputPanel);
        decPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        decPanel.add(pasteDec);

        // --- End of Decryption Panel Code ---

        //Main frame end config
        frame.add(encPanel);
        frame.add(decPanel);
        frame.setLayout(new GridLayout(1,2));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void terminalMode() { // Intended for terminal interaction
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
                System.out.println("Decrypted String : "+decMod.getDecryptedString());
            }

            System.out.println();
            System.out.println("---------------------------------");
            System.out.println();
        }
    }

    public static void main(String[] args){
        System.out.println("---------------------------------");
        System.out.println("Welcome to Dynamic Plaintext Encryption Program\n");
        System.out.println("Choose Interface Mode...\n1. Switch to GUI\n2. Continue with Terminal\n3. Exit program");
        System.out.println("\033[3m"+"\t\t\t\t\t\t\t\t*** Note : Use terminal for less system resource consumption. ***"+"\033[0m");
        System.out.println("---------------------------------");
        System.out.print("Select Mode : ");
        int interface_mode = input.nextInt();
        if(interface_mode == 1){
            System.out.println("Launching GUI...");
            guiMode();
        } else if(interface_mode == 2) {
            terminalMode();
        } else {
            System.out.println("Exiting from program...");
            System.exit(0);
        }
    }
}
