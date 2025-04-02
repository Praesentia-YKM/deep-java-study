package youtube_lamda.lamda;

import java.util.function.Function;
import java.util.function.Predicate;

public class combinePredicate {
    // and, or, negate 로 두개의 predicate를 하나로 결합할 수 있다.
    public static void main(String[] args) {
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i);

        Function<String, String> h = f.andThen(g);  // f적용하고 나서 g를 적용해라
        Function<Integer, Integer> h2 = f.compose(g);

        System.out.println(h.apply("FF"));    // "FF" -> 255 -> "11111111"
        System.out.println(h2.apply(2));      // 2 -> "10" -> 16

        Function<String, String> f2 = x -> x; // 항등 함수(identity function)
        System.out.println(f2.apply("AAA"));  // AAA가 그대로 출력됨

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate(); // i >= 100

        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150));    // true

        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = "abc";

        // str1과 str2가 같은지 비교한 결과를 반환
        Predicate<String> p2 = Predicate.isEqual(str1);
        System.out.println(str1.equals(str2));  // 동등성 (값비교)
        System.out.println(str1==str2); // 동일성 (참조 비교)
        System.out.println(str1==str3); // 리터럴문자열은 스트링 풀에 의하여 같은 값 참조
    }
}
