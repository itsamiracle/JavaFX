/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventHandling;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 *
 */
public class JavaFXML_EventHandler extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    @Override
    /* start fonksiyonuna parametre olarak girilen : Stage classındaki
     * stage değişkeni (sanırım) dıştaki ve bütün çerçeveyi  tanımlıyor.
     * -> stage.initStyle(StageStyle.TRANSPARENT) fonksiyonu ile dış çerceveyi
     * görünmez yapabiliyoruz.
     * -> scene.setFill() fonksiyonu ile scene olmayan arka plana renk atıyoruz.
     *
     * Stage : the entire window
     * Scene : content inside the window
     * and the widgets and buttons will be put inside the stage
     * Layout : how you want to arrange everything on your screen
     */
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
        stage.show();
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // first the main method is called and with launch() we start our program
    // as a JavaFX program 
    // -> Method start() will be called  
        launch(args);
    }
    
}
