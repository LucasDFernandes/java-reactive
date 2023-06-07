package br.com.ldf;

import br.com.ldf.util.Util;
import reactor.core.publisher.Mono;

public class Lec03MonSubscribe {

    public static void main(String[] args) {
        // publisher
        Mono<String> mono = Mono.just("ball");

        Mono<Integer> monoWithError = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 0);

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        monoWithError.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }

}
