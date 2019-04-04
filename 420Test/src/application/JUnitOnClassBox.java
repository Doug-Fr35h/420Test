package application;

import static org.junit.Assert.*; 
import org.junit.Test;

import org.junit.*;

public class JUnitOnClassBox {

	@Test
	public void defaultValues() {
		classBox Box1 = new classBox();
		assertEquals("Default Title Should be            : Title", Box1.getTitle(), "Title");
		assertEquals("Default Attributes should be       : -", Box1.getAttributes(), "-");
		assertEquals("Default Opperations should be      : -", Box1.getOperations(), "-");
		assertEquals("Default Extra Components should be : (nothing)", Box1.getExtraComponents(), "");
		assertEquals("Default xLocation should be        : 20", Box1.getXLocation(), 20);
		assertEquals("Default yLocation should be        : 20", Box1.getYLocation(), 20);
		assertEquals("Default connections.size           : 1", Box1.getRelationshipCount(), 1);
		assertEquals("Default connections[0] should be   : null ",Box1.getRelIndexOf(0), null);
		assertEquals("Default width should be             : 100", Box1.getWidth(), 100);
		assertEquals("Default height should be              : 130", Box1.getHeight(), 130);
	}

    // fields used together with @Parameter must be public
/*    @Parameter(0)
    public int m1;
//    @Parameter(1)
    public int m2;
//    @Parameter(2)
    public int result;/**/
	
	//public classBox box1;
	public classBox box2;
	public relationship R1;
	public relationship R2;

    // creates the test data
   /* @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 1 , 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
        return Arrays.asList(data);
    }/**/


 /*  @Test
    public void testMultiplyException() {
        MyClass tester = new MyClass();
        assertEquals("Result", result, tester.multiply(m1, m2));
    }/**/


    // class to be tested
    class MyClass {
/*        public int multiply(int i, int j) {
            return i *j;
        }/**/
    }
}
