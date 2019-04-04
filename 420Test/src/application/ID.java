package application;

import java.util.*;

/*
 * ID class as it stands right now, assigns uuid's, keeps track of them
 * and also classBoxes to know what ID's are assigned to what boxes, 
 * 
 * In Future Iters: It will only assign ID's 
 * 		classBox.java will remember all ID's using mapping
 * 		the relay functions may be eliminated as well. Thats
 * 		future-Us's problem to figure out. 
 */

public class ID {

	UUID uniqueID;
	ArrayList<UUID> UUIDlist = new ArrayList<UUID>();
	ArrayList<classBox> nodeList = new ArrayList<classBox>();
//	UUID[] UUIDlist = new UUID[];

	/*
	 * Constructor / assigns UUID
	 */
	public UUID ID(classBox cB) {
		uniqueID = UUID.randomUUID();
		UUIDlist.add(uniqueID);
		nodeList.add(cB);
		return uniqueID;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.uniqueID.toString();
	}

	/*
	 * This assumes that we aren't DELETING any nodes, therefore all ID's and
	 * classboxes (assuming we only use classboxes) are in the same index with
	 * respect to each other.
	 * 
	 * This may need tinkered in the future if changes are made
	 * 
	 * UPDATE: This WILL be tinkered in the sense that it won't exist here
	 * and will be relocated and completely rewritten in classBox.java
	 */
	public classBox getClassBox(UUID id) {
		int index = UUIDlist.indexOf(id);
		return nodeList.get(index);
	}

	public classBox getClassBox() {
		return nodeList.get(UUIDlist.indexOf(this));
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
	 */
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
				}
	
}
