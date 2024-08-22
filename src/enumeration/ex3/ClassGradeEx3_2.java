package enumeration.ex3;

import enumeration.ex2.DiscountService;

/** private 생성자를 만듬으로서 클래스 상수 외 나머지 객체는 생성 못하도록 처리 */
public class ClassGradeEx3_2 {
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
//        Grade grade = new Grade(); // enum 타입은 생성자가 private 이라 더이상 객체를 만들 수 없다.

    }
}
