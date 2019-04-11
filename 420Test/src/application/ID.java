package application;

import java.util.*;

public class ID {

	private UUID uniqueID;
	public Map< UUID,classBox> classBoxIDmap = new HashMap< UUID,classBox>();
	public Map< UUID,relationship> relationshipIDmap = new HashMap< UUID,relationship>();

	/*
	 * Constructor / assigns UUID
	 */
	/*public ID(){
		uniqueID = UUID.randomUUID();
		Class.forName(Thread.currentThread().getStackTrace()[2].getClassName())
		if (caller.class = classBox){
			classBoxIDmap.put(uniqueID, caller);
		} else if (caller.class = relationship){
			relationshipIDmap.put(uniqueID, caller);
		}	
		
	}/**/
	
	public ID(classBox cB) {
		uniqueID = UUID.randomUUID();
		classBoxIDmap.put(uniqueID, cB);
		System.out.println("Create ID for classBox " + cB.getTitle() + ": "+uniqueID);
		System.out.println("Also known as this: " + this);
		//return this;
	}
	
	public ID(relationship R){
		uniqueID = UUID.randomUUID();
		relationshipIDmap.put(uniqueID, R);
		System.out.println("Create ID for relationship " + R.getTitle() + ": "+uniqueID);
		System.out.println("Also known as this: " + this);
		//return this;
	}
	
	public UUID getID(){
		return this.uniqueID;
	}
	

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.uniqueID.toString();
	}

	public classBox getClassBox() {
		return classBoxIDmap.get(this);
	}
	
	public relationship getRelationship() {
		return relationshipIDmap.get(this);
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
