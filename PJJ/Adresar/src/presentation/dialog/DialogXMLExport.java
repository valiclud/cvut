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
import presentation.action.ButtonDialogXMLExportAction;

// TODO: Auto-generated Javadoc
/**
 * The Class DialogXMLExport.
 *
 * @author Ludvik Valicek
 */
public class DialogXMLExport extends AbstractDialog {

	/** The b ok. */
	JButton bOK;

	/**
	 * Instantiates a new dialog xml export.
	 *
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public DialogXMLExport() throws AddressaryException {
		super("Insert file name");

		this.setSize(100, 90);

		inPanel.setLayout(new GridLayout(1, 0));

		inPanel.add(new JLabel("Insert XML file name"));
		inPanel.add(filename = new JTextField(20));

		bOK = new JButton("OK");
		bPanel.add(bOK);
		bPanel.add(Box.createVerticalStrut(3));
		bOK.addActionListener(new ButtonDialogXMLExportAction(this));

		pack();
		setVisible(true);
	}

}
