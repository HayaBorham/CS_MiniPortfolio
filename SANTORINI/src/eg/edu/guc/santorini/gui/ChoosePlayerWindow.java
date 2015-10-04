package eg.edu.guc.santorini.gui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eg.edu.guc.santorini.music.Music;
import eg.edu.guc.santorini.players.Player;

//each player chooses his or her character and then enters their name then they press start

public class ChoosePlayerWindow extends JFrame implements MouseListener,
		ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel buttonPanel1;
	private JPanel buttonPanel2;
	private JPanel buttonPanel3;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel p1name;
	private JLabel p2name;
	private TextField a;
	private TextField b;
	private JButton confirm1;
	private JButton confirm2;
	private JButton button1;
	private JButton button2;
	private JLabel choose;
	private JLabel choose2;
	private JLabel choose3;
	private JLabel choose4;
	private String name1;
	private String name2;
	private Player p1;
	private Player p2;
	private JButton xy;
	private JButton diagonally;


	public ChoosePlayerWindow() throws IOException {

		setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
				"New_Gotham_City_revised.jpg")))));

		setTitle("Santorini: Batman vs. The Joker");
		setSize(1000, 700);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new BorderLayout());
		setUndecorated(true);  

		initPanels();

		createButtons();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);

	}

	public JButton getButton1() {
		return button1;
	}

	public void setButton1(JButton button1) {
		this.button1 = button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public void setButton2(JButton button2) {
		this.button2 = button2;
	}

	public TextField getA() {
		return a;
	}

	public void setA(TextField a) {
		this.a = a;
	}

	public JButton getConfirm1() {
		return confirm1;
	}

	public void setConfirm1(JButton confirm1) {
		this.confirm1 = confirm1;
	}

	public JLabel getChoose() {
		return choose;
	}

	public void setChoose(JLabel choose) {
		this.choose = choose;
	}

	public void initPanels() throws IOException {

		buttonPanel1 = new JPanel(new FlowLayout());
		Color transparent = new Color(0f, 0f, 0f, 0.0f);
		buttonPanel1.setBackground(transparent);
		add(buttonPanel1, BorderLayout.NORTH);

		buttonPanel2 = new JPanel(new FlowLayout());
		buttonPanel2.setBackground(Color.darkGray);
		add(buttonPanel2, BorderLayout.SOUTH);
		buttonPanel2.setSize(600, 200);

		buttonPanel3 = new JPanel();
		buttonPanel3.setLayout(new GridBagLayout());
		buttonPanel3.setBackground(Color.black);
		add(buttonPanel3, BorderLayout.CENTER);

	}


	public JPanel getButtonPanel1() {
		return buttonPanel1;
	}

	public void setButtonPanel1(JPanel buttonPanel) {
		this.buttonPanel1 = buttonPanel;
	}

	public JPanel getButtonPanel2() {
		return buttonPanel2;
	}

	public void setButtonPanel2(JPanel buttonPanel) {
		this.buttonPanel2 = buttonPanel;
	}

	public JPanel getButtonPanel3() {
		return buttonPanel3;
	}

	public void setButtonPanel3(JPanel buttonPanel) {
		this.buttonPanel3 = buttonPanel;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void createButtons() {

		ImageIcon icon1 = new ImageIcon("ChoosePlayerBat.png");
		 button1 = new JButton(icon1);
		button1.setActionCommand("Batman");
		button1.addActionListener(this);
		buttonPanel1.add(button1);
		button1.setBackground(Color.BLACK);
		button1.setBorderPainted(false);

		label1 = new JLabel("Batman");
		label1.setForeground(Color.white);
		buttonPanel2.add(label1);

		JLabel gap = new JLabel(" ");
		buttonPanel1.add(gap);

		ImageIcon icon2 = new ImageIcon("ChoosePlayerJoke.png");
		button2 = new JButton(icon2);
		button2.setActionCommand("The Joker");
		button2.addActionListener(this);
		buttonPanel1.add(button2);
		button2.setBackground(Color.BLACK);
		button2.setBorderPainted(false);
		button2.setEnabled(false);

		label2 = new JLabel("                            VS.");
		label2.setForeground(Color.white);
		buttonPanel2.add(label2);

		label3 = new JLabel("                        The Joker");
		label3.setForeground(Color.white);
		buttonPanel2.add(label3);
		buttonPanel2.setVisible(false);

		GridBagConstraints g = new GridBagConstraints();
		g.insets = new Insets(15, 15, 15, 15);

		p1name = new JLabel("Player 1, Enter Your Name:");
		p1name.setForeground(Color.green);
		p1name.setSize(180, 50);
		p1name.setVisible(true);

		a = new TextField();
		a.setVisible(true);
		a.setColumns(25);
		a.setBackground(Color.white);
		a.setForeground(Color.blue);
		a.validate();
		a.repaint();

		confirm1 = new JButton("Confirm");
		confirm1.setForeground(Color.black);
		confirm1.setSize(100, 25);
		confirm1.setVisible(true);

		buttonPanel3.repaint();

		g.gridx = 0;
		g.gridy = 1;
		buttonPanel3.add(p1name, g);

		g.gridx = 0;
		g.gridy = 2;
		buttonPanel3.add(a, g);
		a.validate();
		a.repaint();

		g.gridx = 0;
		g.gridy = 3;
		buttonPanel3.add(confirm1, g);

		confirm1.setActionCommand("P1 Confirm");
		confirm1.addActionListener(this);
		a.addActionListener(this); 
	

	}

	

	public void actionPerformed(ActionEvent e) {

		if (name2 == null) {
		if (e.getActionCommand().equals("P1 Confirm")) {

			name1 = a.getText();

			p1name.setVisible(false);
			a.setVisible(false);
			confirm1.setVisible(false);

			buttonPanel2.setVisible(true);
			buttonPanel2.validate();
			buttonPanel2.repaint();

			choose = new JLabel(name1
					+ "? Nice Name!  Now, Choose Your Character!");
			choose.setForeground(Color.green);
			choose.setSize(180, 50);
			choose.setLocation(450, 75);
			buttonPanel3.add(choose);
			buttonPanel3.setVisible(true);

			button1.setEnabled(true);
			button2.setEnabled(false);
			button1.validate();
			button2.validate();
			buttonPanel3.validate();
			buttonPanel3.repaint();
			button1.repaint();
			button2.repaint();
			
			return;

		}

		if (e.getActionCommand().equals("Batman")
				|| e.getActionCommand().equals("The Joker")) {

			choose.setVisible(false);
            button1.setEnabled(false);
			choose2 = new JLabel(name1
					+ ", Choose Your Battle Tactic!       ");
			choose2.setForeground(Color.green);
			choose2.setSize(180, 50);
			choose2.setLocation(450, 75);
			choose2.setVisible(true);

			xy = new JButton(new ImageIcon("xy.png")); 
			xy.setSize(60, 60);
			xy.setBackground(Color.black);
			xy.setLocation(465, 175);
			xy.setVisible(true);

			diagonally = new JButton(new ImageIcon("diagonally.png")); 
			diagonally.setSize(60, 60);
			diagonally.setBackground(Color.black);
			diagonally.setLocation(500, 175);
			diagonally.setVisible(true);

			buttonPanel3.add(choose2);
			buttonPanel3.add(xy);
			buttonPanel3.add(diagonally);
			buttonPanel3.validate();
			buttonPanel3.repaint();

			xy.setActionCommand("Cube");
			diagonally.setActionCommand("Pyramid");
			xy.addActionListener(this);
			diagonally.addActionListener(this);


		}

		if (e.getActionCommand().equals("Cube") && name1 != null) {
			p1 = new Player(name1, 1);
		} else if (e.getActionCommand().equals("Pyramid")) {
			p1 = new Player(name1, 2);
		}
		

		}
		if (p1 != null) {
		actionPerformed2(e);
		}
	}

	public void actionPerformed2(ActionEvent e) {

	
		GridBagConstraints g = new GridBagConstraints();
		
		if ((name2 == null) || (name2 == "")) {
			
			buttonPanel3.removeAll();
			
			g.insets = new Insets(15, 15, 15, 15);

			p2name = new JLabel("Next up, Player 2 - Your Name?");
			button2.setEnabled(true);
			button1.setEnabled(false);
			p2name.setForeground(Color.green);
			p2name.setSize(180, 50);
			p2name.setVisible(true);

			b = new TextField();
			b.setVisible(true);
			b.setColumns(25);
			b.setBackground(Color.white);
			b.setForeground(Color.blue);
			b.validate();
			b.repaint();

			confirm2 = new JButton("Confirm");
			confirm2.setForeground(Color.black);
			confirm2.setSize(100, 25);
			confirm2.setVisible(true);

			g.gridx = 0;
			g.gridy = 1;
			buttonPanel3.add(p2name, g);

			g.gridx = 0;
			g.gridy = 2;
			buttonPanel3.add(b, g);
			a.validate();
			a.repaint();

			g.gridx = 0;
			g.gridy = 3;
			buttonPanel3.add(confirm2, g);

			confirm2.setActionCommand("P2 Confirm");
			confirm2.addActionListener(this);
			b.addActionListener(this);
			System.out.println("action:" + e.getActionCommand());

			buttonPanel3.validate();
			buttonPanel3.repaint();
			
		}
		
		if (e.getActionCommand().equals("P2 Confirm")) {

			name2 = b.getText();

			p2name.setVisible(false);
			b.setVisible(false);
			confirm2.setVisible(false);
			
			buttonPanel2.setVisible(true);
			buttonPanel2.validate();
			buttonPanel2.repaint();

			choose3 = new JLabel("Pleasure..  Now, Choose Your Character!");
			choose3.setForeground(Color.green);
			choose3.setSize(180, 50);
			choose3.setLocation(450, 75);
			buttonPanel3.add(choose3);
			choose3.setVisible(true);
			buttonPanel3.setBackground(Color.BLACK);

			button1.setEnabled(false);
			button2.setEnabled(true);
			button1.validate();
			button2.validate();
			button1.repaint();
			button2.repaint();


		}

		if (e.getActionCommand().equals("Batman")
				|| e.getActionCommand().equals("The Joker")) {

			buttonPanel3.remove(choose3);
			buttonPanel3.validate();
			buttonPanel3.repaint();
			
			button1.setEnabled(false);
			button2.setEnabled(false);
			choose4 = new JLabel("How Would You Like to Maneuver?  ");
			choose4.setForeground(Color.green);
			choose4.setSize(180, 50);
			choose4.setLocation(450, 75);
			choose4.setVisible(true);

			xy = new JButton(new ImageIcon("xy.png")); 
			xy.setSize(60, 60);
			xy.setBackground(Color.black);
			xy.setLocation(465, 175);
			xy.setVisible(true);

			diagonally = new JButton(new ImageIcon("diagonally.png")); 
			diagonally.setSize(60, 60);
			diagonally.setBackground(Color.black);
			diagonally.setLocation(500, 175);
			diagonally.setVisible(true);

			buttonPanel3.add(choose4);
			buttonPanel3.add(xy);
			buttonPanel3.add(diagonally);
			buttonPanel3.validate();
			buttonPanel3.repaint();

			xy.setActionCommand("Cube");
			diagonally.setActionCommand("Pyramid");
			xy.addActionListener(this);
			diagonally.addActionListener(this);

		}
		if (e.getActionCommand().equals("Cube") && name2 != null) {
			p2 = new Player(name2, 1);
		} else if (e.getActionCommand().equals("Pyramid") && name2 != null) {
			p2 = new Player(name2, 2);

		}

		if ((e.getActionCommand().equals("Cube")
				|| e.getActionCommand().equals("Pyramid")) && name2 != null) {

			buttonPanel3.removeAll();

			JLabel begin = new JLabel("Shall We Start?");
			begin.setForeground(Color.green);
			begin.setSize(180, 50);
			begin.setVisible(true);

			JButton ok = new JButton("OK!");
			JButton exit = new JButton("Exit");

			g.insets = new Insets(10, 10, 10, 10);

			g.gridx = 1;
			g.gridy = 1;
			buttonPanel3.add(begin, g);

			g.gridx = 0;
			g.gridy = 2;
			buttonPanel3.add(ok, g);
			a.validate();
			a.repaint();

			g.gridx = 2;
			g.gridy = 2;
			buttonPanel3.add(exit, g);

			ok.setActionCommand("OK!");
			ok.addActionListener(this);
			exit.setActionCommand("Exit");
			exit.addActionListener(this);

			buttonPanel3.validate();
			buttonPanel3.repaint();

		}

		if (e.getActionCommand().equals("OK!")) {
			this.setVisible(false);
			new NewBoard(p1, p2);
			

		} else if (e.getActionCommand().equals("Exit")) {

			this.setVisible(false);
		}
	}
		

	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		e.getSource();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
