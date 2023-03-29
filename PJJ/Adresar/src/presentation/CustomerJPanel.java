

package presentation;

import core.Customer;
import core.AddressaryException;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerJPanel.
 *
 * @author Ludvik Valíèek
 */
public class CustomerJPanel extends JPanel {

    /** The customer table model. */
    private CustomerTableModel customerTableModel;
    
    /** The customer table. */
    private JTable customerTable;

    /**
     *  Creates a new instance of CustomerTablePanel.
     */
    public CustomerJPanel() {
        setLayout(new BorderLayout());
        customerTableModel = new CustomerTableModel();
        add(new JScrollPane(customerTable = new JTable(customerTableModel)), BorderLayout.CENTER);
        customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//      Sets the table's selection mode to allow only single selections, a single
//     * contiguous interval, or multiple intervals.
        //customerTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

//           @Override
//            public void valueChanged(ListSelectionEvent e) {
//                Main.getInst().stateChanged();
//            }
   //     });
        setBorder(BorderFactory.createTitledBorder("Customers"));

    }

    /**
     * Gets the selected reader.
     *
     * @return the selected reader
     */
    public Customer getSelectedReader() {
        int row = customerTable.getSelectedRow();
        if (row == -1) {
            return null;
        }
        return customerTableModel.getCustomer(customerTable.getSelectedRow());
    }

    /**
     * Selected customer.
     *
     * @return true, if successful
     */
    public boolean selectedCustomer() { //Returns the index of the first selected row, -1 if no row is selected.
        if (customerTable.getSelectedRow() != -1) return true;
        return false;
    }

    /**
     * Refresh data.
     *
     * @throws AddressaryException the addressary exception
     */
    public void refreshData() throws AddressaryException {
        customerTableModel.refresh();
    }
}
