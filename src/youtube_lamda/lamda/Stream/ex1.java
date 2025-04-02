package youtube_lamda.lamda.Stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 주어진 코드에서 람다 표현식을 사용하여 List<Integer>에서 짝수만 출력하도록 하세요.
 */
public class ex1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // 여기에 람다 표현식을 사용하여 짝수만 출력하는 코드를 작성하세요
        Iterator iterator = numbers.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + ",");
        }
        System.out.println();

        Stream<Integer> stream = numbers.stream();
        stream.filter(s->s%2==0).forEach(System.out::println);
    }
}
