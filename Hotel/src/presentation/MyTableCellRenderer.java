package presentation;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class MyTableCellRenderer extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Color originalColor;

	public MyTableCellRenderer(Color originalColor) {
		super();
		this.originalColor = originalColor;
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, originalColor));
		this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setText(" " + value);
		return this;
	}
}