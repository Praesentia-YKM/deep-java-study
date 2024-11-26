package generic.ex5;

/**
 * eraser방식으로 인하여 instance에 대한 제네릭은 사용할 수없다
 * @param <T>
 */
public class EraserBox<T> {

    public boolean instanceCheck(Object param) {
        //return param instanceof T;
        // 자바 이레이저 법칙으로 인하여 제네릭은 컴파일시점에만 타입이 존재하고 .class에서는 T를 다 Object로 치환하므로
        // 항상 참이다.
        return true;
    }

    public void create() {
        //return new T();
        // 항상 new Object는 의도한 사항이 아닐것이라 그렇다.
    }
}
