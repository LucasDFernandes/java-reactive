package br.com.ldf.lectures.flux;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class Lec03FluxFromArrayOrList {

    public static void main(String[] args) {
        var strings = Arrays.asList("a", "b", "c");

        Flux.fromIterable(strings).subscribe(Util.onNext());
    }
}
