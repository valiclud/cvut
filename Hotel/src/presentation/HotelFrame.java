package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

import core.HotelException;

import static presentation.main.ApplicationSetting.COLOR_BASE;
import static presentation.main.ApplicationSetting.COLOR_BASE_LETTERS;
import static presentation.main.ApplicationSetting.ROW_HEIGHT;
import static presentation.main.ApplicationSetting.COLOR_BUTTON_BACKGROUND;
import static presentation.main.ApplicationSetting.LETTER_SMALL;
import static presentation.main.ApplicationSetting.LETTER_MEDIUM;
import static presentation.main.ApplicationSetting.LETTER_TALL;

public class HotelFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static HotelFrame instance;

	private CustomerTablePanel customerPanel;
	private RoomTablePanel roomPanel;
	private CustomerToRoomsTablePanel customerRoomsPanel;

	private JSplitPane splitPane;
	private JSplitPane horizontalSplit;
	private JPanel boxPanel;
	private short parameter;
	private JMenuBar baseMenuBar;
	// private ApplicationMenuBar applicationMenuBar;

	public static HotelFrame getInstance() {
		if (instance == null)
			instance = new HotelFrame();
		return instance;
	}

	private HotelFrame() {
		super("IS Hotelu");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.getContentPane().removeAll();
		this.setLayout(new BorderLayout());

		instance = this;
		customerPanel = new CustomerTablePanel();
		roomPanel = new RoomTablePanel();
		customerRoomsPanel = new CustomerToRoomsTablePanel();
		// this.add(customerRoomsPanel,BorderLayout.SOUTH );
		// this.pack();

		originalFrameSetting();

		this.setVisible(true);

		this.setResizable(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());

		this.setSize(1350, 1015);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

	}

	public void originalFrameSetting() {
		parameter = 0;
		this.getContentPane().removeAll();

		// JSplitPane
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(new CustomerTablePanel());
		splitPane.setRightComponent(new RoomTablePanel());
		splitPane.setBottomComponent(new CustomerToRoomsTablePanel());

		splitPane.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, COLOR_BASE));

		splitPane.setUI(new BasicSplitPaneUI() {
			public BasicSplitPaneDivider createDefaultDivider() {
				return new BasicSplitPaneDivider(this) {
					public void setBorder(Border b) {
					}

					@Override
					public void paint(Graphics g) {
						g.setColor(COLOR_BASE);
						g.fillRect(0, 0, getSize().width, getSize().height);
						super.paint(g);
					}
				};
			}
		});

		splitPane.setResizeWeight(0.70);
		this.getContentPane().add(splitPane);
		horizontalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		horizontalSplit.setTopComponent(splitPane);
		horizontalSplit.setBottomComponent(customerRoomsPanel = new CustomerToRoomsTablePanel());

		horizontalSplit.setResizeWeight(0.65);
		horizontalSplit.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, COLOR_BASE));
		horizontalSplit.setBackground(COLOR_BASE);
		horizontalSplit.setForeground(COLOR_BASE);

		horizontalSplit.setUI(new BasicSplitPaneUI() {
			public BasicSplitPaneDivider createDefaultDivider() {
				return new BasicSplitPaneDivider(this) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public void setBorder(Border b) {
					}

					@Override
					public void paint(Graphics g) {
						g.setColor(COLOR_BASE);
						g.fillRect(0, 0, getSize().width, getSize().height);
						super.paint(g);
					}
				};
			}
		});

		horizontalSplit.setBackground(COLOR_BASE);
		this.getContentPane().add(horizontalSplit);
		this.setResizable(true);
		setVisible(true);
	}

	/*
	 * public void refresh() { try { getCustomerJPanel().refreshData(); } catch
	 * (HotelException ex) { JOptionPane.showMessageDialog(this, ex.toString(),
	 * "Error", JOptionPane.ERROR_MESSAGE); } }
	 */
	public CustomerTablePanel getCustomerJPanel() {
		return customerPanel;
	}
}
