package nested;

/**
 * 바깥 클래스.안쪽클래스명 으로 접근가능(getClass찍어보면 자바에서는 안쪽클래스는 $로 표기해줌)
 * 인스턴스와는 아예 관련이 없기 때문에 바깥 클래스와 독립적인 객체 생성이 가능하다.
 */
public class NestedOuterMain {
    public static void main(String[] args) {
        //NestedOuter outer = new NestedOuter();
        NestedOuter.Nested nested = new NestedOuter.Nested();
        nested.print(); // 내가 가진 메서드 호출
        System.out.println("nestedClass = " + nested.getClass());
    }
}
