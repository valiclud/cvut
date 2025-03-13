package presentation.main;

import java.awt.Color;

public class ApplicationSetting {

	//background color
	public static final Color COLOR_BASE = new Color(234, 244, 249);
	public static final Color COLOR_BASE_LETTERS = new Color(55, 160, 76);
	public static final Color COLOR_DOORFRAME = new Color(237, 250, 240);
	public static final Color COLOR_MESSAGEFRAME = new Color(250, 248, 237);
	public static final Color COLOR_SERVICE = Color.LIGHT_GRAY;
	public static final Color COLOR_ICON_TEXT = new Color(77, 113, 134);
	public static final Color COLOR_ICON_BACKGROUND = new Color(223, 239, 248);
	public static final Color COLOR_ICON_BORDER = new Color(119, 173, 205);
	public static final Color COLOR_BUTTON_BACKGROUND = new Color(244, 244, 244);
	public static final Color COLOR_PANEL_DARKER = new Color(240, 240, 240);
	
	//letter (fonts) heights setting
	public static final int LETTER_TALL = 13;
	public static final int LETTER_MEDIUM = 12;
	public static final int LETTER_SMALL = 10;
	public static final int ROW_HEIGHT = 26;
	public static final String MAIN_FONT = "Arial";
	
	
	//signs
	public static final String ITEM_FILTER = "Filtr položek: ";
	public static final String TEXT_FILTER = "Vybrat text, který se má filtrovat";

	
	//database setting
	public static final String connectionFile = "connection.txt";
	public static final String databaseUrl = "jdbc:mysql://localhost:3306/greenexample";
	public static final String databaseUserName = "root";
	public static final String databaseUserPassword = "admin";
	
	//icons directory path
	public static final String iconsDirectory = "icons/";
	
}