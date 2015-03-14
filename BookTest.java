/**
 * Submitted By
 * Ying Chen
 * Chaitali Gondhalekar
 */
package library;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author David Matuszek
 *
 */
public class BookTest {
	
	private Book contact;
    private Book equalRites;
    private Book python,python1;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        contact = new Book("Contact", "Carl Sagan");
        equalRites = new Book("Equal Rites", "Terry Pratchett");
        python = new Book("Exploring Python","Timothy Budd");
        python1 = new Book("Exploring Python","Timothy Budd");;
        
    }

    /**
     * Test method for {@link library.Book#getTitle()}.
     */
    @Test
    public void testGetTitle() {
        assertEquals("Contact", contact.getTitle());
        assertEquals("Equal Rites", equalRites.getTitle());
        assertNotEquals("Timothy Budd", python.getTitle());
 
    }

    /**
     * Test method for {@link library.Book#getAuthor()}.
     */
    @Test
    public void testGetAuthor() {
        assertEquals("Carl Sagan", contact.getAuthor());
        assertEquals("Terry Pratchett", equalRites.getAuthor());
        assertNotEquals("Exploring Python", python.getAuthor());
    }

    /**
     * Test method for {@link library.Book#getDueDate()}.
     */
    @Test
    public void testGetDueDate() {
        assertEquals(-1, contact.getDueDate());
    }

    /**
     * Test method for {@link library.Book#checkOut(int)}.
     */
    @Test
    public void testCheckOut() {
        contact.checkOut(12);
        assertEquals(12, contact.getDueDate());
        contact.checkOut(0);
        assertNotEquals(-1, contact.getDueDate());
    }

    /**
     * Test method for {@link library.Book#checkIn()}.
     */
    @Test
    public void testCheckIn() {
        contact.checkOut(12);
        assertEquals(12, contact.getDueDate());
        contact.checkIn();
        assertEquals(-1, contact.getDueDate());
        equalRites.checkIn();	//is it correct??
        assertEquals(-1, equalRites.getDueDate());
    }

    /**
     * Test method for {@link library.Book#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("Contact by Carl Sagan", contact.toString());
        assertEquals("Equal Rites by Terry Pratchett", equalRites.toString());
    }
    
    /**
     * Test method for {@link library.Book#equals(Object)}
     */
    @Test
    public void testEquals(){
    	assertFalse(contact.equals(equalRites));
    	//are the two books the same
    	assertTrue(python1.equals(python));
    }

}
