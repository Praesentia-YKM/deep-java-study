package nested;
// static 중첩클래스는 인스턴스 영역에서 생성되는게 아니고 클래스(static) 영역에서 생성되므로 바깥의 멤버변수를
// 참조할 수 없다.
/**
 * 정적 중첩 클래스는 앞에 static 이 붙는다.
 * 정적 중첩 클래스는 자신의 멤버에는 당연히 접근할 수 있다.
 * 바깥 클래스의 인스턴스 멤버에는 접근할 수 없다.
 *
 * 바깥 클래스의 클래스(static) 멤버에는 접근할 수 있다.
 */
public class NestedOuter {
    private static int outClassValue = 3;
    private int outInstanceValue = 2;

    static class Nested {
        private int nestedInstanceValue = 1;
        public void print() {
            // 자신의 멤버에 접근
            System.out.println(nestedInstanceValue);
            // 바깥 클래스의 인스턴스 멤버에는 접근할 수 없다.
            //System.out.println(outInstanceValue);
            // 바깥 클래스의 클래스(static) 멤버에는 접근할 수 있다. private도 접근 가능
            System.out.println(NestedOuter.outClassValue);
        }
    }
}

