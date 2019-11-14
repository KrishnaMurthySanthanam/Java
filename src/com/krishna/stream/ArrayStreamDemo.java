package com.krishna.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreamDemo {

    public static void main(String... args) throws IOException {
        int[] arr = { 50, 10, 250, 100};
        Arrays.stream(arr).parallel().forEach(
                i -> System.out.println(Thread.currentThread().getName() + ": " + i)
        );

        //Builder
        var built = Stream.<Integer>builder()
                .add(50).add(10).add(250).build();
        built.forEach(i->System.out.println(Thread.currentThread().getName() + ": " + i) );

        //Generate
        Stream<Integer> generated = Stream.generate(
                () -> new Random().nextInt(300)+1
        ).limit(10);

        generated.forEach(i->System.out.println(Thread.currentThread().getName() + ": " + i));

        Stream<Integer> iterated = Stream.iterate(0, i -> i < 50 , i -> i + 5);
        //From Java 9 Iterator intoduced in Streams

        iterated.forEach(i->System.out.println(Thread.currentThread().getName() + ": " + i));

        //From Java 9 takeWhile
        Stream<Integer> forTaking = Stream.of( 3, 6, 9, 12, 13, 15);
        forTaking.takeWhile(s -> s % 2 == 0)
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        Stream<Integer> forTaking1 = Stream.of( 3, 6, 9, 2, 4, 8, 12, 36, 18, 42, 11, -13);
        forTaking1.parallel().dropWhile(s -> s % 3 == 0)
                .forEachOrdered(s -> System.out.print(s + " "));

        System.out.println();
        Stream<Integer> forDropping = Stream.of( 3, 6, 9, 11, 12, 13, 15);
        forDropping.dropWhile(s -> s % 3 == 0 )
                .forEach(s -> System.out.print(s + " "));

       IntStream intStream2 = IntStream.range(0, 10);
        IntStream intStream3 = IntStream.rangeClosed(0, 10);
        intStream3.forEach(i->System.out.println(i));

        Random random = new Random();
       IntStream intStream = random.ints(5);
        intStream.forEach(i->System.out.println(i));

        IntStream charStream = "sample".chars();
        charStream.forEach(c -> System.out.print((char) c));

        Stream<String> stringStream = Pattern.compile(" ")
                .splitAsStream("live your life");

        stringStream.forEach(c -> System.out.println(c));

        String inputPath = "E:\\Projects\\Spring5\\java11\\src\\com\\krishna\\stream\\StreamDemo.java";
        Stream<String> fileStream = Files.lines(Path.of(inputPath));

        fileStream.forEach(i-> System.out.println(i));

        List<String> pieces = List.of("some","of", "us", "we’re", "hardly",
                "ever", "here");
        String first = pieces.stream().sorted().findFirst().get();
        System.out.println("First from sorted list: " + first);

    }
}
