package application;

public class classBox {
	
	private String title;
	private String attributes;
	private String operations;
	private String extraComponents;
	private double xLocation;
	private double yLocation;
	private relationship[] connections;
	

	//CONSTRUCTOR
	public classBox() {
		this.title = "Title";
		this.attributes = "-";
		this.operations = "-";
		this.extraComponents = "";
		this.xLocation = 20.; // PREFER TO SET THIS TO MOUSE LOCATION
		this.yLocation = 20.; // ANYBODY KNOW ANYTHING ABOUT THAT?
	}
	
	//---setters ---
	public void setTitle(String newTitle){
		title = newTitle;
	}
	
	/*
	 *  NOTE: These (as multi-lined text boxes, may require some
	 * additional finangling later on to include multiple lines
	 * I'm thinking like a while(hasNext), +=current line + \n
	 * kind of situation 
	 */
	public void setAttributes(String newAttr){
		this.attributes = newAttr;
	}
	
	public void setOperations(String newOpps){
		this.operations = newOpps;
	}
	
	public void setExtraComponents(String newEC){
		this.extraComponents = newEC;
	}
	
	//set/update location
	public void updateLocation(double x, double y){
		this.xLocation = x;
		this.yLocation = y;
	}
	
	//---getters---
	public String getTitle(){
		return this.title;
	}
	
	public String getAttributes(){
		return this.attributes;
	}
	
	public String getOperations(){
		return this.operations;
	}
	
	public String getExtraComponents(){
		return this.extraComponents;
	}
	
	//get location
	public double getXLocation(){
		return this.xLocation;
	}
	public double getYLocation(){
		return this.yLocation;
	}
	
}
