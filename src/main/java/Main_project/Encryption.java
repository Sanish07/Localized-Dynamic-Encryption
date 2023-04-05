package Main_project;

import java.util.*;

class Encryption {
    String inputStr;
    String encryptedStr;

    final char[] customCharArr = new char[]{'E','1','(','j','L','m','K',' ','X','t','M','7','w','.',
            '9','c',':','B','S','T','2','-','6','D','@','b','a','Z',')','o','8','y','I','+','P','k','?','N','U','i',',',
            'h',';','J','H','%','f','0','}','O','e','#','d','3','!','q','u','/','v','l','G','=','A','5','g','z','C','r',
            '4','&','W','^','V',']','s','[','Q','x','n','Y','*','R','p','F','{','$'}; // Primary Hash Table

    final char[] customSymbols = new char[]{'π','ㄶ','す','∮','κ','⊢','ψ','ʃ','さ','§'}; //Secondary Hash Table

    public Encryption(String inputStr){
        this.inputStr = inputStr;
    }

    private String encryptMain(){ //Main Encryption Method
        StringBuilder initialString = new StringBuilder(inputStr);
        int length = initialString.length();
        int rangeNum = resolveNumGenLen(length);
        int randomNum = (int) Math.floor(Math.random() * rangeNum) + 1; //Generates random number from 1 to rangeNum
        if(randomNum % customCharArr.length == 1) randomNum++; //Prevents the string from encrypting in such a way that original & encrypted strings are same

        List<Character> primaryHashTable = generateList(customCharArr);
        List<Character> secondHashTable = generateList(customSymbols);

        int hashValue = randomNum % customCharArr.length;
        for(int i=0;i<initialString.length();i++){
            int indEle = primaryHashTable.indexOf(initialString.charAt(i));
            int originalInd = indEle + hashValue;
            if(originalInd >= primaryHashTable.size()) originalInd = originalInd - primaryHashTable.size();
            initialString.setCharAt(i, primaryHashTable.get(originalInd % primaryHashTable.size()));
           }

        int extractRandom = randomNum;
        int iniPos = 0;
        while(extractRandom != 0){
            initialString.insert(iniPos,secondHashTable.get(extractRandom % 10));
            extractRandom /= 10;
            iniPos += 2;
        }

        return initialString.toString();
    }

    private List<Character> generateList(char[] arr){
        List<Character> list = new ArrayList<>();
        for(char c : arr){
            list.add(c);
        }
        return list;
    }

    private int resolveNumGenLen(int length) {
        int rangeNum;
        if(length < 9){
            rangeNum = (int) Math.pow(10,length);
        } else {
            rangeNum = (int) Math.pow(10,9);
        }
        return rangeNum;
    }

    public String getOriginalString(){
        return inputStr;
    }

    public String getEncryptedString() {
        this.encryptedStr = encryptMain();
        return encryptedStr;
    }
}
