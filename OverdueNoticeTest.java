/**
 * Submitted By
 * Ying Chen
 * Chaitali Gondhalekar
 */
package library;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Chaitali Gondhalekar and Ying Chen
 *
 */
public class OverdueNoticeTest {

	private OverdueNotice notice1;
	private Book book1,book2;
	private ArrayList<Book> books;
	private Library lib1;
	private Patron patron1;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		book1 = new Book("Exploring Python","Timothy Budd");
		book2 = new Book("Head First Java","Kathy Sierra, Bert Bates");
		books = new ArrayList<Book>();
		lib1 = new Library(books);
		patron1 = new Patron("Ying", lib1);
		patron1.take(book1);
		book1.checkOut(0);
		notice1 = new OverdueNotice(patron1,1);
	}

	/**
	 * Test method for {@link library.OverdueNotice#toString()}.
	 */
	@Test
	public void testToString() {
		System.err.println(notice1);
		assertEquals("This is a courtesy reminder for Ying , as of the date '1', you have the following checked out books that are about overdue:\nBook: Exploring Python by Timothy Budd Due Date: 0 OVERDUE!\n" , notice1.toString());
	}

}
