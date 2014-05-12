package dictTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * @author Robert Payne
 * class ITCS 3112-001
 * date 2/28/2014
 */
public class LinkedListDictionaryTest {
	private LinkedListDictionary lldTester;
	/**
	 * setUp()
	 * creates a new hashDictionary Object
	 */	
	@Before
	public void setUp() throws Exception {
		lldTester = new LinkedListDictionary();
	}
	/**
	 * Test method
	 * Tests the get, remove, put, and toString methods from
	 * the LinkedListDictionary class	
	 */
	@Test
	public void test() {
		assertTrue("Get: object from empty dict failed", testEmptyGet());
		assertTrue("Remove: object from empty dict failed", testEmptyRemove());
		assertTrue("Put: object into empty dict failed",testPut());
		assertTrue("Remove: object not in dict from dict failed", testRemoveObjectNotInDict());
		assertTrue("Put: null key/object into dict failed", testPutNull());
		assertTrue("Get: object in dict not found", testGet());
		assertTrue("Remove: head object remove failed", testRemoveHead());
		assertTrue("Remove: middle object remove failed", testRemoveMiddle());
		assertTrue("Remove: tail object remove failed", testRemoveTail());
		assertTrue("toString: toString for dict failed", testToString());
		assertTrue("Get: get head object failed", testGetHead());
		assertTrue("Get: get middle object failed", testGetMiddle());
		assertTrue("Get: get tail object failed", testGetTail());	
	}
	
	/*	testPut()
	 * puts a value and returns true if it is successful
	 * else returns false
	 */
	private boolean testPut(){
		try{
			lldTester.put("Key3", "Value3");
			return true;
		} catch(Exception e){
			return false;
		}
	}
	
	/*	testPutNull()
	 * 	tries to put each combination of null in key and value
	 *  if an exception is thrown returns false
	 *  else will return true
	 */
	private boolean testPutNull(){
		try{
			lldTester.put(null, null);
			lldTester.put("Key1", null);
			lldTester.put(null, "Value2");
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	/*	testGet()
	 * 	checks to see if "Key3" contains "Value3" as previously
	 * 	added to the dictionary
	 */
	private boolean testGet(){
		if(lldTester.get("Key3").toString().equals("Value3"))
			return true;
		else
			return false;
	}
	
	/*	testEmptyGet()
	 * 	checks to see if an exception is thrown when an 
	 *  empty dictionary is queried for an object
	 */
	private boolean testEmptyGet(){
		try{
			lldTester.get("Key not in dictionary");
			return true;
		}catch (Exception e){
			return false;
		}
	}
	
	/*	testRemoveObjectNotInDict()
	 * 	if the remove method throws an exception trying
	 *  to remove an object that is not in the dictionary
	 */
	private boolean testRemoveObjectNotInDict(){
		try{
			lldTester.remove("Key not in dictionary");
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/*	testEmptyRemove()
	 * 	checks to see if an exception is thrown when trying
	 *  to call the remove method on an empty dictionary
	 */
	private boolean testEmptyRemove(){
		try{
			lldTester.remove("Key not in dictionary");
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/* testRemoveHead()
	 * checks to see if the remove method throws an exception
	 * when the head of the dictionary is removed
	 */
	private boolean testRemoveHead(){
		try{
			lldTester.put("Key4", "Value4");		//put values into the dictionary
			lldTester.put("Key5", "Value5");
			lldTester.remove("Key3");
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/*	testRemoveMiddle()
	 * 	if the remove method throws an exception when an element
	 *  from the middle is removed
	 */
	private boolean testRemoveMiddle(){
		try{
			lldTester.put("Key6", "Value6");
			lldTester.remove("Key5");
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/*	testRemoveTail()
	 * if the remove method throws an exception when the tail
	 * element is removed
	 */
	private boolean testRemoveTail(){
		try{
			lldTester.put("Key7", "Value7");
			lldTester.remove("Key7");
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/* testToString()
	 * returns true if the correct object is returned from the
	 * dictionary else returns false
	 */
	private boolean testToString(){
		return lldTester.toString().equals(("[Key4:Value4, Key6:Value6]"));
	}
	
	/* testGetHead()
	 * returns true if the head object is successfully returned
	 */
	private boolean testGetHead(){
		return lldTester.get("Key4").toString().equals("Value4");
	}
	
	/*	testGetMiddle()
	 *  returns true if an object from the middle of the dictionary
	 *  is successfully returned
	 */
	private boolean testGetMiddle(){
		lldTester.put("Key8", "Value8");
		return lldTester.get("Key6").toString().equals("Value6");
	}
	
	/* testGetTail()
	 * returns true if the tail object is successfully returned
	 */
	private boolean testGetTail(){
		return lldTester.get("Key8").toString().equals("Value8");
	}
}
