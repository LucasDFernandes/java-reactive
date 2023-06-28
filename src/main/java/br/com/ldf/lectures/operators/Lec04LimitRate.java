package br.com.ldf.lectures.operators;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {

    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                .limitRate(100) //
                .subscribe(Util.subscriber());
    }
}
