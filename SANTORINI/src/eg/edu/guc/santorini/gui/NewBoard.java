package eg.edu.guc.santorini.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eg.edu.guc.santorini.players.Player;
import eg.edu.guc.santorini.tiles.Piece;

public class NewBoard extends JFrame implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel boardPanel;
	//private JLabel turn;
	private Tile tempLabel;
	private Tile [] locs;
	private NewAdapter a;
	private ArrayList<Tile> possible;
	private Piece moved;

	public NewBoard(Player p1, Player p2) {
		a = new NewAdapter(p1, p2);
		setTitle("SANTORINI");
		getContentPane().setBackground(Color.black);
		setSize(1400, 700);
		setLayout(new BorderLayout());
    	setUndecorated(true);  
		createBoardPanel(5, 5);
		locs = new Tile[2];
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/*public JLabel getTurn() {
		return turn;
	}*/

	/*public void setTurn(JLabel turn) {
		this.turn = turn;
	}*/

	public void createBoardPanel(int row, int column) {
		boardPanel = new JPanel(new GridLayout(row, column));
		boardPanel.setBackground(Color.black);
		add(boardPanel, BorderLayout.CENTER);
		boardPanel.repaint();

		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				boardPanel.add(a.getTiles()[i][j]);
				a.getTiles()[i][j].addMouseListener(this);

			}
		}
		setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		a.cleanBoard();
		tempLabel = (Tile) e.getSource();
		if (a.tileHasPiece(tempLabel)) {
			if (locs[0] != null && a.tileHasPiece(locs[0])) {
				possible = a.movesOrPlacements(tempLabel);
				for (int i = 0; i < possible.size(); i++) {
					possible.get(i).setBorder(
							BorderFactory.createLoweredBevelBorder());
				}
				tempLabel.setBorder(BorderFactory.createLoweredBevelBorder());
				locs[0] = tempLabel;
			}
			if (locs[0] == null) {
				possible = a.movesOrPlacements(tempLabel);
				for (int i = 0; i < possible.size(); i++) {
	
					possible.get(i).setBorder(
							BorderFactory.createLoweredBevelBorder());
					
				}

				tempLabel.setBorder(BorderFactory.createLoweredBevelBorder());
				locs[0] = tempLabel;
			}
		}
		if (a.tileHasPiece(tempLabel) && a.getB().getMoveLeft() == 1) {
			locs[0] = tempLabel;
		} else {
			if (a.tileHasPiece(locs[0])) {
				locs[1] = tempLabel;
			}
		}
		if (locs[0] != null && locs[1] != null && a.getB().getMoveLeft() == 1) {
			if (a.move(locs)) {
				moved = a.getPiece(locs[1]);
				locs[0] = locs[1];
				locs[1] = null;

				possible = a.movesOrPlacements(tempLabel);
				for (int i = 0; i < possible.size(); i++) {
					possible.get(i).setBorder(
							BorderFactory.createLoweredBevelBorder());
				}

			}

		} else {
			if (a.getB().getMoveLeft() == 0 && a.getB().getPlaceLeft() == 1) {
				if (a.compareTo(locs[0], moved)) {
					if (a.place(locs)) {
						locs[1] = null;
						locs[0] = null;
						moved = null;

					}
				}
				repaint();
				validate();
			}
		}
	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent arg0) {

	}

	public void mouseReleased(MouseEvent arg0) {

	}

}
