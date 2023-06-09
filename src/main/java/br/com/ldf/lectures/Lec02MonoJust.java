package br.com.ldf.lectures;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {
        // publisher
        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono);

        // Consumindo publicador
        mono.subscribe(i -> System.out.println("Receive : " + i));
    }
}
