package eg.edu.guc.santorini.gui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Content of Instructions Window

public class InstructionsWindow extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel instpanel;
	private JPanel buttonPanel;
	private JPanel imagePanel;
	private JPanel instructionArea; // for kalam - ta7t el image
	private JLabel instruction; // the actual kalam

	public InstructionsWindow() throws IOException {
		setTitle("How to Play");

		getContentPane().setBackground(Color.white);
		setSize(700, 700);
		setLocation(325, 50);
		setResizable(false);
		setLayout(new BorderLayout());
		setUndecorated(true); //
		setVisible(true);
		createPanel();
		createButtons();
	}

	public JPanel getInstructionArea() {
		return instructionArea;
	}

	public void setInstructionArea(JPanel instructionArea) {
		this.instructionArea = instructionArea;
	}

	public JPanel getInstpanel() {
		return instpanel;
	}

	public void setInstpanel(JPanel instpanel) {
		this.instpanel = instpanel;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public JLabel getInstruction() {
		return instruction;
	}

	public void setInstruction(JLabel instruction) {
		this.instruction = instruction;
	}

	public void createPanel() {
		instpanel = new JPanel();
		add(instpanel, BorderLayout.CENTER);
		instpanel.setBackground(Color.white);

		imagePanel = new JPanel(new FlowLayout());
		JLabel image = new JLabel(new ImageIcon("InstructionsBackground.png"));
		// image.setLocation(0, 150);
		add(imagePanel);
		imagePanel.setBackground(Color.black);
		imagePanel.setSize(200, 150);
		imagePanel.add(image);
		image.setLocation(0, 500);
		image.setVisible(true);

		// instpanel.setToolTipText("Read well");
		instruction = new JLabel();
		instruction
				.setText("<html>"
						+ "<h3>Santorini: Batman vs. The Joker is 2-Player Strategy board game</h3>"
						+ "<p>"
						+ "Each player selects one of the two DC Comic "
						+ "Characters: Batman, or The Joker.</p>"
						+ "<p>Batman moves as soon as he sees the Bat-Signal, "
						+ "followed by the Joker who</p>"
						+ "<p>tries to counterattack."
						+ "<p> <p/>"
						+ "<p> Each player moves one of their two pieces per turn, and then "
						+ "places a tile. <p/>"
						+ "<p>Both players should try to reach a level-3 tile or trap"
						+ "their opponent's pieces to win.</p>"
						+ "<p><h3> So what will it be? Will you help Batman save Gotham City,"
						+ " or help The Joker take over?</h3><p/>"
						+ "</html>");
		instpanel.add(instruction);
		instruction.setForeground(Color.white);
		// instruction.setLocation(0, 550);
		imagePanel.add(instruction, BorderLayout.SOUTH);
		instruction.setVisible(true);

		// setVisible(true);

		buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setBackground(Color.DARK_GRAY);
		setVisible(true);

	}

	public void createButtons() {
		JButton button2 = new JButton("Exit");
		button2.setActionCommand("Exit");
		buttonPanel.add(button2);
		button2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Exit") {
			this.setVisible(false);
			// new WindowDestroyer(e);
		}
	}
}
