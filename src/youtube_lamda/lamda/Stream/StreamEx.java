package youtube_lamda.lamda.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * youtube_lamda.lamda.Stream : 다양한 데이터 소스(컬렉션, 배열 ...)를 표준화된
 * (list, set, map은 서로 자료를 다루는 방식이 달라서 표준화되지 못한 자료구조다)
 * 방법으로 다루기 위한 것
 *
 * 컬렉션(List, Set, Map) 을 -> youtube_lamda.lamda.Stream 으로 만들면 -> 중간작업(n번 실행하는 작업) -> 최종연산(1번 실행)
 * 과 같은 동일한 파이프라인을 거쳐서 작업이 완성된다.
 *
 * Stream은 일회용이다. 최종연산이 실행을 마치면 다시 최종연산을 실행할 수 없다.
 * Stream은 최종연산 전까지 중간연산이 수행되지 않는다 즉, 지연 연산을 한다.
 * Stream은 기본적으로 래퍼타입으로 지정해줘야해서 기본형 Stream이란게 존재한다. (오토박싱.언박싱 비효율 제거위해)
 */
public class StreamEx {
    public static void main(String[] args) {
        /** Stream을 생성하는 방법 (컬렉션, 배열, 람다식과 같은 함수 */
        // List
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();


        // Array
        String[] array = {"a", "b", "c"};
        Stream<String> strStream = Stream.of(array);


        // youtube_lamda.lamda.Stream.iterate() 메서드를 사용하면 초기 값과 생성 규칙에 따라 스트림을 생성
        Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2); // 0, 2, 4, 6, 8, ...


        // youtube_lamda.lamda.Stream.generate() 메서드를 사용하면 무작위 값으로 스트림을 생성
        Stream<Double> randomStream = Stream.generate(Math::random);


        // Stream의 지연연산
        IntStream intRandomStream = new Random().ints(1, 46);  // 1부터 45까지의 범위에서 무한 스트림 생성
        intRandomStream.distinct()                      // 중간 연산: 중복 요소 제거
                .limit(6)                        // 중간 연산: 처음 6개의 요소만 남김
                .sorted()                               // 중간 연산: 요소 정렬
                .forEach(i -> System.out.print(i + ","));  // 최종 연산: 각 요소를 출력


        // youtube_lamda.lamda.Stream Builder를 통한 동적스트림 생성
        Stream.Builder<String> builder = Stream.builder();

        builder.add("a");
        builder.add("b");
        builder.add("c");

        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);


        /** 함수형 인터페이스는 단 하나의 추상 메서드만 가지고 있어야하고, 그 메서드의 구현을 메서드 참조를 통해한다. */
        // 함수형 인터페이스의 이해 (메서드 참조) : 메서드 참조는 특정 객체의 메서드를 직접 참조하거나, 클래스의 정적 메서드를 참조할 때 사용
        Function<String, Integer> func = Integer::parseInt;
        int result = func.apply("123"); // result는 123이 됩니다.
        System.out.println("result = " + result);

        // 함수형 인터페이스의 이해 (람다) : 람다 표현식은 익명 함수를 간결하게 표현하는 방식
        // 함수형 인터페이스는 단 하나의 추상 메서드만 가지고 있어야하고, 그 메서드의 구현을 람다를 통해한다.
        Function<String, Integer> func2 = (e) -> Integer.parseInt(e);
        int result2 = func2.apply("1234");
        System.out.println("result2 = " + result2);
    }
}
