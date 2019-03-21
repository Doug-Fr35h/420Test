package application;

import java.util.*;

/*enum arrowType
{
	NONE, V_ARROW, EMPTYTRIANGLE, FILLEDTRIANGLE, EMPTYDIAMOND, FILLEDDIAMOND, //Add more as we find fit
	//1		2			3				4				5			6			Number Correspondent 
};	/**/	

public class relationship {

	static class arrow {
//		EnumSet<arrowType> type;
		int type;
	}
	
	private classBox End1;
	private classBox End2;
	private String title = "";
	private String multiplicity1 = ""; //Can anyone think of a better title for these?
	private String multiplicity2 = ""; // you know.. the 1..* and 0..1's and shit
	private boolean isDashed = false;
	private arrow arrow1 = new arrow();
	private arrow arrow2 = new arrow();
	

	
	/*
	 * Needed: 		-Arrow Type for both end1 and end 2
	 * 				-therefore, a set of types for both line and arrow with checks
	 * 
	 * Thoughts: 
	 * 		1) please please PLEASE figure out something to rename most of these variables
	 * 
	 * 		2) Perhaps the "1..*"'s and all that could be reduced to 2 chars where we ask for
	 * 			min and max and set the format appropriately rather than allow the user to 
	 * 			put whatever shit they want in there. 
	 */
	/*
	 * Thoughts on this style in setting relationship ends, we could do it
	 * in one click and drag, keeping tabs on the thing clicked on and the 
	 * thing released on and pass them in as such. Makes sense, as relationships
	 * will stick to their end-partners and the idea of moving one end from
	 * one node to a separate 3rd node seems kinda.... not wise. And I think our JFLAP 
	 * vision would concur with that
	 * 
	 * its simple too
	 */
	public void setRelationship(classBox A, classBox B){
		this.End1 = A;
		this.End2 = B;
	}
	
	//-----getters
	
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
		return this.isDashed;
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
	
	//-----setters
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
		this.isDashed = true;
	}
	
	public void undash(){
		this.isDashed = false;
	}
	
	public void toggleDash(){
		this.isDashed = !isDashed;
	}
	
	/*public void setArrow1(EnumSet<arrowType> type){
		arrow1.type.
	}/**/
	
	public int setArrow1(int t){
		if( t >= 1 && t <=6 ){
			arrow1.type = t;
			return t;
		} else {
			System.out.println("setArrow1(): Bad Arrow Type!");
			return 0;
		}
	}
	
	public int setArrow2(int t){
		if( t >= 1 && t <=6 ){
			arrow2.type = t;
			return t;
		} else {
			System.out.println("setArrow2(): Bad Arrow Type!");
			return 0;
		}
	}
}

