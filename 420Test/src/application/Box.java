package application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

class Box extends DraggableNode{
	private Text title = new Text();
	//private Text attributes;
	//private Text operations;
	//private Text extraComponents;
	
	private FlowPane nodeID = new FlowPane();
	private FlowPane nodeVar = new FlowPane();
	private FlowPane nodeMet = new FlowPane();
	private DraggableNode nodeMain = new DraggableNode();
	
	
	public Box(AnchorPane nodeSpace, AnchorPane propSpace)
	{		
		//Sizes
        nodeMain.setPrefSize(80, 60);
        
        nodeID.setPrefSize(80, 20);
        nodeVar.setPrefSize(80, 20);
        nodeMet.setPrefSize(80, 20);
        
        // Define the style via CSS
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
        // Position the node
        nodeMain.setLayoutX(30 + nodeMain.getPrefWidth());
        nodeMain.setLayoutY(30);
        
        //Layout of first node
        nodeID.setLayoutX(30);
        nodeID.setLayoutY(30);
        
        //Makes all children align to the center;
        nodeID.setAlignment(Pos.CENTER);
        
        nodeVar.setLayoutX(30);
        nodeVar.setLayoutY(30 + nodeID.getPrefHeight());
        nodeMet.setLayoutX(30);
        nodeMet.setLayoutY(30 + nodeVar.getPrefHeight());
        
        
        // Add Text to  
        
		title.setText("Title");
		title.setX(30);
        title.setY(30);
        nodeID.getChildren().add(title);
        
        nodeMain.getChildren().addAll(nodeID,nodeVar,nodeMet);
        nodeSpace.getChildren().add(nodeMain);
	}
	
	public void editTitle (Text newTitle)
	{
		title.setText("Title");
	}
	
	/*
	EventHandler<MouseEvent> boxOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			
			
		}
	};
	*/
	
	
	
}
