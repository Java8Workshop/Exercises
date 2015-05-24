package com.tasktoys.java8ws.mrbearing.ch3.ex10;

import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageDemo extends Application {

   public static Image transform(Image in, UnaryOperator<Color> f) {
      int width = (int) in.getWidth();
      int height = (int) in.getHeight();
      WritableImage out = new WritableImage(
         width, height);
      for (int x = 0; x < width; x++)
         for (int y = 0; y < height; y++)
            out.getPixelWriter().setColor(x, y,
               f.apply(in.getPixelReader().getColor(x, y)));
      return out;
   }

   public static <T> UnaryOperator<T> compose(UnaryOperator<T> op1,
      UnaryOperator<T> op2) {
      return t -> op2.apply(op1.apply(t));
   }

   public void start(Stage stage) {
      //Image image = new Image("eiffel-tower.jpg");
	   Image image = new Image(
				"https://pbs.twimg.com/media/CEDfyQEVEAAkERc.png");
      Image image3 = transform(image, compose(Color::brighter, Color::grayscale));
      stage.setScene(new Scene(new HBox(
         new ImageView(image),
         // new ImageView(image2),
         new ImageView(image3))));
      stage.show();

      UnaryOperator<Color> op = Color::brighter;
      /*
       * composeの戻り値がFunction型であるため、UnaryOperatorにキャストしないと使用できない。
       */
      Image finalImage = transform(image, (UnaryOperator<Color>) op.compose(Color::grayscale));


   }

   public static void main(String[] args){
	   System.out.println("hello");
	   ImageDemo.launch(args);

   }

}

/*
実行するとエクセプション飛んじゃいますぅ。
Exception in Application start method
java.lang.reflect.InvocationTargetException
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	at java.lang.reflect.Method.invoke(Unknown Source)
	at com.sun.javafx.application.LauncherImpl.launchApplicationWithArgs(Unknown Source)
	at com.sun.javafx.application.LauncherImpl.launchApplication(Unknown Source)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	at java.lang.reflect.Method.invoke(Unknown Source)
	at sun.launcher.LauncherHelper$FXHelper.main(Unknown Source)
Caused by: java.lang.RuntimeException: Exception in Application start method
	at com.sun.javafx.application.LauncherImpl.launchApplication1(Unknown Source)
	at com.sun.javafx.application.LauncherImpl.lambda$launchApplication$152(Unknown Source)
	at com.sun.javafx.application.LauncherImpl$$Lambda$50/1323468230.run(Unknown Source)
	at java.lang.Thread.run(Unknown Source)
Caused by: java.lang.ClassCastException: java.util.function.Function$$Lambda$90/549995124 cannot be cast to java.util.function.UnaryOperator
	at com.tasktoys.java8ws.mrbearing.ch3.ex10.ImageDemo.start(ImageDemo.java:48)
	at com.sun.javafx.application.LauncherImpl.lambda$launchApplication1$159(Unknown Source)
	at com.sun.javafx.application.LauncherImpl$$Lambda$53/774625936.run(Unknown Source)
	at com.sun.javafx.application.PlatformImpl.lambda$runAndWait$172(Unknown Source)
	at com.sun.javafx.application.PlatformImpl$$Lambda$45/186276003.run(Unknown Source)
	at com.sun.javafx.application.PlatformImpl.lambda$null$170(Unknown Source)
	at com.sun.javafx.application.PlatformImpl$$Lambda$48/836201609.run(Unknown Source)
	at java.security.AccessController.doPrivileged(Native Method)
	at com.sun.javafx.application.PlatformImpl.lambda$runLater$171(Unknown Source)
	at com.sun.javafx.application.PlatformImpl$$Lambda$47/237061348.run(Unknown Source)
	at com.sun.glass.ui.InvokeLaterDispatcher$Future.run(Unknown Source)
	at com.sun.glass.ui.win.WinApplication._runLoop(Native Method)
	at com.sun.glass.ui.win.WinApplication.lambda$null$145(Unknown Source)
	at com.sun.glass.ui.win.WinApplication$$Lambda$36/2117255219.run(Unknown Source)
	... 1 more
Exception running application com.tasktoys.java8ws.mrbearing.ch3.ex10.ImageDemo

 */




