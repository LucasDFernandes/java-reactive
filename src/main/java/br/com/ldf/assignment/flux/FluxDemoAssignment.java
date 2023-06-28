package br.com.ldf.assignment.flux;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class FluxDemoAssignment {

    public static void main(String[] args) throws InterruptedException {

        var latch = new CountDownLatch(1);

        StockPricerPublisher.getPrice()
                .subscribe(new Subscriber<Integer>() {

                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription s) {
                        this.subscription = s;
                        subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer price) {
                        System.out.println(LocalDateTime.now() + "price: " + price);
                        if (price > 110 || price < 90) {
                            this.subscription.cancel();
                            latch.countDown();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        latch.countDown();
                    }

                    @Override
                    public void onComplete() {
                        latch.countDown();
                    }
                });

        latch.await();
    }
}
