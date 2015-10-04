package eg.edu.guc.santorini.tiles;

import java.util.ArrayList;

import eg.edu.guc.santorini.players.Player;
import eg.edu.guc.santorini.utilities.Location;

public abstract class Piece implements PieceInterface {
	private Location location;
	private Player player;
	
	public Piece()
	{
		
	}

	public Piece(Location loc) {
		location = loc;
		location.setHasPiece(true); 
		location.setPiece(this);
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public ArrayList<Location> possibleMoves()
	{
		if (this instanceof Cube)
		{
			return this.possibleMoves();
		}
		else
		{
			return this.possibleMoves();
		}
	}

	public ArrayList<Location> possiblePlacements() {

		ArrayList<Location> possible = new ArrayList<Location>();
		int y = getLocation().getY();
		int x = getLocation().getX();
		if (y - 1 >= 0) {
			possible.add(new Location(--y, x));
			y++;
		}
		if (y + 1 <= 4) {
			possible.add(new Location(++y, x));
			y--;
		}
		if (x - 1 >= 0) {
			possible.add(new Location(y, --x));
			x++;
		}
		if (x + 1 <= 4) {
			possible.add(new Location(y, ++x));
			x--;
		}
		if (y - 1 >= 0 && x - 1 >= 0) {
			possible.add(new Location(--y, --x));
			y++;
			x++;
		}
		if (y + 1 <= 4 && x + 1 <= 4) {
			possible.add(new Location(++y, ++x));
			y--;
			x--;
		}
		if (y - 1 >= 0 && x + 1 <= 4) {
			possible.add(new Location(--y, ++x));
			y++;
			x--;
		}
		if (y + 1 <= 4 && x - 1 >= 0) {
			possible.add(new Location(++y, --x));
			y--;
			x++;
		}
		
		return possible;

	}

}
