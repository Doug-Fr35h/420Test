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
		assertEquals("Default Title Should be            : Title", Box1.getTitle(), "Title");
		assertEquals("Default Attributes should be       : -", Box1.getAttributes(), "-");
		assertEquals("Default Opperations should be      : -", Box1.getOperations(), "-");
		assertEquals("Default Extra Components should be : (nothing)", Box1.getExtraComponents(), "");
		assertEquals("Default xLocation should be        : 20", Box1.getXLocation(), 20, 3);
		assertEquals("Default yLocation should be        : 20", Box1.getYLocation(), 20, 3);
		assertEquals("Default connections.size           : 1", Box1.getRelationshipCount(), 1);
		assertEquals("Default connections[0] should be   : null ",Box1.getRelIndexOf(0), null);
		assertEquals("Default width should be             : 100", Box1.getWidth(), 100, 3);
		assertEquals("Default height should be              : 130", Box1.getHeight(), 130, 3);
	}
	
}
