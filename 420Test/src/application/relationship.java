package application;

public class relationship {
	private classBox End1;
	private classBox End2;
	private String title = "";
	private String End1relationship = "*..*"; //Can anyone think of a better title for these?
	private String End2relationship = "*..*"; // you know.. the 1..* and 0..1's and shit
	
	/*
	 * Needed: 	-Line Type
	 * 			-Arrow Type for both end1 and end 2
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
	
	public String getEnd1rel(){
		return this.End1relationship;
	}
	
	public String getEnd2rel(){
		return this.End2relationship;
	}
	
	//-----setters
	public void setRelationshipTitle(String s){
		this.title = s;
	}
	
	public void setEnd1rel(String s){
		this.End1relationship = s;
	}
	
	public void setEnd2rel(String s){
		this.End2relationship = s;
	}
}
