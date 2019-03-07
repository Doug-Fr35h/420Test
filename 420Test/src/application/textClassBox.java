package application;

public class textClassBox {

	public static void main(String[] args) {
		classBox box1 = new classBox();
		System.out.println("box1's title:      " + box1.getTitle());
		System.out.println("box1's Attributes: " + box1.getAttributes());
		
		System.out.println("------");
		
		classBox box2 = new classBox();
		System.out.println("box2's title:      " + box2.getTitle());
		System.out.println("box2's Attributes: " + box2.getAttributes());
		
		System.out.println("======");
		System.out.println("CHANGING TITLE AND ATTRIBUTES");
		System.out.println("======");
		
		box1.setTitle("Box1's Title");
		box1.setAttributes("Hello \n"
				+ "this is an attribute \n"
				+ "line 3 -- End Box1 attr.");
		box2.setTitle("Box2's Title");
		box2.setAttributes("One Line \n"
				+ "Two Line \n"
				+ "Three line");
		
		System.out.println("box1's title:      " + box1.getTitle());
		System.out.println("box1's Attributes: " + box1.getAttributes());
		System.out.println("------");
		
		System.out.println("box2's title:      " + box2.getTitle());
		System.out.println("box2's Attributes: " + box2.getAttributes());
		System.out.println("------");
		
		//System.out.println(box1.title); Does not work 

	}

}
