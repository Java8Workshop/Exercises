package com.tasktoys.java8ws.intptr_t.ch4.ex01;

import com.sun.javafx.tk.Toolkit;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

@SuppressWarnings("restriction") // for com.sun.javafx.tk.Toolkit
public class Ch4Ex01 extends Application {
	//
	// UI
	//
	final TextField textField = new TextField();
	final Label textLabel = new Label();
	final Rectangle2D display = Screen.getPrimary().getBounds();

	//
	// const values
	//
	final int FONT_PT = 100;

	/**
	 * プログラムエントリーポイント
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * 文字列、フォント情報からGUI表示に必要な横幅を取得
	 * @param text 文字列
	 * @param font フォント
	 * @return 表示幅
	 */
	private double getStringWidth(String text, Font font) {
		//[参考]　http://stackoverflow.com/questions/13015698/how-to-calculate-the-pixel-width-of-a-string-in-javafx
		return Toolkit.getToolkit().getFontLoader().computeStringWidth(text, font);
	}

	/**
	 * ウインドウをリサイズするリスナ
	 */
	private class StageResizeListener implements ChangeListener<String> {
		private final Stage stage;
		private final double minWidth;

		StageResizeListener(Stage stage) {
			this.stage = stage;
			this.minWidth = getStringWidth(Ch4Ex01.this.textLabel.getText(), Ch4Ex01.this.textLabel.getFont());
		}

		@Override
		public void changed(ObservableValue<? extends String> prop, String oldValue, String newValue) {
			// テキストフィールドに文字が追加 かつ
			// ウインドウサイズがディスプレイサイズ範囲を超える場合、拡大処理をしない
			if( (newValue.length() > oldValue.length()) &&
				((this.stage.getX() + this.stage.getWidth()) >= display.getWidth()) ){
				return;
			}

			// 文字列に対する表示幅を算出
			final Insets insets = Ch4Ex01.this.textLabel.getInsets();
			final String metricsText = Ch4Ex01.this.textLabel.getText() + " "; // 最後の文字が隠れてしまうため、空白1文字分を追加
			final double width = getStringWidth(metricsText, Ch4Ex01.this.textLabel.getFont()) + insets.getLeft() + insets.getRight();

			// リサイズ後のサイズが最小サイズを下回る、または最大サイズを超える場合処理しない
			if((width <= this.minWidth) || (width >= Ch4Ex01.this.display.getWidth())) {
				return;
			}

			// 表示をリサイズ
			Ch4Ex01.this.textLabel.resize(width, Ch4Ex01.this.textLabel.getHeight());
			this.stage.setWidth(Ch4Ex01.this.textLabel.getWidth());
		}
	};

	/**
	 * JavaFX エントリーポイント
	 */
	@Override
	public void start(Stage stage) throws Exception {
		final StageResizeListener resizeListener = new StageResizeListener(stage);

		// property
		this.textField.setText("Hello,FX");
		this.textField.setEditable(true);
		this.textLabel.setText(textField.getText());
		this.textLabel.setFont(new Font(FONT_PT));
		stage.setMinWidth(this.textLabel.getWidth());
		stage.setMaxWidth(this.display.getWidth());

		// layout
		final VBox vbox = new VBox(5.0); // 5pixel spacing
		vbox.getChildren().addAll(this.textField, this.textLabel);

		// event
		this.textLabel.textProperty().bind(textField.textProperty());
		this.textField.textProperty().addListener(resizeListener);

		stage.setScene(new Scene(vbox));
		stage.setTitle("練習問題");
		stage.show();
	}
}
