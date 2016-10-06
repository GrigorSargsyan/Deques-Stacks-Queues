//ID: <A13058299>
//LOGIN: <cs12ucd>

//Himanshu Makhija and Sushmitha Kudari helped me with this tester.
//They contributed by making all the edge cases towards the end of the assignment.

import static org.junit.Assert.*;
import org.junit.*;

public class BoundedDequeTester
{
	private Deque12<Integer> empty;
    private Deque12<Integer> one;
    private Deque12<Integer> many;
    
    private final int CAP = 5;
    private final int N = 3;
    
    @Before
	public void setUp()
	{
		empty = new Deque12<Integer>(CAP);
		one = new Deque12<Integer>(CAP);
		one.addFront(new Integer(15));
		many = new Deque12<Integer>(CAP);
		for ( int i = 0; i < N; i++ ) {
		    many.addFront(new Integer(i));
		}
	}
	
    //Tests to see if the capacity method works
    @Test
    public void testCapacity()
    {
    	assertEquals(5, empty.capacity());
    	assertEquals(5, one.capacity());
    	assertEquals(5, many.capacity());
    }
    
    //Tests to see if the size method works
    @Test
    public void testSize()
    {
    	assertEquals(0, empty.size());
    	assertEquals(1, one.size());
    	assertEquals(3, many.size());
    }
    
    
    /********************************  FRONT TESTS *************************************/
    
    //Tests to see if the addFront method has increased the size.
	@Test
	public void testAddFrontSize()
	{
	    assertTrue(empty.addFront(new Integer(1)));
	    assertEquals(1, empty.size());
	    
	    assertTrue(one.addFront(new Integer(1)));
	    assertEquals(2, one.size());
	    
	    assertTrue(many.addFront(new Integer(1)));
	    assertEquals(4, many.size());

	}
	
	//Tests to see if the addFront method returns false if the 
	//list is full and another object is pushed on.
	@Test
	public void testAddFrontFull()
	{
		assertTrue(empty.addFront(new Integer(1)));
		assertTrue(empty.addFront(new Integer(2)));
		assertTrue(empty.addFront(new Integer(3)));
		assertTrue(empty.addFront(new Integer(4)));
		assertTrue(empty.addFront(new Integer(5)));
		
	    assertEquals("Should return false", false, empty.addFront(6));
	}
	
	//Tests to see if the addFront method handles null inputs from 
	//addFront method
	@Test
	public void testAddFrontNull()
	{
		try 
		{
			assertTrue(empty.addFront(null));
			assertTrue(one.addFront(null));
			assertTrue(many.addFront(null));
			fail("Should return NullPointerException");
	    }
	    catch (NullPointerException e) 
		{
	        // Pass
	    }
	}
	
	//Tests to see if frontPeek method returns the integer
	//at the front.
	@Test
	public void testFrontPeek()
	{
		assertTrue(empty.addFront(new Integer(1)));
		assertTrue(empty.addFront(new Integer(2)));
		assertTrue(empty.addFront(new Integer(3)));
		assertTrue(empty.addFront(new Integer(4)));
		assertTrue(empty.addFront(new Integer(5)));
		
		assertEquals("Should return true", true, (empty.peekFront() == 5));
	}
	
	//Tests to see if removing from an empty arrayList returns
	// an exception error with removeFront method
	@Test
	public void testRemoveFrontEmpty()
	{
		try 
		{
			empty.removeFront();
			one.removeFront();
			many.removeFront();
	    }
	    catch (NullPointerException e) 
		{
	        // Pass
	    }
	}
	
	//Tests to see if frontPeek method returns the integer
	//at the front.
	@Test
	public void testRemoveFront()
	{
		assertTrue(empty.addFront(new Integer(1)));
		assertTrue(empty.addFront(new Integer(2)));
		assertTrue(empty.addFront(new Integer(3)));
		assertTrue(empty.addFront(new Integer(4)));
		assertTrue(empty.addFront(new Integer(5)));
		
		assertTrue(empty.removeFront().equals(5));
		assertTrue(empty.peekFront().equals(4));
		assertTrue(empty.size() == 4);
		
		assertTrue(empty.removeFront().equals(4));
		assertTrue(empty.peekFront().equals(3));
		assertTrue(empty.size() == 3);
	}
	
	
	/********************************  BACK TESTS *************************************/
	
	
	//Tests to see if frontPeek method returns the integer
	//at the front.
	@Test
	public void testBackPeek()
	{
		assertTrue(empty.addBack(new Integer(1)));
		assertTrue(empty.addBack(new Integer(2)));
		assertTrue(empty.addBack(new Integer(3)));
		assertTrue(empty.addBack(new Integer(4)));
		assertTrue(empty.addBack(new Integer(5)));
			
		assertEquals("Should return true", true, (empty.peekBack() == 5));
		}
	
