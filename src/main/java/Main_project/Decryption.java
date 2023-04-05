package Main_project;

import java.util.*;

public class Decryption {
    String inputStr;
    String decryptedStr;

    final char[] customCharArr = new char[]{'E','1','(','j','L','m','K',' ','X','t','M','7','w','.',
            '9','c',':','B','S','T','2','-','6','D','@','b','a','Z',')','o','8','y','I','+','P','k','?','N','U','i',',',
            'h',';','J','H','%','f','0','}','O','e','#','d','3','!','q','u','/','v','l','G','=','A','5','g','z','C','r',
            '4','&','W','^','V',']','s','[','Q','x','n','Y','*','R','p','F','{','$'}; // Primary Hash Table

    final char[] customSymbols = new char[]{'π','ㄶ','す','∮','κ','⊢','ψ','ʃ','さ','§'}; //Secondary Hash Table

    public Decryption(String inputStr){
        this.inputStr = inputStr;
    }

    public String decryptMain(){
        int randomNum = extractRandom(inputStr);
        int hashValue = randomNum % customCharArr.length;
        StringBuilder initialString = new StringBuilder(decryptedStr);
        List<Character> primaryHashTable = generateList(customCharArr);

        for(int i=0;i<initialString.length();i++){
            int indEle = primaryHashTable.indexOf(initialString.charAt(i));
            int originalInd = indEle - hashValue;
            if(originalInd < 0) originalInd = primaryHashTable.size() + originalInd;
            initialString.setCharAt(i, primaryHashTable.get(originalInd % primaryHashTable.size()));
        }
        this.decryptedStr = initialString.toString();

        return decryptedStr;
    }

    private int extractRandom(String inputStr) {
        int randomNum = 0;
        StringBuilder manipulatedStr = new StringBuilder(inputStr);
        List<Character> secondHashTable = generateList(customSymbols);
        for(int i=inputStr.length()-1;i>=0;i--){
            char currentChar = inputStr.charAt(i);
            if(secondHashTable.contains(currentChar)){
                int num = secondHashTable.indexOf(currentChar);
                randomNum = randomNum * 10 + num;
                manipulatedStr.delete(i,i+1);
            }
        }
        this.decryptedStr = manipulatedStr.toString();
        return randomNum;
    }

    public String getOriginalString(){
        return inputStr;
    }

    private List<Character> generateList(char[] arr){
        List<Character> list = new ArrayList<>();
        for(char c : arr){
            list.add(c);
        }
        return list;
    }

    public String getDecryptedString() {
        this.decryptedStr = decryptMain();
        return decryptedStr;
    }
}
