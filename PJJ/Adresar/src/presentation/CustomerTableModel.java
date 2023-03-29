

package presentation;

import core.Customer;
import core.AddressaryException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerTableModel.
 *
 * @author Ludvik Val��ek
 */

public class CustomerTableModel extends AbstractTableModel {

    /** The c. */
    private List<Customer> c = new ArrayList<Customer>();

    /* (non-Javadoc)
     * @see javax.swing.table.TableModel#getRowCount()
     */
    @Override
    public int getRowCount() {
        return c.size();
    }

    /* (non-Javadoc)
     * @see javax.swing.table.TableModel#getColumnCount()
     */
    @Override
    public int getColumnCount() {
        return 5;
    }

    /* (non-Javadoc)
     * @see javax.swing.table.TableModel#getValueAt(int, int)
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer customer = c.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return customer.getCustomerId();
            case 1:
                return customer.getName();
            case 2:
                return customer.getSurname();
            case 3:
                return customer.getAddress();
            case 4:
                return customer.getCommentary();
        }
        return null;
    }

    /* (non-Javadoc)
     * @see javax.swing.table.AbstractTableModel#getColumnName(int)
     */
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Name";
            case 2:
                return "Surname";
            case 3:
                return "Address";
            case 4:
                return "Commentary";
        }
        return null;
    }

    /**
     * Gets the customer.
     *
     * @param index the index
     * @return the customer
     */
    public Customer getCustomer(int index) {
        return c.get(index);
    }

    /**
     * Sort customers.
     *
     * @param c the c
     */
    //setřídění zákazníků podle jména
    public void sortCustomers(Collection<Customer> c) {
        this.c = new ArrayList(c);
        Collections.<Customer>sort(this.c, new Comparator<Customer>() {

            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

   /**
    * Refresh.
    *
    * @throws AddressaryException the addressary exception
    */
   public void refresh() throws AddressaryException {
        sortCustomers(Main.getInst().getDAOInterface().listAllCustomers());
        }
}
