/*
 * 
 */
package calculator;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 *
 */
public class JavaFXML_MyCalculator extends Application {
    
    private double xOffset;
    private double yOffset;
    @FXML
    private Button button1;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        stage.initStyle(StageStyle.TRANSPARENT);
        
        // this anonymous inner class expression can be turned into a lambda expression
        root.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        // like this :
        root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
        });
        
        Scene scene = new Scene(root);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        stage.setScene(scene);
        // ADDING THE CSS FILE TO OUR SCENE
        scene.getStylesheets().add
        (JavaFXML_MyCalculator.class.getResource("calculator_css.css").toExternalForm());
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
