package br.com.ldf.lectures.advancedflux;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {

    public static void main(String[] args) {
        Flux.generate(
                        () -> 1,
                        (counter, sink) -> {
                            var name = Util.faker().gameOfThrones().character();
                            sink.next(name);
                            if (counter >= 10 || name.contains("Stark")) {
                                sink.complete();
                            }
                            return counter + 1;
                        }
                )
                .subscribe(Util.subscriber());
    }
}
