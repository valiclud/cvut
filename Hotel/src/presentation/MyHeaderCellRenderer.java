package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import presentation.main.ApplicationSetting;

public class MyHeaderCellRenderer extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Color originalColor;
	private Color originalBorderLetterColor;

	public MyHeaderCellRenderer(Color originalColor, Color originalBorderLetterColor) {
		super();
		this.originalColor = originalColor;
		this.originalBorderLetterColor = originalBorderLetterColor;
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, originalColor));
		table.getTableHeader().setBackground(originalBorderLetterColor);
		table.getTableHeader().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, originalColor));
		table.getTableHeader().setPreferredSize(new Dimension(1000, 34));
		this.setForeground(Color.WHITE);
		this.setFont(new Font("Arial", Font.BOLD, ApplicationSetting.LETTER_MEDIUM));
		this.setHorizontalAlignment(JLabel.CENTER);

		return this;
	}
}