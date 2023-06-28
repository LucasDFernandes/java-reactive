package br.com.ldf.assignment.flux;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class StockPricerPublisher {

    private String text;

    /**
     * Gerador de preco que a cada 1 segundo gera um numero randomico entre -5 e 5
     * e adiciona ao valor atomicInteger
     *
     * @return novo preço
     */
    public static Flux<Integer> getPrice() {
        var atomicInteger = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> atomicInteger.getAndAccumulate(
                        Util.faker().random().nextInt(-5, 5),
                        Integer::sum
                ));
    }
}
