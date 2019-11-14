package com.krishna.stream;

import java.util.List;

public class StreamDemo {

        public static void main(String... args) {
            List<Integer> bigList = List.of( 50, 10, 250, 100);
            bigList.parallelStream()
                    .forEach(i ->
                            System.out.println(Thread.currentThread().getName() + ": " + i)
                    );
        }
}
