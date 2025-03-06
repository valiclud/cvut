package core;

public abstract class Person {

	/** The customer id. */
	PersonId personId;

	/** The name. */
	String name;

	/** The surname. */
	String surname;

	/** The address. */
	String address;

	/** The commentary. */
	String commentary;

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public PersonId getPersonId() {
		return personId;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the surname.
	 *
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname.
	 *
	 * @param surname the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the commentary.
	 *
	 * @return the commentary
	 */
	public String getCommentary() {
		return commentary;
	}

	/**
	 * Sets the commentary.
	 *
	 * @param commentary the new commentary
	 */
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	
}
