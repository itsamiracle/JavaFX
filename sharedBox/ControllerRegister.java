package sharedBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControllerRegister {

    @FXML
    private TextField textFieldEmail, textFieldPassword, textFieldConfirmPassword;
    @FXML
    Label confirmationLabel;

    @FXML
    public void handleButtonAction(ActionEvent event) throws Exception {

        String Email = textFieldEmail.getText();
        String password = textFieldPassword.getText();
        String confirmPassword = textFieldConfirmPassword.getText();


        if (password.equals("") || Email.equals("")){
            confirmationLabel.setText("Fill up credantials !!!");
        }
        else if(password.equals(confirmPassword)) {
            confirmationLabel.setText("Passwords are Matching");
            System.out.println(" ::: Sending DATA to Business layer ::: ");
        }
        else {
            confirmationLabel.setText("ERROR : Passwords not matching");
            System.out.println(password);
            System.out.println(confirmPassword);
        }


        // if the conditions are ok then ...

//        AnchorPane log = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
//        Main.loginWindow.setScene(new Scene(log));

    }

}
