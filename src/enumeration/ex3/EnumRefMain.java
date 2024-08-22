package enumeration.ex3;

public class EnumRefMain {
    public static void main(String[] args) {
        System.out.println("class BASIC = " + Grade.BASIC.getClass());
        System.out.println("class GOLD = " + Grade.GOLD.getClass());
        System.out.println("class DIAMOND = " + Grade.DIAMOND.getClass());

        // 각각의 인스턴스가 서로 다르다.
        System.out.println("ref BASIC = " + refValue(Grade.BASIC));
        System.out.println("ref GOLD = " + refValue(Grade.GOLD));
        System.out.println("ref DIAMOND = " + refValue(Grade.DIAMOND));

    }

    // static 메서드로 정의한 이유는 객체의 상태(= 멤버변수)와 관련이 없는 순수하게 전달된 인자에
    // 대해서만 작업을 수행한다는 의미를 지닌다.
    // 또한 외부에서는 클래스명. 을 통해 접근할 수 없다.(인스턴스와의 무관함)
    private static String refValue(Object grade) {
        // 자바가 관리하는 객체의 참조값을 숫자로 반환함
        return Integer.toHexString(System.identityHashCode(grade));
    }
}
