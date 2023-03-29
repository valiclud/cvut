/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.dialog;

import core.AddressaryException;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import presentation.action.ButtonDialogDeleteAction;

// TODO: Auto-generated Javadoc
/**
 * The Class DialogDeleteCustomer.
 *
 * @author Ludvik Valicek
 */
public class DialogDeleteCustomer extends AbstractDialog {

	/** The b ok. */
	JButton bOK;

	/**
	 * Instantiates a new dialog delete customer.
	 *
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public DialogDeleteCustomer() throws AddressaryException {
		super("Delete Customer");

		this.setSize(100, 90);

		inPanel.setLayout(new GridLayout(1, 0));

		inPanel.add(new JLabel("ID to delete"));
		inPanel.add(id = new JTextField(20));

		bOK = new JButton("OK");
		bPanel.add(bOK);
		bPanel.add(Box.createVerticalStrut(3));
		bOK.addActionListener(new ButtonDialogDeleteAction(this));

		pack();
		setVisible(true);
	}

}
