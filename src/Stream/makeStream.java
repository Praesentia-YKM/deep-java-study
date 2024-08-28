package Stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class makeStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        /** stream은 일회용이다. foreach(최종연산)을 사용하면 stream이 닫힌다. */
        // 리스트 -> 스트림 변환 후 순회
        Stream<Integer> intStream = list.stream();
        intStream.forEach(System.out::print);
        //intStream.forEach(System.out::print); // stream을 이미 최종연산을 사용해서 다시 쓸 수 없다
        intStream = list.stream();
        intStream.forEach(System.out::print);  // 이렇게 stream을 또 생성해줘야한다.
        System.out.print("\n");

        /** stream말고 다른 방식으로 list순회 */
        // 리스트 순회1
        for (Integer iter : list) {
            System.out.print(iter + " ");
        }
        System.out.print("\n");

        // 리스트 순회 2
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.print(next+" ");
        }
        System.out.print("\n");


        /** Arrays.stream을 통한 배열->Stream변환
         * Stream.of 를 통한 배열 -> Stream변환
         */
        String[] strArr = new String[] {"a","b","c","d"};
//        Stream<String> strStream = Stream.of(strArr);
        Stream<String> strStream = Stream.of(new String[] {"a","b","c","d"});
        Stream<String> strStream1 = Arrays.stream(strArr);
        strStream.forEach(System.out::print);
        System.out.println();

        // 기본형 int 배열을 stream으로 변환(Integer Stream보다 속도 향상되고 다양한 메서드를 지원한다.)
        int [] intArr = {1,2,3,4,5};
        IntStream intStream1 = Arrays.stream(intArr);
        intStream1.forEach(System.out::print);
        //System.out.println("count="+intStream1.count()); // stream최종연산은 한번 사용하면 다시 사용못하므로 주석
        //System.out.println("sum="+intStream1.sum());
        //System.out.println("average="+intStream1.average());

        System.out.println();
        // 래퍼타입 Integer 배열을 stream으로 변환 (count함수만 제공)1
        Integer[] intArr2 = {1,2,3,4,5};
        Stream<Integer> intStream2 = Arrays.stream(intArr2);
        //System.out.println("count="+intStream2.count());
    }
}
