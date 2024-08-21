package enumeration.ex2;

public class DiscountService {
    public int discount(ClassGrade classGrade, int price) {
        int discountPercent = 0;

        // 기존에 정의된 상수 주소값과 같은 놈이라면~
        if(classGrade == ClassGrade.BASIC) {
            discountPercent = 10;
        } else if(classGrade == ClassGrade.GOLD) {
            discountPercent = 20;
        } else if(classGrade == ClassGrade.DIAMOND) {
            discountPercent = 30;
        } else {
            System.out.println("할인X");
        }

        return price * discountPercent / 100;
    }
}
