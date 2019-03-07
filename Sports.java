package bbm104;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Sports {
	private int ID;
	private String name;
	private float calorieBurned;

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCalorieBurned() {
		return calorieBurned/60;
	}

	public void setCalorieBurned(float calorieBurned) {
		this.calorieBurned = calorieBurned;
	}

	public Sports(int ID, String name, float calorieBurned) {
		this.ID = ID;
		this.name = name;
		this.calorieBurned = calorieBurned;
	}
public static int counter2 = 0;

	public static Sports[] fileSports(String sports) {
		Sports[] sports1 = new Sports[100];
		String s2[] = {};
		try {
			File file2 = new File(sports);
			FileReader fr2 = new FileReader(file2);
			BufferedReader bf2 = new BufferedReader(fr2);

			String line2 = bf2.readLine();
			
			while (line2 != null) {
				s2 = line2.split("\t");
				// System.out.println(line1);
				line2 = bf2.readLine();
				Sports sport = new Sports(Integer.parseInt(s2[0]), s2[1],Float.parseFloat(s2[2]));
				sports1[counter2] = sport;
				counter2++;
			}
			bf2.close();
		} catch (IOException iox) {
			System.out.println("okunmuyor");
		}

		return sports1;
	}
}
