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
	
	private ID End1; 
	private ID End2;
	private String title = "";
	private String multiplicity1 = ""; 
	private String multiplicity2 = ""; 
	private boolean isdashed = false;
	private arrow arrow1 = new arrow();
	private arrow arrow2 = new arrow();
	

	
	//-----getters----getters----getters----
	
	public classBox getEnd1(){
		return this.End1.getClassBox();
	}
	
	public classBox getEnd2(){
		return this.End2.getClassBox();
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
	
	//-----setters----setters----setters----setters----
	
	public void setRelationship(classBox head, classBox tail){ //setRelationship(clicked, released)
		this.End1 = head.getID();
		this.End2 = tail.getID();
		End1.getClassBox().addConnection(this);
		if (End1 != End2) //TO AVOID DOUBLING THE EFFECT IF CREATING A RELATIONSHIP WITH SELF
			End2.getClassBox().addConnection(this);
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
	
	public int setArrow1(int t){
		if( t >= 1 && t <=6 ){
			arrow1.type = t;
			return t;
		} else {
			System.out.println("setArrow1(): Bad Arrow Type: "+t+" not in range!");
			return 0;
		}
	}
	
	public int setArrow2(int t){
		if( t >= 1 && t <=6 ){
			arrow2.type = t;
			return t;
		} else {
			System.out.println("setArrow2(): Bad Arrow Type: "+t+" not in range!");
			return 0;
		}
	}
}

