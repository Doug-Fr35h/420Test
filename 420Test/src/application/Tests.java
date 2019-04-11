package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	classBox Box1 = new classBox();
	classBox Box2 = new classBox();
	classBox Box3 = new classBox();
	relationship R1 = new relationship();
	relationship R2 = new relationship();
	
	@org.junit.Test
	public void testRelConstructor() {
		
		
		//Testing Constructor
		assertEquals(R1.getEnd1(), null);
		assertEquals(R1.getEnd2(), null);
		assertEquals(R1.getTitle(),"");
		assertEquals(R1.getMultiplicity1(),"");
		assertEquals(R1.getMultiplicity2(),"");
		assertEquals(R1.isDashed(), false);
		assertEquals(R1.getArrow1(), 1);
		assertEquals(R1.getArrow2(), 1);
	}
		//Testing setRelationship
	public void testRelSetRelationship() {
		R1.setRelationship(Box1, Box2);
		assertEquals(R1.getEnd1(), Box1);
		assertFalse(R1.getEnd2() == Box2);
		assertEquals(R1.getEnd2(), Box2);
		assertFalse(R1.getEnd2() == Box1);
	}
		//Testing setRelationshipTitle
	public void testRelTitle() {
		R1.setRelationshipTitle("testTitle");
		assertEquals(R1.getTitle(), "testTitle");
		assertFalse(R1.getTitle().equals("Title"));
	}
		//Testing setMultiplicity
	public void testRelSetMultiplicity() {
		R1.setMultiplicity1("0..0");
		assertEquals(R1.getMultiplicity1(),"0..0");
		assertFalse(R1.getMultiplicity1().equals("1..0"));
		R1.setMultiplicity2("1..*");
		assertEquals(R1.getMultiplicity2(),"1..*");
		assertFalse(R1.getMultiplicity2().equals("*..*"));
	}
		//Testing Dash
	public void testRelDash() {
		R1.dash();
		assertEquals(R1.isDashed(), true);
		assertFalse(R1.isDashed() == false);
	}
		//Testing Undash
	public void testRelUndash() {
		R1.undash();
		assertEquals(R1.isDashed(), false);
		assertFalse(R1.isDashed() == true);
	}
		//Testing toggleDash
	public void testRelToggleDash() {
		R1.toggleDash();
		assertEquals(R1.isDashed(), true);
		assertFalse(R1.isDashed() == false);
	}
		
		//Testing setArrow
	public void testRelSetArrow() {
		R1.setArrow1(3);
		assertEquals(R1.getArrow1(), 3);
		assertFalse(R1.getArrow1() == 2);
		R1.setArrow2(1);
		assertEquals(R1.getArrow2(), 1);
		assertFalse(R1.getArrow2() == 5);
	}
	
	
	@Test
	public void testDefaultValuesCB() {
		//classBox Box1 = new classBox();
		assertEquals("Default Title Should be				: Title", Box1.getTitle(), "Title");
		assertEquals("Default Attributes should be			: -", Box1.getAttributes(), "-");
		assertEquals("Default Opperations should be			: -", Box1.getOperations(), "-");
		assertEquals("Default Extra Components should be	: (nothing)", Box1.getExtraComponents(), "");
		assertEquals("Default xLocation should be			: 20", Box1.getXLocation(), 20, 3);
		assertEquals("Default yLocation should be			: 20", Box1.getYLocation(), 20, 3);
		assertEquals("Default connections.size				: 1", Box1.getRelationshipLength(), 1);
		assertEquals("Default connections.count				: 0", Box1.getRelationshipCount(), 0);				
		assertEquals("Default connections[0] should be		: null ",Box1.getRelIndexOf(0), null);
		assertEquals("Default width should be				: 100", Box1.getWidth(), 100, 3);
		assertEquals("Default height should be				: 130", Box1.getHeight(), 130, 3);
	}

	@Test
	public void testSetTitleCB() {
		//classBox Box1 = new classBox();
		Box1.setTitle("Title2");
		assertEquals("New Title Should be            		: Title", Box1.getTitle(), "Title2");
	}
	
	@Test
	public void testTitle2CB() {
		//String newTitle = "Testy Title";
		//Box1.setTitle(newTitle);
		assertEquals("New Title Should Be					: Title", Box1.getTitle(), "Title");
	}
	
	@Test
	public void testSetAttribCB() {
		//classBox Box1 = new classBox();
		Box1.setAttributes("Attrib1");

		assertEquals("New Attributes should be       : Attrib1", Box1.getAttributes(), "Attrib1");
	}
	
	@Test
	public void testSetOperCB() {
		//classBox Box1 = new classBox();
		Box1.setOperations("Oper1");
		assertEquals("New Operations should be      : Oper1", Box1.getOperations(), "Oper1");
	}
	
	@Test
	public void testSetECCB() {
		//classBox Box1 = new classBox();
		Box1.setExtraComponents("EC1");
		assertEquals("New Extra Components should be : EC1", Box1.getExtraComponents(), "EC1");
	}
	
	@Test
	public void testSetCoordsCB() {
		//classBox Box1 = new classBox();
		Box1.setLocation(3, 24);
		assertEquals("New xLocation should be        : 3", Box1.getXLocation(), 3, 3);
		assertEquals("New yLocation should be        : 24", Box1.getYLocation(), 24, 3);
	}
	
	/*
	 * 
	 */
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
	
	@Test
	public void testConnectionTitle() {
		classBox Box1 = new classBox();
		classBox Box2 = new classBox();
		Box2.setTitle("Box Two");
		relationship R1 = new relationship();
		R1.setRelationship(Box1, Box2);
		assertTrue("testConnectionTitle() Failed", Box1.getOtherEnd(R1).getTitle().equals("Box Two"));
	}
	
	@Test
	public void testEndCoords() {
		classBox Box1 = new classBox();
		classBox Box2 = new classBox();
		Box2.setLocation(69.0, 420.0);
		relationship R1 = new relationship();
		R1.setRelationship(Box1, Box2);
		assertTrue("testCoordsX() Failed", Box1.getOtherEnd(R1).getXLocation() == 69.0);
		assertTrue("testCoordsY() Failed", Box1.getOtherEnd(R1).getYLocation() == 420.0);
	}

}