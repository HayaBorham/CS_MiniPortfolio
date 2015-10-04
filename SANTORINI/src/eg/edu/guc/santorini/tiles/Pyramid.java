package eg.edu.guc.santorini.tiles;

import java.util.ArrayList;

import eg.edu.guc.santorini.utilities.*;

public class Pyramid extends Piece implements PieceInterface {

	public Pyramid(Location loc) {
		super(loc);
	}
	
	public Pyramid()
	{
		super();
	}
	
	public ArrayList<Location> possibleMoves()
	{
		ArrayList<Location> possible = new ArrayList<Location>();
		int y = getLocation().getY();
		int x = getLocation().getX();
		
		if (y - 1 >= 0 && x + 1 <= 4)
		{
			possible.add(new Location(--y, ++x));
			y++;
			x--;
		}
		if (y + 1 <= 4 && x - 1 >= 0)
		{
			possible.add(new Location(++y, --x));
			y--;
			x++;
		}
		if (y + 1 <= 4 && x + 1 <= 4)
		{
			possible.add(new Location(++y, ++x));
			y--;
			x--;
		}
		if (y - 1 >= 0 && x - 1 >= 0)
		{
			possible.add(new Location(--y, --x));
			y++;
			x++;
		}
		
		return possible;
	}

}
