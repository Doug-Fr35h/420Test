package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	classBox Box1 = new classBox();
	classBox Box2 = new classBox();
	classBox Box3 = new classBox();
	relationship R1 = new relationship();
	relationship R2 = new relationship();
	
	relationship rel = new relationship();
	classBox end1 = new classBox();
	classBox end2 = new classBox();
	
	@org.junit.Test
	public void testRelConstructor() {
		
		
		//Testing Constructor
		assertEquals(rel.getEnd1(), null);
		assertEquals(rel.getEnd2(), null);
		assertEquals(rel.getTitle(),"");
		assertEquals(rel.getMultiplicity1(),"");
		assertEquals(rel.getMultiplicity2(),"");
		assertEquals(rel.isDashed(), false);
		assertEquals(rel.getArrow1(), 0);
		assertEquals(rel.getArrow2(), 0);
	}
		//Testing setRelationship
	public void testRelSetRelationship() {
		rel.setRelationship(end1, end2);
		assertEquals(rel.getEnd1(), end1);
		assertFalse(rel.getEnd1() == end2);
		assertEquals(rel.getEnd2(), end2);
		assertFalse(rel.getEnd2() == end1);
	}
		//Testing setRelationshipTitle
	public void testRelSetTitle() {
		rel.setRelationshipTitle("testTitle");
		assertEquals(rel.getTitle(), "testTitle");
		assertFalse(rel.getTitle().equals("Title"));
	}
		//Testing setMultiplicity
	public void testRelSetMultiplicity() {
		rel.setMultiplicity1("0..0");
		assertEquals(rel.getMultiplicity1(),"0..0");
		assertFalse(rel.getMultiplicity1().equals("1..0"));
		rel.setMultiplicity2("1..*");
		assertEquals(rel.getMultiplicity2(),"1..*");
		assertFalse(rel.getMultiplicity2().equals("*..*"));
	}
		//Testing Dash
	public void testRelDash() {
		rel.dash();
		assertEquals(rel.isDashed(), true);
		assertFalse(rel.isDashed() == false);
	}
		//Testing Undash
	public void testRelUndash() {
		rel.undash();
		assertEquals(rel.isDashed(), false);
		assertFalse(rel.isDashed() == true);
	}
		//Testing toggleDash
	public void testRelToggleDash() {
		rel.toggleDash();
		assertEquals(rel.isDashed(), true);
		assertFalse(rel.isDashed() == false);
	}
		
		//Testing setArrow
	public void testRelSetArrow() {
		rel.setArrow1(3);
		assertEquals(rel.getArrow1(), 3);
		assertFalse(rel.getArrow1() == 2);
		rel.setArrow2(1);
		assertEquals(rel.getArrow2(), 1);
		assertFalse(rel.getArrow2() == 5);
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
		assertEquals("Default connections.size				: 1", Box1.getRelationshipCount(), 1);
		assertEquals("Default connections[0] should be		: null ",Box1.getRelIndexOf(0), null);
		assertEquals("Default width should be				: 100", Box1.getWidth(), 100, 3);
		assertEquals("Default height should be				: 130", Box1.getHeight(), 130, 3);
	}

	@Test
	public void testSetTitleCB() {
		classBox Box1 = new classBox();
		Box1.setTitle("Title2");
		assertEquals("New Title Should be            		: Title", Box1.getTitle(), "Title2");
	}
	
	@Test
	public void testTitle2CB() {
		//String newTitle = "Testy Title";
		//Box1.setTitle(newTitle);
		assertEquals("New Title Should Be					:", Box1.getTitle(), "Title");
	}
	
	@Test
	public void testSetAttribCB() {
		classBox Box1 = new classBox();
		Box1.setAttributes("Attrib1");
		assertEquals("New Attributes should be       		: -", Box1.getAttributes(), "Attrib1");
	}
	
	@Test
	public void testSetOperCB() {
		classBox Box1 = new classBox();
		Box1.setOperations("Oper1");
		assertEquals("New Operations should be      		: -", Box1.getOperations(), "Oper1");
	}
	
	@Test
	public void testSetECCB() {
		classBox Box1 = new classBox();
		Box1.setExtraComponents("EC1");
		assertEquals("New Extra Components should be 		: ", Box1.getExtraComponents(), "EC1");
	}
	
	@Test
	public void testSetCoordsCB() {
		classBox Box1 = new classBox();
		Box1.updateLocation(3, 24);
		assertEquals("New xLocation should be        		: ", Box1.getXLocation(), 3, 3);
		assertEquals("New yLocation should be        		: ", Box1.getYLocation(), 24, 3);
	}

}