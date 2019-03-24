package application;

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
    private AnchorPane nodePropPane;

    @FXML
    private AnchorPane creationPane;

	@FXML
	private AnchorPane nodeSpace;

	@FXML
	private AnchorPane properties;

	@FXML
	double orgSceneX, orgSceneY;

	@FXML
	double orgTranslateX, orgTranslateY;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// TODO (don't really need to do anything here).

	}
	
	public DraggableNode createNode(ActionEvent event) {
		
		FlowPane nodeID = new FlowPane();
		FlowPane nodeVar = new FlowPane();
		FlowPane nodeMet = new FlowPane();
		DraggableNode nodeMain = new DraggableNode();
		
		
		//Sizes
        nodeMain.setPrefSize(80, 60);
        
        nodeID.setPrefSize(80, 20);
        nodeVar.setPrefSize(80, 20);
        nodeMet.setPrefSize(80, 20);
        
        // define the style via css
        nodeMain.setStyle(
            "-fx-background-color: black; "
            + "-fx-text-fill: black; "
            + "-fx-border-color: black;");
        nodeID.setStyle(
                "-fx-background-color: #FFFFFF; "
                + "-fx-text-fill: black; "
                + "-fx-border-color: black;");
        nodeVar.setStyle(
                "-fx-background-color: #FFFFFF; "
                + "-fx-text-fill: black; "
                + "-fx-border-color: black;");
        nodeMet.setStyle(
                "-fx-background-color: #FFFFFF; "
                + "-fx-text-fill: black; "
                + "-fx-border-color: black;");
        // position the node
        nodeMain.setLayoutX(30 + nodeMain.getPrefWidth());
        nodeMain.setLayoutY(30);
        
        nodeID.setLayoutX(30);
        nodeID.setLayoutY(30);
        nodeVar.setLayoutX(30);
        nodeVar.setLayoutY(30 + nodeID.getPrefHeight());
        nodeMet.setLayoutX(30);
        nodeMet.setLayoutY(30 + nodeVar.getPrefHeight());
        
        // add the node to the root pane 
        
        nodeMain.getChildren().addAll(nodeID,nodeVar,nodeMet);
        nodeSpace.getChildren().add(nodeMain);
        
        return nodeMain;
         
	}

	public void createRectangle(ActionEvent event) {
		
		Rectangle newRec = new Rectangle(30, 40, 100, 50);
		
	
		newRec.setFill(Color.WHITE);
		

		newRec.setStroke(Color.BLACK);
		

		newRec.setCursor(Cursor.HAND);
		newRec.setOnMousePressed(rectangleOnMousePressedEventHandler);
		newRec.setOnMouseDragged(rectangleOnMouseDraggedEventHandler);
		nodeSpace.getChildren().add(newRec);
		
         
	}
	
	public void drag(MouseEvent event) {
		Node n = (Node) event.getSource();
		n.setTranslateX(n.getTranslateX() + event.getX());
		n.setTranslateY(n.getTranslateY() + event.getY());
	}

	EventHandler<MouseEvent> rectangleOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY();
			orgTranslateX = ((Rectangle) (t.getSource())).getTranslateX();
			orgTranslateY = ((Rectangle) (t.getSource())).getTranslateY();
			nodePropPane.setVisible(true);
			creationPane.setVisible(false);
			
		}
	};

	EventHandler<MouseEvent> rectangleOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;
			
			((Rectangle) (t.getSource())).setTranslateX(newTranslateX);
			((Rectangle) (t.getSource())).setTranslateY(newTranslateY);
		}

	};
	
	//Only used for testing, delete later
/////////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void toggleWindow () 
	{
		if ( nodePropPane.isVisible() == true && creationPane.isVisible() == false)
		{
			nodePropPane.setVisible(false);
			creationPane.setVisible(true);
		}
		else if ( nodePropPane.isVisible() == false && creationPane.isVisible() == true)
		{
			nodePropPane.setVisible(true);
			creationPane.setVisible(false);
		}
		else
		{
			nodePropPane.setVisible(false);
			creationPane.setVisible(true);
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////
	
	@FXML
	public void closeApp() 
	{
		Platform.exit();
	}

}