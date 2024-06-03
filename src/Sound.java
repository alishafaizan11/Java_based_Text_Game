import java.io.File;

import javax.sound.sampled.*;

public class Sound implements Runnable {
	
	Clip themeSong;

	public Sound(String filepath) {
		// Initialize game objects and variables

		// Load sound effect
		themeSong = loadSound(filepath);

		// Add listener to restart clip when it finishes playing

		themeSong.setFramePosition(0);
		themeSong.loop(Clip.LOOP_CONTINUOUSLY);

		Thread t = new Thread(this);
		t.start();

		
	}

	private static Clip loadSound(String filename) {
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			return clip;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void run() {
		while(true) {
			themeSong.start();
		}
	}



	

}