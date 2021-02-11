package views;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Menu represents a list of menu option,
 * it allows user(s) to select from the menu option
 * @author KokHeng
 *
 */

public class Menu {

	private List<String> theList;

	public List<String> createMenuList() {
		theList = new ArrayList<>();

		// add a list of menu option
		theList.add("Add new person.");
		theList.add("Search for a person by id or name");
		//theList.add("List of all registered person alphabetically by name.");
		//theList.add("List of all book alphabetically by title or author name.");
		//theList.add("Search for a book by title or author.");
		//theList.add("Register a person borrowed a book.");
		//theList.add("Display a specific person who borrow a book.");
		//theList.add("Register a person who return a book");
		//theList.add("Register a person who is queueing to borrow a specific book where the book is been borrowed by another person.");
		return theList;
	}

	public List<String> getList() {
		return theList;
	}

}
