public class Contact {
	/** This is a string in which the first name will be saved for each object */
	private String firstName;
	/** This is a string in which the last name will be saved for each object */
	private String lastName;
	/** This is a string in which the phone number will be saved for each object */
	private String phoneNumber;
	/** This is a string in which the e-mail will be saved for each object */
	private String eMail;
	/** This is a string in which the address will be saved for each object */
	private String address;
	/** This is a string in which the notes will be saved for each object */
	private String notes;
	/**
	 * This is an integer representing the number of contacts (number of objects
	 * created and are in the array phone book)
	 */
	private static int numberOfContacts = 0;

	

	// public Contact(String first, String last, String phone){
	// firstName=first;
	// lastName=last;
	// phoneNumber=phone;
	// eMail="";
	// address="";
	// notes="";
	//
	// numberOfContacts++;
	// }
	//
	// public Contact(String first, String last, String phone, String mail){
	// firstName=first;
	// lastName=last;
	// phoneNumber=phone;
	// eMail=mail;
	// address="";
	// notes="";
	//
	// numberOfContacts++;
	// }
	//
	// public Contact(String first, String last, String phone, String
	// mail,String address){
	// firstName=first;
	// lastName=last;
	// phoneNumber=phone;
	// eMail=mail;
	// this.address=address;
	// notes="";
	//
	// numberOfContacts++;
	// }
	/**
	 * This is a constructor for the class Contact, takes six String
	 * parameters representing the (first name, last name, phone number,
	 * e-mail, address, notes)
	 */
	public Contact(String first, String last, String phone, String mail,
			String address, String note) {
		
		firstName = first;
		lastName = last;
		phoneNumber = phone;
		eMail = mail;
		this.address = address;
		notes = note;

		numberOfContacts++;
	}

	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public static int getNumberOfContacts() {
		return numberOfContacts;
	}
	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public static void setNumberOfContacts(int numberOfContacts) {
		Contact.numberOfContacts = numberOfContacts;
	}
	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public String geteMail() {
		return eMail;
	}
	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public String getAddress() {
		return address;
	}
	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 *one of the (getters and setters)for all the variables in the
	 * class Contact.
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	/**
	 * This method prints the object (contact) in one line printing each
	 * variable separated by ", ".
	 */
	@Override
	public String toString() {
		
		return firstName + ", " + lastName + ", " + phoneNumber + ", " + eMail
				+ ", " + address + ", " + notes;
	}

}
