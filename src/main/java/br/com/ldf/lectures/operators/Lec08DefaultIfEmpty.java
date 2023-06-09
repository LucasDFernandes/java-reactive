package br.com.ldf.lectures.operators;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08DefaultIfEmpty {

    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .defaultIfEmpty(-10)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 13);
    }

}
