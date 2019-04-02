package application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

class Box extends DraggableNode{
	private TextField title = new TextField();
	private TextArea var = new TextArea();
	private TextArea meth = new TextArea();
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
        nodeMain.setPrefSize(100, 130);
        
        nodeID.setPrefSize(200, 50);
        nodeVar.setPrefSize(200, 100);
        nodeMet.setPrefSize(200, 100);
        
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
        
        
        // Add Text to title 
        
		title.setPromptText("Title");
		title.setPrefWidth(100);
        nodeID.getChildren().add(title);
        
        //Add Text to var
        
        var.setPromptText("Variables");
		var.setPrefWidth(nodeVar.getPrefWidth());
		var.setPrefHeight(nodeVar.getPrefHeight());
        nodeVar.getChildren().add(var);
        
        //Add Text to meth(ods)
        
        meth.setPromptText("Methods");
		meth.setPrefWidth(nodeMet.getPrefWidth());
		meth.setPrefHeight(nodeMet.getPrefHeight());
        nodeMet.getChildren().add(meth);
        
        nodeMain.getChildren().addAll(nodeID,nodeVar,nodeMet);
        nodeSpace.getChildren().add(nodeMain);
	}
	
	
	
	/*
	EventHandler<MouseEvent> boxOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			
			
		}
	};
	*/
	
	
	
}
