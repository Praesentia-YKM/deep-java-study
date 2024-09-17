package enumeration.ref3;

import static enumeration.ref3.Grade.*;

/** private 생성자를 만듬으로서 클래스 상수 외 나머지 객체는 생성 못하도록 처리 */
public class EnumRefMain3_2 {
    public static void main(String[] args) {
        int price = 10000;

        // Grade.values()를 사용하여 Grade 열거형의 모든 상수를 배열로 구할 수 있다.
        Grade[] grades = Grade.values();
        for(Grade grade : grades) {
            printDiscount(grade, price);
        }
    }

    private static void printDiscount(Grade grade, int price) {
        System.out.println(grade.name() + "등급의 할인 금액: " + grade.discount(price));
    }
}
