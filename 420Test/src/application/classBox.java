package application;

import java.util.HashMap;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * classBox is a model-end representation of the class box object in a UML diagram. 
 * 		It represents only data about the class boxes and storable data for the view
 * 		so that the view can solely reflect the model (such as location, width, and height) 
 * @author zacharygarrettwhelpley
 */
public class classBox {
	
	// classBox Variables
	private String title;
	private String attributes;
	private String operations;
	private String extraComponents;
	private double xLocation;
	private double yLocation;
	private relationship[] connections;
	private ID uniqueID;
	private double width; //100 default
	private double height; //130 default

	/**
	 * classBox object constructor, contains default values
	 */
	public classBox() {
		this.title = "Title";
		this.attributes = "-";
		this.operations = "-";
		this.extraComponents = "";
		this.xLocation = 20.; // PREFER TO SET THIS TO MOUSE LOCATION
		this.yLocation = 20.; // ANYBODY KNOW ANYTHING ABOUT THAT?
		this.connections = new relationship[1];
		this.uniqueID = new ID(this);
		this.width = 100;
		this.height = 130;
		//IDmap.put(this.uniqueID, this);
		
	}
	
	/**
	 *  delete function deletes all relationships of a box
	 *  and then deletes itself from the map
	 */
	public void delete(){
		for (int i = 0; i < this.connections.length; i++){ //delete all relationships first
			connections[i].delete();
			connections[i] = null;
		}
		this.uniqueID.classBoxIDmap.remove(uniqueID);
		this.title = null;
		this.attributes = null;
		this.operations = null;
		this.extraComponents = null;
		this.connections = null;
		
	}
	
	//---SETTER---SETTER---SETTER---SETTER---SETTER---SETTER---SETTER---SETTER---
	/**
	 * setTitle takes in a string and sets the title to the new passed in string
	 * @param newTitle
	 */
	public void setTitle(String newTitle){
		this.title = newTitle;
	}
	
	/**
	 * setWidth takes in a double and sets the width to that double
	 * assuming that it is greater than zero (an acceptable value)
	 * @param newWidth
	 */
	public void setWidth(double newWidth){
		if (newWidth > 0)
			this.width = newWidth;
	}
	
	/**
	 * setHeight takes in a double and sets the height to that double
	 * assuming that it is greater than zero (an acceptable value)
	 * @param newHeight
	 */
	public void setHeight(double newHeight){
		if (newHeight > 0)
			this.height = newHeight;
	}
	
	/**
	 *For a possible automatic adjuster, just add 10 until satisfied 
	 */
	public void bumpHeight(){
		this.height+=10;
	}
	
	/**
	 * decrements height by 5
	 */
	public void trimHeight(){
		this.height-=5;
	}
	
	/**
	 * addConnection takes in a relationship and adds it to the list of relationships
	 * if the list of connections is full, it will expand the array, but also places 
	 * relationship in the last first null spot
	 * @param R
	 */
	public void addConnection(relationship R){
		//System.out.println("addConnction() entered:");
		//this.printConnections();
		// if the last index is not null || if this array is full
		if (this.connections[this.connections.length-1] != null){
			//System.out.println("Resize Needed");
			relationship[] conn2 = new relationship[this.connections.length+5];
			for (int i = 0; i <= this.connections.length-1; i++){
				conn2[i] = this.connections[i];//copy the array somewhere else
			}
			this.connections = conn2;//use the new array
			//System.out.println("New Size:" + this.connections.length);
		}
		int i = 0;
		while (this.connections[i] != null){ //find the next empty spot
			i++;
		}
		//this.printConnections();
		connections[i] = R; //and fill the relationship in that empty spot
		
	}
	
	/** 
	 * setAttributes takes a string and sets attributes to that string
	 * @param newAttr
	 */
	public void setAttributes(String newAttr){
		this.attributes = newAttr;
	}
	
	/**
	 * setOperatons takes a string and sets operations to that string
	 * @param newOpps
	 */
	public void setOperations(String newOpps){
		this.operations = newOpps;
	}
	
	/**
	 * setExtraComponents takes a string and sets extraComponents to that string
	 * @param newEC
	 */
	public void setExtraComponents(String newEC){
		this.extraComponents = newEC;
	}
	
	/**
	 * accepts an ordered pair and sets the location to that ordered pair
	 * this uses both x and y because duh
	 * @param x
	 * @param y
	 */
	public void setLocation(double x, double y){
		this.xLocation = x;
		this.yLocation = y;
	}
	
	//---GETTERS---GETTERS---GETTERS---GETTERS---GETTERS---GETTERS---GETTERS---GETTERS---
	/**
	 * @return the title
	 */
	public String getTitle(){
		return this.title;
	}
	
	/**
	 * @return the attributes string
	 */
	public String getAttributes(){
		return this.attributes;
	}
	
	/**
	 * @return the operations string
	 */
	public String getOperations(){
		return this.operations;
	}
	
	/**
	 * @return the extraComponents string
	 */
	public String getExtraComponents(){
		return this.extraComponents;
	}
	
	/**
	 * Gives back the length minus the number of null
	 * cases (so the number of real relationships)
	 * @return number of relationships
	 */
	public int getRelationshipCount(){
		int count =  this.connections.length;
		for (int i=0; i < count; i++){
			if (this.connections[i] == null){
				count --;
			}
		}
		return count;
	}

	/**
	 * Gives back the actual length, nulls included
	 * @return length of relationship array
	 */
	public int getRelationshipLength(){
		return this.connections.length;
	}
	
	/**
	 * returns the classBox at the other end of a relationship
	 * @param R is the relationship refering to
	 * @return the classBox that exists at the end of
	 * 		the relationship refered to
	 */
	public classBox getOtherEnd(relationship R){
		if (R.getEnd1() == this){
			return R.getEnd2();
		} else if (R.getEnd2() == this){
			return R.getEnd1();
		} else {
			return null;
		}
	}
	
	/**
	 * Accesses the connections[] array at passed in index
	 * @param index of array 
	 * @return the relationship refered to in the the relationship array
	 */
	public relationship getRelIndexOf(int index){
		if (index >= 0 && index < connections.length){
			return connections[index];
		}
		System.out.println("RelIndexOf says: Bad Index");
		return null;
	}
	
	/**
	 * @return the width of the classBox
	 */
	public double getWidth(){
		return this.width;
	}
	
	/**
	 * @return the height of the classBox
	 */
	public double getHeight(){
		return this.height;
	}
	
	//get location
		/**
		 * @return x coord
		 */
		public double getXLocation(){
			return this.xLocation;
		}
		/**
		 * @return y coord
		 */
		public double getYLocation(){
			return this.yLocation;
		}
	
	/**
	* @return the ID of classbox at hand
	*/
	public ID getID(){
		return this.uniqueID;
	}
	
	
	/**
	 * In grid fashion, this method prints out the array of connections
	 * Box's connections-----------------------------
	 * | R1     | R2     | null   | null   | null   |
	 * 1--------2--------3--------4--------5--------6
	 */
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
	
	
	
}/**/
