package br.com.ldf.lectures.flux;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {

    public static void main(String[] args) {
        Flux.range(3, 10)
                .log()
                .map(i -> Util.faker().gameOfThrones().character())
                .log()
                .subscribe(
                        Util.onNext()
                );
    }
}
