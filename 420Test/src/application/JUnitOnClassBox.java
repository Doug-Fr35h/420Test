package application;

import static org.junit.Assert.*; 
import org.junit.Test;

import org.junit.*;

public class JUnitOnClassBox {
	
	classBox Box1 = new classBox();
	classBox Box2 = new classBox();
	classBox Box3 = new classBox();
	relationship R1 = new relationship();
	relationship R2 = new relationship();
	
	@Test
	public void defaultValues() {
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
	public void setOperators() {
		classBox Box1 = new classBox();
		Box1.setTitle("Title2");
		Box1.setAttributes("Attrib1");
		Box1.setOperations("Oper1");
		Box1.setExtraComponents("EC1");
		Box1.updateLocation(3, 24);
		assertEquals("New Title Should be            : Title", Box1.getTitle(), "Title2");
		assertEquals("New Attributes should be       : -", Box1.getAttributes(), "Attrib1");
		assertEquals("New Opperations should be      : -", Box1.getOperations(), "Oper1");
		assertEquals("New Extra Components should be : ", Box1.getExtraComponents(), "EC1");
		assertEquals("New xLocation should be        : ", Box1.getXLocation(), 3, 3);
		assertEquals("New yLocation should be        : ", Box1.getYLocation(), 24, 3);
	}
	
	@Test
	public void testTitle() {
		String newTitle = "Testy Title";
		Box1.setTitle(newTitle);
		assertEquals("New Title Should Be					:" + newTitle, Box1.getTitle(), newTitle);
	}
	
	@Test
	public void testTitle2() {
		//String newTitle = "Testy Title";
		//Box1.setTitle(newTitle);
		assertEquals("New Title Should Be					:", Box1.getTitle(), "Title");
	}
	
}
