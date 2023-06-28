package br.com.ldf.lectures.advancedflux;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssigment {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
                    var character = Util.faker().gameOfThrones().character();
                    synchronousSink.next(character);
                    if (character.contains("Stark")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(Util.onNext());

    }
}
