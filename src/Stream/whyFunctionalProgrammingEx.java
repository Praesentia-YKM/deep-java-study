package Stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 명령형 : [HOW]어떻게 리스트를 순회(for문), 어떻게 단어를 구해(length), 어떻게 map에 저장해(조건에 맞춰 map에)
 * 선언형 : [WHAT]최종적인 결과에 더 집중 : 결과만 내면되고 내부 구현은 api나 메서드 이용(반복과 같은 세부적인 부분은 고차 함수에 위임합니다.)
 * 함수형 : [FLOW] 데이터의 흐름에 집중, 변수의 불변성
 */
public class whyFunctionalProgrammingEx {
    public static void main(String[] args) {
        // 예제 리스트
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "egg", "fig", "grape");

        // 명령형 스타일 호출
        Map<Integer, Integer> imperativeResult = numberOfWordsPerLengthImperative(words);
        System.out.println("Imperative result: " + imperativeResult);

        // 선언형 스타일 호출
        Map<Integer, Integer> declarativeResult = numberOfWordsPerLengthDeclarative(words);
        System.out.println("Declarative result: " + declarativeResult);

        // 함수형 스타일 호출
        Map<Integer, Long> functionalResult = numberOfWordsPerLengthPurelyFunctional(words);
        System.out.println("Functional result: " + functionalResult);
    }

    // 명령형 스타일 (Imperative)
    public static Map<Integer, Integer> numberOfWordsPerLengthImperative(List<String> words) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            int key = words.get(i).length();
            result.put(key, result.getOrDefault(key, 0) + 1);
        }
        return result;
    }

    // 선언형 스타일 (Declarative)
    public static Map<Integer, Integer> numberOfWordsPerLengthDeclarative(List<String> words) {
        Map<Integer, Integer> result = new HashMap<>();
        words.forEach(word -> {
            int key = word.length();
            result.put(key, result.getOrDefault(key, 0) + 1);
        });
        return result;
    }

    // 함수형 스타일 (Functional)
    public static Map<Integer, Long> numberOfWordsPerLengthPurelyFunctional(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }
}
