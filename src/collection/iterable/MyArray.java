package collection.iterable;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArray implements Iterable<Integer> {

    private int[] numbers;

    public MyArray(int[] numbers) {
        this.numbers = numbers;
    }

    // 나는 반복가능한 놈이야. 반복가능하다는 건 반복자를 반환한다는 뜻!!
    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator(numbers);
    }

}