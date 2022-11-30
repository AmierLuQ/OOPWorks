package com.mycompany.electricalgridsystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DistributionStation {
           
    public float distributed;
    ArrayList<Consumer> c = new ArrayList<Consumer> ();
    public int consumerNo = 0;
    public float totalConsumed, avgConsumed;
    public String stationName;
    
    public DistributionStation(float distributed){
        this.distributed = distributed;
    }
    
    public void calcTotalConsumed(){
        float total = 0;
        
        for(int i =0; i<c.size();i++){
            
            total += c.get(i).consumed;
            
        }
        
        totalConsumed = total;
        
    }
    
    public void calcAvgConsumed(){
        avgConsumed = totalConsumed / c.size();
    }
    
}