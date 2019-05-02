package application;

import java.util.*;

/*
{
	NONE, V_ARROW, EMPTYTRIANGLE, FILLEDTRIANGLE, EMPTYDIAMOND, FILLEDDIAMOND, //Add more as we find fit
	//1		2			3				4				5			6			Number Correspondent 
};	/**/	
/**
 * relationship class models the relationships (lines) between objects in a UML diagram. In this model, 
 * a relationship is aware of who it connects and also all the attributes of a line such as the title,
 * multiplicities, arrow head, and if its dashed or not. Relationships recieve an ID
 * @author zacharygarrettwhelpley
 *
 */
public class relationship {

	//relationship variables
	static class arrow {int type;} //if this implementation sticks, just use ints, but for now.
	private classBox End1; 		//		because we don't know if we'll actully use the arrow
	private classBox End2;		//		class in a better way, we'll just keep it as is.
	private String title = "";
	private String multiplicity1 = ""; 
	private String multiplicity2 = ""; 
	private boolean isdashed = false;
	private arrow arrow1 = new arrow();
	private arrow arrow2 = new arrow();
	private ID uniqueID;
	
	/**  
	 * constructor for a relationship must have a head end and a tail end, defaults 
	 * to a very basic line
	 * @param head
	 * @param tail
	 */
	public relationship(classBox head, classBox tail){
		this.setRelationship(head, tail);
		this.title = "";
		this.multiplicity1 = "";
		this.multiplicity2 = "";
		this.isdashed = false;
		this.setArrow1(1);
		this.setArrow2(1);
		this.uniqueID = new ID(this);
	}
	
	/**
	 * constructor for a blank relationship for testing purposes only, the application
	 * itself should never reach this method. 
	 */
	public relationship(){
		this.title = "";
		this.multiplicity1 = "";
		this.multiplicity2 = "";
		this.isdashed = false;
		this.setArrow1(1);
		this.setArrow2(1);
		this.uniqueID = new ID(this);
		
	}
	
	/**
	 * delete function erases all values and removes it from the map, garbage collection will
	 * take care of the rest
	 */
	public void delete(){
		this.End1 = null;
		this.End2 = null;
		this.title = null;
		this.multiplicity1 = null;
		this.multiplicity2 = null;
		this.arrow1 = null;
		this.arrow2 = null;
		uniqueID.relationshipIDmap.remove(uniqueID);
	}

	//-----GETTERS-----GETTERS-----GETTERS-----GETTERS-----GETTERS-----GETTERS
	
	/**
	 * @return this relationships ID
	 */
	public ID getID(){
		return this.uniqueID;
	}
	
	/**
	 * @return a particular end of the relationship, End1
	 */
	public classBox getEnd1(){
		return this.End1;
	}
	
	/**
	 * @return a particular end of the relationship, End2
	 */
	public classBox getEnd2(){
		return this.End2;
	}
	
	/**
	 * @return this relationships title
	 */
	public String getTitle(){
		return this.title;
	}
	
	/**
	 * @return this relationships multiplicity on end1
	 */
	public String getMultiplicity1(){
		return this.multiplicity1;
	}
	
	/**
	 * @return this relationships multiplicity on end2
	 */
	public String getMultiplicity2(){
		return this.multiplicity2;
	}
	
	/**
	 * @return true if dashed, false if solid
	 */
	public boolean isDashed(){
		return this.isdashed;
	}
	
	/*public EnumSet<arrowType> getArrow1(){
		return this.arrow1.type;
	}
	
	public EnumSet<arrowType> getArrow2(){
		return this.arrow2.type;
	}/**/
	
	/**
	 * @return the arrow head type on end1
	 */
	public int getArrow1(){
		return this.arrow1.type;
	}
	
	/**
	 * @return the arrow head type on end2
	 */
	public int getArrow2(){
		return this.arrow2.type;
	}
	
	//-----SETTERS-----SETTERS-----SETTERS-----SETTERS-----SETTERS-----SETTERS
	
	/**
	 * setRelationship takes in 2 classboxes and sets them as the ends of the relationship
	 * and adds that relationship to those classBox's list of relationships. If the relationship
	 * is self-referencing, the connection is only added once instead of twice. 
	 * @param head
	 * @param tail
	 */
	public void setRelationship(classBox head, classBox tail){ //setRelationship(clicked, released)
		this.End1 = head;
		this.End2 = tail;
		End1.addConnection(this); 
		if (End1 != End2) //TO AVOID DOUBLING THE EFFECT IF CREATING A RELATIONSHIP WITH SELF
			End2.addConnection(this);
	}
	
	/**
	 * takes in a string and sets this relationships title to that string
	 * @param s
	 */
	public void setTitle(String s){
		this.title = s;
	}
	
	/**
	 * takes in a string and sets this relationships multiplicity on end 1 to that string
	 * @param s
	 */
	public void setMultiplicity1(String s){
		this.multiplicity1 = s;
	}
	
	/**
	 * takes in a string and sets this relationships multiplicity on end 2 to that string
	 * @param s
	 */
	public void setMultiplicity2(String s){
		this.multiplicity2 = s;
	}
	
	/**
	 * dashes the line
	 */
	public void dash(){
		this.isdashed = true;
	}
	
	/**
	 * makes the line solid
	 */
	public void undash(){
		this.isdashed = false;
	}
	
	/**
	 * changes the line from solid to dashed or visa versa
	 */
	public void toggleDash(){
		this.isdashed = !isdashed;
	}
	
	/*public void setArrow1(EnumSet<arrowType> type){
		arrow1.type.
	}/**/
	
	/**
	 * sets the arrow type on end 1 to the specified arrow type assuming 
	 * that the type specified is a valid type
	 * @param t
	 */
	public void setArrow1(int t){
		if( t >= 1 && t <=6 ){
			arrow1.type = t;
		} else {
			System.out.println("setArrow1(): Bad Arrow Type: "+t+" not in range!"); 
		}
	}
	
	/**
	 * sets the arrow type on end 2 to the specified arrow type assuming 
	 * that the type specified is a valid type
	 * @param t
	 */
	public void setArrow2(int t){
		if( t >= 1 && t <=6 ){
			arrow2.type = t;
		} else {
			System.out.println("setArrow2(): Bad Arrow Type: "+t+" not in range!");
		}
	}
}

