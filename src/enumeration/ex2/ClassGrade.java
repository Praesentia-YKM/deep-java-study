package enumeration.ex2;

/** static으로 선언된 변수와 메서드는 **메서드 영역(Method Area)**에 저장됩니다. 
 * 따라서 변수던 메서드던 클래스명. 쩜 으로 접근 가능해지는 것
 */
public class ClassGrade {
    // 메서드 영역에 변수를 선언해두고 주소값을 할당한다.
    // -> 자바 코드에서 자기 자신의 클래스를 타입으로 가지며 new 키워드를 사용하여 인스턴스를 생성하는 것은
    // 클래스의 인스턴스를 제한적으로 관리할 때 사용
    // ClassGrade라는 타입은 ClassGrade 클래스에 정의된 속성(필드)과 메서드를 사용할 수 있음을 의미
    public static final ClassGrade BASIC = new ClassGrade();
    public static final ClassGrade GOLD = new ClassGrade();
    public static final ClassGrade DIAMOND = new ClassGrade();

    //private 생성자로 둬서 외부에서 상수말고 다른 객체를 만들 수 없게 함
    private ClassGrade() {};

}
