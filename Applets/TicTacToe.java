import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 <applet code="TicTacToe.class" width="300" height="300">
 </applet>
 */
public class TicTacToe extends Applet implements ActionListener {
	Button[] btnarray = new Button[9];
	private final static String PLAYER1 = "PLAYER1";
	private final static String PLAYER2 = "PLAYER2";
	private static String CURRENT_PLAYER = null;
	Label lbl = new Label();

	public void init() {
		CURRENT_PLAYER = PLAYER1;
		lbl.setText(CURRENT_PLAYER + " Turn!");
		setLayout(new BorderLayout());
		Panel p = new Panel();
		GridLayout gl = new GridLayout(3, 3);
		p.setLayout(gl);
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setSize(300, 300);
		Font myFont = new Font("TimesRoman", Font.BOLD, 80);
		for (int i = 0; i < 9; i++) {
			btnarray[i] = new Button(null);
			btnarray[i].setActionCommand("" + i);
			btnarray[i].addActionListener(this);
			btnarray[i].setFont(myFont);
			btnarray[i].setBackground(Color.white);
			p.add(btnarray[i]);
		}
		add(BorderLayout.CENTER, p);
		add(BorderLayout.NORTH, lbl);
		add(BorderLayout.SOUTH, new Label("Player 1 => X , Player 2 => 0"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = Integer.parseInt(e.getActionCommand());
		btnarray[index].disable();
		if (CURRENT_PLAYER == PLAYER1) {
			btnarray[index].setLabel("X");
			CURRENT_PLAYER = PLAYER2;

		} else {
			btnarray[index].setLabel("0");
			CURRENT_PLAYER = PLAYER1;
		}
		lbl.setText(CURRENT_PLAYER + " Turn!");
		check();
	}

	void check() {
		String[] pattern = new String[8];
		pattern[0] = btnarray[0].getLabel() + btnarray[1].getLabel()
				+ btnarray[2].getLabel();
		pattern[1] = btnarray[3].getLabel() + btnarray[4].getLabel()
				+ btnarray[5].getLabel();
		pattern[2] = btnarray[6].getLabel() + btnarray[7].getLabel()
				+ btnarray[8].getLabel();
		pattern[3] = btnarray[0].getLabel() + btnarray[3].getLabel()
				+ btnarray[6].getLabel();
		pattern[4] = btnarray[1].getLabel() + btnarray[4].getLabel()
				+ btnarray[7].getLabel();
		pattern[5] = btnarray[2].getLabel() + btnarray[5].getLabel()
				+ btnarray[8].getLabel();
		pattern[6] = btnarray[0].getLabel() + btnarray[4].getLabel()
				+ btnarray[8].getLabel();
		pattern[7] = btnarray[2].getLabel() + btnarray[4].getLabel()
				+ btnarray[6].getLabel();
		int j = 0;

		while (j < 8) {
			char[] array = pattern[j].toCharArray();
			if (array[0] == 'X' && array[1] == 'X' && array[2] == 'X') {
				lbl.setText(PLAYER1 + " Wins!");
			} else if (array[0] == '0' && array[1] == '0' && array[2] == '0') {
				lbl.setText(PLAYER2 + " Wins!");
			}
			j++;
		}

	}
}
