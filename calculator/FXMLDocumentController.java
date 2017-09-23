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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 *
 */
public class FXMLDocumentController {
    
    private double num1;
    private boolean isOperationSet = false;
    private String value1 = new String();
    @FXML
    private Button exit,button1;
    // promptText="Gimme Calculations" can be set in the XML file 
    // shows the String when no input is given
    @FXML
    private TextField output;
    @FXML
    private Text output2;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        /*  When we do Object1 = Object2; , it will pass only the adress 
         *  That means we wont coppy the whole object, we just coppied the pointer
         *  Using this property now : event.getSource() returns an Event Object 
         *  The object on which the Event initially occurred.
         *  We type cast it to a Button object ->  (Button)event.getSource();
         *  then giving the reference to tempButton 
         *  --- this way we can use all the Button Methods on every button pressed --- 
         *  like this : 
         */
        Button tempButton = (Button)event.getSource();
        tempButton.setStyle("-fx-background-color: #FF0000");
        tempButton.setPrefHeight(30);
        
        /*  If we want to change only some specific buttons 
         *  We need to give them an fx:id first (in scene builder OR in the XML document)
         *  Like this : <Button fx:id="button1" layout.../>
         *  Then declaring them in our Controler class with '@FXML' : 
         *       @FXML
         *       private Button exit,button1;
         *  then we can access all the Button Methods from the button we want to modify
         *  like this :
         */
        if((Button)event.getTarget() == button1) {  // if button1 is the Target Object
                                                    // (clicked , dragged , etc)
            button1.setId("button1");               // Relevant for CSS files
            button1.setVisible(false);
        }
        
        
        
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
        
        // Comparing Objects with '==' and '.equals()' are DIFFERENT ! Carefull !
        // Here it wouldnt work if we used '==' to compare
        if (((Button)event.getSource()).getText().equals("C")){
            output.setText("");
            value1 = "";
            isOperationSet = false;
            return;
        }
        else if (((Button)event.getSource()).getText().equals("=")) {
            
            // stringtoCalc.eval(String str); Evaluates the string and returns the 
            // result of the operation as double
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
    /*  Returns the string representation of the {@code double} argument.
     *   
     *   public static String valueOf(double d) {
     *      return Double.toString(d);
     *   }
     *   
     *   public static String valueOf(long l) {
     *       return Long.toString(l);
     *   }
     * 
     *   public static String valueOf(float f) {
     *       return Float.toString(f);
     *   }
     *
     */
}
