package collection.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmptyListMain {

    public static void main(String[] args) {
        // ArrayList<Integer> list1 = Arrays.asList(1,2,3); 이거 안됨!
        /**
         * 왜? Arrays.asList는 new ArrayList를 반환하는데 우리가 생각하는 ArrayList클래스가 아니다.
         * 동적이 나닌 정적으로 나누기 위해 Arrays클래스 안에서 private한 중첩클래스로 ArrayList를 선언해두었다.
         * 그 ArrayList 클래스타입은 외부에서 접근할 수 없는 타입이기 때문에 우리가 선언한 ArrayList와 안 맞아서 에러가 나는거다.
         *
         * 하지만 List로는 된다.
         * List<Integer> list1 = Arrays.asList(1,2,3);  따라서 이렇게 List로 두는 습관이 좋다.
         */

        List<Integer> list3 = Collections.emptyList();
        List<Integer> list4 = List.of();

        System.out.println("list3.getClass() = " + list3.getClass());
        System.out.println("list4.getClass() = " + list4.getClass());

        Integer[] arr = {1,2,3,4,5};
        List<Integer> list1 = Arrays.asList(arr);
        list1.set(0,100); // 0번쨰를 100으로 변환 . Arrays.asList는 변할 순 있고 정적임

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("ArrayList = " + list1);

        List<Integer> list2 = List.of(1,2,3);
        System.out.println("list2 = " + list2); // List.of는 불변 + 정적이라 변경 및 추가가 안된다!!!
        list2.set(0,100);
        System.out.println("list2 = " + list2);



    }
}
