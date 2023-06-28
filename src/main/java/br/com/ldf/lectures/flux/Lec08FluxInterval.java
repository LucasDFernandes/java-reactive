package br.com.ldf.lectures.flux;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxInterval {

    public static void main(String[] args) {
        // Funciona de maneira Assyncrhona
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());

        Util.sleepSeconds(5000);
    }
}
