package application;

import static org.junit.Assert.*; 

import org.junit.*;

public class JUnitOnClassBox {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

    // fields used together with @Parameter must be public
/*    @Parameter(0)
    public int m1;
//    @Parameter(1)
    public int m2;
//    @Parameter(2)
    public int result;/**/
	
	public classBox box1;
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
