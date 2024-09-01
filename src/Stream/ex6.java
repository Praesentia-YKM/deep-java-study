package Stream;

import java.util.Optional;

/**
 * Optional<String>을 사용하여, 만약 주어진 문자열이 null이거나 비어 있지 않다면 그 문자열을 대문자로 변환하여 출력하고,
 * 그렇지 않다면 "EMPTY"라는 메시지를 출력하도록 하세요.
 */
public class ex6 {
    public static void main(String[] args) {
        Optional<String> optionalName = Optional.ofNullable("john");

        // 이 코드를 완성하여 조건에 맞는 결과를 출력하세요
        optionalName.map(String::toUpperCase)
                .ifPresentOrElse(System.out::println, () -> System.out.println("EMPTY"));

    }
}
