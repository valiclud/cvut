package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

import core.PersonId;
import core.Customer;

import static presentation.main.ApplicationSetting.COLOR_BASE;
import static presentation.main.ApplicationSetting.COLOR_BASE_LETTERS;
import static presentation.main.ApplicationSetting.ROW_HEIGHT;
import static presentation.main.ApplicationSetting.COLOR_BUTTON_BACKGROUND;
import static presentation.main.ApplicationSetting.LETTER_SMALL;
import static presentation.main.ApplicationSetting.LETTER_MEDIUM;
import static presentation.main.ApplicationSetting.LETTER_TALL;

public class CustomerTablePanel extends JPanel implements TableModelListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PersonId personId;

	private CustomersTableModel customersTableModel;
	private ListSelectionHandler handler;
	private JTable customerTable;

	private Color originalColor, borderLetterColor, originalBorderLetterColor;
	private Set<Customer> users = new HashSet<Customer>();
	private boolean isFiltered;

	private Border tableBorder, emptyBorder;
	private JToggleButton titleB;
	private JTableHeader header;
	private TableRowSorter<CustomersTableModel> sorter;

	private Set<Customer> customers = new HashSet<Customer>();
	private JScrollPane jsp = null;
	private TitledBorder titleBorder;
	private JPanel form;
	private JLabel filterLabel;
	private JTextField filterText;
	private String toFilter;
	private int index = 0;
    private int col = 0;

	public CustomerTablePanel() {

		this.originalColor = COLOR_BASE;
		this.borderLetterColor = COLOR_BASE_LETTERS;
		this.originalBorderLetterColor = COLOR_BASE_LETTERS;
		this.users.clear();
		this.isFiltered = false;

		setLayout(new BorderLayout());
		customersTableModel = new CustomersTableModel();
		customerTable = new JTable(customersTableModel);
		customerTable.setGridColor(COLOR_BASE);
		customerTable.setRowHeight(ROW_HEIGHT);
		customerTable.setOpaque(false);
		customerTable.setFillsViewportHeight(true);
		handler = new ListSelectionHandler();

		tableBorder = BorderFactory.createLineBorder(borderLetterColor, 1);
		this.setBorder(BorderFactory.createLineBorder(COLOR_BASE, 1));
		MyTableCellRenderer cellRenderer = new MyTableCellRenderer(COLOR_BASE);
		customerTable.setDefaultRenderer(Object.class, cellRenderer);
		MyHeaderCellRenderer headerRenderer = new MyHeaderCellRenderer(originalColor, originalBorderLetterColor);
		header = customerTable.getTableHeader();
		header.setDefaultRenderer(headerRenderer);

//      UserTable sorter
		customerTable.setAutoCreateRowSorter(true);
		customerTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		customerTable.setRowSelectionAllowed(true);
		sorter = new TableRowSorter<CustomersTableModel>(customersTableModel);
		customerTable.setRowSorter(sorter);

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

	    jsp = new JScrollPane(customerTable);
        ComponentTitledBorder componentBorder = new ComponentTitledBorder(titleB, jsp, titleBorder); 
        jsp.setBackground(COLOR_BASE);
        jsp.getViewport().setBackground(COLOR_BASE);
        jsp.setBorder(componentBorder);
        add(jsp, BorderLayout.CENTER);         
//      Create a separate form for filterText and statusText
        form = new JPanel(new GridLayout(1,3));      
        form.setOpaque(true);
        form.setBackground(COLOR_BASE);
        filterLabel = new JLabel("Filter položek: ", SwingConstants.TRAILING);
        filterLabel.setFont(new Font("Arial", Font.BOLD, LETTER_MEDIUM));
        filterLabel.setForeground(borderLetterColor);
        form.add(filterLabel);
        filterText = new JTextField();      
  
	}

	private void newFilter(int i) {
		RowFilter<CustomersTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(filterText.getText(), index);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	public boolean isSelectedReader() {
		return customerTable.getSelectedRow() != -1;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
		int column = e.getColumn();
		TableModel model = (TableModel) e.getSource();

		String columnName = model.getColumnName(column);
		Object data = model.getValueAt(row, column);

		switch (column) {
		case 0:
			toFilter = (String) model.getValueAt(0, column);
			break;
		case 1:
			toFilter = (String) model.getValueAt(0, column);
			break;
		case 2:
			toFilter = ((String) model.getValueAt(0, column));
			break;
		}
		newFilter(col);

	}
	
	public void clearCustomers() {
		this.customers.clear();
	}
	
	public boolean isFiltered() {
		return isFiltered;
	}

	public void setFiltered(boolean isFiltered) {
		this.isFiltered = isFiltered;
	}

	private class ListSelectionHandler implements ListSelectionListener {

		int index = -1;

		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				int maxIndex = lsm.getMaxSelectionIndex();
				index = maxIndex;
				if (maxIndex == -1) {
					lsm.clearSelection();
					clearCustomers();
					return;
				} else {
					// setting setFiltered() to true, necessary for future getting values from panel
					// to dialog boxes
					setFiltered(true);
					int minIndex = lsm.getMinSelectionIndex();
					for (int i = minIndex; i <= maxIndex; i++) {

						personId = (PersonId) customerTable.getValueAt(i, 0);
					}
				}
			}
		}

		public int getIndex() {
			return index;
		}
	}

}
