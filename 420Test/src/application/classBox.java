package application;

public class classBox {
	
	private String title;
	private String attributes;
	private String operations;
	private String extraComponents;
	private double xLocation;
	private double yLocation;
	private relationship[] connections;
	final private ID uniqueID;
	private double width; //100
	private double height; //130
	

	//CONSTRUCTOR
	public classBox() {
		this.title = "Title";
		this.attributes = "-";
		this.operations = "-";
		this.extraComponents = "";
		this.xLocation = 20.; // PREFER TO SET THIS TO MOUSE LOCATION
		this.yLocation = 20.; // ANYBODY KNOW ANYTHING ABOUT THAT?
		this.connections = new relationship[1];
		this.uniqueID = new ID();
		this.width = 100;
		this.height = 130;
	}
	
	//---setters ---
	public void setTitle(String newTitle){
		title = newTitle;
	}
	
	public void addConnection(relationship R){
		System.out.println("addConnction() entered:");
		this.printConnections();
		if (this.connections[this.connections.length-1] != null){
			System.out.println("Resize Needed");
			relationship[] conn2 = new relationship[this.connections.length+5];
			for (int i = 0; i <= this.connections.length-1; i++){
				conn2[i] = this.connections[i];
			}
			this.connections = conn2;
			System.out.println("New Size:" + this.connections.length);
		}
		int i = 0;
		while (this.connections[i] != null){
			i++;
		}
		this.printConnections();
		connections[i] = R;
		
	}
	
	public void printConnections(){
		System.out.print(this.title + "'s connections");
		for(int i = 1; i<= (this.connections.length * 10) - (this.title.length() + 14); i++)
			System.out.print("=");
		System.out.print("\n");
		for(int i = 0; i < this.connections.length; i++){
			if(this.connections[i] == null){
				System.out.printf(" %-8s|", "null");
			}else{
				System.out.printf(" %-8s|",this.connections[i].getTitle());
			}
		}
		System.out.println();
		for(int i = 0; i < this.connections.length; i++)
			System.out.print("-" +i+"-------+");
		System.out.println();
	}
	
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
	
	public int getRelationshipCount(){
		return this.connections.length;
	}
	
	public relationship getRelIndexOf(int index){
		if (index >= 0 && index < connections.length){
			return connections[index];
		}
		System.out.println("RelIndexOf says: Bad Index");
		return null;
	}
	
	public double getWidth(){
		return this.width;
	}
	
	public double getHeight(){
		return this.height;
	}
	//get location
	public double getXLocation(){
		return this.xLocation;
	}
	public double getYLocation(){
		return this.yLocation;
	}
	
	public ID getID(){
		return this.uniqueID;
	}
	
}/**/
