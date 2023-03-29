
package presentation.action;

import core.AddressaryException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.Main;
import presentation.dialog.DialogInsertCustomer;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonDialogOKAction.
 *
 * @author Ludvik Valicek
 */
public class ButtonDialogOKAction implements ActionListener {

	/** The d. */
	DialogInsertCustomer d;

	/**
	 * Instantiates a new button dialog ok action.
	 *
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public ButtonDialogOKAction() throws AddressaryException {
		d = new DialogInsertCustomer();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		try {
			String customerName = d.getCustomerName();
			String customerSurname = d.getCustomerSurname();
			String customerAddress = d.getCustomerAddress();
			String customerCommentary = d.getCustomerComments();
			Main.getInst().getDAOInterface().createCustomer(customerName, customerSurname, customerAddress,
					customerCommentary);
			d.dispose();
		} catch (AddressaryException ex) {
			// MainPanel.getInstance().showErr(ex.toString());
		}
	}

}
