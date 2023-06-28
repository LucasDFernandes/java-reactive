package br.com.ldf.lectures.flux;

import br.com.ldf.util.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {

    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("Received Sub: " + s);
                        atomicReference.set(s);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("OnNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("OnError: " + t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("OnCompleted:");
                    }
                });

        Util.sleepSeconds(3000);
        atomicReference.get().request(3);
        Util.sleepSeconds(5000);
        atomicReference.get().request(3);
        Util.sleepSeconds(5000);
        System.out.println("Going to cancel");
        atomicReference.get().cancel();
        Util.sleepSeconds(5000);
        atomicReference.get().request(4);
        Util.sleepSeconds(5000);
    }
}
