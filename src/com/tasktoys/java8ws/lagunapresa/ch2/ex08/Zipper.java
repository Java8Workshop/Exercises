package com.tasktoys.java8ws.lagunapresa.ch2.ex08;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Zipper {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Objects.requireNonNull(first);
        Objects.requireNonNull(second);

        return StreamSupport.stream(
            Spliterators.spliteratorUnknownSize(
                new ZippedIterator<>(first.iterator(), second.iterator()),
                Spliterator.IMMUTABLE | Spliterator.NONNULL),
            false);
    }

    private static final class ZippedIterator<T> implements Iterator<T> {

        private final AtomicBoolean a = new AtomicBoolean(true);

        private final Iterator<T> it1;
        private final Iterator<T> it2;

        private ZippedIterator(Iterator<T> it1, Iterator<T> it2) {
            this.it1 = it1;
            this.it2 = it2;
        }

        @Override
        public boolean hasNext() {
            return a.get() ? it1.hasNext() : it2.hasNext();
        }

        @Override
        public T next() {
            return a.getAndSet(!a.get()) ? it1.next() : it2.next();
        }

    }

}
