package br.com.ldf.lectures.advancedflux.helper;

import br.com.ldf.util.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<Object>> {

    private FluxSink<Object> fluxSink;

    @Override
    public void accept(FluxSink<Object> objectFluxSink) {
        this.fluxSink = objectFluxSink;
    }

    public void produce() {
        var name = Util.faker().gameOfThrones().character();

        var thread = Thread.currentThread().getName();

        this.fluxSink.next(thread + ": " + name);
    }
}
