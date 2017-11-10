package sharedBox;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerMain {
    @FXML
    Button gotoLogin;

    @FXML
    public void handleButtonAction() {
        ControllerLogin.closeMainStage();
        Main.loginWindow.show();
    }
}
