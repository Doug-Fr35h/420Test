package application;

import java.util.*;

public class ID {
	
	UUID uniqueID;
	ArrayList<UUID> UUIDlist = new ArrayList<UUID>();
	
	public UUID ID(){
		uniqueID = UUID.randomUUID();
		UUIDlist.add(uniqueID);
		return uniqueID;
	}
	
	public String toString(){
		return this.uniqueID.toString();
	}
	
}
