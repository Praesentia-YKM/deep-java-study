package collection.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImmutableMain {

    public static void main(String[] args) {
        //불변 리스트 생성
        List<Integer> list = List.of(1, 2, 3);

        //가변 리스트
        ArrayList<Integer> mutableList = new ArrayList<>(list);
        mutableList.add(4);
        System.out.println("mutableList = " + mutableList);
        System.out.println("mutableList class = " + mutableList.getClass());

        //불변 리스트 전환
        List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList);
        System.out.println("unmodifiableList class = " + unmodifiableList.getClass());

        //예외 발생 java.lang.UnsupportedOperationException
        // unmodifiableList.add(5);

         Set<String> set = Set.of("A", "B", "C");
         // set.add("D"); // UnsupportedOperationException

         Set<String> originalSet = new HashSet<>();
         originalSet.add("A");
         Set<String> unmodifiableSet = Collections.unmodifiableSet(originalSet);
         // 원본 set 수정 가능
         originalSet.add("B");
         // unmodifiableSet은 여전히 불변이므로 수정 불가
         // unmodifiableSet.add("C"); // UnsupportedOperationException

    }
}