package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *  Runs the programs
 * @author _______
 *
 */
public class MyApplication extends Application {
    
	/**
	 * 
	 */
    @Override
    public void start(Stage primaryStage) {
        try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass().getResource("/MyScene.fxml"));
            primaryStage.setTitle("SpeghettiForZoppetti UML Editor");
            primaryStage.setScene(new Scene(root));
            primaryStage.show(); 
         
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
}