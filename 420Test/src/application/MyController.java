package application;

import java.awt.Button;
import java.awt.Desktop;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

//import org.apache.commons.io.FileUtils;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
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
import java.util.*;

import java.awt.Desktop;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

//import org.apache.commons.io.FileUtils;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
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
import java.util.*;

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
	private TextField boxTitle;
	@FXML
	private MenuItem loadFile;
	@FXML
	private VBox editPane;
	private boolean lineMode = false;
	public static ArrayList<Box> boxes = new ArrayList<Box>(10);
	public ArrayList<Line> lines = new ArrayList<Line>(10);
	@FXML
	FileChooser fc = new FileChooser();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	
	public EventHandler<MouseEvent> firstClick = new EventHandler<MouseEvent>() {
		private Line currentLine = null;
		private Node getBox(MouseEvent e) {
		Node Bnode = e.getPickResult().getIntersectedNode();
		while (!(Bnode instanceof DraggableNode) && Bnode != null) {
		Bnode = Bnode.getParent(); 
		}
		return Bnode;
		}
		@Override
		public void handle(MouseEvent e) {
		if (!lineMode) {
		return;
		}
		if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
		DraggableNode.moveable = false;
		Node Bnode = getBox(e);
		if (Bnode == null) {
		return;
		}
		currentLine = new Line();
		currentLine.startXProperty().bind(Bindings.add(Bnode.layoutXProperty(), Bnode.getLayoutBounds().getWidth() / 2));
		currentLine.startYProperty().bind(Bindings.add(Bnode.layoutYProperty(), Bnode.getLayoutBounds().getHeight() / 2));
		currentLine.endXProperty().set(e.getSceneX());
		currentLine.endYProperty().set(e.getSceneY());
		nodeSpace.getChildren().add(currentLine);
		} else if (e.getEventType() == MouseEvent.MOUSE_RELEASED) {
		Node Enode = getBox(e);
		if (Enode == null) {
		nodeSpace.getChildren().remove(currentLine);
		return;
		}
		currentLine.endXProperty().bind(Bindings.add(Enode.layoutXProperty(), Enode.getLayoutBounds().getWidth() / 2));
		currentLine.endYProperty().bind(Bindings.add(Enode.layoutYProperty(), Enode.getLayoutBounds().getHeight() / 2));
		nodeSpace.getChildren()
		.filtered(n -> n instanceof DraggableNode)
		.forEach(n -> n.toFront());
		currentLine.toBack();
		lines.add(currentLine);
		currentLine = null;
		DraggableNode.moveable = true;
		} else if (e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
		if (currentLine == null) {
		return;
		}
		currentLine.endXProperty().set(e.getSceneX());
		currentLine.endYProperty().set(e.getSceneY());
		}
		//double x = Bnode.getLayoutX();
		//double y = Bnode.getLayoutY();
		//double x = e.getX();
		//double y = e.getY();
		//currentLine.setLayoutX(x);
		//currentLine.setLayoutY(y);
		//currentLine.startXProperty().bind(Bindings.add(Bnode.layoutBoundsProperty().getValue().getMinX());
		//currentLine.startYProperty().bind(Bindings.add(Bnode.layoutYProperty(), e.getY()));
		}
		};

		public void createLine(ActionEvent e) {
		nodeSpace.setOnMousePressed(firstClick);
		nodeSpace.setOnMouseDragged(firstClick);
		nodeSpace.setOnMouseReleased(firstClick);
		lineMode = true;
		}

		public void removeLineListeners() {
		lineMode = false;
		nodeSpace.removeEventHandler(MouseEvent.MOUSE_PRESSED, firstClick);
		nodeSpace.removeEventHandler(MouseEvent.MOUSE_DRAGGED, firstClick);
		nodeSpace.removeEventHandler(MouseEvent.MOUSE_RELEASED, firstClick);
		}

		/* 
		    private Line currentLine ;
		public Line createLine(ActionEvent event) {
		System.out.print("inside create line");
		        Pane pane = nodeSpace;

		        pane.setOnMousePressed(e -> {
		            currentLine = new Line(e.getX(), e.getY(), e.getX(), e.getY());
		            //System.out.print("got here");
		            lines.ensureCapacity(lines.size() + 5);
		            lines.add(currentLine);
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
		*/
	

	public void createNode() {
		classBox box = new classBox();
		//root.getChildren().addAll(box);
		
		Box t = new Box(nodeSpace, editPane, box.getID());	
		boxes.ensureCapacity(boxes.size() + 5);
		boxes.add(t);
		nodeSpace.getChildren().add(t);
		
		if(editPane.isVisible() == false) {
			editPane.setVisible(true);
		}
	}
	
	@FXML
	public void closeApp() 
	{
		Platform.exit();
	}
	
	@FXML
	public void open() throws FileNotFoundException
	{	
		nodeSpace.getChildren().clear();
		boxes.clear();
		lines.clear();
		//FileChooser fc = new FileChooser();
		
		File file = fc.showOpenDialog(nodeSpace.getScene().getWindow());
		Scanner scanner = new Scanner(file);
		int numLines = scanner.nextInt();
		for(int i = numLines; i > 0; --i)
		{
			double startX = scanner.nextDouble();
			double startY = scanner.nextDouble();
			double endX = scanner.nextDouble();
			double endY = scanner.nextDouble();
			Line l = new Line(startX, startY, endX, endY);
			nodeSpace.getChildren().add(l);
			lines.ensureCapacity(lines.size() + 1);
			lines.add(l);
		}
		while(scanner.hasNext()) 
		{
			String title = scanner.nextLine();
			String vars = "";
			int numVars = scanner.nextInt();
			scanner.nextLine();
			for(int i = numVars; i > 0; --i)
			{
				vars += scanner.nextLine() + " \n";
			}
			
			String methods = "";
			int numMethods = scanner.nextInt();
			scanner.nextLine();
			for(int i = numMethods; i > 0; --i)
			{
				methods += scanner.nextLine() + " \n";
			}
			double x = scanner.nextDouble();
			double y = scanner.nextDouble();
			if(scanner.hasNextLine())
				scanner.nextLine();
			Box t = new Box(nodeSpace, title, vars, methods, x, y);
			boxes.ensureCapacity(boxes.size() + 5);
			boxes.add(t);
			nodeSpace.getChildren().add(t);
		}
		System.out.println("After open: " + boxes.size());
		scanner.close();
	}
	
	@FXML
	public void save() throws FileNotFoundException
	{
		//FileChooser fc = new FileChooser();
		File file = fc.showSaveDialog(nodeSpace.getScene().getWindow());
		PrintWriter pw = new PrintWriter(file);
		pw.println(lines.size());
		for(Line line : lines)
		{
			pw.println(line.getStartX());
			pw.println(line.getStartY());
			pw.println(line.getEndX());
			pw.println(line.getEndY());
		}
		for(Box box : boxes)
		{
			String title = box.getTitle().getText();
			int numVars = box.getVars().getText().split("\n").length;
			int numMethods = box.getMethods().getText().split("\n").length;
			String[] vars =  box.getVars().getText().split("\n");
			String[] methods = box.getMethods().getText().split("\n");
			double x = box.getDragNode().getLayoutX() - 100.0;
			double y = box.getDragNode().getLayoutY();
			pw.println(title);
			pw.println(numVars);
			for(String s: vars)
			{
				pw.println(s);
			}
			pw.println(numMethods);
			for(String s: methods)
			{
				pw.println(s);
			}
			pw.println(x);
			pw.println(y);
		}
		pw.close();
	}
	
	@FXML
	public void export() throws IOException{
		FileChooser fileChooser = new FileChooser();

	    //Set extension filter
	    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.png"));

	    //Prompt user to select a file
	    File file = fileChooser.showSaveDialog(null);

	    if(file != null){
	        try {
	            //Pad the capture area
	            WritableImage writableImage = new WritableImage((int)nodeSpace.getWidth(),
	                    (int)nodeSpace.getHeight());
	            nodeSpace.snapshot(null, writableImage);
	            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
	            //Write the snapshot to the chosen file
	            ImageIO.write(renderedImage, "png", file);
	        } catch (IOException ex) { ex.printStackTrace(); }
	    }
	    
	   
	    try (PDDocument doc = new PDDocument())
        {
	    	PDPage page = new PDPage();
            doc.addPage(page);
            
            String imagePath = file.toString();

            // creates a PDF object from an image file
            PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, doc);
            
            // draw the image
            try (PDPageContentStream contents = new PDPageContentStream(doc, page))
            {
                PDRectangle box = page.getMediaBox();
                double factor = Math.min(box.getWidth() / nodeSpace.getWidth(), box.getHeight() / nodeSpace.getHeight());

                float height = (float) (nodeSpace.getHeight() * factor);

                // beware of inverted y axis here
                contents.drawImage(pdImage, 0, box.getHeight() - height, (float) (nodeSpace.getWidth() * factor), height);
                
            }
            
            String str = file.toString();
            int indexOfLast = str.lastIndexOf(".");
            String pdfPath = str;
            if(indexOfLast >= 0) 
            	pdfPath = str.substring(0, indexOfLast) + ".pdf";
            
            doc.save(pdfPath);
            Files.delete(file.toPath());
        }
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
	
	public void toggleBoxEdit() {
		if(editPane.isVisible() == true) {
			editPane.setVisible(false);
		} else {
			editPane.setVisible(true);
		}
	}
	
	public void setLight() {
		root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		root.getStylesheets().remove(getClass().getResource("DarkMode.css").toExternalForm());
		root.getStylesheets().remove(getClass().getResource("SMode.css").toExternalForm());
	}
	
	public void setDark() {
		root.getStylesheets().add(getClass().getResource("DarkMode.css").toExternalForm());
		root.getStylesheets().remove(getClass().getResource("application.css").toExternalForm());
		root.getStylesheets().remove(getClass().getResource("SMode.css").toExternalForm());
	}
	
	public void setSpaget() {
		root.getStylesheets().add(getClass().getResource("SMode.css").toExternalForm());
		root.getStylesheets().remove(getClass().getResource("application.css").toExternalForm());
		root.getStylesheets().remove(getClass().getResource("DarkMode.css").toExternalForm());
	}
	
}