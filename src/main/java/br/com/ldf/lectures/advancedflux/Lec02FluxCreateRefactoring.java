package br.com.ldf.lectures.advancedflux;

import br.com.ldf.lectures.advancedflux.helper.NameProducer;
import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactoring {

    public static void main(String[] args) {
        var nameProducer = new NameProducer();

        Flux.create(nameProducer)
                .subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;

        for (int index = 0; index < 10; index++) {
            new Thread((runnable)).start();
        }

        Util.sleepSeconds(2000);
    }
}
