module com.example.kurauthonjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.kurauthonjavafx to javafx.fxml;
    exports com.example.kurauthonjavafx;
}