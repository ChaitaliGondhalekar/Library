/**
 * Tests for Library assignment.
 * Submitted By
 * Ying Chen
 * Chaitali Gondhalekar 
 */
package library;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author David Matuszek
 */
public class PatronTest {
    private Patron dave;
    private Patron paula;
    private Book book,book1,book2,book3;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        dave = new Patron("Dave", null);
        paula = new Patron("Paula", null);
        book = new Book("Disappearing Nightly", "Laura Resnick");
        book1 = new Book("Pride and Prejudice", "Jane Austen");
        book2 = new Book("Paths of Glory", "Jeffery Archer");	//delete if unused
        book3 = new Book("Deception Point", "Dan Brown");
    }

    /**
     * Test method for {@link library.Patron#Patron(java.lang.String, library.Library)}.
     * test if object of Patron class is created
     */
    @Test
    public void testPatron() {
        Patron paula = new Patron("Paula", null);
        assertTrue(paula instanceof Patron);
    }

    /**
     * Test method for {@link library.Patron#getName()}.
     * test if correct name is returned for this patron
     */
    @Test
    public void testGetName() {
        assertEquals("Dave", dave.getName());
        assertEquals("Paula", paula.getName());
    }

    /**
     * Test method for {@link library.Patron#take(library.Book)}.
     * test if this patron can take the books
     */
    @Test
    public void testTake() {
        paula.take(book);
        assertTrue(paula.getBooks().contains(book));
        assertFalse(dave.getBooks().contains(book));
        dave.take(book1);
        assertFalse(dave.getBooks().isEmpty());
    }

    /**
     * Test method for {@link library.Patron#giveBack(library.Book)}.
     * test if book is returned
     */
    @Test(expected=RuntimeException.class)
    public void testGiveBack() {
        paula.take(book);
        assertTrue(paula.getBooks().contains(book));
        paula.giveBack(book);
        //check if returned book is removed from the list of books checked out by patron
        assertFalse(paula.getBooks().contains(book));
        
    }

    /**
     * Test method for {@link library.Patron#getBooks()}.
     */
    @Test(expected=RuntimeException.class)
    public void testGetBooks() {
        dave.take(book);
        assertTrue(dave.getBooks().contains(book));
        assertEquals(1, dave.getBooks().size());
        dave.giveBack(book);
        dave.take(book1);
        assertFalse(dave.getBooks().isEmpty());
    }

    /**
     * Test method for {@link library.Patron#toString()}.
     * test if name of this patron is printed correctly
     */
    @Test
    public void testToString() {
        assertEquals("Dave", dave.toString());
        assertEquals("Paula", paula.toString());
    }

}
