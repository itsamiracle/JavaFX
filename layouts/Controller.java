package layouts;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


/**     Sometimes the IDE autofills the WRONG one
 *
 *      import javafx.scene.input.MouseEvent;  ---> CORRECT one to import
 *      import java.awt.event.MouseEvent;      ---> WRONG one to import
 *
 *      Also we should not forget to add which class will be the controller of the program :
 *                      --- fx:controller="layouts.Controller" ---
 *      Every window can have only 1 controller (?)
 */

/**     Padding : kenarların başka objelere olan uzaklığı
 *      Margin : Örneğin Buttonun içindeki yazının Buttonun kenarlarına olan uzaklığı
 *
 *
 */

public class Controller implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Button buttonSend, buttonSubmit;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private ListView<String> listView;

    /**
      *   Getting the Text of the button/ChoiceBox which was clicked / pressed / release / etc
      *
      *   ((Button)(event.getSource())).getText();
      *   ((ChoiceBox<String>)(event.getSource())).getValue();  -- choiceBox.getValue();
      *
      *   this can be done for different types of objects
      */
    @FXML
    private void handleMouseAction (MouseEvent event)  {
        String input,choice;


        // if the user clicks the 'Send' Button
        if(event.getSource() == buttonSend){
            System.out.println("Button is clicked!");

            input = ((Button)(event.getSource())).getText();
            System.out.println("The text here should be 'Send' : " + input);
        // accessing the choice element currently selected
            choice = choiceBox.getValue();
            System.out.println("The text here should be 'Send' : " + choice);
        }

        /*
         *  create an event if the user selects a different item from the list
         */
        choiceBox.setOnAction(e -> System.out.println(choiceBox.getValue()));

        comboBox.setOnAction(e -> System.out.println(comboBox.getValue()));

        System.out.println("ChoiceBox value : " + choiceBox.getValue());
        System.out.println("ComboBox value : " + comboBox.getValue());

    }
    @FXML
    private void handleListAction(MouseEvent event){

        //System.out.println("Items selected : " + listView.getSelectionModel().getSelectedItems().toString());

        buttonSubmit.setOnAction(e -> {
            String message = "";
            ObservableList<String> movies ;
            movies = listView.getSelectionModel().getSelectedItems();

            for(String m : movies){
                message += m + " ";
            }
            System.out.println("After button click : " + message);
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /*  ChoiceBox, Setting the items in our ChoiceBox before the window is shown to us
         *  sets a default value . Works only with a value that already exists in the list
         */
        choiceBox.getItems().addAll("Apple","Banana","Bla");
        choiceBox.setValue("Apple");

        /*  ComboBox , the difference is you can add a promt text to it
         *  you can edit it
         *
         */
        comboBox.getItems().addAll("Antalya","izmir","istanbuul");
        comboBox.setPromptText("Which city you like the most ?");
        comboBox.setEditable(true);

        /*  ListView , adding items is the same
         *  by default you can only select one item from the list.
         *  For selecting multiple items :
         *   --- listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); ---
         */
        listView.getItems().addAll("Iron Man", "Spiderman","Titanic","Alien","Lord of War");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
}
