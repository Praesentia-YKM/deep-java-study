package nested.inner;

public class InnerOuterMain {
    public static void main(String[] args) {
        InnerOuter outer = new InnerOuter();

        // inner클래스의 인스턴스 생성 -> 무조건 outer 객체가 있어야 생성가능 (outer를 통해서 inner를 생성하는거라서)
        InnerOuter.Inner inner = outer.new Inner();
        inner.print();

        System.out.println("innerCClass = " + inner.getClass());
    }
}
