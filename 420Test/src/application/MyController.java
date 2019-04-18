package application;

import java.awt.Button;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.MenuItem;

public class MyController implements Initializable {

	@FXML
	private AnchorPane root;
	
	@FXML
    private AnchorPane createSpace;

	@FXML
    private VBox buttonBox;

	@FXML
	private AnchorPane nodeSpace;
	
	@FXML
	private TextField titleText;
	
	@FXML
	private MenuItem loadFile;
	
	@FXML
	private VBox editPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//propSpace.getChildren().add(titleText);		
		createNode();

	}
	
    private Line currentLine ;
	
	public Line createLine(ActionEvent event) {
		
		System.out.print("inside create line");
		
        Pane pane = nodeSpace;

        pane.setOnMousePressed(e -> {
            currentLine = new Line(e.getX(), e.getY(), e.getX(), e.getY());
            //System.out.print("got here");
            pane.getChildren().add(currentLine);
        });

        pane.setOnMouseDragged(e -> {
            currentLine.setEndX(e.getX());
            currentLine.setEndY(e.getY());
            
        });
        pane.setOnMouseReleased(e ->{
        	   
        });
        
        return currentLine;
	    }	

	public void createNode() {
		classBox box = new classBox();
		//root.getChildren().addAll(box);
		
		Box t = new Box(nodeSpace, editPane, box.getID());	
		
		nodeSpace.getChildren().add(t);
	}
	
	@FXML
	public void closeApp() 
	{
		Platform.exit();
	}
	
	/*
	* Need to add functionality where when a file is opened the old window closes
	* Need to add functionality where it can only open the correct extension
	*
	*	fileChooser.getExtensionFilters().addAll(
	*		     new FileChooser.ExtensionFilter("Text Files", "*.txt")
	*		    ,new FileChooser.ExtensionFilter("HTML Files", "*.htm")
	*		);
	*/
	
	FileChooser fileChooser = new FileChooser();
	private Desktop desktop = Desktop.getDesktop();
	@FXML
	public void fileOpen() {
		loadFile.setOnAction(
	            new EventHandler<ActionEvent>() {
	                @Override
	                public void handle(final ActionEvent e) {
	                    File file = fileChooser.showOpenDialog(root.getScene().getWindow());
	                    if (file != null) {
	                        openFile(file);
	                    }
	                }
	            });
	}
	private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                MyController.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
	
	//------------------------

	public void toggleBoxEdit() {
		if(editPane.isVisible() == true) {
			editPane.setVisible(false);
		} else {
			editPane.setVisible(true);
		}
	}
	//------------------------

}