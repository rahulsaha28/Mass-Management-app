package sample;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LastWin {

    Stage window3;
    Scene scene;

    public void DisplayLast(TextField[] name,double[] meal, double[] bazarcost, double[] livCost, TextField service){

        //calculating service charge
        double serviceCharge = Double.parseDouble(service.getText());
        serviceCharge = serviceCharge/(meal.length);


        //calculating each_persone cost
        double[] eachCost = eachCost(meal,mealRate(bazarcost,meal),livCost,serviceCharge);

        window3 = new Stage();

        //creating titledPane, VBox, Label
        TitledPane[] titledPane = new TitledPane[name.length];
        VBox vBox = new VBox();
        Label[] labels = new Label[name.length];
        String text = "";

        for(int i=0; i<name.length; i++){

            text = "Name: "+name[i].getText()+"\nTotal Meal: "+meal[i]+"\nBazar Cost: "+bazarcost[i]+"\nMeal Rate: "+mealRate(bazarcost,meal)+"\nYou will pay : "+eachCost[i]+" TK";

            labels[i] = new Label(text);


            titledPane[i] = new TitledPane();
            titledPane[i].setText(name[i].getText());
            titledPane[i].setContent(labels[i]);
        }

         vBox.getChildren().addAll(titledPane);

        //showing window3
        scene = new Scene(vBox,500,500);
        window3.setScene(scene);
        window3.setTitle("<<<Answer>>>");
        window3.show();
    }

    // calculating mealRate from bazar & meal
    private static double mealRate(double[] bazar, double[] meal){
        double b=0;
        double m=0;
        for(int i=0; i<bazar.length; i++){
            b += bazar[i];
            m += meal[i];
        }

        return (b/m);
    }

    //per person cost calculation
    private static double[] eachCost(double[] meal, double mealRate, double[] livCost,double service){

        double[] perPersonCost = new double[meal.length];

        for(int i=0; i<meal.length; i++){
            perPersonCost[i] = (mealRate*meal[i])+livCost[i]+service;
        }

        return perPersonCost;
    }



}
