
package presentation.action;

import java.awt.event.ActionEvent;
import core.AddressaryException;
import javax.swing.AbstractAction;

import presentation.AddressaryFrame;
import presentation.Main;
import presentation.dialog.DialogInsertCustomer;

// TODO: Auto-generated Javadoc
/**
 * The Class InsertCustomerAction.
 *
 * @author Ludvik Valicek
 */

public class InsertCustomerAction extends AbstractAction {

	/** The insert customer dialog. */
	DialogInsertCustomer insertCustomerDialog;

	/**
	 * Vytvori novou instanci.
	 */
	public InsertCustomerAction() {
		this.insertCustomerDialog = insertCustomerDialog;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String customerName = insertCustomerDialog.getCustomerName();
			String customerSurname = insertCustomerDialog.getCustomerSurname();
			String customerAddress = insertCustomerDialog.getCustomerAddress();
			String customerCommentary = insertCustomerDialog.getCustomerComments();
			Main.getInst().getDAOInterface().createCustomer(customerName, customerSurname, customerAddress,
					customerCommentary);
			insertCustomerDialog.dispose();
		} catch (AddressaryException ex) {
			// AddressaryFrame.getInstance().showErr(ex.toString());
		}
	}
}
