package application;

import java.util.*;

/*
{
	NONE, V_ARROW, EMPTYTRIANGLE, FILLEDTRIANGLE, EMPTYDIAMOND, FILLEDDIAMOND, //Add more as we find fit
	//1		2			3				4				5			6			Number Correspondent 
};	/**/	

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
	 * 
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
	 * 
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
	 * 
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
	 * 
	 * @return
	 */
	public ID getID(){
		return this.uniqueID;
	}
	
	/**
	 * 
	 * @return
	 */
	public classBox getEnd1(){
		return this.End1;
	}
	
	/**
	 * 
	 * @return
	 */
	public classBox getEnd2(){
		return this.End2;
	}
	
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
	public String getMultiplicity1(){
		return this.multiplicity1;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMultiplicity2(){
		return this.multiplicity2;
	}
	
	/**
	 * 
	 * @return
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
	 * 
	 * @return
	 */
	public int getArrow1(){
		return this.arrow1.type;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getArrow2(){
		return this.arrow2.type;
	}
	
	//-----SETTERS-----SETTERS-----SETTERS-----SETTERS-----SETTERS-----SETTERS
	
	/**
	 * 
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
	 * 
	 * @param s
	 */
	public void setTitle(String s){
		this.title = s;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setMultiplicity1(String s){
		this.multiplicity1 = s;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setMultiplicity2(String s){
		this.multiplicity2 = s;
	}
	
	/**
	 * 
	 */
	public void dash(){
		this.isdashed = true;
	}
	
	/**
	 * 
	 */
	public void undash(){
		this.isdashed = false;
	}
	
	/**
	 * 
	 */
	public void toggleDash(){
		this.isdashed = !isdashed;
	}
	
	/*public void setArrow1(EnumSet<arrowType> type){
		arrow1.type.
	}/**/
	
	/**
	 * 
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
	 * 
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

