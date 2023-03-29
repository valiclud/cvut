

package core;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Customer.
 *
 * @author Ludvik Valicek
 */

public class Customer implements Serializable {


    /** The custmer id. */
    private CustomerId custmerId;
    
    /** The name. */
    private String name;
    
    /** The surname. */
    private String surname;
    
    /** The address. */
    private String address;
    
    /** The commentary. */
    private String commentary;

    /**
     * Instantiates a new customer.
     *
     * @param custmerId the custmer id
     * @param name the name
     * @param surname the surname
     * @param address the address
     * @param commentary the commentary
     */
    public Customer(CustomerId custmerId, String name, String surname,String address, String commentary) {
        this.custmerId = custmerId;
        this.name = name;
        this.surname=surname;
        this.address=address;
        this.commentary = commentary;
    }

    /**
     * Gets the customer id.
     *
     * @return the customer id
     */
    public CustomerId getCustomerId() {
        return custmerId;
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
    public String getSurname(){
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return custmerId+":"+ name;
    }
}
