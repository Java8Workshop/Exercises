package com.tasktoys.java8ws.lagunapresa.ch3.ex10;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorApi {
    public static void main(String[] args) {
        // 型の話をするだけなので実行は考慮していない
        System.exit(0);

        Image image = new Image("eiffel-tower.jpg");
        UnaryOperator<Color> op = Color::brighter;
        // compose の戻り型は Function<Color, Color>
        Function<Color, Color> compose = op.compose(Color::grayscale);

        // 一方、transform の第2引数の引数型は UnaryOperator<Color> であるため、コンパイル不可。
//        Image finalImage = transform(image, compose);

        // 解決法1：P68 のような compose メソッドを自作する。
        Image finalImage1 = transform(image, compose(op, Color::grayscale));

        // 解決法2：もし UnaryOperator が次のような実装（AdvancedUnaryOperator）であれば解決する。
        AdvancedUnaryOperator<Color> op2 = Color::brighter;
        Image finalImage2 = transform(image, op2.compose(Color::grayscale));

        // 解決法3：transform メソッドの第2引数の型を Function<Color, Color> にする。
        Image finalImage3 = transform2(image, op.compose(Color::grayscale));

        // 考えるに、UnaryOperator<T> は Function<T, T> の型シノニムとして存在すべきだが、
        // Java にその機能はないため、サブタイプとして実装されてしまっているところに問題がある気がする。
        // 現状 UnaryOperator<T> を引数型として使用したい場合には、代わりに Function<T, T> を使用すべきだと思う。
    }

    @FunctionalInterface
    public interface AdvancedUnaryOperator<T> extends UnaryOperator<T> {
        // この compose は Function#compose をオーバーライドしていない。
        // FunctionalInterface であることを保つためデフォルト実装にしてあるのが無理矢理ではある。
        default AdvancedUnaryOperator<T> compose(AdvancedUnaryOperator<T> before) {
            Objects.requireNonNull(before);
            return t -> apply(before.apply(t));
        }
    }

    private static Image transform(Image in, UnaryOperator<Color> f) {
        return null;
    }

    private static Image transform2(Image in, Function<Color, Color> f) {
        return null;
    }

    private static <T> UnaryOperator<T> compose(UnaryOperator<T> op1,
                                               UnaryOperator<T> op2) {
        return t -> op2.apply(op1.apply(t));
    }

    // > ストラクチャル型とノミナル型のユーティリティに関して
    // ？？？

}
