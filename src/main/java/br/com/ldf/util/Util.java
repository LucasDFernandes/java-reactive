package br.com.ldf.util;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class Util {

    private static final Faker faker = Faker.instance();

    public static Consumer<Object> onNext() {
        return o -> System.out.println("Received : " + o);
    }

    public static Consumer<Throwable> onError() {
        return e -> System.out.println("error : " + e.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("completed");
    }

    public static Faker faker() {
        return faker;
    }

    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
