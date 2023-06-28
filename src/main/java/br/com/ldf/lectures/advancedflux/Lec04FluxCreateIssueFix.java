package br.com.ldf.lectures.advancedflux;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String name;
                    do {
                        name = Util.faker().gameOfThrones().character();
                        System.out.println("Emitting: " + name);
                        fluxSink.next(name);
                    } while (!name.contains("Stark") && !fluxSink.isCancelled());
                })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
