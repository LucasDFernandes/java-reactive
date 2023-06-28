package br.com.ldf.lectures.flux;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec04FluxFromStream {

    public static void main(String[] args) {

        var list = List.of(1 ,2 ,3, 4, 5);

//        stream.forEach(System.out::println);

        var flux = Flux.fromStream(() -> list.stream());

        flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }
}
