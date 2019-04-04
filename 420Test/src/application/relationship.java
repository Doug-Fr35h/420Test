package application;

import java.util.*;

/*enum arrowType
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

	//-----GETTERS-----GETTERS-----GETTERS-----GETTERS-----GETTERS-----GETTERS
	
	public classBox getEnd1(){
		return this.End1;
	}
	
	public classBox getEnd2(){
		return this.End2;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getMultiplicity1(){
		return this.multiplicity1;
	}
	
	public String getMultiplicity2(){
		return this.multiplicity2;
	}
	
	public boolean isDashed(){
		return this.isdashed;
	}
	
	/*public EnumSet<arrowType> getArrow1(){
		return this.arrow1.type;
	}
	
	public EnumSet<arrowType> getArrow2(){
		return this.arrow2.type;
	}/**/
	
	public int getArrow1(){
		return this.arrow1.type;
	}
	
	public int getArrow2(){
		return this.arrow2.type;
	}
	
	//-----SETTERS-----SETTERS-----SETTERS-----SETTERS-----SETTERS-----SETTERS
	
	public void setRelationship(classBox head, classBox tail){ //setRelationship(clicked, released)
		this.End1 = head;
		this.End2 = tail;
		End1.addConnection(this); 
		if (End1 != End2) //TO AVOID DOUBLING THE EFFECT IF CREATING A RELATIONSHIP WITH SELF
			End2.addConnection(this);
	}
	
	public void setRelationshipTitle(String s){
		this.title = s;
	}
	
	public void setMultiplicity1(String s){
		this.multiplicity1 = s;
	}
	
	public void setMultiplicity2(String s){
		this.multiplicity2 = s;
	}
	
	public void dash(){
		this.isdashed = true;
	}
	
	public void undash(){
		this.isdashed = false;
	}
	
	public void toggleDash(){
		this.isdashed = !isdashed;
	}
	
	/*public void setArrow1(EnumSet<arrowType> type){
		arrow1.type.
	}/**/
	
	public void setArrow1(int t){
		if( t >= 1 && t <=6 ){
			arrow1.type = t;
		} else {
			System.out.println("setArrow1(): Bad Arrow Type: "+t+" not in range!"); 
		}
	}
	
	public void setArrow2(int t){
		if( t >= 1 && t <=6 ){
			arrow2.type = t;
		} else {
			System.out.println("setArrow2(): Bad Arrow Type: "+t+" not in range!");
		}
	}
}

