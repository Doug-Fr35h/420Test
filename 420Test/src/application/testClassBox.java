package application;

public class testClassBox {

	public static void main(String[] args) {

		// MAKE BOX1
		
		classBox box1 = new classBox();
		System.out.println("box1's title:      " + box1.getTitle());
		System.out.println("box1's Attributes: " + box1.getAttributes());
		
		System.out.println("------");
		
		//MAKE BOX2
		
		classBox box2 = new classBox();
		System.out.println("box2's title:      " + box2.getTitle());
		System.out.println("box2's Attributes: " + box2.getAttributes());
		
		//DISPLAY DEFAULTED VLUES FOR BOTH BOXES
		
		System.out.println("======");
		System.out.println("CHANGING TITLE AND ATTRIBUTES");
		System.out.println("======");
		
		box1.setTitle("Box1");
		box1.setAttributes("Hello \n"
				+ "this is an attribute \n"
				+ "line 3 -- End Box1 attr.");
		box2.setTitle("Box2");
		box2.setAttributes("One Line \n"
				+ "Two Line \n"
				+ "Three line");
		
		//DISPLAY NEW ATTRIBUTES
		
		System.out.println("box1's title:      " + box1.getTitle());
		System.out.println("box1's Attributes: " + box1.getAttributes());
		System.out.println("------");
		
		System.out.println("box2's title:      " + box2.getTitle());
		System.out.println("box2's Attributes: " + box2.getAttributes());
		System.out.println("------");
		
		/*try {
			System.out.println(box1.title); //Does not work 
		} catch {
			System.out.println("box1.title not usable");
		}*/
		
		System.out.println("Attempting to create relationship R1 between box1->box2");
		relationship R1 = new relationship();
		R1.setRelationship(box1, box2);
		System.out.println("Inspect R1:");
		Inspect(R1);
		System.out.println("Changing R1's Title");
		R1.setRelationshipTitle("R1");
		System.out.println("Changing R1's Arrow head to invalid value: 9");
		R1.setArrow1(9);
		System.out.println("Changing R1's Arrow head and tail to valid values");
		R1.setArrow1(2);
		R1.setArrow2(4);
		System.out.println("Changing R1's Multiplicities (1 & 2)");
		R1.setMultiplicity1("1..3");
		R1.setMultiplicity2("0..*");
		System.out.println("Toggling R1.isDashed");
		R1.dash();
		System.out.println("Inspect R1:");
		Inspect(R1);
		
		System.out.println("\n\n\nAdding New Relationship R2 between box1->box1");
		relationship R2 = new relationship();
		R2.setRelationship(box1, box1);
		
		System.out.println("\n\n\nAdding New Relationship R3 between box1->box1");
		relationship R3 = new relationship();
		R3.setRelationship(box1, box1);
		System.out.println("\n\n\nAdding New Relationship R4 between box1->box1");
		relationship R4 = new relationship();
		R4.setRelationship(box1, box1);

	}
	
	public static void Inspect(relationship r){
		System.out.printf("+--------------------+\n");
		/*int sp = 2;
		if (r.getTitle().length()!=0)
			sp= (20-r.getTitle().length())/2;
		System.out.println(sp);
		System.out.printf("|%-sps|\n", r.getTitle());/**/
		System.out.printf("|%-20s|\n", r.getTitle());
		System.out.printf("+--------------------+\n");
		System.out.printf("| head:%14s|\n", r.getEnd1().getTitle());
		System.out.printf("| tail:%14s|\n", r.getEnd2().getTitle());
		System.out.printf("| h-type:%12d|\n", r.getArrow1());
		System.out.printf("| t-type:%12d|\n", r.getArrow2());
		System.out.printf("| h-multi.:%10s|\n", r.getMultiplicity1());
		System.out.printf("| t-multi.:%10s|\n", r.getMultiplicity2());
		String b = "Solid";
		if (r.isDashed()){
			b = "Dashed";
		}
		System.out.printf("| State:%13s|\n", b);
		System.out.printf("+--------------------+\n");
	}

}
