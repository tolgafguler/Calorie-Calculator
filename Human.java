package bbm104;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Human{
	private int ID;
	private int weight;
	private int length;
	private int age;
	private String name;
	private String gender;
	private long dailyCalorieNeeds;
	public long gainedcal;
	public long loosedcal;	
	private long gainedNewcal;
	private float loosedNewcal;
	private long totalCal;

	
	public  Human(int ID, String name,String gender,int weight,int length,int age,long dailyCalorieNeeds ){
		this.gender=gender;	
		this.ID = ID;
		this.name = name;
		this.weight=weight;
		this.length=length;
		this.age=age;
		this.dailyCalorieNeeds=dailyCalorieNeeds;
		this.gainedNewcal=this.getDailyCalorieNeeds();
		this.loosedNewcal=this.getDailyCalorieNeeds();
		this.totalCal=this.getDailyCalorieNeeds();
	}
	
	public long getTotalcal(){
		return -this.totalCal;
	}
	public void setTotalcal(long fromFood,long fromSport){
		this.totalCal=this.totalCal-fromFood;
		this.totalCal=this.totalCal+fromSport;
	}

	public long getGainedNewcal() {
		return gainedNewcal;
	}
	public void setGainedNewcal(long gainedcal) {
		this.gainedNewcal=this.gainedNewcal-gainedcal;
		this.gainedcal+=gainedcal;
	}
	public float getLoosedNewcal() {
		return loosedNewcal;
	}
	public void setLoosedNewcal(float loosedcal) {
		this.loosedNewcal=this.loosedNewcal+loosedcal;
		this.loosedcal+=loosedcal;
	}
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getAge() {
		return 2018-age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDailyCalorieNeeds(long dailyCalorieNeeds){
		this.dailyCalorieNeeds=dailyCalorieNeeds;
	}
	public long getDailyCalorieNeeds(){
		return dailyCalorieNeeds;
	}
	
	public static long dailyCalorieNeedsM(int weight,int height,int age){
		long result=Math.round(66+(13.75*weight)+(5*height)-(6.8*age));
		return result;
	}
	
	public static long dailyCalorieNeedsW(int weight,int height,int age){
			
		long result=Math.round(665+(9.6*weight)+(1.7*height)-(4.7*age));
		return result;
	}

	public static int counter = 0;


	public static Human[] filePerson(String people){
		Human[] humans = new Human[50];
		String s[]={};
		long neededCalori=0;
		try{	
			File file = new File(people);
			FileReader fr = new FileReader(file);
			BufferedReader bf=new BufferedReader(fr);
			
			String line = bf.readLine();
			
			while (line != null) {
				s=line.split("\t");
				//System.out.println(line);
				if ("male".equals(s[2])){
					neededCalori=dailyCalorieNeedsM(Integer.parseInt(s[3]),Integer.parseInt(s[4]),2018-(Integer.parseInt(s[5])));
				}
				else if("female".equals(s[2])){
					neededCalori=dailyCalorieNeedsW(Integer.parseInt(s[3]),Integer.parseInt(s[4]),2018-(Integer.parseInt(s[5])));
				}
				
				
				Human human = new Human(Integer.parseInt(s[0]),s[1],s[2],Integer.parseInt(s[3]),Integer.parseInt(s[4]),Integer.parseInt(s[5]),neededCalori);
				humans[counter] = human;
				counter++;
				line= bf.readLine();
			}
			bf.close();
		}
	catch(IOException iox){
		System.out.println("cant read");
	}
	
	return humans;
	
	
	}

}
	
