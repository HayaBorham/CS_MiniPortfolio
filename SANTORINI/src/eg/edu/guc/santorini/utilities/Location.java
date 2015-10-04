package eg.edu.guc.santorini.utilities;
import eg.edu.guc.santorini.tiles.Piece;

public class Location {
	private int y;
	private int x;
	private int level;
	private boolean hasPiece;
	private Piece piece;

	public Location(int y, int x) {
		this.y = y;
		this.x = x;
		
	}
	public boolean getHasPiece() {
		return hasPiece;
	}
	public void setHasPiece(boolean hasPiece) {
		this.hasPiece = hasPiece;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		
		this.level = level;
	}
	
	public boolean equals(Location loc)
	{
		return (x == loc.getX() && y == loc.getY());
		
	}
	

}
