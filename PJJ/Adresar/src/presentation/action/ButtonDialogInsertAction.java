
package presentation.action;

import core.AddressaryException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import presentation.AddressaryFrame;
import presentation.Main;
import presentation.dialog.DialogInsertCustomer;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonDialogInsertAction.
 *
 * @author Ludvik Valíèek
 */
public class ButtonDialogInsertAction implements ActionListener {

	/** The c. */
	DialogInsertCustomer c;

	/**
	 * Instantiates a new button dialog insert action.
	 *
	 * @param c
	 *            the c
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public ButtonDialogInsertAction(DialogInsertCustomer c) throws AddressaryException {
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
			String customerName = c.getCustomerName();
			String customerSurname = c.getCustomerSurname();
			String customerAddress = c.getCustomerAddress();
			String customerCommentary = c.getCustomerComments();
			Main.getInst().getDAOInterface().createCustomer(customerName, customerSurname, customerAddress,
					customerCommentary);
			AddressaryFrame.getInst().refresh();
			c.dispose();
		} catch (AddressaryException ex) {
			JOptionPane.showMessageDialog(c, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
