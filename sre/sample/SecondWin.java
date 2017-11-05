package sample;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecondWin {

    Stage window2;
    Scene scene;

    public void DisplaySecWindow(String massName, String managerName, String number){

        window2 = new Stage();

        //captureing int from string
        int memberNo = Integer.parseInt(number);
        System.out.println(memberNo);

        //creating TitlePane GridPane TextField  VBox Button
        VBox vBox = new VBox();
        VBox vBox1 = new VBox(10);
        Label label = new Label("Enter total service charge(khala+net+paper+electricity+other)");
        TextField textField = new TextField();

        Button button = new Button("Enter");
        TitledPane[] titledPanes = new TitledPane[memberNo];
        GridPane[] gridPanes = new GridPane[memberNo];
        TextField[] textFields1 = new TextField[memberNo]; //name
        TextField[] textFields2 = new TextField[memberNo]; //meal
        TextField[] textFields3 = new TextField[memberNo]; //bazar
        TextField[] textFields4 = new TextField[memberNo]; //livingcost


        //for loop to create GridPane inside TitlePane
        for(int i=0; i<memberNo; i++){

            gridPanes[i] = new GridPane();
            gridPanes[i].setVgap(5);

            //name
            gridPanes[i].add(new Label("Name :"),0,0);
            textFields1[i] = new TextField();
            gridPanes[i].add(textFields1[i],1,0);

            //meal
            gridPanes[i].add(new Label("Meal No :"),0,1);
            textFields2[i] = new TextField();
            gridPanes[i].add(textFields2[i],1,1);

            //bazar
            gridPanes[i].add(new Label("Bazar Cost:"),0,2);
            textFields3[i] = new TextField();
            gridPanes[i].add(textFields3[i],1,2);

            //living
            gridPanes[i].add(new Label("Living Cost:"),0,3);
            textFields4[i] = new TextField();
            gridPanes[i].add(textFields4[i],1,3);




            titledPanes[i] = new TitledPane();
            titledPanes[i].setText("Member "+(i+1));
            titledPanes[i].setContent(gridPanes[i]); // adding gridPane in titledPane


        }
         vBox.getChildren().addAll(titledPanes); //adding titledPane in vBox
        vBox1.getChildren().addAll(vBox,label,textField,button);
        scene = new Scene(vBox1,500,500);


         //working with Button Click
        button.setOnAction(e ->{
            LastWin lastWin = new LastWin();
            lastWin.DisplayLast(textFields1,convDouble(textFields2),convDouble(textFields3),convDouble(textFields4),textField);
            window2.close();
        });


        //opening window2
        window2.setScene(scene);
        window2.setTitle(massName);
        window2.show();
    }

    private double[] convDouble(TextField[] text){
        int length = text.length;
        double[] value = new double[length];

        for (int i=0; i<length; i++){

            value[i] = Double.parseDouble(text[i].getText());
        }
        return value;
    }

}
