package application;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.MenuItem;

public class MyController implements Initializable {

	@FXML
	private AnchorPane root;
	
	@FXML
    private AnchorPane createSpace;

	@FXML
    private AnchorPane propSpace;

	@FXML
	private AnchorPane nodeSpace;
	
	@FXML
	private TextField titleText;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//propSpace.getChildren().add(titleText);		
		createNode();

	}
	
	public void createNode() {
		//classBox box = new classBox();
		//root.getChildren().addAll(box);
		
		Box t = new Box(nodeSpace, propSpace);
		nodeSpace.getChildren().add(t);
		/*
		Text title = new Text();
		title.setText("Title");
		title.setX(20);
        title.setY(20);
        nodeSpace.getChildren().add(title);
		*/
	}
	
	@FXML
	public void closeApp() 
	{
		Platform.exit();
	}

}