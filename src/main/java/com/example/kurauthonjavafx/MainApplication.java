package com.example.kurauthonjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Вікно привітання
        FXMLLoader welcomeLoader = new FXMLLoader(getClass().getResource("welcome-view.fxml"));
        Parent welcomeRoot = welcomeLoader.load();
        Scene welcomeScene = new Scene(welcomeRoot, 285, 125);

        // головне вікно
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent mainRoot = mainLoader.load();
        Scene mainScene = new Scene(mainRoot, 615, 322);

        // Зміна сцен
        WelcomeController welcomeController = welcomeLoader.getController();
        welcomeController.setMainScene(mainScene, primaryStage);

        // Зміна сцен
        MainController mainController = mainLoader.getController();
        mainController.setWelcomeScene(welcomeScene, primaryStage);

        // Логотип
        Image logo = new Image("logo.png");

        primaryStage.getIcons().add(logo);
        primaryStage.setTitle("OWA");
        primaryStage.setResizable(false);
        primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
