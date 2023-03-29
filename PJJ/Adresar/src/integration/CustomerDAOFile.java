

package integration;

import core.*;
import java.io.*;
import core.AddressaryException;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerDAOFile.
 *
 * @author Ludvik Valíèek
 */
public class CustomerDAOFile implements DAOInterface {

	/** The customer map. */
	SortedMap<CustomerId, Customer> customerMap;

	/** The customer. */
	Collection<Customer> customer;

	/** The customer sub map. */
	SortedMap<CustomerId, Customer> customerSubMap;

	/**
	 * Creates a new instance of LibraryMapImplementation.
	 *
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public CustomerDAOFile() throws AddressaryException {
		try {
			FileInputStream fis = new FileInputStream("file/customers.data");

			ObjectInputStream cust = new ObjectInputStream(fis);
			customerMap = (SortedMap<CustomerId, Customer>) cust.readObject();
		} catch (FileNotFoundException ex) {
			customerMap = new TreeMap<CustomerId, Customer>();
		} catch (IOException ex) {
			throw new AddressaryException(ex);
		} catch (ClassNotFoundException ex) {
			throw new AddressaryException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see integration.DAOInterface#createCustomer(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void createCustomer(String name, String surname, String address, String commentary)
			throws AddressaryException {
		int max = 0;
		SortedSet<CustomerId> cm = (SortedSet<CustomerId>) customerMap.keySet();
		CustomerId id;
		if (!cm.isEmpty()) {
			id = customerMap.lastKey();
			max = id.getIdNumber();
		}
		Customer newCustomer = new Customer(new CustomerId(max + 1), name, surname, address, commentary);
		customerMap.put(newCustomer.getCustomerId(), newCustomer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see integration.DAOInterface#deleteCustomer(core.CustomerId)
	 */
	@Override
	public void deleteCustomer(CustomerId customerId) throws AddressaryException {
		if (customerMap.remove(customerId) == null) {
			throw new AddressaryException("The customer does not exist");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see integration.DAOInterface#listAllCustomers()
	 */
	@Override
	public Collection<Customer> listAllCustomers() throws AddressaryException {
		return new ArrayList<Customer>(customerMap.values());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see integration.DAOInterface#findCustomerById(core.CustomerId)
	 */
	@Override
	public Customer findCustomerById(CustomerId customerId) throws AddressaryException {
		Customer c = customerMap.get(customerId);
		if (c == null) {
			throw new AddressaryException("The customer  does not exist");
		}
		return c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see integration.DAOInterface#findCustomerBySurname(java.lang.String)
	 */
	@Override
	public Collection<Customer> findCustomerBySurname(String surname) throws AddressaryException {
		Collection<Customer> c = listAllCustomers();
		Collection<Customer> d = new ArrayList<Customer>();

		// for (Iterator<Customer> it
		// =customerMap.values().iterator();it.hasNext(); ){
		// it.next();

		for (Customer cust : c) {
			if (cust.getSurname().compareToIgnoreCase(surname) == 0)
				d.add(cust);
		}
		if (d.isEmpty()) {
			throw new AddressaryException("The name does not exist");
		}
		return d;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see integration.DAOInterface#renewCustomer(core.Customer)
	 */
	@Override
	public void renewCustomer(Customer customer) throws AddressaryException {
		customerMap.put(customer.getCustomerId(), customer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see integration.DAOInterface#getLastId()
	 */
	@Override
	public int getLastId() throws AddressaryException {
		CustomerId id;
		if (customerMap.isEmpty())
			return 0;
		else
			id = customerMap.lastKey();
		return id.getIdNumber();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see integration.DAOInterface#existsId(int)
	 */
	@Override
	public boolean existsId(int id) throws AddressaryException {
		CustomerId c = new CustomerId(id);
		if (customerMap.containsKey(c))
			return true;
		c = null;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see integration.DAOInterface#close()
	 */
	@Override
	public void close() throws AddressaryException {
		try {
			FileOutputStream fos = new FileOutputStream("file/customers.data");
			ObjectOutputStream customers = new ObjectOutputStream(fos);
			customers.writeObject(customerMap);
			customers.close();
		} catch (IOException ex) {
			throw new AddressaryException(ex);
		}
	}

}
