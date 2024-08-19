package enumeration.ex1;

/**
 * 문자열 상수를 변수화해서 사용해도, 개발자가 다른 값(없는 등급) 을 넣는 것을 제어할 수는 없다.
 * 즉, 완벽한 해결을 못함
 */
public class StringGradeEx1_2 {
    public static void main(String[] args) {
        int price = 10000;
        DiscountService discountService = new DiscountService();
        
        // 존재하지 않는 등급
        int vip = discountService.discount("VIP", price);
        System.out.println("VIP 등급의 할인 금액: " + vip);
        
        // 오타
        int diamondd = discountService.discount("DIAMONDD", price);
        System.out.println("DIAMONDD 등급의 할인 금액: " + diamondd);
        
        // 소문자 입력
        int gold = discountService.discount("gold", price);
        System.out.println("gold 등급의 할인 금액: " + gold);
    }
}
