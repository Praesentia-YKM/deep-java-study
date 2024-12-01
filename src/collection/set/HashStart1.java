package collection.set;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class HashStart1 {

    public static void main(String[] args) throws Exception {
        Integer[] inputArray = new Integer[4];
        inputArray[0] = 1;
        inputArray[1] = 2;
        inputArray[2] = 5;
        inputArray[3] = 8;
        System.out.println("inputArray = " + Arrays.toString(inputArray));

        int searchValue = 8;
        //4번 반복 O(n)
        for (int inputValue : inputArray) {
            if (inputValue == searchValue) {
                System.out.println(inputValue);
            }
        }
    }
}