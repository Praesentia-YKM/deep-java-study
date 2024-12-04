package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain3 {

    public static void main(String[] args) {
        //중복 등록 안됨
        MyHashSetV2 set = new MyHashSetV2(10);
        Member m1 = new Member("A");
        Member m2 = new Member("A");
        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());
        System.out.println("m1.equals(m2) = " + m1.equals(m2));

        set.add(m1);
        set.add(m2);
        System.out.println(set);

        //검색 성공
        Member searchValue = new Member("A");
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
        boolean contains = set.contains(searchValue);
        System.out.println("contains = " + contains);

        // 값을 기반으로 해쉬코드를 생성할 수 있게 된다. 오버라이딩을 함으로써
        System.out.println("\"Aa\".hashCode() = " + "Aa".hashCode());
        System.out.println("\"Aa\".hashCode() = " + new String("Aa").hashCode());
        System.out.println("\"BB\".hashCode() = " + "BB".hashCode());
    }
}