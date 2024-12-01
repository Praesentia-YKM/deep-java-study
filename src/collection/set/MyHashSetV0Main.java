package collection.set;

public class MyHashSetV0Main {

    public static void main(String[] args) {
        MyHashSetV0 set = new MyHashSetV0();

        // todo 데이터를 add할때마다 중복이 있는지 항상 풀스캔 돌아서 성능상 추가가 불리하다 이점이 개선필요하다! -> hash
        set.add(1); // O(1)
        set.add(2); // O(n)
        set.add(3); // O(n)
        set.add(4); // O(n)
        System.out.println(set);
        // System.out.println() 메서드는 모든 객체를 출력할 때 해당 객체의 toString() 메서드를 호출하여
        // 문자열로 변환한 후 출력합니다.

        boolean result = set.add(4);//중복 데이터 저장
        System.out.println("중복 데이터 저장 결과 = " + result);
        System.out.println(set);
        
        System.out.println("set.contains(3): " + set.contains(3)); // O(n)
        System.out.println("set.contains(99): " + set.contains(99)); // O(n)
        System.out.println(set.toString());
    }
}