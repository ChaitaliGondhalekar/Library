/**
 * Submitted By
 * Ying Chen
 * Chaitali Gondhalekar
 */
package library;
import java.util.*;


/**
 * @author Chaitali Gondhalekar and Ying Chen
 *
 */
public class Patron {
	//instance variables and objects
	private String name;
	private Library library;
	private Set<Book> ownedBooks; // use Set to prevent owning same book more than one time 
	public static final int MAX_BOOKS = 3; // static constant
	
	/**
	 * Construct a patron with the given name and no books
	 * @param name
	 * @param library
	 */
	public Patron(String name, Library library){
		
		this.name = name;
		this.library = library;
		ownedBooks = new HashSet<Book>();
	}
	
	/**
	 * 
	 * @return name of this patron as a String
	 */
	
	public String getName(){
		
		return name;
	}
	
	/**
	 * Add this book to the list of books checked out by this Patron
	 * returns nothing
	 * @param book
	 */
	void take(Book book) throws RuntimeException {
		
		if (ownedBooks.size() >= MAX_BOOKS)
			throw new RuntimeException("cannot borrow more than " + MAX_BOOKS + " books");
		if(book.getDueDate() != -1) // not available
			throw new RuntimeException("Cannot check-out book which hasn't been checked-in");
		if (!ownedBooks.add(book)) // this book has already been bought
			throw new RuntimeException("cannot borrow same book twice for book: '" + book + "'");		
	}
	
	/**
	 * Remove this Book object from the list of books checked out by this Patron 
	 * @param book
	 */
	void giveBack(Book book) throws RuntimeException{//incomplete?

			throw new RuntimeException("cannot give back unowned book for book: '" + book + "'");
	}
	
	/**
	 * Returns the list of Book objects checked out to this Patron
	 * @return
	 */
	public ArrayList<Book> getBooks(){
		return new ArrayList<Book>(ownedBooks); // copy Set into new ArrayList
	}
	
	/**
	 * returns number of overdue books
	 * @param today- current date
	 * @return no. of overdue books
	 */
	public int overdueCount(int today) {
		int overdue = 0;
		for(Book book : ownedBooks)  // check every borrowed book
			if(book.getDueDate() == today - 1)
				overdue++;
		return overdue;
	}
	
	/**
	 * Returns this patron's name.
	 */
	@Override
	public String toString(){

		return name;
	}

}
