package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.Region;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.MenuItem;

public class MyController implements Initializable {

	@FXML
	private AnchorPane root;
	
	@FXML
    private AnchorPane nodePropPane;

    @FXML
    private AnchorPane creationPane;
	
/*
	@FXML
	private Rectangle newRec;
*/
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

	public Rectangle createRectangle(ActionEvent event) {
		Rectangle newRec = new Rectangle(30, 40, 100, 150);

		newRec.setFill(Color.WHITE);

		newRec.setStroke(Color.BLACK);

		newRec.setCursor(Cursor.HAND);
		newRec.setOnMousePressed(rectangleOnMousePressedEventHandler);
		newRec.setOnMouseDragged(rectangleOnMouseDraggedEventHandler);
		nodeSpace.getChildren().add(newRec);
		return newRec;
         
	}
	
	/*public class Agent extends Rectangle {
		public Agent() {
			Text text = new Text("Title");
			
		}
	}*/
	
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
	@FXML
	public void toggleWindow () 
	{
		if ( nodePropPane.isVisible() == true && creationPane.isVisible() == false)
		{
			nodePropPane.setVisible(false);
			creationPane.setVisible(true);
		}
		
	}
	
	@FXML
	public void closeApp() 
	{
		Platform.exit();
	}

}