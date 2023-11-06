package com.example.kurauthonjavafx;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Model {

    public static String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy:HH:mm:ss");
        return now.format(formatter);
    }

    public static String encrypt(String plainText, String key, String key1, String key2) throws Exception {
        //ENCTDESBOT sa = new ENCTDESBOT();
        TDESRClass sa = new TDESRClass();
        return sa.encrypt(plainText, key, key1, key2);
    }

    public static String decrypt(String encryptedText1, String key, String key1, String key2) throws Exception {
        //ENCTDESBOT ss = new ENCTDESBOT();
        TDESRClass ss = new TDESRClass();
        return ss.decrypt(encryptedText1, key, key1, key2);
    }
}