	//Tests the size of arrayList when addBack method is used
	@Test
	public void testAddBackSize()
	{
		
		assertTrue(empty.addBack(new Integer(1)));
	    assertEquals(1, empty.size());
	    
	    assertTrue(one.addBack(new Integer(1)));
	    assertEquals(2, one.size());
	    
	    assertTrue(many.addBack(new Integer(1)));
	    assertEquals(4, many.size());
	}
	
	//Tests to see if the addFront method handles null inputs from 
	//addFront method
	@Test
	public void testAddBackNull()
	{
		try 
		{
			assertTrue(empty.addBack(null));
			assertTrue(one.addBack(null));
			assertTrue(many.addBack(null));
	        fail("Should return NullPointerException");
	    }
	    catch (NullPointerException e) 
		{
	        // Pass
	    }
	}
	
	//Tests to see if removing from an empty arrayList returns
	// an exception error with removeBack method
	@Test
	public void testRemoveBackEmpty()
	{
		try 
		{
			empty.removeBack();
			one.removeBack();
			many.removeBack();
	    }
	    catch (NullPointerException e) 
		{
	        // Pass
	    }
	}
	
	//Tests to see if the addFront method returns false if the 
	//list is full and another object is pushed on.
	@Test
	public void testAddBackFull()
	{
		assertTrue(empty.addBack(new Integer(1)));
		assertTrue(empty.addBack(new Integer(2)));
		assertTrue(empty.addBack(new Integer(3)));
		assertTrue(empty.addBack(new Integer(4)));
		assertTrue(empty.addBack(new Integer(5)));
			
	    assertEquals("Should return false", false, empty.addBack(6));
	}
	
	//Tests to see if BackPeek method returns the integer
	//at the front.
	@Test
	public void testRemoveBack()
	{
		assertTrue(empty.addBack(new Integer(1)));
		assertTrue(empty.addBack(new Integer(2)));
		assertTrue(empty.addBack(new Integer(3)));
		assertTrue(empty.addBack(new Integer(4)));
		assertTrue(empty.addBack(new Integer(5)));
		
		assertTrue(empty.removeBack().equals(5));
		assertTrue(empty.peekBack().equals(4));
		assertTrue(empty.size() == 4);
		
	}
	
	
	/************************************** EDGE CASES ******************************/
	
	@Test
	public void testDeque12Constructor() 
	{
		Deque12<Integer> deque = new Deque12<Integer> (CAP);
		
		/* Test ctor by testing capacity() and size() methods of Deque12 */
		assertEquals("Capacity should be equal to 'cap'", CAP, deque.capacity());
		assertEquals("Size should be equal to 'size'", 0, deque.size());
	}
	
	@Test
	public void testCapacityEmpty() 
	{
		
		/* Test capacity by comparing two Deque12 objects */
		Deque12<String> dequeBigger = new Deque12<String>(2 * CAP);
		Deque12<String> dequeSmaller = new Deque12<String>(CAP);
		
		assertTrue("DequeBigger should have bigger size", 
				dequeBigger.capacity() > dequeSmaller.capacity());
	}
	
	@Test
	public void testCapacityFilled() 
	{
		Deque12<Boolean> deque = new Deque12<Boolean>(CAP);
		deque.addFront(true);
		deque.addFront(true);
		deque.addFront(true);
		deque.addFront(true);
		deque.addFront(true);
		
		assertEquals("Capacity should be unchanged", deque.capacity(), CAP);
		
		deque.removeBack();
		deque.removeBack();
		deque.removeBack();
		deque.removeBack();
		deque.removeBack();
		
		assertEquals("Capacity should be unchanged", deque.capacity(), CAP);
	}
	
	@Test
	public void testSizeEmpty() 
	{
		
		/* Test capacity by comparing two Deque12 objects */
		Deque12<String> StringDeque = new Deque12<String>(CAP);
		Deque12<String> StringDeque2 = new Deque12<String>(CAP);
		
		assertTrue("StringDeque should have same size", StringDeque.size() == StringDeque2.size());
	}

	@Test
	public void testSizeFilled() 
	{
		Deque12<Integer> deque = new Deque12<Integer>(CAP);
		
		deque.addFront(1);
		deque.addBack(-1);
		
		assertTrue("Size should now be 2", deque.size() == 2);
		
		deque.removeFront();
		deque.removeBack();
		
		assertTrue("Size should now be back to 0", deque.size() == 0);
	}


}
