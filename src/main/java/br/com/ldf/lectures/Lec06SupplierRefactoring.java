package br.com.ldf.lectures;

import br.com.ldf.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {
        getName();
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext());
        var resultString = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        getName();
        Util.sleepSeconds(4000);
    }

    private static Mono<String> getName() {
        System.out.println("entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name ...");
            Util.sleepSeconds(3000);
            return Util.faker().gameOfThrones().character();
        }).map(String::toUpperCase);
    }
}
