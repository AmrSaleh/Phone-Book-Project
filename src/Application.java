import java.io.File;
import java.io.IOException;

public class Application {
	
	/**
	 * This is the main method that calls all the methods of class phone book.
	 * @author Amr
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		
		System.out.println("Welcome to Amr Phone Book");
		System.out.println("=========================");
		
		
		try{
		Phonebook.load();
		}catch(Exception e){
			
			  new File("phonebook.txt");
		}
		try {
			boolean repeat = true;
			while (repeat == true) {
				System.out
						.println("\nMain menu\n=========\nWhat would you like to do: ");
				System.out
						.println("\n1- Add a contact.\n2- View all contacts.\n3- Search for a contact.\n4- Edit a contact.\n5- Delete a contact.\n6- Exit program.");
				int answer = -1;
				try {
					answer = Integer.parseInt(Phonebook.readWithBuf());
				} catch (Exception e) {

				}
				if (answer == 1) {
					Phonebook.addContact();
					Phonebook.save();
				} else if (answer == 2) {
					System.out.println("\nAll contacts:\n============\n");
					System.out
							.println("First Name, Last Name, Phone Number, E-Mail, Address, Notes");
					System.out
							.println("___________________________________________________________\n");
					Phonebook.printPhoneBook();
					Phonebook.save();
				} else if (answer == 3) {
					Phonebook.search(0);

				} else if (answer == 4) {
					Phonebook.search(1);
					Phonebook.save();
				} else if (answer == 5) {
					Phonebook.search(2);
					Phonebook.save();
				} else if (answer == 6) {
					repeat = false;
					Phonebook.save();
				} else {
					System.out.println("wrong answer, try again");
				}
				Phonebook.save();
			}

		} catch (IOException e) {
			// System.err.println("ERROR IN INPUT");
			e.printStackTrace();
		}
		System.out
				.println("\nThank you for using Amr Phone Book\n\nprogrammer: Amr Saleh");
	}

}
