
package core;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Customer.
 *
 * @author Ludvik Valicek
 */

public class Customer extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The passport No. */
	private String passportNo;
	
	private List rooms;

	/**
	 * Instantiates a new customer.
	 *
	 * @param personId the customer id
	 * @param passportNo the passport No
	 * @param name       the name
	 * @param surname    the surname
	 * @param address    the address
	 * @param commentary the commentary
	 */
	public Customer(PersonId personId, String passportNo, String name, String surname, String address,
			String commentary, List rooms) {
		this.personId = personId;
		this.passportNo = passportNo;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.commentary = commentary;
		this.rooms = rooms;
	}

	/**
	 * Gets the passportNo.
	 *
	 * @return the passportNo
	 */
	public String getPassportNo() {
		return passportNo;
	}

	/**
	 * Sets the passportNo.
	 *
	 * @param passportNo the new passportNo
	 */
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	
	public List getRooms() {
		return rooms;
	}

	public void setRooms(List rooms) {
		this.rooms = rooms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return personId + ":" + name;
	}
}
