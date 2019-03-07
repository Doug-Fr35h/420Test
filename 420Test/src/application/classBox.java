package application;

public class classBox {
	
	String title;
	String attributes;
	String operations;
	String extraComponents;

	//CONSTRUCTOR
	public classBox() {
		this.title = "Title";
		this.attributes = "-";
		this.operations = "-";
		this.extraComponents = "";
	}
	
	//---setters ---
	public void setTitle(String newTitle){
		title = newTitle;
	}
	
	/*
	 * NOTE: These (as multi-lined text boxes, may require some
	 * additional finangling later on to include multiple lines
	 * I'm thinking like a while(hasNext), +=current line + \n
	 * kind of situation
	 */
	public void setAttributes(String newAttr){
		attributes = newAttr;
	}
	
	public void setOperations(String newOpps){
		operations = newOpps;
	}
	
	public void setExtraComponents(String newEC){
		extraComponents = newEC;
	}
	
	//---getters---
	public String getTitle(){
		return this.title;
	}
	
	public String getAttributes(){
		return attributes;
	}
	
	public String getOperations(){
		return operations;
	}
	
	public String getExtraComponents(){
		return extraComponents;
	}
	
}
