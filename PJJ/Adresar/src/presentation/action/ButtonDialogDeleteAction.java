
package presentation.action;

import core.AddressaryException;
import core.Customer;
import core.CustomerId;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import presentation.AddressaryFrame;
import presentation.Main;
import presentation.dialog.DialogDeleteCustomer;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonDialogDeleteAction.
 *
 * @author Ludvik Valicek
 */
public class ButtonDialogDeleteAction implements ActionListener {

	/** The i. */
	CustomerId i;

	/** The customer. */
	Customer customer;

	/** The c. */
	DialogDeleteCustomer c;

	/**
	 * Instantiates a new button dialog delete action.
	 *
	 * @param c
	 *            the c
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public ButtonDialogDeleteAction(DialogDeleteCustomer c) throws AddressaryException {
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
			int last = Main.getInst().getDAOInterface().getLastId();
			if ((id > last) | (id == 0))
				throw new AddressaryException("ID does not exist - please insert one more time with correct ID");
			else if (Main.getInst().getDAOInterface().existsId(id) == false)
				throw new AddressaryException("ID was already erased - please insert one more time with correct ID");
			i = new CustomerId(id);
			Main.getInst().getDAOInterface().deleteCustomer(i);
			AddressaryFrame.getInst().refresh();
			c.dispose();
		} catch (AddressaryException ex) {
			JOptionPane.showMessageDialog(c, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
