package application;

import java.util.*;

public class ID {

	UUID uniqueID;
	ArrayList<UUID> UUIDlist = new ArrayList<UUID>();
	ArrayList<classBox> nodeList = new ArrayList<classBox>();

	public UUID ID(classBox cB) {
		uniqueID = UUID.randomUUID();
		UUIDlist.add(uniqueID);
		nodeList.add(cB);
		return uniqueID;
	}

	public String toString() {
		return this.uniqueID.toString();
	}

	/*
	 * This assumes that we aren't DELETING any nodes, therefore all ID's and
	 * classboxes (assuming we only use classboxes) are in the same index with
	 * respect to each other.
	 * 
	 * This may need tinkered in the future if changes are made
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
