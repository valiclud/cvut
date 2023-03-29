 

package presentation;

import presentation.table.ButtonJPanel;
import presentation.table.CustomerJPanel;
import presentation.table.CustomerTableModel;
import core.AddressaryException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


// TODO: Auto-generated Javadoc
/**
 * The Class AddressaryFrame.
 *
 * @author Ludvik Valíèek
 */
public class AddressaryFrame extends JFrame {

    /** The customer j panel. */
    private CustomerJPanel customerJPanel;
    
    /** The customer table model. */
    private CustomerTableModel customerTableModel;
    
    /** The button j panel. */
    ButtonJPanel buttonJPanel;

    /** The inst. */
    //singlton
    private static AddressaryFrame inst;

    /**
     * Gets the inst.
     *
     * @return the inst
     */
    public static AddressaryFrame getInst() {
        if (inst == null)
            inst = new AddressaryFrame();
        return inst;
        }

    /**
     * Instantiates a new addressary frame.
     */
    private AddressaryFrame() {

         inst=this;        
 
        this.setLayout(new BorderLayout(20,0));

        buttonJPanel = new ButtonJPanel();
        this.add(buttonJPanel, BorderLayout.NORTH);

        customerJPanel = new CustomerJPanel();
        this.add(customerJPanel,BorderLayout.SOUTH );
        this.pack();
      
        this.setVisible(true);
      
      addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
            try {
                Main.getInst().getDAOInterface().close();
             }
            catch (AddressaryException ee){
                JOptionPane.showMessageDialog(AddressaryFrame.getInst(), ee.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                System.exit(1);
                }
        });

       setLocation(300, 200);

        pack();
        setVisible(true);
      }

    
  /**
   * Gets the customer j panel.
   *
   * @return the customer j panel
   */
  public CustomerJPanel getCustomerJPanel() {
        return customerJPanel;
    }

  /**
   * Gets the customer table model.
   *
   * @return the customer table model
   */
  public CustomerTableModel getCustomerTableModel() {
        return customerTableModel;
    }

  /**
   * Refresh.
   */
  public void refresh() {
        try {
            getCustomerJPanel().refreshData();
      } catch (AddressaryException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
