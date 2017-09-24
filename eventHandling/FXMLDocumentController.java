/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventHandling;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 *
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button sendButton;
    @FXML
    private TextField textField;

    /**      *** IMPORTANT ***
     *
     *      event.getTarget().equals(sendButton) : Gives back different results
     *                                             each time the program runs !
     *      instead use :
     *
     *      (event.getSource()) == sendButton
     *
     */

    // Different Actions can call different methods :
    // CAREFULL with the EVENT TYPE !!!  --- MouseEvent , ActionEvent , ... ---

    // onMousePressed="#handlePressAction"
    @FXML
    private void handlePressAction(MouseEvent event) {

        System.out.println(" --- Pressed ---");
        if((event.getSource()) == sendButton) {
            System.out.println(" --- Sent ! 1 ---");
        }
    }
    // onMouseReleased="#handleRelease"
    @FXML
    private void handleRelease (MouseEvent event) {

        System.out.println(" --- Released ---");
        if((event.getSource()) == sendButton) {
            System.out.println(" --- Sent ! 2---");
        }
    }
    // onMouseClicked="#handleClick"
    @FXML
    private void handleClick (MouseEvent event) {
        System.out.println(" --- Clicked ---");
        if((event.getSource()) == sendButton) {
            System.out.println(" --- Sent ! 3---");
            isInt(textField,textField.getText());
        }
    }

    private static boolean isInt (TextField textField, String message){
        try {
            int age = Integer.parseInt(textField.getText());
            System.out.println("User is " + age + " years old");
            return true;
        }
        catch (NumberFormatException e){
            System.out.println("Error : "+ message + " is not a number");
        }
        return false;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
