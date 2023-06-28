package br.com.ldf.lectures.advancedflux;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String name;
                    do {
                        name = Util.faker().gameOfThrones().character();
                        fluxSink.next(name);
                   } while (!name.contains("Stark"));
                })
                .subscribe(Util.subscriber());
    }
}
