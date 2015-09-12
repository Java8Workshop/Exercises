package com.tasktoys.java8ws.intptr_t.ch7.ex10;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class Ch7Ex10 extends Application {
	public static void main(String[] args) throws IOException {
		// サンプルデータを生成
		String sample = "{\"one\":10, \"two\":20, \"four\":40, \"eight\": 80}";
		Files.write(Paths.get("./out/pie.json"), sample.getBytes(), StandardOpenOption.CREATE);

		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
		final Map<String, Object> pieKeyValues = loadPieData();
		for(Map.Entry<String, Object> e : pieKeyValues.entrySet()) {
			pieData.add(new PieChart.Data(e.getKey(), Double.parseDouble(e.getValue().toString())));
		}
		final PieChart pieChart = new PieChart(pieData);
		pieChart.setTitle("Title");
		
		final Scene scene = new Scene(pieChart);
		primaryStage.setScene(scene);
		primaryStage.show();
	}	
	
	static Map<String, Object> loadPieData() {
		try {
			Path path = Paths.get("./out/pie.json");
			return loadJson(path);
		} catch(Exception ex) {
			return null;
		}
	}
	
	static Map<String, Object> loadJson(Path path)
				throws ScriptException,
					   ClassNotFoundException,
					   IllegalAccessException,
					   IllegalArgumentException,
					   InvocationTargetException,
					   NoSuchMethodException,
					   SecurityException,
					   IOException
	{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");
		String text = new String(Files.readAllBytes(path), "utf-8");
		
		Object obj = (Object)engine.eval(String.format("(%s)", text));
		
		return loadJson(obj);
	}
	
	static Map<String, Object> loadJson(Object obj)
				throws ScriptException,
					   IllegalAccessException,
					   IllegalArgumentException,
					   InvocationTargetException,
					   NoSuchMethodException,
					   SecurityException,
					   ClassNotFoundException
	{
		Class<?> scriptObjectMirrorClasss = Class.forName("jdk.nashorn.api.scripting.ScriptObjectMirror");		
		Object[] keys = ((java.util.Set<?>)obj.getClass().getMethod("keySet").invoke(obj)).toArray();
		Method methodGet = obj.getClass().getMethod("get", Class.forName("java.lang.Object"));
		Map<String, Object> map = new HashMap<>();
		for(Object key : keys) {
			Object value = methodGet.invoke(obj, key);
			if(scriptObjectMirrorClasss.isInstance(value)) {
				// array or associative array
				map.put(key.toString(), loadJson(value));
			} else {
				map.put(key.toString(), value.toString());
			}
		}
		
		return map;
	}
}
