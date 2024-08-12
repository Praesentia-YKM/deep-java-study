package lang.wrapper;

public class WrapperClassMain {
/**
 * 래퍼클래스를 만들때는 valueOf를 사용하자 (new 말고)
 * 모든 래퍼클래스는 toString을 재정의 해뒀다. 객체를 그대로 출력해도 내부의 값을 그대로 출력할 수 있도록!
 * */
    public static void main(String[] args) {
        // 자바의 Integer Pool : 미리 만들어둔 -128~127은 미리 만들어두고 그 값을 꺼내서 사용해서 최적화됨
        // 이래서 new Integer은 하지마~라고 권고하는것.
        Integer newInteger = new Integer(10); //미래에 삭제 예정, 대신에 valueOf()를 사용
        //Integer newInteger = Integer.valueOf(10); //미래에 삭제 예정, 대신에 valueOf()를 사용
        Integer integerObj = Integer.valueOf(10); //-128 ~ 127 자주 사용하는 숫자 값 재사용, 불변

        Long longObj = Long.valueOf(100);   // 100을 박스에 넣어서 Long으로 만듬 : 박싱
        Double doubleObj = Double.valueOf(10.5);

        System.out.println("newInteger = " + newInteger);
        System.out.println("integerObj = " + integerObj);
        System.out.println("longObj = " + longObj);
        System.out.println("doubleObj = " + doubleObj);

        // intValue를 통해서 값 꺼내기
        System.out.println("내부 값 읽기");
        int intValue = integerObj.intValue();   // 언박싱 (Integer의 값을 꺼내서 int로 만듬)
        System.out.println("intValue = " + intValue);
        long longValue = longObj.longValue();
        System.out.println("longValue = " + longValue);

        // == 을 통한 비교 : 주소값 비교 (이때 valueOf로 값을 뽑으면 캐싱된 애를 가져와서 참조값도 같게됨)
        // equals : 내부의 값을 가지고 비교
        System.out.println("비교");
        System.out.println("==: " + (newInteger == integerObj));
        System.out.println("equals: " + (newInteger.equals(integerObj)));
    }
}
