package enumeration.ref1;

public class ClassGradeRefMain1 {
    public static void main(String[] args) {
        int price = 10000;

        // 상수에 객체의 참조값을 넣어뒀기 때문에 정해진 상수값만 쓸 수 있다.
        DiscountService discountService = new DiscountService();
        int basic = discountService.discount(ClassGrade.BASIC, price);
        int gold = discountService.discount(ClassGrade.GOLD, price);
        int diamond = discountService.discount(ClassGrade.DIAMOND, price);

        System.out.println("BASIC 등급의 할인 금액 : " + basic);
        System.out.println("GOLD 등급의 할인 금액 : " + gold);
        System.out.println("DIAMOND 등급의 할인 금액 : " + diamond);
    }
}
