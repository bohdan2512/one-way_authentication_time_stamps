package com.example.kurauthonjavafx;
import java.util.ArrayList;
public class TDESRClass {
    int[] IP = { 58, 50, 42, 34, 26, 18,
            10, 2, 60, 52, 44, 36, 28, 20,
            12, 4, 62, 54, 46, 38,
            30, 22, 14, 6, 64, 56,
            48, 40, 32, 24, 16, 8,
            57, 49, 41, 33, 25, 17,
            9, 1, 59, 51, 43, 35, 27,
            19, 11, 3, 61, 53, 45,
            37, 29, 21, 13, 5, 63, 55,
            47, 39, 31, 23, 15, 7 };

    // Inverse Initial Permutation Table
    int[] IP1 = { 40, 8, 48, 16, 56, 24, 64,
            32, 39, 7, 47, 15, 55,
            23, 63, 31, 38, 6, 46,
            14, 54, 22, 62, 30, 37,
            5, 45, 13, 53, 21, 61,
            29, 36, 4, 44, 12, 52,
            20, 60, 28, 35, 3, 43,
            11, 51, 19, 59, 27, 34,
            2, 42, 10, 50, 18, 58,
            26, 33, 1, 41, 9, 49,
            17, 57, 25 };

    // first key-hePermutation Table
    int[] PC1 = { 57, 49, 41, 33, 25,
            17, 9, 1, 58, 50, 42, 34, 26,
            18, 10, 2, 59, 51, 43, 35, 27,
            19, 11, 3, 60, 52, 44, 36, 63,
            55, 47, 39, 31, 23, 15, 7, 62,
            54, 46, 38, 30, 22, 14, 6, 61,
            53, 45, 37, 29, 21, 13, 5, 28,
            20, 12, 4 };

    // second key-Permutation Table
    int[] PC2 = { 14, 17, 11, 24, 1, 5, 3,
            28, 15, 6, 21, 10, 23, 19, 12,
            4, 26, 8, 16, 7, 27, 20, 13, 2,
            41, 52, 31, 37, 47, 55, 30, 40,
            51, 45, 33, 48, 44, 49, 39, 56,
            34, 53, 46, 42, 50, 36, 29, 32 };

    // Expansion D-box Table
    int[] E = { 32, 1, 2, 3, 4, 5, 4,
            5, 6, 7, 8, 9, 8, 9, 10,
            11, 12, 13, 12, 13, 14, 15,
            16, 17, 16, 17, 18, 19, 20,
            21, 20, 21, 22, 23, 24, 25,
            24, 25, 26, 27, 28, 29, 28,
            29, 30, 31, 32, 1 };

    // Straight Permutation Table
    int[] P = { 16, 7, 20, 21, 29, 12, 28,
            17, 1, 15, 23, 26, 5, 18,
            31, 10, 2, 8, 24, 14, 32,
            27, 3, 9, 19, 13, 30, 6,
            22, 11, 4, 25 };

