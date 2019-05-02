package application;

import java.util.*;

/**
 * ID class creates unique identifiers for every object and maps those objects
 * using that id in a Map, and contains functions to use that map
 * @author zacharygarrettwhelpley
 */
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
	
	/**
	 * constructor for an ID on classBox
	 * @param cB
	 */
	public ID(classBox cB) {
		uniqueID = UUID.randomUUID();
		classBoxIDmap.put(uniqueID, cB);
		System.out.println("Create ID for classBox " + cB.getTitle() + ": "+uniqueID);
		System.out.println("Also known as this: " + this);
		//return this;
	}
	
	/**
	 * constructor for and ID on a relationship
	 * @param R
	 */
	public ID(relationship R){
		uniqueID = UUID.randomUUID();
		relationshipIDmap.put(uniqueID, R);
		System.out.println("Create ID for relationship " + R.getTitle() + ": "+uniqueID);
		System.out.println("Also known as this: " + this);
		//return this;
	}
	
	/**
	 * @return ID of an object
	 */
	public UUID getID(){
		return this.uniqueID;
	}
	
	/** 
	 * @return the ID in string form
	 */
	public String toString() {
		return this.uniqueID.toString();
	}

	/**
	 * @return classBox with this ID
	 */
	public classBox getClassBox() {
		return classBoxIDmap.get(this);
	}
	
	/**
	 * @return relationship with this ID
	 */
	public relationship getRelationship() {
		return relationshipIDmap.get(this);
	}
	
}
