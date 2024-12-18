package collection.compare;

import java.util.Arrays;

/**
 * Arrays.sort를 통한 배여 ㄹ정렬
 */
public class SortMain1 {

    public static void main(String[] args) {
        Integer[] array = {3, 2, 1};
        System.out.println(Arrays.toString(array));

        System.out.println("기본 정렬 후");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}