package enumeration.ref1;

/** static으로 선언된 변수와 메서드는 **메서드 영역(Method Area)**에 저장됩니다. 
 * 따라서 변수던 메서드던 클래스명. 쩜 으로 접근 가능해지는 것
 */
// 등급과 할인율의 분리.
// 결국 classgrade 가 만들어질때 할인율은 정해지는거니까 생성자로 관리하면 됨
public class ClassGrade {
    public static final ClassGrade BASIC = new ClassGrade(10);
    public static final ClassGrade GOLD = new ClassGrade(20);
    public static final ClassGrade DIAMOND = new ClassGrade(30);

    private final int discountPercent;

    //private 생성자로 둬서 외부에서 상수말고 다른 객체를 만들 수 없게 함
    private ClassGrade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

}
