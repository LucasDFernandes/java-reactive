package br.com.ldf.lectures.mono;

import java.util.stream.Stream;

public class Lec01Stream {

    /**
     * Explicando que o stream por natureza é Lazy
     *
     * @param args
     */
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1)
                .map(i -> {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return i * 2;
                });

        stream.forEach(System.out::println);
    }

}
