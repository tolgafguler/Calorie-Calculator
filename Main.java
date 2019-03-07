package bbm104;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		
		
		
		Human [] a=new Human[50];
		a=Human.filePerson("people.txt");
		Food [] b=new Food[100];
		b=Food.fileFood("food.txt");
		Sports [] c=new Sports[100];
		c=Sports.fileSports("sport.txt");
		
		
		String []s3={};
		Human[] humansUseds=new Human[50];
		String[] humanId=new String[50];
		int humanCounter=0;
		int idCounter=0;
	
		
		String filee=args[0];
		try{
			File fileOutput=new File("monitoring.txt");
	        FileWriter fw1 = new FileWriter(fileOutput, false);
	        BufferedWriter bw1 = new BufferedWriter(fw1);
	        
	        
			File file3 =new File(filee);
			FileReader fr3 = new FileReader(file3);
			BufferedReader bf3=new BufferedReader(fr3);
			String line3=bf3.readLine();
			
			while(line3!=null){	
				s3=line3.split("\t");			
				if(s3.length!=1){
					if("1".equals(s3[1].substring(0,1))){
						for(int i=0;i<Human.counter;i++){
							for(int j=0;j<Food.counter1;j++){
								if ((Integer.parseInt(s3[0])==(a[i].getID())) && (Integer.parseInt(s3[1])==(b[j].getID()))){
									a[i].setGainedNewcal(Integer.parseInt(s3[2])*b[j].getCalorieCount());
									a[i].setLoosedNewcal(0);
									a[i].setTotalcal(a[i].gainedcal,0);
										bw1.write(a[i].getID()+" "+"has taken"+" "+Integer.parseInt(s3[2])*b[j].getCalorieCount()+" "+"kcal"+" "+"from"+" "+b[j].getName());
										bw1.newLine();
										bw1.write("************");
										bw1.newLine();
									
										if (Arrays.asList(humanId).contains(s3[0])){
											
										}
										else{
											humanId[idCounter]=s3[0];
											humansUseds[humanCounter]=a[i];
											humanCounter++;
											idCounter++;
										}	
												
									}
									}
									}
								    }
					else if("2".equals(s3[1].substring(0,1))){
						for(int k=0;k<Human.counter;k++){
							for(int l=0;l<Sports.counter2;l++){
								if((Integer.parseInt(s3[0])==(a[k].getID())) &&  (Integer.parseInt(s3[1])==(c[l].getID()))){
									a[k].setLoosedNewcal(Integer.parseInt(s3[2])*c[l].getCalorieBurned());
									a[k].setGainedNewcal(0);
									a[k].setTotalcal(0,a[k].loosedcal);
									bw1.write(a[k].getID()+" "+"has burned"+" "+Integer.parseInt(s3[2])*c[l].getCalorieBurned()+" "+"thanks to"+" "+c[l].getName());
									bw1.newLine();
									bw1.write("************");
									bw1.newLine();
									
									if (Arrays.asList(humanId).contains(s3[0])){	
									}
									else{
										humanId[idCounter]=s3[0];
										humansUseds[humanCounter]=a[k];
										humanCounter++;
										idCounter++;
									}
								
									}
									}
								    }
								    }
					}						
				else if(s3.length==1){
					int o=0;
				
					if("printList".equals(s3[0])){
						for(int r=0;r<humanCounter;r++){
							bw1.write(humansUseds[o].getName()+"	"+humansUseds[o].getAge()+" "+humansUseds[o].getDailyCalorieNeeds()+"	"+humansUseds[o].gainedcal+"	"+humansUseds[o].loosedcal+"	"+humansUseds[o].getTotalcal());
							bw1.newLine();
							o++;	
								}
							bw1.write("***********");
							bw1.newLine();
									}
					else{
						
					for(int m=0;m<(humanCounter);m++){
						
					if(Integer.parseInt(s3[0].substring(6,11))== humansUseds[m].getID()){
						bw1.write(humansUseds[m].getName()+" "+humansUseds[m].getAge()+" "+humansUseds[m].getDailyCalorieNeeds()+" "+humansUseds[m].gainedcal+"	"+humansUseds[m].loosedcal+"	"+humansUseds[m].getTotalcal());	
						bw1.newLine();
					}
					
					}
					bw1.write("***********");
					bw1.newLine();
									}
								
										}
				line3=bf3.readLine();
								}
			bf3.close();
			bw1.close();
		
						}	
					
				catch(IOException iox){
					System.out.println("okunmuyor");
						
					}
					
					}	
			}
			
			
