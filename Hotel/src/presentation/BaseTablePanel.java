package presentation;

import static presentation.main.ApplicationSetting.COLOR_BASE;
import static presentation.main.ApplicationSetting.COLOR_BASE_LETTERS;
import static presentation.main.ApplicationSetting.COLOR_BUTTON_BACKGROUND;
import static presentation.main.ApplicationSetting.LETTER_MEDIUM;
import static presentation.main.ApplicationSetting.LETTER_TALL;
import static presentation.main.ApplicationSetting.ROW_HEIGHT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import core.Customer;
import core.PersonId;

public abstract class BaseTablePanel  extends JPanel implements TableModelListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ListSelectionHandler handler;
	private JComboBox<String> comboBox;

	private Color originalColor, borderLetterColor, originalBorderLetterColor;
	private boolean isFiltered;

	private Border tableBorder, emptyBorder;
	private JToggleButton titleB;
	private JTableHeader header;

	private JScrollPane jsp = null;
	private TitledBorder titleBorder;
	private JPanel form;
	private JLabel filterLabel;
	private JTextField filterText;
	private String toFilter;
	private int index = 0;
    private int col = 0;

	public CustomerToRoomsTablePanel() {

		this.originalColor = COLOR_BASE;
		this.borderLetterColor = COLOR_BASE_LETTERS;
		this.originalBorderLetterColor = COLOR_BASE_LETTERS;
		this.isFiltered = false;

		setLayout(new BorderLayout());
		handler = new ListSelectionHandler();

		tableBorder = BorderFactory.createLineBorder(borderLetterColor, 1);
		this.setBorder(BorderFactory.createLineBorder(COLOR_BASE, 1));
		MyTableCellRenderer cellRenderer = new MyTableCellRenderer(COLOR_BASE);
		MyHeaderCellRenderer headerRenderer = new MyHeaderCellRenderer(originalColor, originalBorderLetterColor);
		header.setDefaultRenderer(headerRenderer);

//     	Create a title border       
		titleB = new JToggleButton("Pacienti - detailní info, změny");
		titleB.setOpaque(true);
		titleB.setContentAreaFilled(true);
		titleB.setBackground(COLOR_BUTTON_BACKGROUND);
		titleB.setFont(new Font("Arial", Font.CENTER_BASELINE, LETTER_TALL));
		titleB.setForeground(borderLetterColor);
		emptyBorder = BorderFactory.createEmptyBorder();
		titleBorder = BorderFactory.createTitledBorder(emptyBorder, "Pacienti", TitledBorder.RIGHT,
				TitledBorder.DEFAULT_POSITION);
		titleBorder.setTitleColor(borderLetterColor);
		titleBorder.setTitleFont(new Font("Arial", Font.BOLD, LETTER_MEDIUM));

//      Create a separate form for filterText and statusText
        form = new JPanel(new GridLayout(1,3));      
        form.setOpaque(true);
        form.setBackground(COLOR_BASE);
        filterLabel = new JLabel("Filter položek: ", SwingConstants.TRAILING);
        filterLabel.setFont(new Font("Arial", Font.BOLD, LETTER_MEDIUM));
        filterLabel.setForeground(borderLetterColor);
        form.add(filterLabel);
        filterText = new JTextField();      
  
        comboBox = new JComboBox<String>();
        //overwrite setSelectionBackground method
        Object child = comboBox.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup = (BasicComboPopup)child;
        JList<?> list = popup.getList();
        list.setSelectionBackground(COLOR_BUTTON_BACKGROUND);
        
        comboBox.setRenderer(new DefaultListCellRenderer() {
            public void paint(Graphics g) {
               setForeground(originalBorderLetterColor);
                setFont(new Font("Arial", Font.BOLD, LETTER_MEDIUM));
                setToolTipText("Vybrat text, který se má filtrovat");
                super.paint(g);
            }
        });
        
    	comboBox.addItem("Id");
    	comboBox.addItem("Jméno");
    	comboBox.addItem("Příjmení");
    	comboBox.addItem("Diagnoza");
    	comboBox.addItem("Rodné číslo");
    	comboBox.addItem("Adresa");
    	comboBox.addItem("Pojišťovna");
    	form.add(comboBox);
    	filterLabel.setLabelFor(comboBox);
        form.add(filterText);
        form.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(form,BorderLayout.SOUTH);
  
        comboBox.addActionListener(new ActionListener() {       	
            public void actionPerformed(ActionEvent event) {               
            	 	JComboBox<?> comboBox = (JComboBox<?>) event.getSource();
            	 	index = comboBox.getSelectedIndex();
            		}
        		});
        
        titleB.addActionListener(new ActionListener(){ 
            	public void actionPerformed(ActionEvent e){ 
					//MainPanel.getInstance().usersOnlyPanel(parameter, originalColor, originalBorderLetterColor);   
            	} 
        	}); 
	}
	
	public boolean isFiltered() {
		return isFiltered;
	}

	public void setFiltered(boolean isFiltered) {
		this.isFiltered = isFiltered;
	}

		public int getIndex() {
			return index;
		}
	}

}
