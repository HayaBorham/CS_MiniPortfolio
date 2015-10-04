package eg.edu.guc.santorini.gui;

import java.awt.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import eg.edu.guc.santorini.music.Music;

//Main Menu

public class LauncherWindow extends JFrame implements ActionListener

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel buttonPanel;
	private JPanel logoPanel;


	public LauncherWindow() throws IOException {


		setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
				"New_Gotham_City_revised.jpg")))));

		setTitle("Santorini: Batman vs. The Joker");
		setLayout(new BorderLayout());
		setSize(1000, 700);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		createPanel();
		createButtons();
		setUndecorated(true);  
		Music x = new Music("SoundtrackFULL.mp3");
		x.play();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}


	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public void createPanel() throws IOException {

		buttonPanel = new JPanel(new GridBagLayout());
		Color transparent = new Color(0f, 0f, 0f, 0.0f);
		buttonPanel.setBackground(transparent);
		add(buttonPanel, BorderLayout.SOUTH);

		logoPanel = new JPanel(new GridLayout());
		add(logoPanel, BorderLayout.NORTH);

		ImageIcon l = new ImageIcon("batman santorini-01.png");
		JLabel logo = new JLabel(l);
		logoPanel.add(logo);
		logoPanel.setBackground(transparent);

	}

	public void createButtons() {

		JButton button1 = new JButton("        Play        ");
		button1.setActionCommand("Play");

		JButton button2 = new JButton(" Instructions ");
		button2.setActionCommand("Instructions");

		JButton button3 = new JButton("         Quit         ");
		button3.setActionCommand("Quit");

		GridBagConstraints g = new GridBagConstraints();
		g.insets = new Insets(15, 15, 15, 15);

		g.gridx = 0;
		g.gridy = 1;
		buttonPanel.add(button1, g);
		button1.addActionListener(this);
		g.gridx = 0;
		g.gridy = 2;
		buttonPanel.add(button2, g);
		button2.addActionListener(this);
		g.gridx = 0;
		g.gridy = 3;
		buttonPanel.add(button3, g);
		button3.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "Quit") {
			new WindowDestroyer(e);
		}
		if (e.getActionCommand() == "Play") {
			try {
				new ChoosePlayerWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getActionCommand() == "Instructions") {
			try {
				new InstructionsWindow();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException {
		LauncherWindow mainMenu = new LauncherWindow();
	}

}
