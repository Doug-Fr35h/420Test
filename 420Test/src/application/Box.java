package application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

class Box extends DraggableNode{
	
	private ID boxID;
	//Title text
	private TextField title = new TextField();
	//Variable text
	private TextArea var = new TextArea();
	//Method text
	private TextArea meth = new TextArea();
	//private Text attributes;
	//private Text operations;
	//private Text extraComponents;
	
	//The Pane which will hold the title
	private FlowPane nodeID = new FlowPane();
	//The Pane which holds the Variables
	private FlowPane nodeVar = new FlowPane();
	//The Pane which holds the methods
	private FlowPane nodeMet = new FlowPane();
	//The main Node which holds all Panes and can drag
	private DraggableNode nodeMain = new DraggableNode();
	
	//Constructor: Creates the basic box
	//Requires the Pane which the node will appear in and the Pane which it's properties will be in
	public Box(AnchorPane nodeSpace, VBox editor, ID identifyer)
	{		
		boxID = identifyer;
		nodeMain.setID(boxID);
		
		//Sizes
        nodeMain.setPrefSize(100, 130);
        
        nodeID.setPrefSize(200, 50);
        nodeVar.setPrefSize(200, 100);
        nodeMet.setPrefSize(200, 100);
        
        // the style via CSS
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
        
        //Layout of Variable Node
        nodeVar.setLayoutX(30);
        nodeVar.setLayoutY(30 + nodeID.getPrefHeight());
        
        //Layout of Method node
        nodeMet.setLayoutX(30);
        nodeMet.setLayoutY(30 + nodeVar.getPrefHeight());
        
        
        // Add Text to title 
        
		title.setPromptText("Title");
		title.setPrefWidth(100);
		title.setEditable(false);
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
        
        //Adds all Panes as children of nodeMain
        nodeMain.getChildren().addAll(nodeID,nodeVar,nodeMet);
        
        //Adds nodeMain to be the child of the AnchorPane which it will spawn in
        nodeSpace.getChildren().add(nodeMain);
        
	}
	
	public Box(AnchorPane nodeSpace, String boxTitle, String boxVars, String boxMethods, double x, double y)
	{		
		//this.uniqueID = new ID(this);
		//Sizes
        nodeMain.setPrefSize(100, 130);
        
        nodeID.setPrefSize(200, 50);
        nodeVar.setPrefSize(200, 100);
        nodeMet.setPrefSize(200, 100);
        
        // the style via CSS
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
        nodeMain.setLayoutX(x + nodeMain.getPrefWidth());
        nodeMain.setLayoutY(y);
        
        //Layout of first node
        nodeID.setLayoutX(30);
        nodeID.setLayoutY(30);
        
        //Makes all children align to the center;
        nodeID.setAlignment(Pos.CENTER);
        
        //Layout of Variable Node
        nodeVar.setLayoutX(30);
        nodeVar.setLayoutY(30 + nodeID.getPrefHeight());
        
        //Layout of Method node
        nodeMet.setLayoutX(30);
        nodeMet.setLayoutY(30 + nodeVar.getPrefHeight());
        
        
        // Add Text to title 
        
		title.setText(boxTitle);
		title.setPrefWidth(100);
        nodeID.getChildren().add(title);
        
        //Add Text to var
        
        var.setText(boxVars);
		var.setPrefWidth(nodeVar.getPrefWidth());
		var.setPrefHeight(nodeVar.getPrefHeight());
        nodeVar.getChildren().add(var);
        
        //Add Text to meth(ods)
        
        meth.setText(boxMethods);
		meth.setPrefWidth(nodeMet.getPrefWidth());
		meth.setPrefHeight(nodeMet.getPrefHeight());
        nodeMet.getChildren().add(meth);
        
        //Adds all Panes as children of nodeMain
        nodeMain.getChildren().addAll(nodeID,nodeVar,nodeMet);
        
        //Adds nodeMain to be the child of the AnchorPane which it will spawn in
        nodeSpace.getChildren().add(nodeMain);
        
        
	}
	
	public TextField getTitle()
	{
		return title;
	}
	
	public TextArea getVars()
	{
		return var;
	}
	
	public TextArea getMethods()
	{
		return meth;
	}
	
	public DraggableNode getDragNode()
	{
		return nodeMain;
	}
	
	public ID getID(){
		return this.boxID;
	}
	
	public void boxEditor(VBox editor) {
		nodeMain.setOnMouseClicked(e ->{
			if(editor.isVisible() == false) {
				editor.setVisible(true);
			}
		});
	}
		
	public void removeBox()
	{
		nodeMain.removeNode(nodeMain);
	}
	
	
	
}
