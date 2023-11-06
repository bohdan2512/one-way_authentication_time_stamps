package com.example.kurauthonjavafx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MainController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField area1;

    @FXML
    private TextField area2;

    @FXML
    private TextField area3;

    @FXML
    private TextField area4;

    @FXML
    private TextField area5;

    @FXML
    private TextField area6;

    @FXML
    private TextField area7;

    @FXML
    private TextField area8;
    @FXML
    private TextField area9;
    String key = "hellomes";
    String key1 = "hellafes";
    String key2 = "huulomes";
    String keyex = "";

    private Scene welcomeScene;
    private Stage primaryStage;
    public void initialize() throws Exception {
        // Set the text of area1 to the current time
        area1.setText(Model.getCurrentTime().toString());
        area3.setText(Model.getCurrentTime().toString());

        String keyex = area9.getText();
        if (keyex.isEmpty()) {
            keyex = "simplekey";
            area9.setText(keyex);
        }

        String formattedDateTime = Model.getCurrentTime().toString();

        String temp = formattedDateTime.concat(keyex);
        String OStr1 = temp;
        System.out.println(OStr1);
        area2.setText(Model.encrypt(OStr1,key,key1,key2));

        // Schedule a task to update the text of area1 every 10 seconds
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(20), event -> {
            area1.setText(Model.getCurrentTime().toString());
            area3.setText(Model.getCurrentTime().toString());
            String updatedKeyex = area9.getText();
            try {
                area2.setText(Model.encrypt(Model.getCurrentTime().toString().concat(updatedKeyex),key,key1,key2));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            area3.setText(Model.getCurrentTime().toString());
        }));
        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.play();
    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void btn1(ActionEvent actionEvent) throws Exception {
        String OStr2 = Model.decrypt(area2.getText(),key,key1,key2);
        System.out.println(area2.getText());
        String firstdate = OStr2.substring(0,19);
        String testString = new String(firstdate.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        area4.setText(testString);
        area5.setText(area2.getText());

        /*Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Отримуємо поточний час та виводимо його в текстове поле з id="area1"
                String currentTime = java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                area1.setText(currentTime);
            }
        }, 0, 10000); // Запускаємо TimerTask на виконання кожні 10 секунд (10000 мілісекунд)*/
    }

    public void btn2(ActionEvent actionEvent) throws Exception {
        boolean Flag = true;
        String secondkey = "simplekey";
        String OStr2 = Model.decrypt(area5.getText(),key,key1,key2);
        //String firstdate = OStr2.substring(0,14);
        String firstkey = OStr2.substring(19);
        String iduserB = "simplekey";

        //Генерація другої мітки часу
        //long timesres = Long.parseLong(area3.getText().replaceAll("[.\\:]", "")) - Long.parseLong(area4.getText().replaceAll("[.\\:]", ""));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy:HH:mm:ss");
        long timesres = ChronoUnit.SECONDS.between(LocalDateTime.parse(area4.getText(), formatter), LocalDateTime.parse(area3.getText(), formatter));
        if (timesres > 20){
            area6.setText("ERROR");
            Flag = false;
        }else {area6.setText("OK");}
        if (!firstkey.equals(iduserB)){
            area7.setText("ERROR");
            Flag = false;
        }else {area7.setText("OK");}
        if (Flag){
            area8.setText("SUCCESS");
        }else {
            area8.setText("FAILURE");
        }

    }

    public void setWelcomeScene(Scene welcomeScene, Stage primaryStage) {
        this.welcomeScene = welcomeScene;
        this.primaryStage = primaryStage;
    }
    public void btn3(ActionEvent actionEvent) {
        area4.setText("");
        area5.setText("");
        area6.setText("");
        area7.setText("");
        area8.setText("");
        primaryStage.setScene(welcomeScene);
    }


}
