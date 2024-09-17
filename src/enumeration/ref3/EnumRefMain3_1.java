package enumeration.ref3;

/** private 생성자를 만듬으로서 클래스 상수 외 나머지 객체는 생성 못하도록 처리 */
public class EnumRefMain3_1 {
    public static void main(String[] args) {
        int price = 10000;

        // 상수에 객체의 참조값을 넣어뒀기 때문에 정해진 상수값만 쓸 수 있다.
        DiscountService discountService = new DiscountService();
        int basic = discountService.discount(Grade.BASIC, price);
        int gold = discountService.discount(Grade.GOLD, price);
        int diamond = discountService.discount(Grade.DIAMOND, price);

        System.out.println("BASIC 등급의 할인 금액 : " + basic);
        System.out.println("GOLD 등급의 할인 금액 : " + gold);
        System.out.println("DIAMOND 등급의 할인 금액 : " + diamond);
    }
}
