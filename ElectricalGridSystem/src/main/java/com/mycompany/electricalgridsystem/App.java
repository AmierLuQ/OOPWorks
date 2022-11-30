package com.mycompany.electricalgridsystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    
    public void start(Stage stage) {
        
        //Consumer c = new Consumer();
        
        GeneratingStationList gsl = new GeneratingStationList();
        
        gsl.readFile();
        
        //gsl.testPrint();
        
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        //var label = new Label("Hi");
        
        //test data collected
        var label = new Label("Generator 2 Transmitter 2 Distributer 1 " + String.valueOf(gsl.gs.get(1).ts.get(1).ds.get(0).distributed));
        
        //var label = new Label(Integer.toString(gsl.generatorNo) + "Generators Present. Gen1 generated " + String.valueOf(gsl.gs.get(0).generated)
          //      + " while Gen2 generated " + String.valueOf(gsl.gs.get(1).generated));
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}