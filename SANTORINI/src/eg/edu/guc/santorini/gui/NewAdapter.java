package eg.edu.guc.santorini.gui;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import eg.edu.guc.santorini.Board;
import eg.edu.guc.santorini.exceptions.InvalidMoveException;
import eg.edu.guc.santorini.exceptions.InvalidPlacementException;
import eg.edu.guc.santorini.music.Music;
import eg.edu.guc.santorini.players.Player;
import eg.edu.guc.santorini.tiles.Piece;
import eg.edu.guc.santorini.utilities.Location;

public class NewAdapter {
	private Board b;
	private Tile[][] tiles;
	private String won;

	public NewAdapter(Player p1, Player p2) {
		b = new Board(p1, p2);
		tiles = new Tile[5][5];
		ImageIcon icon = new ImageIcon("BoardLevel.png");
		ImageIcon iconP1 = new ImageIcon("batTile0.png");
		ImageIcon iconP2 = new ImageIcon("jokerTile0.png");

		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				tiles[i][j] = new Tile(icon, i, j);
				if (i == 0) {
					if (j == 0) {
						tiles[i][j] = new Tile(iconP1, i, j);
					}
					if (j == 3) {
						tiles[i][j] = new Tile(iconP2, i, j);

					}
				}
				if (i == 4) {
					if (j == 1) {
						tiles[i][j] = new Tile(iconP1, i, j);

					}

					if (j == 4) {
						tiles[i][j] = new Tile(iconP2, i, j);

					}
				}

			}
		}

	}
	public boolean compareTo(Tile tile, Piece piece) {
		int y = tile.getYY();
		int x = tile.getXX();
		return (getB().getLocs()[y][x].getPiece() == piece);
	}

	public Piece getPiece(Tile tile) {
		int y = tile.getYY();
		int x = tile.getXX();
		return (getB().getLocs()[y][x].getPiece());
	}

	public boolean tileHasPiece(Tile t) {
		int y = t.getYY();
		int x = t.getXX();
		Location[][] locs = b.getLocs();
		return locs[y][x].getHasPiece();
	}

	public void cleanBoard() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				tiles[i][j].setBorder(BorderFactory.createEmptyBorder());
			}

		}
	}

	public ArrayList<Tile> movesOrPlacements(Tile t) {
		Location l = b.getLocs()[t.getYY()][t.getXX()];
		Piece p = l.getPiece();
		ArrayList<Location> possible;
		ArrayList<Tile> res = new ArrayList<Tile>();
		if (!b.isGameOver()) {
			if (b.getMoveLeft() == 1) {
				possible = p.possibleMoves();
				for (int i = 0; i < possible.size(); i++) {
					Location pos = possible.get(i);
					if (b.canMove(p, pos) && !pos.getHasPiece()) {
						res.add(tiles[pos.getY()][pos.getX()]);
					}
				}
			}

			if (b.getMoveLeft() == 0 && b.getPlaceLeft() == 1
					&& !b.isGameOver()) {
				possible = p.possiblePlacements();
				for (int i = 0; i < possible.size(); i++) {
					Location pos = possible.get(i);
					if (b.canPlace(p, pos) && !pos.getHasPiece()) {
						res.add(tiles[pos.getY()][pos.getX()]);
					}
				}
			}
		} else {
			if (b.isGameOver()) {
				if (b.isWinner(getB().getP1())) {
					won = "Player 1";
				}
				if (b.isWinner(getB().getP2())) {
					won = "Player 2";
				}
				new GameOverWindow(won);
			}
		}
		return res;

	}

	public boolean move(Tile[] t) {
		int y = t[0].getYY();
		int x = t[0].getXX();
		try {
			if (b.getMoveLeft() == 1
					&& !b.getLocs()[t[1].getYY()][t[1].getXX()].getHasPiece()) {
				b.move(b.getLocs()[y][x].getPiece(),
						b.getLocs()[t[1].getYY()][t[1].getXX()]);
				changePicsAfterMove(t);

			}
		} catch (InvalidMoveException e) {
			return false;
		}
		return true;
	}

	public void changePicsAfterMove(Tile[] t) {
		String[][] s = b.display();
		switch (b.getLocs()[t[0].getYY()][t[0].getXX()].getLevel()) {
		case 0:
			t[0].setIcon(new ImageIcon("BoardLevel.png"));
			break;
		case 1:
			t[0].setIcon(new ImageIcon("tile1.png"));
			break;
		case 2:
			t[0].setIcon(new ImageIcon("tile2.png"));
			break;
		case 3:
			t[0].setIcon(new ImageIcon("tile3.png"));
			break;
		case 4:
			t[0].setIcon(null);
			break;
		default:
			break;
		}
		if (s[t[1].getYY()][t[1].getXX()].length() >= 2) {
			if (s[t[1].getYY()][t[1].getXX()].charAt(2) == '1') {
				switch (b.getLocs()[t[1].getYY()][t[1].getXX()].getLevel()) {
				case 0:
					t[1].setIcon(new ImageIcon("batTile0.png"));
					break;
				case 1:
					t[1].setIcon(new ImageIcon("batTile1.png"));
					break;
				case 2:
					t[1].setIcon(new ImageIcon("batTile2.png"));
					break;
				case 3:
					t[1].setIcon(new ImageIcon("batTile3.png"));
					break;
				default:
					break;
				}
			} else {
				if (s[t[1].getYY()][t[1].getXX()].charAt(2) == '2') {
					switch (b.getLocs()[t[1].getYY()][t[1].getXX()].getLevel()) {
					case 0:
						t[1].setIcon(new ImageIcon("jokerTile0.png"));
						break;
					case 1:
						t[1].setIcon(new ImageIcon("jokerTile1.png"));
						break;
					case 2:
						t[1].setIcon(new ImageIcon("jokerTile2.png"));
						break;
					case 3:
						t[1].setIcon(new ImageIcon("jokerTile3.png"));
						break;
					default:
						break;
					}
				}
			}
			if (b.getLocs()[t[1].getYY()][t[1].getXX()].getLevel() == 4) {
				b.isGameOver();
				if (b.isWinner(getB().getP1())) {
					won = "Player 1";
				}
				if (b.isWinner(getB().getP2())) {
					won = "Player 2";
				}
				
				new GameOverWindow(won);
			}
		}
	}

	public boolean place(Tile[] t) {
		int y = t[0].getYY();
		int x = t[0].getXX();
		try {
			if (b.getMoveLeft() == 0 && b.getPlaceLeft() == 1) {
				int xp = t[1].getXX();
				int yp = t[1].getYY();
				b.place(b.getLocs()[y][x].getPiece(), b.getLocs()[yp][xp]);
				changePicsAfterPlace(t);
			}
		} catch (InvalidPlacementException e) {
			return false;
		}
		return true;
	}

	public void changePicsAfterPlace(Tile[] t) {
		int xp = t[1].getXX();
		int yp = t[1].getYY();
		changeTurn();
		switch (b.getLocs()[yp][xp].getLevel()) {
		case 1:
			t[1].setIcon(new ImageIcon("tile1.png"));
			break;
		case 2:
			t[1].setIcon(new ImageIcon("tile2.png"));
			break;
		case 3:
			t[1].setIcon(new ImageIcon("tile3.png"));
			break;
		case 4:
			t[1].setIcon(new ImageIcon("bomb.png"));
			Music exp = new Music("explosion.mp3");
			exp.play();
			break;
		default:
			break;
		}

	}

	public void changeTurn() {
		getB().getTurn();
	}

	public Board getB() {
		return b;
	}

	public void setB(Board b) {
		this.b = b;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
}