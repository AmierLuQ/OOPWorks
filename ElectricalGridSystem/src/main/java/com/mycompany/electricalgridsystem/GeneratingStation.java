package com.mycompany.electricalgridsystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GeneratingStation {
    
    //attributes
    public float generated;
    ArrayList<TransmissionStation> ts = new ArrayList<TransmissionStation> ();
    public int transmitterNo = 0;
    public float totalTransmitted, avgTransmitted;
    public String StationName;
    
    //constructor
    public GeneratingStation(float generated){
        this.generated = generated;
    }
    
    //methods
    public void readFile(File file, int generatorNo){
        
        
        
        try {
            
            Scanner sc = new Scanner(file);
            
            String genCount = "Generator" + Integer.toString(generatorNo + 1);
            String genCount1 = "Generator" + Integer.toString(generatorNo + 2);
            boolean val = false;    
            
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String words[] = line.split(" ");
                
                if (words[0].equals(genCount)) val = true;
                
                
                if (val){
                    String transCount = "Transmitter" + Integer.toString(transmitterNo + 1);
                        
                    if (words[0].equals(transCount)) {
                        
                        //System.out.println(genCount + " " + transCount + " " + words[1]);
                        
                        TransmissionStation temp = new TransmissionStation(Float.parseFloat(words[1]));
                        ts.add(temp);
                        ts.get(transmitterNo).readFile(file, transmitterNo, generatorNo);
                        transmitterNo++;
                    }  
                    }
                
                if (words[0].equals(genCount1)) break;    
                }
                
            }
        
        catch (IOException ex) {
                ex. printStackTrace();
                System.exit(1);
            }
    }
    
    public void calcTotalTransmitted(){
        
        float total = 0;
        
        for(int i =0; i<ts.size();i++){
            
            total += ts.get(i).transmitted;
            
        }
        
        totalTransmitted = total;
    }
    
    
    public void calcAvgTransmitted(){
        
       avgTransmitted = totalTransmitted / ts.size();
       
    }
}