package br.com.ldf.lectures.operators;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallbacks {

    public static void main(String[] args) {
        // ciclo de vida callbacks reativo
        Flux.create(fluxSink -> {
                    System.out.println("inside create");
                    for (int index = 0; index < 5; index++) {
                        fluxSink.next(index);
//                        fluxSink.error(new RuntimeException("ops"));
                    }
                    System.out.println("--completed");
                })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst"))
                .doOnNext(o -> System.out.println("doOnNext: " + o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe " + s))
                .doOnRequest(l -> System.out.println("doOnRequest: " + l))
                .doOnError(error -> System.out.println("doOnError : " + error))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doFinally(signal -> System.out.println("doFinally: " + signal))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard : " + o))
                .subscribe(Util.subscriber());


    }
}
