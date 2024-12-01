package collection.set;

import java.util.Arrays;

public class MyHashSetV0 {

    private int[] elementData = new int[10]; // 배열에 요소 저장
    private int size = 0;

    // O(n)
    public boolean add(int value) { // 잘 값이 들어갔는지 boolean으로 판단
        if (contains(value)) { // -> 이 contains 때문에 O(n)
            return false;
        }
        elementData[size] = value;
        size++;
        return true;
    }

    // O(n)
    public boolean contains(int value) { // 배열 순회하면서 값이 있는지 없는지 판단
        for (int data : elementData) {
            if (data == value) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV0{" +
                "elementData=" + Arrays.toString(Arrays.copyOf(elementData, size)) +
                ", size=" + size +
                '}';
    }

}