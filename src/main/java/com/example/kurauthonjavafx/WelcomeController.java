package com.example.kurauthonjavafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class WelcomeController {

    @FXML
    private Button startButton;

    private Scene mainScene;
    private Stage primaryStage;

    public void setMainScene(Scene mainScene, Stage primaryStage) {
        this.mainScene = mainScene;
        this.primaryStage = primaryStage;
    }

    @FXML
    private void handleStartButtonAction() {
        // Switch to the main scene
        primaryStage.setScene(mainScene);
    }
    @FXML
    private void showinfo(){
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("https://uk.wikipedia.org/wiki/OCRA"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void showAuthorInfo(){
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Автор");
        popup.setResizable(false);

        Label label = new Label("Програму розробив Загирняк Богдан.");

        Hyperlink moreLink = new Hyperlink("More");
        moreLink.setOnAction(event -> {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI("https://stratz.com/players/259213088?trendsMatchCount=100"));
                    Desktop.getDesktop().browse(new URI("https://uk.dotabuff.com/players/259213088"));
                    Desktop.getDesktop().browse(new URI("https://www.twitch.tv/stray228"));
                    // Отримуємо шлях до зображення
                    String imagePath = getClass().getResource("/sa.jpg").getPath();

                    try {
                        // Відкриваємо зображення за допомогою фоторедактора
                        File imageFile = new File(imagePath);
                        Desktop.getDesktop().open(imageFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
        moreLink.setStyle("-fx-text-fill: black; -fx-border-color: transparent; -fx-opacity: 0.9;");

        HBox buttons = new HBox(10);
        buttons.getChildren().add(moreLink);
        buttons.setAlignment(Pos.BOTTOM_RIGHT);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, buttons);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #ffffff;");

        StackPane root = new StackPane();
        root.getChildren().add(layout);

        Scene scene = new Scene(root, 250, 100);
        popup.setScene(scene);
        popup.showAndWait();

    }
}
