/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.table;

import core.Customer;
import core.AddressaryException;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerJPanel.
 *
 * @author Ludvik Valicek
 */
public class CustomerJPanel extends JPanel {

	/** The customer table model. */
	private CustomerTableModel customerTableModel;

	/** The customer table. */
	private JTable customerTable;

	/**
	 * Creates a new instance of CustomerTablePanel.
	 */
	public CustomerJPanel() {
		setLayout(new BorderLayout());
		customerTableModel = new CustomerTableModel();
		add(new JScrollPane(customerTable = new JTable(customerTableModel)), BorderLayout.CENTER);
		customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Sets the table's selection mode to allow only single selections, a
		// single
		// * contiguous interval, or multiple intervals.

		setBorder(BorderFactory.createTitledBorder("Customers"));

	}

	/**
	 * Refresh data.
	 *
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public void refreshData() throws AddressaryException {
		customerTableModel.refresh();
	}
}
