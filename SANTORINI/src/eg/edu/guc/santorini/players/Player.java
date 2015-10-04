package eg.edu.guc.santorini.players;

import eg.edu.guc.santorini.tiles.*;

public class Player {
	private String name;
	private int type;
	private Piece t1;
	private Piece t2;
	
	
	public Player(String name, int number)
	{
		this.name = name;
		this.type = number;
		if (type == 1)
		{
			t1 = new Cube();
			t2 = new Cube();
		}
		if (type == 2)
		{
			t1 = new Pyramid();
			t2 = new Pyramid();
		}
		t1.setPlayer(this);
		t2.setPlayer(this);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setT1(Piece t1) {
		this.t1 = t1;
	}

	public Piece getT1() {
		return t1;
	}

	public Piece getT2() {
		return t2;
	}

	public void setT2(Piece t2) {
		this.t2 = t2;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
