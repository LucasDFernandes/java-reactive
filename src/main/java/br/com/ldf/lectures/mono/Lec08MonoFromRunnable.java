package br.com.ldf.lectures.mono;

import br.com.ldf.util.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        () -> System.out.println("process is done")
                );
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3000);
            System.out.println("Operations completed");
        };
    }

}
