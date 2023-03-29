
package presentation.action;

import core.AddressaryException;
import core.Customer;
import core.CustomerId;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import presentation.AddressaryFrame;
import presentation.Main;
import presentation.dialog.DialogModifyCustomer;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonDialogModifyAction.
 *
 * @author Ludvik Valicek
 */
public class ButtonDialogModifyAction implements ActionListener {

	/** The i. */
	CustomerId i;

	/** The customer. */
	Customer customer;

	/** The c. */
	DialogModifyCustomer c;

	/**
	 * Instantiates a new button dialog modify action.
	 *
	 * @param c
	 *            the c
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public ButtonDialogModifyAction(DialogModifyCustomer c) throws AddressaryException {
		this.c = c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		try {
			int id = c.getCustomerID();
			String customerName = c.getCustomerName();
			String customerSurname = c.getCustomerSurname();
			String customerAddress = c.getCustomerAddress();
			String customerCommentary = c.getCustomerComments();
			int last = Main.getInst().getDAOInterface().getLastId();
			if ((id > last) | (id == 0))
				throw new AddressaryException("ID does not exist - please insert one more time with correct ID");
			else if (Main.getInst().getDAOInterface().existsId(id) == false)
				throw new AddressaryException("ID was already erased - please insert one more time with correct ID");

			i = new CustomerId(id);
			customer = new Customer(i, customerName, customerSurname, customerAddress, customerCommentary);
			Main.getInst().getDAOInterface().renewCustomer(customer);
			AddressaryFrame.getInst().refresh();
			c.dispose();
		} catch (AddressaryException ex) {
			JOptionPane.showMessageDialog(c, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException enf) {
			JOptionPane.showMessageDialog(c, enf.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
