package com.quincy.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class RTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println("------------");
        List<String> result = list.stream().map(s->s+="x").collect(Collectors.toList());
        result.forEach(System.out::println);
        System.out.println("------------");

		List<Integer> elements = new ArrayList<>();
        Flux.just(1, 2, 3, 4)
                .log()
                .subscribe(elements::add);

//        elements.forEach(e->{System.out.println(e);});
        elements.forEach(System.out::println);
        System.out.println("------------");
//        elements.stream().map(i->i+=2);
        elements.stream().map(i->{return i+2;});
        elements.forEach(System.out::println);
        System.out.println("------------");

        List<String> elements2 = new ArrayList<>();
        Flux.just(1, 2, 3, 4)
        	.log()
        	.map(i -> i * 2)
        	.zipWith(Flux.range(0, Integer.MAX_VALUE),
                (one, two) -> String.format("First Flux: %d, Second Flux: %d", one, two))
        	.subscribe(elements2::add);
        elements2.forEach(System.out::println);

        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
            while(true) {
                fluxSink.next(System.currentTimeMillis());
            }
        }).sample(Duration.ofSeconds(2)).publish();
        publish.subscribe(System.out::println);
        publish.subscribe(System.out::println);
        publish.connect();

        elements  = new CopyOnWriteArrayList<>();
        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> i * 2)
                .subscribeOn(Schedulers.parallel())
                .subscribe(elements::add);

	}

}
