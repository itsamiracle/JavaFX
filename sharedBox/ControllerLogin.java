package sharedBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label textForgotPassword;
    @FXML
    private AnchorPane rootPane, mainWindow, loginWindow;
    @FXML
    private Button loginButton, registerButton;

    static Stage mainStage;
    static Stage registerStage;


    public static void closeMainStage() {
        mainStage.hide();
    }

    @FXML
    private void handleActionLogin (ActionEvent event) {

        System.out.println("Login button clicked");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainView.fxml"));
            Parent root1 = fxmlLoader.load();
            mainStage = new Stage();
            mainStage.setScene(new Scene(root1));
            mainStage.show();
            Main.closeLoginWindow();
        }
        catch (Exception e ){
            System.out.println(e);
        }
    }

    @FXML
    private void handleActionRegister (ActionEvent event) throws Exception {

        System.out.println("Register button clicked");
        AnchorPane reg = FXMLLoader.load(getClass().getResource("RegisterView.fxml"));
        Main.loginWindow.setScene(new Scene(reg));

//        try {
//            // Change the current scene to a register scene
//            AnchorPane registerWindow = FXMLLoader.load(getClass().getResource("RegisterView.fxml"));
//            rootPane.getChildren().setAll(registerWindow);
//        }
//        catch (Exception e ){
//            System.out.println(e);
//        }
    }

    @FXML
    private void handleActionForgotPassword () {

        textForgotPassword.setVisible(true);
    }

    @FXML
    private void handleActionRememberMe (ActionEvent event) {



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


