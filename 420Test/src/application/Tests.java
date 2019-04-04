package application;

import static org.junit.Assert.*;

public class Tests {

	@org.junit.Test
	public void test() {
		relationship rel = new relationship();
		classBox end1 = new classBox();
		classBox end2 = new classBox();
		
		//Testing Constructor
		assertEquals(rel.getEnd1(), null);
		assertEquals(rel.getEnd2(), null);
		assertEquals(rel.getTitle(),"");
		assertEquals(rel.getMultiplicity1(),"");
		assertEquals(rel.getMultiplicity2(),"");
		assertEquals(rel.isDashed(), false);
		assertEquals(rel.getArrow1(), 0);
		assertEquals(rel.getArrow2(), 0);
		
		//Testing setRelationship
		rel.setRelationship(end1, end2);
		assertEquals(rel.getEnd1(), end1);
		assertFalse(rel.getEnd1() == end2);
		assertEquals(rel.getEnd2(), end2);
		assertFalse(rel.getEnd2() == end1);
		
		//Testing setRelationshipTitle
		rel.setRelationshipTitle("testTitle");
		assertEquals(rel.getTitle(), "testTitle");
		assertFalse(rel.getTitle().equals("Title"));
		
		//Testing setMultiplicity
		rel.setMultiplicity1("0..0");
		assertEquals(rel.getMultiplicity1(),"0..0");
		assertFalse(rel.getMultiplicity1().equals("1..0"));
		rel.setMultiplicity2("1..*");
		assertEquals(rel.getMultiplicity2(),"1..*");
		assertFalse(rel.getMultiplicity2().equals("*..*"));
		
		//Testing Dash, Undash, and toggleDash
		rel.dash();
		assertEquals(rel.isDashed(), true);
		assertFalse(rel.isDashed() == false);
		rel.undash();
		assertEquals(rel.isDashed(), false);
		assertFalse(rel.isDashed() == true);
		rel.toggleDash();
		assertEquals(rel.isDashed(), true);
		assertFalse(rel.isDashed() == false);
		
		//Testing setArrow
		rel.setArrow1(3);
		assertEquals(rel.getArrow1(), 3);
		assertFalse(rel.getArrow1() == 2);
		rel.setArrow2(1);
		assertEquals(rel.getArrow2(), 1);
		assertFalse(rel.getArrow2() == 5);
	}

}