

package integration;
import core.*;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Interface DAOInterface.
 *
 * @author Ludvik Valíèek
 */
public interface DAOInterface {

    /**
     * Creates the customer.
     *
     * @param name the name
     * @param surname the surname
     * @param address the address
     * @param commentary the commentary
     * @throws AddressaryException the addressary exception
     */
    public void createCustomer(String name, String surname, String address, String commentary) throws AddressaryException;

    /**
     * Delete customer.
     *
     * @param customerId the customer id
     * @throws AddressaryException the addressary exception
     */
    public void deleteCustomer(CustomerId customerId) throws AddressaryException;

    /**
     * List all customers.
     *
     * @return the collection
     * @throws AddressaryException the addressary exception
     */
    public Collection<Customer> listAllCustomers()throws AddressaryException;

    /**
     * Find customer by id.
     *
     * @param customerId the customer id
     * @return the customer
     * @throws AddressaryException the addressary exception
     */
    public Customer findCustomerById(CustomerId customerId) throws AddressaryException;

    /**
     * Find customer by surname.
     *
     * @param surname the surname
     * @return the collection
     * @throws AddressaryException the addressary exception
     */
    public Collection<Customer> findCustomerBySurname (String surname)throws AddressaryException;

    /**
     * Renew customer.
     *
     * @param customer the customer
     * @throws AddressaryException the addressary exception
     */
    public void renewCustomer(Customer customer)throws AddressaryException;

    /**
     * Gets the last id.
     *
     * @return the last id
     * @throws AddressaryException the addressary exception
     */
    public int getLastId() throws AddressaryException;

    /**
     * Exists id.
     *
     * @param id the id
     * @return true, if successful
     * @throws AddressaryException the addressary exception
     */
    public boolean existsId(int id) throws AddressaryException;

    /**
     * Close.
     *
     * @throws AddressaryException the addressary exception
     */
    public void close() throws AddressaryException;
}
