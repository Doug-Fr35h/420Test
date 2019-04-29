package application;

import java.util.*;

/**
 * 
 * @author zacharygarrettwhelpley
 *
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
	 * 
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
	 * 
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
	 * 
	 * @return
	 */
	public UUID getID(){
		return this.uniqueID;
	}
	
	/** 
	 * 
	 */
	public String toString() {
		return this.uniqueID.toString();
	}

	/**
	 * 
	 * @return
	 */
	public classBox getClassBox() {
		return classBoxIDmap.get(this);
	}
	
	/**
	 * 
	 * @return
	 */
	public relationship getRelationship() {
		return relationshipIDmap.get(this);
	}
	
}
