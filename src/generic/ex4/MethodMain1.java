package generic.ex4;

public class MethodMain1 {

    /**
     * 제네릭 메서드에 타입을 클라이언트 딴에서 지정하는 방식은 2가지이다.
     *
     * 명시적 : 객체.<타입>메서드명(인자) 형식으로 지정
     * 암시적 : 객체.메서드명(인자) -> 인자를 기준으로 타입 추론
     * @param args
     */
    public static void main(String[] args) {
        Integer i = 10;
        Object object = GenericMethod.objMethod(i);

        // 타입 인자(Type Argument) 명시적 전달
        System.out.println("명시적 타입 인자 전달");
        Integer result = GenericMethod.<Integer>genericMethod(i);
        Integer integerValue = GenericMethod.<Integer>numberMethod(10);
        Double doubleValue = GenericMethod.<Double>numberMethod(20.0);

        //타입 추론, 타입 인자 생략
        System.out.println("타입 추론");
        Integer result2 = GenericMethod.genericMethod(i);
        Integer integerValue2 = GenericMethod.numberMethod(10);
        Double doubleValue2 = GenericMethod.numberMethod(20.0);
    }
}