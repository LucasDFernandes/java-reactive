package br.com.ldf.lectures.advancedflux;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {

    public static void main(String[] args) {
        Flux.range(1, 20)
                .take(3) // after this cancels !
                .log()
                .subscribe(Util.subscriber());
    }
}
