package lang.wrapper;

// 레퍼 클래스를 만들어보자~
public class MyInteger {

    private final int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // 내 값과 넘어온 값을 비교하기
    public int compareTo(int target) {
        if (value < target) {
            return -1;
        } else if (value > target) {
            return 1;
        } else {
            return 0;
        }
    }

    // sout을 하면 자바가 그 객체를 문자열로 표현하기 위해 toString을 자동으로 호출함
    // 따라서 오버라이딩 해줘야함(기본 : 클래스정보 해쉬코드로 표현)
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
