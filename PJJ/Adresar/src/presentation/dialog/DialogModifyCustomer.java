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
import presentation.action.ButtonDialogModifyAction;

// TODO: Auto-generated Javadoc
/**
 * The Class DialogModifyCustomer.
 *
 * @author Ludvik Valicek
 */
public class DialogModifyCustomer extends AbstractDialog {

	/** The b ok. */
	JButton bOK;

	/**
	 * Instantiates a new dialog modify customer.
	 *
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public DialogModifyCustomer() throws AddressaryException {
		super("Modify Customer");

		this.setSize(100, 90);

		inPanel.setLayout(new GridLayout(5, 0));
		inPanel.add(new JLabel("ID"));
		inPanel.add(id = new JTextField(20));
		inPanel.add(new JLabel("Name:"));
		inPanel.add(name = new JTextField(20));
		inPanel.add(new JLabel("Surname:"));
		inPanel.add(surname = new JTextField(20));
		inPanel.add(new JLabel("Address:"));
		inPanel.add(address = new JTextField(20));
		inPanel.add(new JLabel("Commentary:"));
		inPanel.add(comments = new JTextField(20));

		bOK = new JButton("OK");
		bPanel.add(bOK);
		bPanel.add(Box.createVerticalStrut(3));
		bOK.addActionListener(new ButtonDialogModifyAction(this));

		pack();
		setVisible(true);
	}

}
