package eg.edu.guc.santorini.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tile extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int layer;
	private int yy;
	private int xx;
	private ImageIcon a;

	public Tile(ImageIcon a, int y, int x) {
		super(a);
		this.setA(a);
		layer = 0;
		this.yy = y;
		this.xx = x;
	}

	public Tile(int y, int x) {
		yy = y;
		xx = x;
		layer = 0;
	}

	public int getYY() {
		return yy;
	}

	public void setYY(int y) {
		this.yy = y;
	}

	public int getXX() {
		return xx;
	}

	public void setXX(int x) {
		this.xx = x;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}
	/*
	 * public void setIcon(ImageIcon a) { this.a = a; } public ImageIcon
	 * getIcon() { return a; }
	 */

	public ImageIcon getA() {
		return a;
	}

	public void setA(ImageIcon a) {
		this.a = a;
	}
}
