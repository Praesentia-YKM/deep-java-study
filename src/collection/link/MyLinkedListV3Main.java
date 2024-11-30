package collection.link;

/**
 * 링크드 리스트에 제네릭 적용
 */
public class MyLinkedListV3Main {
    public static void main(String[] args) {
        MyLinkedListV3<String> stringList = new MyLinkedListV3<>();

        MyLinkedListV3 badList = new MyLinkedListV3();
        MyLinkedListV3 badList2 = new MyLinkedListV3<>(); // 이것도 타입추론하라고 다이아몬드연산자 썻지만 실제로 raw type
        MyLinkedListV3<String> badList3 = new MyLinkedListV3<String>();// 타입추론 생략하자
        
        badList.add("a");
        badList.add(2); // 이렇게 타입안정성이 깨져버림...
//        Object a = (String)badList.get(0);
//        Object b = (String)badList.get(1);
//        System.out.println(badList.toString());
//        System.out.println(a);
//        System.out.println(b);

        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        System.out.println(stringList.toString());
        //stringList.add(2); 컴파일 에러
        String string = stringList.get(0);
        System.out.println("string = " + string);

        MyLinkedListV3<Integer> intList = new MyLinkedListV3<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Integer integer = intList.get(0);
        System.out.println("integer = " + integer);
    }

}