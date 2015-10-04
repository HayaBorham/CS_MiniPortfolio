package eg.edu.guc.santorini.gui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import eg.edu.guc.santorini.players.Player;

public class GameOverWindow extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel gameOverPanel;
	private Font prop = new Font("Verdana", Font.BOLD, 24);

	public GameOverWindow(String winner) {

		JLabel harley = new JLabel(new ImageIcon("SidekickHarleyJoke.png"));
		JLabel robin = new JLabel(new ImageIcon("SidekickRobinBat.png"));

		setTitle("Santorini: Batman vs. The Joker: GAME OVER");
		setSize(1400, 300);
		setLocation(0, 200);
		setUndecorated(true);
		gameOverPanel = new JPanel(new GridBagLayout());
		gameOverPanel.setBackground(Color.BLACK);
		add(gameOverPanel, BorderLayout.CENTER);
		JLabel text = new JLabel();
		JLabel line = new JLabel();
		text.setForeground(Color.BLUE);
		line.setForeground(Color.BLUE);
		text.setFont(prop);

		if (winner == "Player 1") {
			text.setText("Batman wins!");
		} else {
			text.setText("The Joker wins!");
		}

		text.setSize(400, 500);
		text.setLocation(250, 40);

		gameOverPanel.add(text);

		if (winner == "Player 1") {
			gameOverPanel.add(robin);
		} else {
			gameOverPanel.add(harley);
		}

		createButtons();

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void createButtons() {

		JButton replay = new JButton("Another Round");
		// JButton replay = new JButton("Play Again");
		replay.setBackground(Color.BLACK);
		replay.setForeground(Color.white);
		replay.setActionCommand("Another Round");
		replay.addActionListener(this);
		// replay.setBorder(null);
		// replay.setBorderPainted(true);
		replay.setVisible(true);

		JButton exit = new JButton("Walk Away");
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.white);
		exit.setActionCommand("Walk Away");
		exit.addActionListener(this);
		exit.setVisible(true);

		GridBagConstraints g = new GridBagConstraints();
		g.insets = new Insets(15, 15, 15, 15);

		gameOverPanel.add(replay, g);
		gameOverPanel.add(exit, g);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Another Round")) {
			this.setVisible(false);
			this.validate();
			this.repaint();
			try {
				new ChoosePlayerWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.getActionCommand().equals("Walk Away")) {
			this.setVisible(false);
			this.validate();
			this.repaint();
			try {
				new LauncherWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
