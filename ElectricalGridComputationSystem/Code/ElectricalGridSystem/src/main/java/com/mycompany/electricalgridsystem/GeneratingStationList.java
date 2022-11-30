package com.mycompany.electricalgridsystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class GeneratingStationList {
    
    ArrayList<GeneratingStation> gs = new ArrayList<GeneratingStation> ();
    public int generatorNo = 0;
    public float totalGenerated, avgGenerated;
    public String districtName;
        
    
    public void readFile(){
    
        File file = new File("C:\\Users\\user\\Documents\\UTP\\Year 1 Sem 2 - Sep 22\\TEB1043 - Object Oriented Programming\\03 Exercises\\ElectricalGridProject\\data.txt");
    
        
        try {
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String words[] = line.split(" ");
                
                
                for(int i =0;i<words.length;i++){
                    
                    String genCount = "Generator" + Integer.toString(generatorNo + 1);
                    
                    if (words[i].equals(genCount)) {
                        
                        GeneratingStation temp = new GeneratingStation(Float.parseFloat(words[1]));
                                                
                        gs.add(temp);
                        
                        gs.get(generatorNo).readFile(file, generatorNo);
                        
                        generatorNo++;
                    }
                }
                
                }
            }
        
        catch (IOException ex) {
                ex. printStackTrace();
                System.exit(1);
            }
    }
    
    public void calcTotalGenerated(){
        
        float total = 0;
        
        for(int i =0; i<gs.size();i++){
            
            total += gs.get(i).generated;
            
        }
        
        totalGenerated = total;
    }
    
    public void calcAvgGenerated(){
        
       avgGenerated = totalGenerated / gs.size();
       
    }
    
    public void testPrint(){
        
        for (int i=0;i<gs.size();i++){
            System.out.println("Generator " + String.valueOf(i+1) + ": " + String.valueOf(gs.get(i).generated));
            for (int j=0;j<gs.get(i).ts.size();j++){
                System.out.println("Generator " + String.valueOf(i+1) + " Transmitter " + String.valueOf(j+1)+ ": " + String.valueOf(gs.get(i).ts.get(j).transmitted));
                for (int k=0;k<gs.get(i).ts.get(j).ds.size();k++){
                    System.out.println("Generator " + String.valueOf(i+1) + " Transmitter " + String.valueOf(j+1) + " Distributer " + String.valueOf(k+1) + ": "
                            + String.valueOf(gs.get(i).ts.get(j).ds.get(k).distributed));
                }
            }
        }
        
    }
}