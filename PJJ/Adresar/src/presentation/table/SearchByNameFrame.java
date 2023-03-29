/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.table;

import core.AddressaryException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchByNameFrame.
 *
 * @author Ludvik Valicek
 */
public class SearchByNameFrame extends JFrame {

	/** The name j panel. */
	private SearchByNameJPanel nameJPanel;

	/** The b j panel. */
	private BJPanel bJPanel;

	/**
	 * The Class BJPanel.
	 */
	protected class BJPanel extends JPanel {

		/**
		 * Instantiates a new BJ panel.
		 */
		BJPanel() {
			setLayout(new FlowLayout());
			JButton del = new JButton("Cancel");
			this.add(del);
			del.addActionListener(new ActionButtonCancel());
		}
	}

	/**
	 * Instantiates a new search by name frame.
	 */
	public SearchByNameFrame() {

		this.setLayout(new BorderLayout(20, 0));
		this.setAlwaysOnTop(true);

		bJPanel = new BJPanel();
		this.add(bJPanel, BorderLayout.NORTH);

		nameJPanel = new SearchByNameJPanel();
		this.add(nameJPanel, BorderLayout.SOUTH);
		this.pack();

		this.setVisible(true);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
			}
		});

		setLocation(300, 200);

		pack();
		setVisible(true);

	}

	/**
	 * Refresh.
	 *
	 * @param name
	 *            the name
	 */
	public void refresh(String name) {
		try {
			nameJPanel.refreshData(name);
		} catch (AddressaryException ex) {
			JOptionPane.showMessageDialog(this, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * The Class ActionButtonCancel.
	 */
	class ActionButtonCancel implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}
