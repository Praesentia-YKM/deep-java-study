package Stream;

import java.util.Arrays;
import java.util.List;

/**
 * 다음 코드를 메서드 참조를 사용하도록 수정하세요.
 */
public class ex2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");

        // 이 람다 표현식을 메서드 참조로 변환하세요
        names.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.println(name));

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}
