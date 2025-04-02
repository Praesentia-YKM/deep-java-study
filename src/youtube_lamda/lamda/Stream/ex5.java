package youtube_lamda.lamda.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 주어진 List<String>에서 각 문자열을 단어로 나누어,
 * 각 단어의 첫 글자가 대문자인 경우만 모아 중복을 제거한 뒤, 모든 단어를 사전순으로 정렬하여 출력하세요.
 */
public class ex5 {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList("Hello world", "Java youtube_lamda.lamda.Stream", "Functional programming", "Hello Java");

        // 이 스트림을 완성하여 조건에 맞는 결과를 출력하세요
        Stream<String> words = sentences.stream();
        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .filter(word -> Character.isUpperCase(word.charAt(0)))
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }
}
