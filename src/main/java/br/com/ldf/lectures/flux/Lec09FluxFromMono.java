package br.com.ldf.lectures.flux;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

    public static void main(String[] args) {
        // convert mono to flux
//        var mono = Mono.just("a");
//
//        var flux = Flux.from(mono);
//
//        flux.subscribe(Util.onNext());

        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next() // convert flux to mono because emitting 1 item
                .subscribe(Util.onNext());

    }

    private static void doSomething(Flux<String> flux) {

    }
}
