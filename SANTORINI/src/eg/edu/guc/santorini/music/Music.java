package eg.edu.guc.santorini.music;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music {
	private String filename;
	private Player player;

	public Music(String filename) {
		this.filename = filename;
	}

	public Music() {
		// TODO Auto-generated constructor stub
		
	}

	public void close() {
		if (player != null) {
			player.close();
		}
	}

	public void play() {
		try {
			FileInputStream fis = new FileInputStream(filename);
			BufferedInputStream bis = new BufferedInputStream(fis);
			player = new Player(bis);
			new Thread() {
				public void run() {
					try {
						player.play();
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}

			.start();

		} catch (Exception e) {
			return;

		}

	}

}
