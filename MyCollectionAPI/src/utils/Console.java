package utils;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Console {

	/** Define static variables. */

	// the file directory for registering borrowing file.
	public static final String BORROW_DIRECTORY ="C:\\Users\\KokHeng\\eclipse-workspace\\My Collections\\src\\registeredReaderBorrowABook.txt";
	// the file directory for registering returning file.
	public static final String RETURN_DIRECTORY ="C:\\Users\\KokHeng\\eclipse-workspace\\My Collections\\src\\registeredReaderReturnABook.txt";
	// the file directory for registering waiting list file.
	public static final String WAITING_DIRECTORY ="C:\\Users\\KokHeng\\eclipse-workspace\\My Collections\\src\\registeredReaderWaitingABook.txt";

	public static int readInt(String prompt) {
		boolean validInt = false;
		int input = 0;
		Scanner scan = null;

		while(! validInt) {
			System.out.print(prompt);
			try {
				scan = new Scanner(System.in);
				input = scan.nextInt();
				validInt = true;
			}
			catch(InputMismatchException imexp) {
				scan.nextLine(); // clear the buffer
				System.out.println("Error! Enter number only, try again.");
			}
		}
		return input;
	}

	public static String readString(String prompt) {
		boolean validString = false;
		String input = null;
		Scanner scan = null;

		while(! validString) {
			System.out.print(prompt);
			try {
				scan = new Scanner(System.in);
				input = scan.nextLine();
				validString = true;
			}
			catch(Exception imexp) {
				scan.nextLine(); // clear the buffer
				System.out.println("Error! Enter letter, try again.");
			}
		}
		return input;
	}

	/**
	 * Method to print data to the external file
	 * by using print writer stream where
	 * wrapped by buffered and file writer constructor.
	 * @param obj1 the instance to be printed
	 * @param obj2 the instance to be printed
	 * @param fileDirectory the file directory path.
	 * @param message the message indication when taking place.
	 * @return the instance of the print writer.
	 */
	public static PrintWriter printToFile(Object obj1, Object obj2, String fileDirectory, String message) {
		BufferedWriter bufferedWriter = null;
		FileWriter fileWriter = null;
		PrintWriter pw = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		Date issuedDate = calendar.getTime();

		try {
			fileWriter = new FileWriter(fileDirectory, true);
			bufferedWriter = new BufferedWriter(fileWriter);
			pw = new PrintWriter(bufferedWriter);
			// write to text file
			pw.println(obj1);
			pw.print(obj2);
			pw.println(message + dateFormat.format(issuedDate));
			pw.println();

			// close the print writer
			pw.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("Error! File: " + fileDirectory + " not found, check details and try again.");
		}
		catch(IOException ioexp) {
			System.out.println("Either printer or buffered or file writer not available this time, check details and try again.");
			System.err.println(ioexp.getMessage());
		}

		return pw;
	}

	public static int generateId(int n) {
		int[] arrayInt = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int id = 0;
		for(int i = 0; i < n; i=i+1) {
			id = id + arrayInt[new Random().nextInt(arrayInt.length-1)];
		}
		return id;
	}

	public static String generateBookId(int n) {
		String[] arrayChar = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String id = "";
		for(int i = 0; i < n; i=i+1) {
			id = id + arrayChar[new Random().nextInt(arrayChar.length - 1)];
		}
		return id;
	}

	public static void continuing() {
		readString("Press <ENTER> to continue.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// testing the read integer method

		int input = readInt("Enter number: ");
		System.out.println("Number: " + input + " is entered.");

	}

}
