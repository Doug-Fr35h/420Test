package application;

import java.util.*;

public class ID {
	
	UUID uniqueID;
	ArrayList<UUID> UUIDlist = new ArrayList<UUID>();
	ArrayList<classBox> nodeList = new ArrayList<classBox>();
	
	public UUID ID(classBox cB){
		uniqueID = UUID.randomUUID();
		UUIDlist.add(uniqueID);
		nodeList.add(cB);
		return uniqueID;
	}
	
	public String toString(){
		return this.uniqueID.toString();
	}
	
	/*
	 * This assumes that we aren't DELETING any nodes, therefore all
	 * ID's and classboxes (assuming we only use classboxes) are in 
	 * the same index with respect to each other.  
	 * 
	 * This may need tinkered in the future if changes are made
	 */
	public classBox getClassBox(UUID id){
		int index = UUIDlist.indexOf(id);
		return nodeList.get(index);
	}
	
}
