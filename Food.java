package bbm104;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Food {
	private int ID;
	private String name;
	private int calorieCount;

	public Food(int ID, String name, int calorieCount) {
		this.ID = ID;
		this.name = name;
		this.calorieCount = calorieCount;
	}

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

	public int getCalorieCount() {
		return calorieCount;
	}

	public void setCalorieCount(int calorieCount) {
		this.calorieCount = calorieCount;
	}
	public static int counter1 = 0;

	public static Food[] fileFood(String foods) {
		Food[] foods1 = new Food[100];
		String s1[] = {};

		try {
			File file1 = new File(foods);
			FileReader fr1 = new FileReader(file1);
			BufferedReader bf1 = new BufferedReader(fr1);

			String line1 = bf1.readLine();
			
			while (line1 != null) {
				s1 = line1.split("\t");
				// System.out.println(line1);
				line1 = bf1.readLine();
				Food food = new Food(Integer.parseInt(s1[0]), s1[1],Integer.parseInt(s1[2]));
				foods1[counter1] = food;
				counter1++;
			}
			bf1.close();
		} catch (IOException iox) {
			System.out.println("okunmuyor");
		}

		return foods1;
		
		
	}
}
