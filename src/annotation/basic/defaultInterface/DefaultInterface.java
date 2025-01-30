package annotation.basic.defaultInterface;

public interface DefaultInterface {

    String overridingMethod();

    // default 접근제어자와 default 키워드는 다름,
    // 우선 default 접근제어자는 명시적으로 선언못함 걍 생략 해야함
    // 그리고 인터페이스는 모두 public 임...
    // 그래서 회사에서 인터페이스에 public은 안 다는게 맞다고 생각
    default void print() {
        System.out.println("Hello World");
    }

}
