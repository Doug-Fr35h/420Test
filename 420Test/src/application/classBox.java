package application;

import java.util.HashMap;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * 
 * @author zacharygarrettwhelpley
 *
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
	 * 
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
	 * 
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
	 * 
	 * @param newTitle
	 */
	public void setTitle(String newTitle){
		title = newTitle;
	}
	
	/**
	 * 
	 * @param newWidth
	 */
	public void setWidth(double newWidth){
		if (newWidth > 0)
			this.width = newWidth;
	}
	
	/**
	 * 
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
		height+=10;
	}
	
	/**
	 * 
	 */
	public void trimHeight(){
		height-=5;
	}
	
	/**
	 * 
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
	 * 
	 * @param newAttr
	 */
	public void setAttributes(String newAttr){
		this.attributes = newAttr;
	}
	
	/**
	 * 
	 * @param newOpps
	 */
	public void setOperations(String newOpps){
		this.operations = newOpps;
	}
	
	/**
	 * 
	 * @param newEC
	 */
	public void setExtraComponents(String newEC){
		this.extraComponents = newEC;
	}
	
	/**
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
	 * 
	 * @return
	 */
	public String getTitle(){
		return this.title;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAttributes(){
		return this.attributes;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getOperations(){
		return this.operations;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getExtraComponents(){
		return this.extraComponents;
	}
	
	/**
	 *
	 * Gives back the length minus the number of null
	 * cases (so the number of real relationships)
	 * @return
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
	 * @return
	 */
	public int getRelationshipLength(){
		return this.connections.length;
	}
	
	/**
	 *
	 * returns the classBox at the other end of a relationship
	 * @param R
	 * @return
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
	 * @param index
	 * @return
	 */
	public relationship getRelIndexOf(int index){
		if (index >= 0 && index < connections.length){
			return connections[index];
		}
		System.out.println("RelIndexOf says: Bad Index");
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getWidth(){
		return this.width;
	}
	
	/**
	 * 
	 * @return
	 */
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
	
	/**
	* 
	* @return
	*/
	public ID getID(){
		return this.uniqueID;
	}
	
	
	/**
	 * 
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
