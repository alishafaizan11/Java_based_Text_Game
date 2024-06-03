import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.rmi.UnknownHostException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TCPClient implements Runnable{

	private String host;
	private int port;

	static boolean tornadoStatus = false;
	static boolean screamStatus = false;
	static boolean invisiblityStatus = false;


	public TCPClient(String host, int port){
		this.host = host;
		this.port = port;

		Thread t = new Thread(this);
		t.start();
	}

	JSONParser parser = new JSONParser();


	public static synchronized boolean getTornado () {
		return tornadoStatus;
	}

	public static synchronized boolean getScream () {
		return screamStatus;
	}

	public static synchronized boolean getInvisibility () {
		return invisiblityStatus;
	}

	// Gyro
	public static synchronized void setTornado () {
		tornadoStatus = true;
	}

	// Light Intensity
	public static synchronized void setScream () {
		screamStatus = true;
	}

	// Orientation
	public static synchronized void setInvisibility () {
		invisiblityStatus = true;
	}

	public static synchronized void resetFlags(){
		tornadoStatus = false;
		screamStatus = false;
		invisiblityStatus = false;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		try {
			
			Socket socket = new Socket(this.host, this.port);
			InputStream input = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);

			// -------------------------------- new reader -------------------------------
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			while ((line = br.readLine()) != null) {//read line by line
				JSONObject jsonObject = (JSONObject) parser.parse(line);
				//System.out.println(line);
				String accX = (String) jsonObject.get("accelerometerAccelerationX");		
				double accXval = Double.parseDouble(accX);
				String accY = (String) jsonObject.get("accelerometerAccelerationY");	
				double accYval = Double.parseDouble(accX);
				String accZ = (String) jsonObject.get("accelerometerAccelerationZ");	
				double accZval = Double.parseDouble(accX);


				String orientation = (String) jsonObject.get("deviceOrientation");			
				double orientval = Double.parseDouble(orientation);

				String gyroZ = (String) jsonObject.get("gyroRotationZ");			
				double gyroZval = Double.parseDouble(gyroZ);

				String audioDB = (String) jsonObject.get("avAudioRecorderAveragePower");
				float audioDBval = Float.parseFloat(audioDB);
				
				//String batteryLevel = (String) jsonObject.get("batteryLevel");
				//double batteryLevelval = Double.parseDouble(batteryLevel);
				//System.out.println(line);
				
				// using acc
				// check run
				if(accXval < -0.05 || accXval > 0.05 || accYval > 0.05 || accYval < -0.05){
					setTornado();
				}
				//check walk
				// using gryo
				// check fight
				if((audioDBval > -20))
				{
					setScream();
				}
				// orientation sensor for turnOnLight
				// 5 means face up
				// 6 means face down
				if(orientval == 6){
					setInvisibility();
				}
			}
		
		//----------------------------------------------------------------------------

	} catch (UnknownHostException ex) {
		System.out.println("Server not found: " + ex.getMessage());
	} catch (IOException ex) {
		System.out.println("I/O error: " + ex.getMessage());
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
