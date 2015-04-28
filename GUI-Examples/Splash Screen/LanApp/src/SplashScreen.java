// SplashScreen.java
// A simple application to show a title screen in the center of the screen
// for the amount of time given in the constructor.  This class includes
// a sample main() method to test the splash screen, but it's meant for use
// with other applications.
//

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class SplashScreen extends JWindow {

	private static JProgressBar pbar;

	// A simple little method to show a title screen in the center
	// of the screen for the amount of time given in the constructor
	public void showSplash() throws FontFormatException, IOException {
		JPanel content = (JPanel) getContentPane();
		content.setBackground(Colors.DARK_PRIMARY_COLOR);

		// Set the window's bounds, centering the window
		int width = 450;
		int height = 200;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);
		pbar = new JProgressBar();
		pbar.setMinimum(0);
		pbar.setMaximum(100);
		pbar.setStringPainted(true);
		pbar.setBackground(Colors.LIGHT_PRIMARY_COLOR);
		pbar.setForeground(Colors.ACCENT_COLOR);
		pbar.setPreferredSize(new Dimension(300, 20));
		// Build the splash screen
		Panel top_panel = new Panel();
		JLabel title = new JLabel("The Lan App");
		top_panel.setLayout(null);
		top_panel.add(title);
		title.setBounds(100,20,220,160);
		title.setFont(new Font("Courier New", Font.BOLD, 35));
		title.setForeground(Colors.TEXT_COLOR);
		
		JLabel copyrt = new JLabel("Copyright 2015, Develop By : Anurag Goel",
				JLabel.CENTER);
		copyrt.setForeground(Colors.TEXT_COLOR);
		Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/Cartoon.ttf").openStream());
		GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		genv.registerFont(font);
		copyrt.setFont(new Font("Sans", Font.BOLD, 12));
		font = font.deriveFont(40f);
		title.setFont(font);
		content.add(top_panel, BorderLayout.CENTER);
		Panel btm_panel = new Panel();
		BorderLayout bl = new BorderLayout();
		btm_panel.setLayout(bl);
		btm_panel.add(copyrt, BorderLayout.SOUTH);
		btm_panel.add(pbar, BorderLayout.CENTER);
		content.add(btm_panel, BorderLayout.SOUTH);
		content.setBorder(BorderFactory.createLineBorder(
				Colors.DARK_PRIMARY_COLOR, 2));

		// Display it
		setVisible(true);

		// Wait a little while, maybe while loading resources
		try {
			int i = 0;
			while (i <= 100) {
				i++;
				pbar.setValue(i);
				Thread.sleep(40);
			}

		} catch (Exception e) {
		}

		setVisible(false);
	}

	public void showSplashAndExit() throws FontFormatException, IOException {
		showSplash();
		System.exit(0);
	}

	public static void main(String[] args) throws FontFormatException, IOException {
		// Throw a nice little title page up on the screen first
		SplashScreen splash = new SplashScreen();
		// Normally, we'd call splash.showSplash() and get on with the program.
		// But, since this is only a test...
		splash.showSplashAndExit();
		System.out.print("Splash Screen CLosed");
	}

	public void progressbar_animation() {

	}
}
