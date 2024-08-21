package enumeration.ex2;
/** private 생성자를 만듬으로서 클래스 상수 외 나머지 객체는 생성 못하도록 처리 */
public class ClassGradeEx2_2 {
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();

        /* private 생성자를 만들지 않았을때의 문제 */
        /* 매개변수가 ClassGrade타입이라고해서 바로new해서 넣어버리면 할인에 포함되는 객체가 아니라서 할인적용 안됨 */
//        ClassGrade newClassGrade = new ClassGrade();
//        int failedResult = discountService.discount(newClassGrade, price);
//
//        System.out.println("newClassGrade의 할인금액 : " + failedResult);

        
    }
}
