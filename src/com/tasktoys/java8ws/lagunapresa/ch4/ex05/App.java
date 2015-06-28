package com.tasktoys.java8ws.lagunapresa.ch4.ex05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import static com.tasktoys.java8ws.lagunapresa.ch4.ex05.MyBindings.observe;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) {
        Button smallerR = new Button("Smaller");
        Button largerR = new Button("Larger");
        Button smallerG = new Button("Smaller");
        Button largerG = new Button("Larger");
        Rectangle gaugeR = new Rectangle(0, 5, 50, 15);
        Rectangle gaugeG = new Rectangle(0, 5, 50, 15);
        Rectangle outline1 = new Rectangle(0, 5, 100, 15);
        outline1.setFill(null);
        outline1.setStroke(Color.BLACK);
        Rectangle outline2 = new Rectangle(0, 5, 100, 15);
        outline2.setFill(null);
        outline2.setStroke(Color.BLACK);

        VBox box = new VBox(10);
        Scene scene = new Scene(box);

        Pane pane1 = new Pane();
        pane1.getChildren().addAll(gaugeR, outline1);
        Pane pane2 = new Pane();
        pane2.getChildren().addAll(gaugeG, outline2);
        smallerR.setOnAction(event -> gaugeR.setWidth(gaugeR.getWidth() - 10));
        largerR.setOnAction(event -> gaugeR.setWidth(gaugeR.getWidth() + 10));
        smallerG.setOnAction(event -> gaugeG.setWidth(gaugeG.getWidth() - 10));
        largerG.setOnAction(event -> gaugeG.setWidth(gaugeG.getWidth() + 10));
        smallerR.disableProperty().bind(observe(t -> t.doubleValue() <= 0, gaugeR.widthProperty()));
        largerR.disableProperty().bind(observe(t -> t.doubleValue() >= 100, gaugeR.widthProperty()));
        smallerG.disableProperty().bind(observe(t -> t.doubleValue() <= 0, gaugeG.widthProperty()));
        largerG.disableProperty().bind(observe(t -> t.doubleValue() >= 100, gaugeG.widthProperty()));
        box.styleProperty().bind(observe((t, u) -> {
            String css = String.format("-fx-background-color:rgb(%s,%s,0);", t.intValue() * 255 / 100, u.intValue() * 255 / 100);
            System.out.println(css);
            return css;
        }, gaugeR.widthProperty(), gaugeG.widthProperty()));

        HBox box1 = new HBox(10);
        box1.getChildren().addAll(smallerR, pane1, largerR);
        HBox box2 = new HBox(10);
        box2.getChildren().addAll(smallerG, pane2, largerG);
        box.getChildren().addAll(box1, box2);
        stage.setScene(scene);
        stage.show();
    }

}
