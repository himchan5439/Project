package msg;

import javax.swing.JOptionPane;

public class jop {
	
	public static void info(String text) {
		JOptionPane.showMessageDialog(null, text, "정보", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void error(String text) {
		JOptionPane.showMessageDialog(null, text, "경고", JOptionPane.ERROR_MESSAGE);
	}
}
