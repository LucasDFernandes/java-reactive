package br.com.ldf.lectures.operators;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

public class Lec02HandleAssignment {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
                    synchronousSink.next(Util.faker().country().name());
                }).map(Object::toString)
                .handle(((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if (s.equalsIgnoreCase("brazil")) {
                        synchronousSink.complete();
                    }
                }))
                .subscribe(Util.subscriber());


    }
}
