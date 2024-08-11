package lang.string.chaining;

public class ValueAdder {

    private int value;

    // 자기자신의 참조값을 반환하니까 계속 참조가 가능해서 체이닝이 가능
    public ValueAdder add(int addValue) {
        value += addValue;
        return this;
    }

    public int getValue() {
        return value;
    }
}
