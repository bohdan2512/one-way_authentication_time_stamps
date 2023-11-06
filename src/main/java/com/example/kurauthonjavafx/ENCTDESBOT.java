package com.example.kurauthonjavafx;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ENCTDESBOT {
    private static final String ALGORITHM = "DESede";

    public static String encrypt(String plainText, String key, String key1, String key2) throws Exception {
        SecretKey secretKey = generateSecretKey(key, key1, key2);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return bytesToHex(encryptedBytes);
    }

    public static String decrypt(String cipherText, String key, String key1, String key2) throws Exception {
        SecretKey secretKey = generateSecretKey(key, key1, key2);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = hexToBytes(cipherText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

    private static SecretKey generateSecretKey(String key, String key1, String key2) throws Exception {
        byte[] keyBytes = key.getBytes();
        byte[] keyBytes1 = key1.getBytes();
        byte[] keyBytes2 = key2.getBytes();
        byte[] allKeyBytes = new byte[24];
        System.arraycopy(keyBytes, 0, allKeyBytes, 0, 8);
        System.arraycopy(keyBytes1, 0, allKeyBytes, 8, 8);
        System.arraycopy(keyBytes2, 0, allKeyBytes, 16, 8);
        return new SecretKeySpec(allKeyBytes, ALGORITHM);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(String.format("%02x", aByte));
        }
        return sb.toString();
    }

    private static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] bytes = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            bytes[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return bytes;
    }
}


