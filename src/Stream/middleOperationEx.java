package Stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class middleOperationEx {
    public static void main(String[] args) {
        // sout 인자 넣어서 호출하기 (인자없으면 Runnable사용)
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello, World with Consumer!");

        // skip 사용(처음 n개의 요소를 건너뛰고 나머지 요소들로 구성된 새로운 스트림을 생성하는 중간 연산)
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> skippedNumbers = numbers.stream()
                .skip(2)  // 처음 두 개의 요소(1, 2)를 건너뜀
                .collect(Collectors.toList());

        System.out.println(skippedNumbers);  // 출력: [3, 4, 5]

        // 순서가 보장되지 않는 컬렉션은 skip을 사용해도 뭘 건너뛰어야할지 확실히 정해져있지 않다.
        Set<String> fruits = new HashSet<>(Arrays.asList("apple", "banana", "cherry", "date"));
        Stream<String> stream = fruits.stream().skip(2);

        stream.forEach(System.out::println); // 출력 순서는 보장되지 않음

    }
}
