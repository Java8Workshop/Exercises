package com.tasktoys.java8ws.lagunapresa.ch3.ex16;

import java.util.Optional;
import java.util.function.Consumer;

public class Either<L, R> {

    public final Optional<L> left;
    public final Optional<R> right;

    private Either(Optional<L> left, Optional<R> right) {
        this.left = left;
        this.right = right;
    }

    public static <L, R> Either<L, R> rightOf(R right) {
        return new Either<>(Optional.empty(), Optional.of(right));
    }

    public static <L, R> Either<L, R> leftOf(L left) {
        return new Either<>(Optional.of(left), Optional.empty());
    }

    public void accept(Consumer<R> onRight, Consumer<L> onLeft) {
        right.ifPresent(onRight);
        left.ifPresent(onLeft);
    }

}
