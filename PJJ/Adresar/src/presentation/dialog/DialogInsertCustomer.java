package presentation.dialog;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import core.*;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import presentation.action.ButtonDialogInsertAction;

// TODO: Auto-generated Javadoc
/**
 * The Class DialogInsertCustomer.
 *
 * @author Ludvik Valicek
 */
public class DialogInsertCustomer extends AbstractDialog {

	/** The b ok. */
	JButton bOK;

	/**
	 * Instantiates a new dialog insert customer.
	 *
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public DialogInsertCustomer() throws AddressaryException {
		super("Insert Customer");

		this.setSize(100, 90);

		inPanel.setLayout(new GridLayout(4, 0));

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
		bOK.addActionListener(new ButtonDialogInsertAction(this));

		pack();
		setVisible(true);
	}

}
