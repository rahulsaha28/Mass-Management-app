package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FirstWin extends Application {


    Stage window1;
    Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
      //creating new window
        window1 = primaryStage;


        //creating label
        Label label1 = new Label("Mass Name: ");
        Label label2 = new Label("Manager Name: ");
        Label label3 = new Label("Member No ");

        //creating textField
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();

        //Creating GridPane  HBox Button
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);

        Button button = new Button("Submit");

        HBox hBox1 = new HBox(10);
        HBox hBox2 = new HBox(10);
        HBox hBox3 = new HBox(10);

        //putting component
        hBox1.getChildren().addAll(label1,textField1);
        hBox2.getChildren().addAll(label2,textField2);
        hBox3.getChildren().addAll(label3,textField3);


        gridPane.add(hBox1,4,1);
        gridPane.add(hBox2,4,2);
        gridPane.add(hBox3,4,3);
        gridPane.add(button,5,4);


        //working with Button Click
        button.setOnAction(e ->{
               SecondWin secondWin = new SecondWin();
               secondWin.DisplaySecWindow(textField1.getText(),textField2.getText(),textField3.getText());
               window1.close();
        });




        //putting layout in scene
        scene = new Scene(gridPane,500,250);
        window1.setScene(scene);

        //showing window
        window1.setTitle("----Calculation----");
        window1.show();

    }




    public static void main(String[] args) {
        launch(args);
    }
}
