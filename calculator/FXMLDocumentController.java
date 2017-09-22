/*
 * 
 */
package calculator;

import java.lang.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 *
 */
public class FXMLDocumentController /*implements Initializable*/ {
    
    private double num1 ;
    private boolean isOperationSet = false;
    private String value1 = new String();
    @FXML
    private Button exit;
    @FXML
    private TextField output;
    @FXML
    private Text output2;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getTarget() == exit)
            Platform.exit();
        
        else if(isOperationSet == false){
            value1 = value1 + ((Button)event.getSource()).getText();
            output.setText(value1);
            //System.out.println(value1);
            return;
        }
        else
            value1 = value1 + ((Button)event.getSource()).getText();
            output.setText(value1);
            //System.out.println(value1);
            
        }
        
    
    @FXML
    private void handleOperatorAction(ActionEvent event) {
        
        if (((Button)event.getSource()).getText().equals("C")){
            output.setText("");
            value1 = "";
            isOperationSet = false;
            return;
        }
        else if (((Button)event.getSource()).getText().equals("=")) {
            num1 = stringtoCalc.eval(value1);
            output.setText(String.valueOf(num1));
            output2.setText(value1 + "=" + String.valueOf(num1));
            value1 = String.valueOf(num1);
            isOperationSet = false;
            return;
        }
        
        isOperationSet = true;
        value1 = value1 + ((Button)event.getSource()).getText();
        output.setText(value1);
    }
}
