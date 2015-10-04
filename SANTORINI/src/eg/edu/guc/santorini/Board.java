package eg.edu.guc.santorini;

import java.util.ArrayList;
import eg.edu.guc.santorini.exceptions.InvalidMoveException;
import eg.edu.guc.santorini.exceptions.InvalidPlacementException;
import eg.edu.guc.santorini.utilities.Location;
import eg.edu.guc.santorini.players.Player;
import eg.edu.guc.santorini.tiles.Cube;
import eg.edu.guc.santorini.tiles.Piece;

public class Board implements BoardInterface {
	private Player p1;
	private Player p2;
	private Location[][] locs;
	private int moveLeft;
	private int placeLeft;
	private Player turn;
	private Player opponent;

	public Board(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
		p1.getT1().setLocation(new Location(0, 0));
		p2.getT1().setLocation(new Location(0, 3));
		p1.getT2().setLocation(new Location(4, 1));
		p2.getT2().setLocation(new Location(4, 4));
		locs = new Location[SIDE][SIDE];
		turn = p1;
		moveLeft = 1;
		placeLeft = 1;

		for (int i = 0; i < SIDE; i++) {
			for (int j = 0; j < SIDE; j++) {
				locs[i][j] = new Location(i, j);
				if (i == 0) {
					if (j == 0) {
						locs[i][j].setPiece(p1.getT1());
						locs[i][j].setHasPiece(true);
					}
					if (j == 3) {
						locs[i][j].setPiece(p2.getT1());
						locs[i][j].setHasPiece(true);
					}
				}
				if (i == 4) {
					if (j == 1) {
						locs[i][j].setPiece(p1.getT2());
						locs[i][j].setHasPiece(true);
					}

					if (j == 4) {
						locs[i][j].setPiece(p2.getT2());
						locs[i][j].setHasPiece(true);
					}
				}

			}
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

	public Location[][] getLocs() {
		return locs;
	}

	public void setLocs(Location[][] locs) {
		this.locs = locs;
	}

	public int getMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(int moveLeft) {
		this.moveLeft = moveLeft;
	}

	public int getPlaceLeft() {
		return placeLeft;
	}

	public void setPlaceLeft(int placeLeft) {
		this.placeLeft = placeLeft;

	}

	public Player getTurn() {
		if (moveLeft == 0 && placeLeft == 0) {
			if (turn == p1) {
				turn = p2;
			} else {
				turn = p1;
			}
			moveLeft = 1;
			placeLeft = 1;
		}
		return turn;
	}

	public void setTurn(Player turn) {
		this.turn = turn;
	}

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}

	public boolean canMove(Piece piece, Location location) {
		Location loc = locs[location.getY()][location.getX()];

		if (loc.getHasPiece())
		{
			return false;
		}
				if (piece.possibleMoves().isEmpty()) {
			return false;
		}
		if (piece.getLocation().getLevel() >= loc.getLevel()
				|| piece.getLocation().getLevel() + 1 == loc.getLevel()) {
			for (int i = 0; i < piece.possibleMoves().size(); i++) {
				if (loc.equals(piece.possibleMoves().get(i))
						&& loc.getLevel() != 4) {
					return true;
				}
			}
		}

		return false;
	}

	public void move(Piece piece, Location newLocation)
			throws InvalidMoveException {
		Location newloc = locs[newLocation.getY()][newLocation.getX()];

		if (canMove(piece, locs[newloc.getY()][newloc.getX()])
				&& piece.getPlayer().equals(getTurn()) && moveLeft == 1 && placeLeft == 1
				&& piece.getLocation() != locs[newloc.getY()][newloc.getX()]
				&& locs[newloc.getY()][newloc.getX()] != null
				&& !hasNoMoves(piece.getPlayer()) && !isGameOver()) {
			locs[newloc.getY()][newloc.getX()].setHasPiece(true);
			locs[newloc.getY()][newloc.getX()].setPiece(piece);
			locs[piece.getLocation().getY()][piece.getLocation().getX()]
					.setHasPiece(false);
			locs[piece.getLocation().getY()][piece.getLocation().getX()]
					.setPiece(null);
			piece.setLocation(locs[newloc.getY()][newloc.getX()]);
			moveLeft--;
		}

		else {
			throw new InvalidMoveException("Invalid Move!");
		}
	}

	public boolean canPlace(Piece piece, Location newLocation) {
		Location newloc = locs[newLocation.getY()][newLocation.getX()];
		if (piece.possiblePlacements().isEmpty()
				|| newloc.getHasPiece()
				|| (newloc.getLevel() == 4)) {
			return false;
		}
		for (int i = 0; i < piece.possiblePlacements().size(); i++) {
			if (newloc.getX() == piece.possiblePlacements().get(i).getX()) {
				if (newloc.getY() == piece.possiblePlacements().get(i).getY()) {
					return true;
				}
			}
		}

		return false;
	}

	public void place(Piece piece, Location newLocation)
			throws InvalidPlacementException {
		Location newloc = locs[newLocation.getY()][newLocation.getX()];
		if (moveLeft == 0 && placeLeft == 1) {
			if (!newloc.getHasPiece() && newloc.getLevel() < 4
					&& canPlace(piece, newloc) && !isGameOver() && getTurn() == piece.getPlayer()) {
				int level = newloc.getLevel();
				newloc.setLevel(++level);
				placeLeft--;
			}

			else {
				throw new InvalidPlacementException(
						"You can't make a placement");
			}
		} else {
			throw new InvalidPlacementException("You can't make a placement");
		}
		if (newloc.getLevel() == 4) {
			newloc = null;
		}
	}

	public String[][] display() {
		String[][] s = new String[SIDE][SIDE];
		for (int i = 0; i < SIDE; i++) {
			for (int j = 0; j < SIDE; j++) {
				s[i][j] = "";
				s[i][j] += locs[i][j].getLevel();
				if (locs[i][j].getHasPiece()) {
					if (locs[i][j].getPiece() instanceof Cube) {
						s[i][j] += "C";
					} else {
						s[i][j] += "P";
					}
					if (locs[i][j].getPiece().equals(p1.getT1())
							|| locs[i][j].getPiece().equals(p1.getT2())) {
						s[i][j] += "1";
					} else {
						s[i][j] += "2";
					}
				}
			}
		}

		return s;
	}

	public boolean isGameOver() {
		return (isWinner(p2)) || (isWinner(p1));
	}

	public boolean isWinner(Player player) {

		if (player == p1) {
			setOpponent(p2);
		} else {
			setOpponent(p1);
		}

		if (hasNoMoves(player)) {
			return false; // isGameOver();
		}

		if (player.getT1().getLocation().getLevel() == 3
				|| player.getT2().getLocation().getLevel() == 3
				|| hasNoMoves(getOpponent()) && getTurn() == getOpponent()) {
			return true;
		}
		return false;

	}

	public boolean hasNoMoves(Player player)
	{
		if (player.getT1().possibleMoves() == null
				|| player.getT1().possibleMoves().size() == 0) {
			return true;
		} else {
			ArrayList<Location> possible = player.getT1().possibleMoves();
			for (int i = 0; i < possible.size(); i++) {
				if (canMove(player.getT1(),
						locs[possible.get(i).getY()][possible.get(i).getX()])) {
					return false;
				}
			}
			
		}

		if (player.getT2().possibleMoves() == null
				|| player.getT2().possibleMoves().size() == 0) {
			return true;
		} else {
			ArrayList<Location> possible = player.getT2().possibleMoves();
			for (int i = 0; i < possible.size(); i++) {
				if (canMove(player.getT2(),
						locs[possible.get(i).getY()][possible.get(i).getX()])) {
					return false;
				}
			}
			return true;
		}

	}

	public Player getWinner() {
		if (isWinner(p1)) {
			return p1;
		} else {
			return p2;
		}
	}

}
