package generic.ex4;

/**
 * 제네릭 메서드!!
 *
 * 클래스에 <T> 붙이는건 제네릭 타입이고 이건 메서드 단위로 붙이는 제네릭 메서드다/
 */
public class GenericMethod {

    public static Object objMethod(Object obj) {
        System.out.println("object print: " + obj);
        return obj;
    }

    public static <T> T genericMethod(T t) {
        System.out.println("generic print: " + t);
        return t;
    }

    public static <T extends Number> T numberMethod(T t) {
        System.out.println("bound print: " + t);
        return t;
    }
}