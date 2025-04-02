package youtube_lamda.lamda.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 다음 코드에서 filter, map, sorted, collect 메서드를 사용하여
 * 이름이 "J"로 시작하는 사람들의 이름을 대문자로 변환한 뒤, 알파벳 순으로 정렬하고,
 * 최종 결과를 List로 반환하도록 하세요.
 */
public class ex3 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe", "Alice", "Bob");

        // 이 스트림을 완성하여 조건에 맞는 결과를 반환하세요
        Stream<String> stream = names.stream();
        List<String> result = stream.filter(s -> s.startsWith("J"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
