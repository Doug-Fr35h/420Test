package application;

import java.util.*;

public class ID {

	private UUID uniqueID;
	public Map< UUID,classBox> classBoxIDmap = new HashMap< UUID,classBox>();
	public Map< UUID,relationship> relationshipIDmap = new HashMap< UUID,relationship>();

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
	
}
