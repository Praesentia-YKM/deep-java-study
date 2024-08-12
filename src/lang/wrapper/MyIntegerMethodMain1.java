package lang.wrapper;
// 기본형을 감싸서 가공한 클래스 = 래퍼클래스
// 비교가 필요해? 그럼 내가 가지고 있는 compareTo를 써~
public class MyIntegerMethodMain1 {

    public static void main(String[] args) {
        MyInteger myInteger = new MyInteger(10);
        int i1 = myInteger.compareTo(5);
        int i2 = myInteger.compareTo(10);
        int i3 = myInteger.compareTo(20);
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
    }
}
