package Optaional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalMethodEx {
    public static void main(String[] args) {
        // 1. Optional.empty() - 비어있는 Optional 객체 생성
        // 팩토리 메서드 사용: Optional.empty()는 비어 있는(null) Optional 객체를 반환합니다.
        // 이 객체는 값이 없음을 명시적으로 표현할 때 사용됩니다.
        Optional<String> emptyOptional = Optional.empty();
        System.out.println("emptyOptional.isPresent(): " + emptyOptional.isPresent());  // 출력: false
        System.out.println("emptyOptional.isEmpty(): " + emptyOptional.isEmpty());  // 출력: true


        // 2. Optional.of() - 절대 null이 아닌 값을 가진 Optional 객체 생성
        // 팩토리 메서드 사용: Optional.of()는 절대 null이 아닌 값을 감싸는 Optional 객체를 생성합니다.
        // 만약 null이 전달되면 NullPointerException을 던집니다.
        // [널이 아닌대도 굳이 옵셔널로 감싸면 널이 아니라는 의도를 보여굼과 더불어 함수형 인터페이스 사용가능]
        // map(), flatMap(), filter()등의 메서드를 사용하여 더 선언적이고 간결한 방식으로 데이터를 처리할 수 있습니다.
        Optional<String> nonNullOptional = Optional.of("Hello, World!");
        System.out.println("nonNullOptional.isPresent(): " + nonNullOptional.isPresent());  // 출력: true
        System.out.println("nonNullOptional.isEmpty(): " + nonNullOptional.isEmpty());  // 출력: false
        Optional<Integer> length = nonNullOptional.map(String::length);
        length.ifPresent(System.out::println);  // 출력: 13


        // 3. Optional.ofNullable() - null일 수도 있고 아닐 수도 있는 값을 가진 Optional 객체 생성
        // 팩토리 메서드 사용: Optional.ofNullable()는 null일 수도 있고 아닐 수도 있는 값을 감싸는 Optional 객체를 생성합니다.
        // 전달된 값이 null이면 비어 있는 Optional 객체를 반환하고, 그렇지 않으면 값을 감싸는 Optional 객체를 반환합니다.
        String nullableString = null;
        Optional<String> nullableOptional = Optional.ofNullable(nullableString);
        System.out.println("nullableOptional.isPresent(): " + nullableOptional.isPresent());  // 출력: false


        // 4. get() - Optional에 값이 있을 때만 가져옴 (주의: 값이 없으면 예외 발생)
        try {
            String value = nonNullOptional.get();
            System.out.println("nonNullOptional.get(): " + value);  // 출력: Hello, World!
        } catch (Exception e) {
            System.out.println("nonNullOptional.get() 예외 발생: " + e.getMessage());
        }

        try {
            String value = emptyOptional.get();  // 예외 발생
        } catch (Exception e) {
            System.out.println("emptyOptional.get() 예외 발생: " + e.getMessage());  // 출력: No value present
        }


        // 5. orElse() - 값이 있으면 그 값을 반환하고, 없으면 기본값을 반환
        String orElseResult = emptyOptional.orElse("기본값");
        System.out.println("emptyOptional.orElse(): " + orElseResult);  // 출력: 기본값


        // 6. orElseGet() - 값이 있으면 그 값을 반환하고, 없으면 람다 표현식의 결과를 반환
        String orElseGetResult = emptyOptional.orElseGet(() -> "기본값(람다)");
        System.out.println("emptyOptional.orElseGet(): " + orElseGetResult);  // 출력: 기본값(람다)


        // 7. orElseThrow() - 값이 없으면 예외를 던짐
        try {
            String orElseThrowResult = emptyOptional.orElseThrow(() -> new IllegalArgumentException("값이 없습니다!"));
        } catch (Exception e) {
            System.out.println("emptyOptional.orElseThrow() 예외 발생: " + e.getMessage());  // 출력: 값이 없습니다!
        }


        // 8. ifPresent() - 값이 있으면 특정 작업을 수행
        nonNullOptional.ifPresent(value -> System.out.println("값이 존재합니다: " + value));  // 출력: 값이 존재합니다: Hello, World!


        // 9. ifPresentOrElse() - 값이 있으면 특정 작업을 수행하고, 없으면 다른 작업을 수행 (Java 9 이상)
        nonNullOptional.ifPresentOrElse(
                value -> System.out.println("값이 존재합니다: " + value),  // 출력: 값이 존재합니다: Hello, World!
                () -> System.out.println("값이 없습니다.")
        );

        emptyOptional.ifPresentOrElse(
                value -> System.out.println("값이 존재합니다: " + value),
                () -> System.out.println("값이 없습니다.")  // 출력: 값이 없습니다.
        );


        // 10. map() - Optional의 값을 변환
        Optional<Integer> lengthOptional = nonNullOptional.map(String::length);
        lengthOptional.ifPresent(len -> System.out.println("문자열 길이: " + len));  // 출력: 문자열 길이: 13


        // 11. flatMap() - Optional의 값을 Optional로 변환하고 중첩된 Optional을 평탄화
        Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("Nested"));
        Optional<String> flatOptional = nestedOptional.flatMap(opt -> opt);
        flatOptional.ifPresent(System.out::println);  // 출력: Nested


        // 12. filter() - Optional의 값을 조건에 따라 걸러냄
        // 람다 = 메서드표현식 = 익명클래스 = 인터페이스의 구현 = 인터페이스의 메서드들은 언제나 public이므로 구현가능한것.
        Optional<String> filteredOptional1 = nonNullOptional.filter(value -> value.startsWith("Hello"));
        Optional<String> filteredOptional2 = nonNullOptional.filter("Hello"::startsWith); // 출력안됨
        filteredOptional1.ifPresent(value -> System.out.println("조건에 맞는 값1: " + value));  // 출력: 조건에 맞는 값: Hello, World!
        filteredOptional2.ifPresent(value -> System.out.println("조건에 맞는 값2: " + value));

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        // Stream과 compareTo를 사용하여 문자열 정렬
        List<String> sortedWords = words.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());

        // 결과 출력
        sortedWords.forEach(System.out::println);

        // Stream과 startsWith를 사용하여 'a'로 시작하는 문자열 필터링
        List<String> filteredWords = words.stream()
                .filter(word -> word.startsWith("a"))
                .collect(Collectors.toList());

        // 결과 출력
        filteredWords.forEach(System.out::println);
    }
}
