package enumeration.ex3;

import static enumeration.ex3.Grade.*; // static import 를 통해서 Grade.BASIC 에서 생략 가능함

public class DiscountService {
    public int discount(Grade classGrade, int price) {
        int discountPercent = 0;

        // enum 상수 주소값과 같은 놈이라면~
        if(classGrade == BASIC) {
            discountPercent = 10;
        } else if(classGrade == GOLD) {
            discountPercent = 20;
        } else if(classGrade == DIAMOND) {
            discountPercent = 30;
        } else {
            System.out.println("할인X");
        }

        return price * discountPercent / 100;
    }
}
