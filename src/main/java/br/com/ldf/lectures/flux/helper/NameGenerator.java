package br.com.ldf.lectures.flux.helper;

import br.com.ldf.util.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

//    public static List<String> getNames(int count) {
//        List<String> list = new ArrayList<>();
//
//        for (int index = 0; index < count; index++) {
//            list.add(generate());
//        }
//
//        return list;
//    }

    public static Flux<String> getNames(int count) {
        return Flux.range(0, count)
                .map(i -> generate());
    }

    private static String generate() {
        Util.sleepSeconds(3000);
        return Util.faker().gameOfThrones().character();
    }
}
