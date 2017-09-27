package database;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private TextField textFieldDatabase;
    @FXML
    private TextArea textAreaQuery;
    @FXML
    private Button buttonCreate, buttonDelete , buttonQuery, buttonClear;

    @FXML
    private void handleMouseAction (MouseEvent event) {
        System.out.println("Success !");

        if (event.getSource().equals(buttonCreate)){
            try {
                if(getConnection() == null) {
                    System.out.println("NO CONNECTION TO DATABASE");
                    return;
                }
                Connection myConn = getConnection();
                createDatabase(myConn, textFieldDatabase.getText());
                System.out.println("Database " + textFieldDatabase.getText() +" is created !");
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if(event.getSource().equals(buttonDelete)) {
            try {
                if(getConnection() == null) {
                    System.out.println("NO CONNECTION TO DATABASE");
                    return;
                }
                Connection myConn = getConnection();
                deleteDatabase(myConn, textFieldDatabase.getText());
                System.out.println("Database " + textFieldDatabase.getText() +" is deleted !");
            }
            catch (Exception e){
                System.out.println(e);

            }
        }
        else if(event.getSource().equals(buttonQuery)) {
            try {
                if(getConnection() == null) {
                    System.out.println("NO CONNECTION TO DATABASE");
                    return;
                }
                Connection myConn = getConnection();
                querry(myConn, textAreaQuery.getText());
                System.out.println("Querry " + textAreaQuery.getText() +" is executed !");
            }
            catch (Exception e){
                System.out.println(e);

            }
        }
        else if(event.getSource().equals(buttonClear)) {
            textAreaQuery.clear();
            textFieldDatabase.clear();
        }


    }

    private void createDatabase (Connection myConnection, String databaseName){

        try {
            Statement myStm = myConnection.createStatement();
            //  .executeQuery()  ----    .executeUpdate()
            myStm.executeUpdate("CREATE DATABASE " + databaseName);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    private void deleteDatabase (Connection myConnection, String databaseName){

        try {
            Statement myStm = myConnection.createStatement();
            //  .executeQuery()  ----    .executeUpdate()
            myStm.executeUpdate("DROP DATABASE " + databaseName);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    private void querry (Connection myConnection , String myQuerry) {

        try {
            Statement myStm = myConnection.createStatement();
            //  .executeQuery()  ----    .executeUpdate()
            myStm.executeUpdate(myQuerry);
           /**
            * ResultSet resultSet = myStm.executeQuery(myQuerry);
            *   while(resultSet.next()){
            *       String firstName = resultSet.getString("<firstName>");
            *       ...
            *   }
            */
        }
        catch (Exception e){
            System.out.println(e);
        }



    }

    private Connection getConnection() throws Exception{

        try{
            // SHOW GLOBAL VARIABLES LIKE 'PORT';
            String url = "jdbc:mysql://localhost:3306/selam?useSSL=false";
            String user = "root";
            String pw = "0810562007";
            Class.forName("com.mysql.jdbc.Driver");

            Connection myConnecion = DriverManager.getConnection(url,user,pw);
            return myConnecion;
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
