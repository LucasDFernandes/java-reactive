package br.com.ldf.lectures.mono;

import br.com.ldf.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonofromSupllier {

    public static void main(String[] args) {
        // use just only when you have data already
        // Mono<String> mono = Mono.just(getName());

        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier((stringSupplier));
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }

    private static String getName() {
        System.out.println("Generating name ...");
        return Util.faker().gameOfThrones().character();
    }

}
