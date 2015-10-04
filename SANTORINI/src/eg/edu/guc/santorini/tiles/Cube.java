package eg.edu.guc.santorini.tiles;

import eg.edu.guc.santorini.utilities.Location;
import java.util.ArrayList;

public class Cube extends Piece implements PieceInterface {

	public Cube(Location loc) {
		super(loc);
	}
	
	public Cube()
	{
		super();
	}
	
	public ArrayList<Location> possibleMoves() {
		ArrayList<Location> possible = new ArrayList<Location>();
		int y = this.getLocation().getY();
		int x = this.getLocation().getX();

		if (y + 1 <= 4) {
			possible.add(new Location(++y, x));
			y--;
		}
		if (x + 1 <= 4) {
			possible.add(new Location(y, ++x));
			x--;
		}
		if (x - 1 >= 0) {
			possible.add(new Location(y, --x));
			x++;
		}
		
		if (y - 1 >= 0) {
			possible.add(new Location(--y, x));
			y++;
		}
		return possible;
	}

}