    // S-box Table
    int[][][] sbox = {

            {
                    { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                    { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
                    { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
                    { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 }
            },

            {
                    { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 },
                    { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 },
                    { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 },
                    { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 }
            },

            {
                    { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
                    { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
                    { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
                    { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 }
            },

            {
                    { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 },
                    { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
                    { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
                    { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 }
            },

            {
                    { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
                    { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
                    { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
                    { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 }
            },

            {
                    { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
                    { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
                    { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
                    { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 }
            },

            {
                    { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
                    { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
                    { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
                    { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 }
            },

            {
                    { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
                    { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 },
                    { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 },
                    { 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 }
            }

    };

    int[] shiftBits = { 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 };

    String hexToBin(String input) {

        int n = input.length() * 4;
        input = Long.toBinaryString(Long.parseUnsignedLong(input, 16));
        while (input.length() < n)
            input = "0" + input;
        return input;

    }

    // binary to hexadecimal conversion
    String binToHex(String input) {

        int n = input.length() / 4;
        input = Long.toHexString(Long.parseUnsignedLong(input, 2));
        while (input.length() < n)
            input = "0" + input;
        return input;

    }
    public String convertStringToBinary(String data) { // data is either (a block from the plain text) or (a key)
        StringBuilder result = new StringBuilder();
        char[] chars = data.toCharArray();
        for (char c : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(c))   // char -> int, auto-cast
                            .replaceAll(" ", "0")     // zero padding
            );
        }
        return result.toString();
    }

    public String convertBinaryToString(String binary){
        String encryptedData = "";
        ArrayList<String> splitted = splitText(binary,8);
        for (String temp : splitted) {
            int num = Integer.parseInt(temp, 2);
            char letter = (char) num;
            encryptedData = encryptedData.concat(String.valueOf(letter));
        }
        return encryptedData;
    }

    public String permutation(String binaryData, int[] permutationMatrix){
        String permutatedBinary = "";
        for (int element : permutationMatrix) {
            permutatedBinary = permutatedBinary.concat(String.valueOf(binaryData.charAt(element-1)));
        }
        return permutatedBinary;
    }

    public String xor(String data1, String data2){
        String output = "";
        for(int i = 0; i < data1.length(); i++){
            if(data1.charAt(i) != data2.charAt(i)){
                output = output.concat("1");
            } else {
                output = output.concat("0");
            }
        }
        return output;
    }

    public String circularLeftShift(String binaryData){
        String temp = "";
        for(int i = 0; i < binaryData.length(); i++){
            if(i != binaryData.length()-1) {
                temp = temp.concat(String.valueOf(binaryData.charAt(i+1)));
            } else{
                temp = temp.concat(String.valueOf(binaryData.charAt(0)));
            }
        }
        return temp;
    }

    public ArrayList<String> generate16Keys(String key){
        ArrayList<String> dividedKeys = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> permKeys = new ArrayList<>();
        String keyInBinary = convertStringToBinary(key);
        String permutatedKey_Pc1 = permutation(keyInBinary,PC1);
        String C0 = splitText(permutatedKey_Pc1,28).get(0);
        String D0 = splitText(permutatedKey_Pc1,28).get(1);
        String C1 = "", D1 = "";
        for(int i = 0; i < shiftBits[0]; i++){
            C1 = circularLeftShift(C0);
            D1 = circularLeftShift(D0);
        }
        dividedKeys.add(C1);                    // In this arraylist c is always the even index and 0 index keys.get(2) ==> C2 keys.get(3) ==> D2.
        // to get n, if C: n = (index/2) + 1. if D: n = index/2
        dividedKeys.add(D1);                    // what is the index of Dn = (n*2)-1 , and what is the index of Cn = (n-1)*2
        for(int i = 0; i < 15; i++){
            String C = "", D = "";
            for(int j = 0; j < shiftBits[i+1]; j++){
                C = circularLeftShift(dividedKeys.get(i));
                D = circularLeftShift(dividedKeys.get(i+1));
            }
            dividedKeys.add(C);
            dividedKeys.add(D);
        }
        for(int i = 0; i < dividedKeys.size(); i+=2){
            keys.add(dividedKeys.get(i).concat(dividedKeys.get(i+1)));      // k1 = c1 + c2
        }
        String permutatedKeys_Pc2 = "";
        for(int i = 0; i < keys.size(); i++){
            permutatedKeys_Pc2 = permutation(keys.get(i),PC2);
            permKeys.add(permutatedKeys_Pc2);
        }

        return permKeys;
    }

    public String sBox(String input){

        String output = "";
        for (int i = 0; i < 48; i += 6) {

            String temp = input.substring(i, i + 6);
            int num = i / 6;
            int row = Integer.parseInt(temp.charAt(0) + "" + temp.charAt(5), 2);
            int col = Integer.parseInt(temp.substring(1, 5), 2);
            output = output.concat(String.format("%4s", Integer.toBinaryString(sbox[num][row][col]))   // char -> int, auto-cast
                    .replaceAll(" ", "0"));     // zero padding)//(sbox[num][row][col]));
        }
        return output;
    }

    public String round(String L_previous, String R_previous, String key){
        String R_perm = permutation(R_previous,E);         // 32 bits ==> 48 bits
        String R_xor_key = xor(R_perm,key);
        String output = sBox(R_xor_key);                    // 48 bits ==> 32 bits
        R_perm = permutation(output,P);
        String R_xor_L = xor(L_previous,R_perm);
        return R_xor_L;
    }

    public String encrypt(String data, String key){
        ArrayList<String> keys = generate16Keys(key);
        String dataInBinary = convertStringToBinary(data);
        String permutatedData_IP = permutation(dataInBinary,IP);
        String L0 = splitText(permutatedData_IP,32).get(0);
        String R0 = splitText(permutatedData_IP,32).get(1);
        ArrayList<String> R = new ArrayList<>();
        String L = "";
        for(int i = 0; i < keys.size(); i++){
            if(i == 0){
                R.add(round(L0,R0,keys.get(i)));
                L = R0;
            } else{
                R.add(round(L,R.get(i-1),keys.get(i)));
                L = R.get(i-1);
            }
        }
        String output = R.get(15).concat(L);        // swapping R16 with L16 and concatenating them
        output = permutation(output,IP1);
        output = binToHex(output);
        return output;

    }

    public String decrypt(String encryptedText, String key){
        String decrypted = "";
        ArrayList<String> keys = generate16Keys(key);
        String encryptedBinary = hexToBin(encryptedText);
        encryptedBinary = permutation(encryptedBinary,IP);
        String L16 = splitText(encryptedBinary,32).get(1);
        String R16 = splitText(encryptedBinary,32).get(0);
        ArrayList<String> L = new ArrayList<>();
        String R = "";
        int j = 0;
        for(int i = keys.size()-1; i >= 0; i--){       // getting L0,R0
            if(i == 15){
                L.add(round(R16,L16,keys.get(i)));
                R = L16;
            } else{
                L.add(round(R,L.get(j),keys.get(i)));
                R = L.get(j);
                j++;
            }
        }
        String decryptedBinary = L.get(15).concat(R);
        String reversePermuattion = permutation(decryptedBinary,IP1);
        decrypted = convertBinaryToString(reversePermuattion);
        decrypted = decrypted.replace("#","");
        return decrypted;
    }

    public ArrayList<String> splitText(String text, int size){
        int i, j;
        ArrayList<String> plainText = new ArrayList<>();
        for(i = 0; i < text.length(); i++){
            String temp = "";
            for(j = i; j < (i+size); j++){
                if(j < text.length()) {
                    temp += text.charAt(j);
                }else {
                    break;
                }
            }
            if(temp.length() < size){
                for(int k = temp.length(); k < size; k++){
                    temp = temp.concat("#");
                }
            }
            plainText.add(temp);
            i = j-1;
        }
        return plainText;
    }
    public static String encrypt(String plainText, String key, String key1, String key2) {
        TDESRClass des = new TDESRClass();
        ArrayList<String> text = new ArrayList<>();
        if (plainText.length() < 8) {
            for (int i = plainText.length(); i < 8; i++) {
                plainText = plainText.concat("#");
            }
        }
        if (plainText.length() >= 8) {
            text = des.splitText(plainText, 8);
        }

        String encryptedText = "";
        for (String temp : text) {
            encryptedText = encryptedText.concat(des.encrypt(temp, key));
        }
        //System.out.println("Encrypted text:\n" + encryptedText);

        ArrayList<String> blocks = des.splitText(encryptedText, 16);
        String decryptedText = "";
        for (String block : blocks) {
            decryptedText = decryptedText.concat(des.decrypt(block, key1));
        }

        String encryptedText1 = "";
        ArrayList<String> text1 = new ArrayList<>();
        for (String temp : text1 = des.splitText(decryptedText, 8)) {
            encryptedText1 = encryptedText1.concat(des.encrypt(temp, key2));
        }
        return encryptedText1;
    }
    //---------------------------------------
    public static String decrypt(String encryptedText1, String key, String key1, String key2) {
        TDESRClass des = new TDESRClass();
        ArrayList<String> blocks1 = des.splitText(encryptedText1,16);
        String decryptedText1 = "";
        for(String block1 : blocks1){
            decryptedText1 = decryptedText1.concat(des.decrypt(block1,key2));
        }

        String encryptedText2 = "";
        ArrayList<String> text2 = new ArrayList<>();
        for(String temp : text2 = des.splitText(decryptedText1, 8)) {
            encryptedText2 = encryptedText2.concat(des.encrypt(temp,key1));
        }

        ArrayList<String> blocks2 = des.splitText(encryptedText2,16);
        String decryptedText2 = "";
        for(String block2 : blocks2){
            decryptedText2 = decryptedText2.concat(des.decrypt(block2,key));
        }
        return decryptedText2;
    }

}