import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Phonebook {
	
	/**
	 * This is the array which contains all the contacts (objects of class
	 * contact)
	 */
	private static Contact[] phoneBook = new Contact[10];

	// public static Scanner amr = new Scanner (System.in);
	// public static BufferedReader bf = new BufferedReader(new
	// InputStreamReader(System.in));

	/**
	 * This method reads with buffer reader and returns a string containing
	 * the line entered by user
	 */
	public static String readWithBuf() throws IOException {
		
		BufferedReader myBuf = new BufferedReader(new InputStreamReader(
				System.in));
		String z = myBuf.readLine();
		// myBuf.close();
		return z;
	}
	/**
	 * This method needs no parameters which ask the user to enter info and
	 * creates a contact and put it into the array of contacts, and returns
	 * void.
	 */
	public static void addContact() throws IOException {
		
		System.out.println("\nAdding a contact");
		System.out.println("================\n");
		String firstName;
		String lastName;
		String phoneNum;
		String eMail = "";
		String address = "";
		String notes = "";

		Matcher matcher;

		// BufferedReader bf = new BufferedReader(new
		// InputStreamReader(System.in));
		do {
			System.out.println("pls enter first name (required) : ");

			firstName = readWithBuf();

			if (!firstName.equals("")) {
				if (firstName.contains(",")) {
					System.out.println("error, cannot contain \",\"");
				}
			} else {

				System.out.println("error,required field");
			}
		} while (firstName.equals("") || firstName.contains(","));

		do {
			System.out.println("pls enter last name (required) : ");
			lastName = readWithBuf();

			if (!lastName.equals("")) {
				if (lastName.contains(",")) {
					System.out.println("error, cannot contain \",\"");
				}
			} else {
				System.out.println("error,required field");
			}
		} while (lastName.equals("") || lastName.contains(","));

		System.out.println("pls enter phone number (required) : ");
		boolean y = true;
		do {
			phoneNum = readWithBuf();
			y = true;

			final String PHONE_NUM_PATTERN = "\\d{3,13}";
			Pattern pattern = Pattern.compile(PHONE_NUM_PATTERN);
			matcher = pattern.matcher(phoneNum);

			if (matcher.matches() == true) {
				for (int l = 0; l < Contact.getNumberOfContacts(); l++) {
					if (phoneNum.equals(phoneBook[l].getPhoneNumber())) {
						y = false;
						System.out
								.println("error repeated number, pls enter a new number");
					}
				}
			} else {
				System.out
						.println("error, pls enter a valid phone number with no spaces or commas from(0-9) length(3-13)");
			}
		} while (matcher.matches() == false || y == false);
		System.out
				.println("pls enter e-mail (optional) or press \"Enter\" to skip : ");
		// eMail = readWithBuf();
		do {
			eMail = readWithBuf();

			final String E_MAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			Pattern pattern = Pattern.compile(E_MAIL_PATTERN);
			matcher = pattern.matcher(eMail);

			if (matcher.matches() == true || eMail.equals("")) {
				// OK then
			} else {
				System.out.println("error, pls enter a valid email");
			}
		} while (matcher.matches() == false && !eMail.isEmpty());

		do {
			System.out
					.println("pls enter address (optional) or press \"Enter\" to skip : ");
			address = readWithBuf();
			if (!address.equals("")) {
				if (address.contains(",")) {
					System.out.println("error, cannot contain \",\"");
				}
			}
		} while (address.contains(","));

		do {
			System.out
					.println("pls enter notes (optional) or press \"Enter\" to skip : ");
			notes = readWithBuf();
			if (!notes.equals("")) {
				if (notes.contains(",")) {
					System.out.println("error, cannot contain \",\"");
				}
			}
		} while (notes.contains(","));

		Contact entry = new Contact(firstName, lastName, phoneNum, eMail,
				address, notes);
		phoneBook[Contact.getNumberOfContacts() - 1] = entry;
		System.out.println("The contact entered is: ");
		System.out.println(phoneBook[Contact.getNumberOfContacts() - 1]
				.toString());
		System.out.println("\npress enter to continue");
		readWithBuf();

		// Contact[] phoneBooktemp=new Contact[phoneBook.length+1];
		// System.arraycopy(phoneBook, 0, phoneBooktemp, 0, phoneBook.length);
		// phoneBook=phoneBooktemp;

		if (Contact.getNumberOfContacts() == phoneBook.length - 1) {
			Contact[] phoneBooktemp = new Contact[phoneBook.length * 2];
			System.arraycopy(phoneBook, 0, phoneBooktemp, 0, phoneBook.length);
			phoneBook = phoneBooktemp;

		}
	}
	/**
	 * This method takes a parameter (integer the index of the contact in
	 * the array of phone book) and allows the user to change the info of
	 * the contact, and returns void.
	 */
	public static void editContact(int contactPos) throws IOException {
		

		boolean done = false;
		Matcher matcher;
		while (done == false) {
			System.out.println("\nWhat would you like to edit: ");
			System.out
					.println("1. first name      2. last name\n3. phone number    4. e-mail\n5. address         6. notes\n7. exit to main menu");

			String x = "-1";
			x = readWithBuf();

			int xInt = -1;

			try {
				xInt = Integer.parseInt(x);
			} catch (Exception e) {

			}

			switch (xInt) {
			case 1:
				do {
					System.out.println("enter first name: ");
					phoneBook[contactPos].setFirstName(readWithBuf());
					if (!phoneBook[contactPos].getFirstName().equals("")) {
						if (phoneBook[contactPos].getFirstName().contains(",")) {
							System.out.println("error, cannot contain \",\"");
						}
					} else {

						System.out.println("error,required field");
					}
				} while (phoneBook[contactPos].getFirstName().equals("")
						|| phoneBook[contactPos].getFirstName().contains(","));

				System.out.println("contact after editing is \n"
						+ phoneBook[contactPos].toString());
				break;
			case 2:
				do {
					System.out.println("enter last name: ");
					phoneBook[contactPos].setLastName(readWithBuf());

					if (!phoneBook[contactPos].getLastName().equals("")) {
						if (phoneBook[contactPos].getLastName().contains(",")) {
							System.out.println("error, cannot contain \",\"");
						}
					} else {

						System.out.println("error,required field");
					}
				} while (phoneBook[contactPos].getLastName().equals("")
						|| phoneBook[contactPos].getLastName().contains(","));

				System.out.println("contact after editing is \n"
						+ phoneBook[contactPos].toString());
				break;

			case 3:
				// System.out.println("enter phone number: ");

				// phoneBook[contactPos].setPhoneNumber(amr.next());

				System.out.println("pls enter phone number (required) : ");
				boolean y = true;
				do {
					phoneBook[contactPos].setPhoneNumber(readWithBuf());
					y = true;
					final String PHONE_NUM_PATTERN = "\\d{3,13}";
					Pattern pattern = Pattern.compile(PHONE_NUM_PATTERN);
					matcher = pattern.matcher(phoneBook[contactPos]
							.getPhoneNumber());

					if (matcher.matches() == true) {
						for (int l = 0; l < Contact.getNumberOfContacts(); l++) {
							if (phoneBook[contactPos].getPhoneNumber().equals(
									phoneBook[l].getPhoneNumber())
									&& l != contactPos) {
								y = false;
								System.out
										.println("error repeated number, pls enter a new number");
							}
						}
					} else {
						System.out
								.println("error, pls enter a valid phone number with no spaces or commas from(0-9) length(3-13)");
					}
				} while (matcher.matches() == false || y == false);
				System.out.println("contact after editing is \n"
						+ phoneBook[contactPos].toString());
				break;

			case 4:
				System.out
						.println("enter e-mail: or press enter if you want it empty");

				// phoneBook[contactPos].seteMail(readWithBuf());

				// if(phoneBook[contactPos].geteMail().equals("-1"))
				// phoneBook[contactPos].seteMail("");

				do {

					phoneBook[contactPos].seteMail(readWithBuf());

					final String E_MAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
							+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

					Pattern pattern = Pattern.compile(E_MAIL_PATTERN);
					matcher = pattern.matcher(phoneBook[contactPos].geteMail());
					if (matcher.matches() == true
							|| phoneBook[contactPos].geteMail().isEmpty()) {
						// OK then
					} else {
						System.out.println("error, pls enter a valid email");
					}
				} while (matcher.matches() == false
						&& !phoneBook[contactPos].geteMail().isEmpty());
				System.out.println("contact after editing is \n"
						+ phoneBook[contactPos].toString());
				break;

			case 5:
				do {
					System.out
							.println("enter address: or press enter if you want it empty");

					phoneBook[contactPos].setAddress(readWithBuf());
					if (!phoneBook[contactPos].getAddress().equals("")) {
						if (phoneBook[contactPos].getAddress().contains(",")) {
							System.out.println("error, cannot contain \",\"");
						}
					}

				} while (phoneBook[contactPos].getAddress().contains(","));
				System.out.println("contact after editing is \n"
						+ phoneBook[contactPos].toString());
				break;

			case 6:
				do {
					System.out
							.println("enter note: or press enter if you want it empty");

					phoneBook[contactPos].setNotes(readWithBuf());
					if (!phoneBook[contactPos].getNotes().equals("")) {
						if (phoneBook[contactPos].getNotes().contains(",")) {
							System.out.println("error, cannot contain \",\"");
						}
					}

				} while (phoneBook[contactPos].getNotes().contains(","));
				System.out.println("contact after editing is \n"
						+ phoneBook[contactPos].toString());
				break;
			case 7:
				done = true;
				System.out.println("contact after editing is \n"
						+ phoneBook[contactPos].toString());
				break;
			default:
				System.out.println("Illegal choice! Please try again.");
				break;
			}
		}
	}
	/**
	 * This method takes a parameter (integer the index of contact in the
	 * phone book array) and deletes it from the array and shifts all the
	 * contacts to fit right in place after deletion, and returns void.
	 */
	public static void deleteContact(int contactPos) throws IOException {
		
		if (contactPos == phoneBook.length - 1) {
			phoneBook[contactPos] = null;
			Contact.setNumberOfContacts(Contact.getNumberOfContacts() - 1);
		} else {
			System.arraycopy(phoneBook, contactPos + 1, phoneBook, contactPos,
					phoneBook.length - 1 - contactPos);

		}
		Contact.setNumberOfContacts(Contact.getNumberOfContacts() - 1);
		System.out.println("contact deleted.");
		System.out.println("\npress enter to continue");
		readWithBuf();
	}
	/**
	 * This method takes no parameter and prints all the contacts in the
	 * array phone book, and returns void nothing
	 */
	public static void printPhoneBook() throws IOException {
		

		for (int i = 0; i < phoneBook.length; i++) {
			if (phoneBook[i] != null)
				System.out.println(phoneBook[i].toString());

		}
		System.out
				.println("___________________________________________________________");
		System.out.println("\npress enter to continue");
		readWithBuf();
	}
	/**
	 * This method takes a parameter (integer the type of operation the
	 * search is needed for) type=0 for only search,type=1 for search and
	 * edit, type=2 for search and delete, and returns void.
	 */
	public static void search(int type) throws IOException {
		
		int answer;
		do {
			System.out
					.println("\nHow would you like to search for the contact:");
			System.out
					.println("1. By first name.\n2. By last name.\n3. By phone number.\n4. Back to main menu");
			answer = -1;
			try {
				answer = Integer.parseInt(Phonebook.readWithBuf());
			} catch (Exception e) {

			}
			if (answer == 1) {
				searchByFirst(type);
			} else if (answer == 2) {
				searchByLast(type);
			} else if (answer == 3) {
				searchByPhone(type);
			} else if (answer == 4) {

			} else {
				System.out.println("wrong answer, please try again");
			}
		} while (answer != 1 && answer != 2 && answer != 3 && answer != 4);
	}

	private static int[] checkArr; // this array is used to check if the number
									// that the user entered to edit or delete
									// is among the shown result contacts, used
									// in searchByFirst(int type),
									// searchByLast(int type), searchByPhone(int
									// type) and afterSearch(int type)
	/**
	 * This method takes one parameter (integer type of operation after
	 * search) and return void.
	 */
	public static void searchByFirst(int type) throws IOException {
		
		System.out.println("enter the first name or part of it: ");
		String name = readWithBuf();
		boolean notFound = true;
		int n = 0;
		checkArr = new int[Contact.getNumberOfContacts()];
		for (int j = 0; j < checkArr.length; j++) {
			checkArr[j] = -1;
		}
		for (int i = 0; i < Contact.getNumberOfContacts(); i++) {
			if (phoneBook[i] != null) {
				if (phoneBook[i].getFirstName().toLowerCase()
						.contains(name.toLowerCase())) {
					System.out.print("index= " + i + "  ");
					System.out.println(phoneBook[i].toString());
					notFound = false;
					checkArr[n] = i;
					n++;
				}
			}
		}

		if (notFound) {
			System.out.println("not found");
		} else {
			afterSearch(type);
		}
	}
	/**
	 * This method takes one parameter (integer type of operation after
	 * search) and return void.
	 */
	public static void searchByLast(int type) throws IOException {
		
		System.out.println("enter the last name or part of it: ");
		String name = readWithBuf();
		boolean notFound = true;
		int n = 0;
		checkArr = new int[Contact.getNumberOfContacts()];
		for (int j = 0; j < checkArr.length; j++) {
			checkArr[j] = -1;
		}
		for (int i = 0; i < Contact.getNumberOfContacts(); i++) {
			if (phoneBook[i].getLastName().toLowerCase()
					.contains(name.toLowerCase())) {
				System.out.print("index= " + i + "  ");
				System.out.println(phoneBook[i].toString());
				notFound = false;
				checkArr[n] = i;
				n++;
			}
		}
		if (notFound) {
			System.out.println("not found");
		} else {
			afterSearch(type);
		}
	}
	/**
	 * This method takes one parameter (integer type of operation after
	 * search) and return void.
	 */
	public static void searchByPhone(int type) throws IOException {
		
		System.out.println("enter the phone number or part of it: ");
		String name = readWithBuf();
		boolean notFound = true;
		int n = 0;
		checkArr = new int[Contact.getNumberOfContacts()];
		for (int j = 0; j < checkArr.length; j++) {
			checkArr[j] = -1;
		}
		for (int i = 0; i < Contact.getNumberOfContacts(); i++) {
			if (phoneBook[i].getPhoneNumber().toLowerCase()
					.contains(name.toLowerCase())) {
				System.out.print("index= " + i + "  ");
				System.out.println(phoneBook[i].toString());
				notFound = false;
				checkArr[n] = i;
				n++;
			}
		}
		if (notFound) {
			System.out.println("not found");
		} else {
			afterSearch(type);
		}
	}
	/**
	 * This method takes one parameter(integer type of operation after the
	 * search done)type=0 for only search,type=1 for search and edit, type=2
	 * for search and delete, and returns void. And calls the delete and
	 * edit methods.
	 * @param this is a parameter that determines the action needed after  
	 */
	public static void afterSearch(int type) throws IOException {
		
		if (type == 1) {
			boolean again = false;
			int answer;
			boolean checkBoolean = false;
			do {
				again = false;
				checkBoolean = false;
				System.out
						.println("\nenter the index number of the contact you want to edit:");

				answer = -1;
				try {
					answer = Integer.parseInt(Phonebook.readWithBuf());

					for (int k = 0; k < checkArr.length; k++) {
						if (checkArr[k] == answer) {
							checkBoolean = true;
						}
					}

					if (answer < 0
							|| answer > Contact.getNumberOfContacts() - 1) {
						System.out.println("wrong answer, try again");
						again = true;
					} else if (checkBoolean == false) {
						System.out.println("wrong answer, try again");
						again = true;
					}
				} catch (Exception e) {
					System.out.println("wrong answer, try again");
					again = true;
				}

			} while (again == true);
			editContact(answer);
		} else if (type == 2) {

			boolean again = false;
			int answer;
			boolean checkBoolean = false;
			do {
				again = false;
				checkBoolean = false;
				System.out
						.println("\nenter the index number of the contact you want to delete: ");

				answer = -1;
				try {
					answer = Integer.parseInt(Phonebook.readWithBuf());

					for (int k = 0; k < checkArr.length; k++) {
						if (checkArr[k] == answer) {
							checkBoolean = true;
						}
					}

					if (answer < 0
							|| answer > Contact.getNumberOfContacts() - 1) {
						System.out.println("wrong answer, try again");
						again = true;
					} else if (checkBoolean == false) {
						System.out.println("wrong answer, try again");
						again = true;
					}
				} catch (Exception e) {
					System.out.println("wrong answer, try again");
					again = true;
				}

			} while (again == true);
			deleteContact(answer);
		} else {
			System.out.println("\npress enter to continue");
			readWithBuf();
		}
	}
	/**
	 * This method takes no parameters, and it prints the array phone book
	 * into an external file, and returns void.
	 */
	public static void save() {
		

		try {
			PrintStream ps = new PrintStream("phonebook.txt");
			for (int i = 0; i < phoneBook.length; i++) {
				if (phoneBook[i] != null)
					ps.println(phoneBook[i].toString());
			}
			ps.close();
		} catch (IOException ioe) {

		}
	}
	/**
	 * This method takes no parameters and reads all the contacts from an
	 * external file and calls the constructor of contacts class and
	 * generates the array with all contacts in the program.
	 */
	public static void load() throws IOException {
		
		BufferedReader fileBuffer = new BufferedReader(new FileReader(
				"phonebook.txt"));
		String[] splittedLine;
		String line;
		String firstName = "";
		String lastName = "";
		String phoneNum = "";
		String eMail = "";
		String address = "";
		String notes = "";

		while ((line = fileBuffer.readLine()) != null) {
			splittedLine = line.split(", ");
			firstName = "";
			lastName = "";
			phoneNum = "";
			eMail = "";
			address = "";
			notes = "";

			if (splittedLine.length - 1 >= 0)
				firstName = splittedLine[0];
			if (splittedLine.length - 1 >= 1)
				lastName = splittedLine[1];
			if (splittedLine.length - 1 >= 2)
				phoneNum = splittedLine[2];
			if (splittedLine.length - 1 >= 3)
				eMail = splittedLine[3];
			if (splittedLine.length - 1 >= 4)
				address = splittedLine[4];
			if (splittedLine.length - 1 >= 5)
				notes = splittedLine[5];

			Contact entry = new Contact(firstName, lastName, phoneNum, eMail,
					address, notes);

			phoneBook[Contact.getNumberOfContacts() - 1] = entry;

			if (Contact.getNumberOfContacts() == phoneBook.length - 1) {
				Contact[] phoneBooktemp = new Contact[phoneBook.length * 2];
				System.arraycopy(phoneBook, 0, phoneBooktemp, 0,
						phoneBook.length);
				phoneBook = phoneBooktemp;
			}
		}

		fileBuffer.close();

	}

}
