package br.com.ldf.lectures.flux;

import br.com.ldf.lectures.flux.helper.NameGenerator;
import br.com.ldf.util.Util;

public class Lec07FluxVsList {

    public static void main(String[] args) {
//        var listNames = NameGenerator.getNames(5);
//        System.out.println(listNames);

        NameGenerator.getNames(5)
                .subscribe(Util.onNext());




    }
}
