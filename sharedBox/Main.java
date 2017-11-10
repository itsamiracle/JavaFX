package sharedBox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{

    private double xOffset;
    private double yOffset;

    static Stage loginWindow;
    static AnchorPane loginLayout, registerLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {

        loginWindow = primaryStage;

        loginLayout = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        registerLayout =  FXMLLoader.load(getClass().getResource("RegisterView.fxml"));

        Scene rootScene = new Scene(loginLayout);

        rootScene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());

        loginWindow.setScene(rootScene);

        loginWindow.show();



        // ---------------------------------------------------
        loginLayout.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        loginLayout.setOnMouseDragged(event -> {
            loginWindow.setX(event.getScreenX() - xOffset);
            loginWindow.setY(event.getScreenY() - yOffset);
        });
        // ---------------------------------------------------


    }

    public static void closeLoginWindow() {
        loginWindow.hide();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
