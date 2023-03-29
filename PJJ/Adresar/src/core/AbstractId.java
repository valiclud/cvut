

package core;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractId.
 *
 * @author Ludvik Valíèek abstract class for Identification Number creation
 */
public abstract class AbstractId implements Serializable, Comparable<AbstractId> {

	
	/** The id number. */
	private int idNumber = 0;

	/**
	 * Instantiates a new abstract id.
	 *
	 * @param idNumber
	 *            the id number
	 */
	public AbstractId(int idNumber) {
		this.idNumber = idNumber;
	}

	/**
	 * Gets the id number.
	 *
	 * @return the id number
	 */
	public int getIdNumber() {
		return idNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (this.idNumber * 7);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true; // reflexivita, aby neselhalo pretypovani

		if (getClass() != o.getClass())
			return false; // porovna 2 objekty

		final AbstractId other = (AbstractId) o; // pretypovani reference na o
													// se ulozi do other, abych
													// porovnaval AbstractId
		return compareTo(other) == 0; // vlastni porovnani Id dvou objektu
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(AbstractId o) {
		return idNumber - o.getIdNumber();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(idNumber);
	}
}