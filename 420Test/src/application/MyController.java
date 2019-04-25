package application;

import java.awt.Button;
import java.awt.Desktop;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

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
	private TextField titleText;
	
	@FXML
	private MenuItem loadFile;
	
	@FXML
	private VBox editPane;
	
	public static ArrayList<Box> boxes = new ArrayList<Box>(10);
	
	public ArrayList<Line> lines = new ArrayList<Line>(10);
	
	@FXML
	FileChooser fc = new FileChooser();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//propSpace.getChildren().add(titleText);		
		

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
		//FileChooser fc = new FileChooser();
		
		File file = fc.showOpenDialog(nodeSpace.getScene().getWindow());
		Scanner scanner = new Scanner(file);
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
	public void exportToPNG() throws IOException{
		FileChooser fileChooser = new FileChooser();

	    //Set extension filter
	    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png"));

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
	    /*
	    try (PDDocument doc = new PDDocument())
        {
            PDPage page = new PDPage();
            doc.addPage(page);
            
            String imagePath = file.toString();

            // createFromFile is the easiest way with an image file
            // if you already have the image in a BufferedImage, 
            // call LosslessFactory.createFromImage() instead
            PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, doc);
            
            // draw the image at full size at (x=20, y=20)
            try (PDPageContentStream contents = new PDPageContentStream(doc, page))
            {
                // draw the image at full size at (x=20, y=20)
                contents.drawImage(pdImage, 20, 20);
                
                // to draw the image at half size at (x=20, y=20) use
                // contents.drawImage(pdImage, 20, 20, pdImage.getWidth() / 2, pdImage.getHeight() / 2); 
            }
            
            String str = file.toString();
            int indexOfLast = str.lastIndexOf(".");
            String pdfPath = str;
            if(indexOfLast >= 0) 
            	pdfPath = str.substring(0, indexOfLast) + ".pdf";
            
            doc.save(pdfPath);
        }
	    /*
	    
	    
	   //Convert FIle to String method
	    /*
	    
	    String str = file.toString();
        System.out.println(str);
        int indexOfLast = str.lastIndexOf(".");
        String pdfPath = str;
        if(indexOfLast >= 0) 
        	pdfPath = str.substring(0, indexOfLast) + ".pdf";
        System.out.println(pdfPath);
        */
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
	

}