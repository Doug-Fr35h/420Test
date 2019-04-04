/*
 * THIS DOESN'T WORK YET
 * 
 * FOR FUTURE ITERS
 * 	The idea would be to have nodeFactory follow the factory
 * 	model... unlike what its doing here. That being said:
 * 	everything below can pretty much be ignored for now.
 */

package application;

public class nodeFactory {
	private String title;
	private double xLocation;
	private double yLocation;
	private relationship[] connections;
//	classBox cB;
//	stickFigure sF;
//	simpleBox sB;
	
/*	public class classBox extends node {
		private String attributes;
		private String operations;
		private String extraComponents;
		
		public classBox() {
			super.title = "~classBox~";
			this.attributes = "-";
			this.operations = "-";
			this.extraComponents = "";
			super.xLocation = 20.; // PREFER TO SET THIS TO MOUSE LOCATION
			super.yLocation = 20.; // ANYBODY KNOW ANYTHING ABOUT THAT?
			super.connections = new relationship[5];
		}
		
		//setters-----setters-----setters-----setters-----
		public void setAttributes(String newAttr){
			this.attributes = newAttr;
		}
		
		public void setOperations(String newOpps){
			this.operations = newOpps;
		}
		
		public void setExtraComponents(String newEC){
			this.extraComponents = newEC;
		}
		
		//getters------getters------getters------getters----
		public String getAttributes(){
			return this.attributes;
		}
		
		public String getOperations(){
			return this.operations;
		}
		
		public String getExtraComponents(){
			return this.extraComponents;
		}
	}/**/
	
	public class stickFigure extends nodeFactory {
		private int[] color; 
		public stickFigure (){
			super.title = "~Character~";
			super.xLocation = 20.;
			super.yLocation = 20.;
			super.connections = new relationship[3];
			this.color = new int[3]; 
		}
		
		public String getColorString() {
			String color = "[";
			for (int i = 0; i < 3; i++){
				color += (this.color[i]%1000)/100;
				color += (this.color[i]%100)/10;
				color += (this.color[i]%10);
				if (i != 2)
					color += ",";
			}
			color+="]";
			return color;
		}
		
		public int getColor() {
			int c = 0;
			/*for (int i = 0; i <= 2; i++){
				c += array[i] * (1000^(2-i));
			}/**/
			c += this.color[2];//* 1
			c += this.color[1]   * 1000;
			c += this.color[0]   * 1000000;
			return c;
		}
		
		
		public void setColor(String colorText) {
			int r = 0;
			int g = 1;
			int b = 2;
			switch (colorText.toLowerCase()){
			case "black":
				this.color[r] = 0;
				this.color[g] = 0;
				this.color[b] = 0;
				break;
			case "red":
				this.color[r] = 255;
				this.color[g] = 0;
				this.color[b] = 0;
				break;
			case "green":
				this.color[r] = 0;
				this.color[g] = 255;
				this.color[b] = 0;
				break;
			case "blue":
				this.color[r] = 0;
				this.color[g] = 0;
				this.color[b] = 255;
				break;
			case "yellow":
				this.color[r] = 255;
				this.color[g] = 255;
				this.color[b] = 10;
				break;
			case "orange":
				this.color[r] = 255;
				this.color[g] = 145;
				this.color[b] = 10;
				break;
			case "magenta":
				this.color[r] = 255;
				this.color[g] = 0;
				this.color[b] = 255;
				break;
			default:
				this.color[r] = 0;
				this.color[g] = 0;
				this.color[b] = 0;
				break;
			}
		}

		public void setColor(int r, int g, int b){
			int R = 0;
			int G = 1;
			int B = 2;
			if (checkRGB(r) && checkRGB(g) && checkRGB(b)){
				this.color[R] = r;
				this.color[G] = g;
				this.color[B] = b;
			}
		}
		
		private boolean checkRGB(int v){
			return ((v >= 0) && (v <= 255));
		}
	}

	public class simpleBox extends nodeFactory {
		private String note;
		public simpleBox(){
			super.title = "~simpleBox~";
			super.xLocation = 20.;
			super.yLocation = 20.;
			super.connections = new relationship[5];
			this.note = "";
		}
		
		public void setNote(String s){
			this.note = s;
		}
		
		public String getNote(){
			return this.note;
		}
		
	}

	public void node(classBox e){
		
	}
	
	public void setTitle(String newTitle){
		this.title = newTitle;
	}
	
	public void addConnection(relationship R){
		System.out.println("addConnction() entered:");
		this.printConnections();
		if (this.connections[this.connections.length-1] != null){
			System.out.println("Resize Needed");
			relationship[] conn2 = new relationship[this.connections.length+5];
			for (int i = 0; i <= this.connections.length-1; i++){
				conn2[i] = this.connections[i];
			}
			this.connections = conn2;
			System.out.println("New Size:" + this.connections.length);
		}
		int i = 0;
		while (this.connections[i] != null){
			i++;
		}
		this.printConnections();
		this.connections[i] = R;
		
	}
	
	public void printConnections(){
		System.out.print(this.title + "'s connections");
		for(int i = 1; i<= (this.connections.length * 10) - (this.title.length() + 14); i++)
			System.out.print("=");
		System.out.print("\n");
		for(int i = 0; i < this.connections.length; i++){
			if(this.connections[i] == null){
				System.out.printf(" %-8s|", "null");
			}else{
				System.out.printf(" %-8s|",this.connections[i].getTitle());
			}
		}
		System.out.println();
		for(int i = 0; i < this.connections.length; i++)
			System.out.print("-" +i+"-------+");
		System.out.println();
	}
	
	public void updateLocation(double x, double y){
		this.xLocation = x;
		this.yLocation = y;
	}
	
	//---getters---
	public String getTitle(){
		return this.title;
	}
	
	public double getXLocation(){
		return this.xLocation;
	}
	
	public double getYLocation(){
		return this.yLocation;
	}
}
