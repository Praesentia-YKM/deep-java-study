package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain1 {

    public static void main(String[] args) {
        //중복 등록
        MyHashSetV2 set = new MyHashSetV2(10);
        MemberNoHashNoEq m1 = new MemberNoHashNoEq("A");
        MemberNoHashNoEq m2 = new MemberNoHashNoEq("A");
        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());
        System.out.println("m1.equals(m2) = " + m1.equals(m2));

        set.add(m1);
        set.add(m2);
        System.out.println(set);

        //검색 실패
        MemberNoHashNoEq searchValue = new MemberNoHashNoEq("A");
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
        boolean contains = set.contains(searchValue);
        System.out.println("contains = " + contains);

        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html#hashCode()
//        System.out.println("hashCode: " + m1.hashCode());
//        System.out.println("identityHashCode: " + System.identityHashCode(m1)); // 메모리 기반 해시코드

        // 둘다 같은 A를 담은 멤버인데 해쉬코드가 달라져버린다.
        System.out.println("\"A\".hashCode() = " + m1.hashCode());
        System.out.println("\"A\".hashCode() = " + new MemberNoHashNoEq("A").hashCode());
    }
}