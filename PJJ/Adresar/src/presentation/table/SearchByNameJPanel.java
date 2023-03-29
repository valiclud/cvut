/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.table;

import core.AddressaryException;
import core.Customer;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchByNameJPanel.
 *
 * @author Ludvik Valicek
 */
public class SearchByNameJPanel extends JPanel {

	/** The customer table model. */
	private CustomerTableModel customerTableModel;

	/** The customer table. */
	private JTable customerTable;

	/** The name. */
	public String name;

	/**
	 * Creates a new instance of CustomerTablePanel.
	 */
	public SearchByNameJPanel() {
		setLayout(new BorderLayout());
		customerTableModel = new CustomerTableModel();
		add(new JScrollPane(customerTable = new JTable(customerTableModel)), BorderLayout.CENTER);
		customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		setBorder(BorderFactory.createTitledBorder("Found customers"));

	}

	/**
	 * Refresh data.
	 *
	 * @param name
	 *            the name
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public void refreshData(String name) throws AddressaryException {
		customerTableModel.refresh(name);
	}
}
