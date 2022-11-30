package com.mycompany.electricalgridsystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TransmissionStation {
    
    public float transmitted;
    ArrayList<DistributionStation> ds = new ArrayList<DistributionStation> ();
    public int distributerNo = 0;
    public float totalDistributed, avgDistributed;
    public String StationName, typeOfTransformer;
    
    public TransmissionStation(float transmitted){
        this.transmitted = transmitted;
    }
    
    public void readFile(File file, int transmitterNo, int generatorNo){
        
        //not ready
        
        try {
            
            Scanner sc = new Scanner(file);
            
            String genCount = "Generator" + Integer.toString(generatorNo + 1);
            String genCount1 = "Generator" + Integer.toString(generatorNo + 2);
            
            System.out.print(generatorNo);
            System.out.println(transmitterNo);
            
            boolean val = false;
            boolean val1 = false;    
            
            while (sc.hasNextLine()){
                
                //System.out.println(distributerNo);
                              
                String line = sc.nextLine();
                String words[] = line.split(" ");
                
                String transCount = "Transmitter" + Integer.toString(transmitterNo + 1);
                String transCount1 = "Transmitter" + Integer.toString(transmitterNo + 2) ;
            
                //System.out.println(String.valueOf(genCount) + " vs " + String.valueOf(words[0]));
                
                if (words[0].equals(genCount)) val = true;
                
                if (val){
                    
                    if (words[0].equals(transCount)) val1 = true;
                    
                    if (val1){
                    String distCount = "Distributer" + Integer.toString(distributerNo + 1);
                    
                    if (words[0].equals(distCount)) {
                        
                        //System.out.println(genCount + " " + transCount + " " + distCount + " " + words[1]);
                        DistributionStation temp = new DistributionStation(Float.parseFloat(words[1]));
                        ds.add(temp);
                        //ds.get(transmitterNo).readFile(file, transmitterNo, generatorNo);
                        distributerNo++;
                        
                        }
                    }
                }
                
                if (words[0].equals(transCount1) || words[0].equals(genCount1)) break; 
            }
                
            }
        
        catch (IOException ex) {
                ex. printStackTrace();
                System.exit(1);
            }
    }
    
    public void calcTotalDistributed(){
        float total = 0;
        
        for(int i =0; i<ds.size();i++){
            
            total += ds.get(i).distributed;
            
        }
        
        totalDistributed = total;
        
    }
    
    public void calcAvgDistributed(){
        avgDistributed = totalDistributed / ds.size();
    }
    
}