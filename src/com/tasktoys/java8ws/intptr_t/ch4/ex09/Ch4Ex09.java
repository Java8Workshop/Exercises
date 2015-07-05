package com.tasktoys.java8ws.intptr_t.ch4.ex09;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

// 参考
// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/ArcTo.html
public class Ch4Ex09 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final Group group = new Group();
		final Scene scene = new Scene(group, 640, 480);
		final Circle circle = new Circle(10);

		final double centerX = 320 + 160;
		final double centerY = 240;
		final double radiusX = 160;
		final double radiusY = 120;
		
		// アニメーション用の軌跡を生成
		// 	画面の中心から、１周する円を描く (大きな弧で円を描くため x[end point]を+1する)
		//  xAxisRotation := 0.0(描画する楕円全体の回転量[degree])
		//  largeArcFlag := true(大きいな弧)
		//  sweepFlag := false(時計回り)
		final Path path = new Path();
	    path.getElements().add (new MoveTo(centerX - radiusX, centerY - radiusY));
	    path.getElements().add(new ArcTo(radiusX, radiusY, 0.0, centerX - radiusX + 1, centerY - radiusY, true, false));
	    path.getElements().add (new ClosePath());
	    
		final PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(2000));		
		pt.setDelay(Duration.ZERO);
		pt.setNode(circle);
		pt.setPath(path);
		pt.setOrientation(OrientationType.NONE);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(false);
		pt.play();		
		
		group.getChildren().add(circle);
		group.getChildren().add(path);		
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
