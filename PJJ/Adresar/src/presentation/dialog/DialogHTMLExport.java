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
import presentation.action.ButtonDialogHTMLExportAction;

// TODO: Auto-generated Javadoc
/**
 * The Class DialogHTMLExport.
 *
 * @author Ludvik Valicek
 */
public class DialogHTMLExport extends AbstractDialog {

	/** The b ok. */
	JButton bOK;

	/**
	 * Instantiates a new dialog html export.
	 *
	 * @throws AddressaryException
	 *             the addressary exception
	 */
	public DialogHTMLExport() throws AddressaryException {
		super("Insert file name");

		this.setSize(100, 90);

		inPanel.setLayout(new GridLayout(1, 0));

		inPanel.add(new JLabel("Insert HTML file name"));
		inPanel.add(filename = new JTextField(20));

		bOK = new JButton("OK");
		bPanel.add(bOK);
		bPanel.add(Box.createVerticalStrut(3));
		bOK.addActionListener(new ButtonDialogHTMLExportAction(this));

		pack();
		setVisible(true);
	}

}
