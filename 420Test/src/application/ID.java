package application;

import java.util.*;

public class ID {

	private UUID uniqueID;
	public Map< UUID,classBox> IDmap = new HashMap< UUID,classBox>(); 

	/*
	 * Constructor / assigns UUID
	 */
	public UUID ID(classBox cB) {
		uniqueID = UUID.randomUUID();
		IDmap.put(uniqueID, cB);
		return uniqueID;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.uniqueID.toString();
	}

	public classBox getClassBox() {
		return IDmap.get(this);
	}

	/*
	 * Relay Functions: Why? Just to cover bases. 
	 * 			there were a few instances where
	 * 			scope and stuff got in the way bc
	 * 			it was box1.id.getTitle or something
	 * 			and a rewrite seemed odd. Should have
	 * 			cited this instance.... 
	 * The goal: Write in such a way that we don't 
	 * 			even use these. However, some existing
	 * 			code didn't like the recent change to
	 * 			End1 and End2 class changing from 
	 * 			classBox to ID. And it looks better 
	 * 			in those files to leave as is instead of 
	 * 			having head.getClassBox().getTitle or 
	 * 			longer cases in there. It gets ugly. 
	 * 
	 * 			Stay Sharp my dudes
	 * /
				public String getTitle(){
					return this.getClassBox().getTitle();
				}
			
				public double getXLocation(){
					return this.getClassBox().getXLocation();
				}
				
				public double getYLocation(){
					return this.getClassBox().getYLocation();
				}
			
				public String getAttributes(){
					return this.getClassBox().getAttributes();
				}
			
				public String getExtraComponents(){
					return this.getClassBox().getExtraComponents();
				}
			
				public String getOperations(){
					return this.getClassBox().getOperations();
				}/**/
	
}
