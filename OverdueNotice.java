/**
 * Submitted By
 * Ying Chen
 * Chaitali Gondhalekar
 */
package library;

/**
 * @author Chaitali Gondhalekar and Ying Chen
 *
 */
public class OverdueNotice {
	private Patron patron;
	private int todaysDate;
	
	/**
	 * construct object of OverdueNotice class for this patron, today
	 * @param patron
	 * @param todaysDate
	 */
	public OverdueNotice(Patron patron, int todaysDate) {
		this.patron = patron;
		this.todaysDate = todaysDate;
	}
	
	@Override
	public String toString() {
		String notice = "This is a courtesy reminder for " + patron + " , as of the date '" + todaysDate +
				"', you have the following checked out books that are overdue:\n";
		for(Book ownedBook : patron.getBooks()) // list every borrowed book
			notice += "Book: " + ownedBook + " Due Date: " + ownedBook.getDueDate() +
			(todaysDate > ownedBook.getDueDate() ? " OVERDUE!" : "") + "\n";
		return notice;
	}

}
