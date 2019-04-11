package application;


import javafx.event.EventHandler;
import javafx.scene.Node;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.FlowPane;

class DraggableNode extends FlowPane {

    // node position
    private double xNode = 0;
    private double yNode = 0;
    // mouse position
    private double mousex = 0;
    private double mousey = 0;
    //The node that will be dragged
    private Node view;
    //Checks if Node is dragging
    private boolean dragging = false;
    //Checks if Node is in front
    private boolean moveToFront = true;

    //Constructor: Calls Initialization fxn
    public DraggableNode() {
        init();
    }

    //Constructor: Makes view == input node & calls initialization fxn
    public DraggableNode(Node view) {
        this.view = view;

        getChildren().add(view);
        init();
    }

    private void init() {

    	// Creates Mouse Press event
    	//Sets scene coordinates to mouse
    	//Sets layout coordinates to variables representing the Node's coordinates
    	//Checks if the node is in front
        onMousePressedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                // record the current mouse X and Y position on Node
                mousex = event.getSceneX();
                mousey = event.getSceneY();

                xNode = getLayoutX();
                yNode = getLayoutY();

                if (isMoveToFront()) {
                    toFront();
                }
            }
        });

        //Creates event for mouse drag
        //Finds the offset of the scene and mouse coordinates
        // Adds the offset to the Node coordinate variables 
        //Sets the newly offset Node coordinates as its own translation variable
        //Applies it to the scene
        //Sets dragging to true
        // Sets the scene coordinates to the mouse coordinates
        //repeats
        onMouseDraggedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                // Get the exact moved X and Y

                double offsetX = event.getSceneX() - mousex;
                double offsetY = event.getSceneY() - mousey;

                xNode += offsetX;
                yNode += offsetY;

                double scaledX = xNode;
                double scaledY = yNode;

                setLayoutX(scaledX);
                setLayoutY(scaledY);

                dragging = true;

                // again set current Mouse x AND y position
                mousex = event.getSceneX();
                mousey = event.getSceneY();

                event.consume();
            }
        });
        
        //If Node is clicked, set drag to false
        onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                dragging = false;
            }
        });

    }

    //Returns if the node is dragging
    protected boolean isDragging() {
        return dragging;
    }


    //Returns the view Node
    public Node getView() {
        return view;
    }

    //Sets current moveToFront to the input boolean moveToFront
    public void setMoveToFront(boolean moveToFront) {
        this.moveToFront = moveToFront;
    }

    //Returns moveToFront
    public boolean isMoveToFront() {
        return moveToFront;
    }
    
    //Removes the Node n
    public void removeNode(Node n) {
        getChildren().remove(n);
    }
}