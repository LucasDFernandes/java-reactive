package br.com.ldf.lectures.flux;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {

    public static void main(String[] args) {
        var flux = Flux.just(1, 2, 3, 4);

        var evenFlux = flux.filter(i -> i % 2 == 0);

        flux.subscribe(i -> System.out.println("Sub 1: " + i));

        evenFlux.subscribe(i -> System.out.println("Sub 2: " + i));
    }
}
