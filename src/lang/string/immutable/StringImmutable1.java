package lang.string.immutable;

public class StringImmutable1 {
    /**
     * String은 불변 객체이므로 가공을 하는 함수들에 보통 새로운 string객체를 리턴하는 식으로 구현되어있다.(ex. concat)
     *
     * 왜 불변일까?
     * String내부 값을 변경할 수 있으면 문자열 풀에서 같은 문자를 참조하고 있는 변수의 모든 문자가 함께
     * 변경되는 문제가 발생할 수 있음
     *
     * 결국 참조형 변수는 그 값을 참조하고 있는 모든 값이 바뀔 수 있다는 염려를 생각해야한다.
     */
    public static void main(String[] args) {
        // String 의 필드는 final 이라서 최초 객체 생성 시점에 정해진 문자열은 절대 변하지 않는다.
        String str = "hello";
        str.concat(" java"); // 따라서 concat함수 자체는 return 값이 있어서 그 return을 받아서 처리해야한다.
        // str = str.concat(" java"); // 이건 참조값을 재할당하는거라 됨
        System.out.println("str = " + str);
    }
}
