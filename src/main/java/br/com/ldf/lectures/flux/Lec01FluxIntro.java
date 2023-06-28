package br.com.ldf.lectures.flux;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

    public static void main(String[] args) {
        var flux = Flux.just(1, 2, 3, Util.faker().gameOfThrones().character());

        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
