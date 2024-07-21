package lang.immutable.change;

public class MutableMain {

    public static void main(String[] args) {
        MutableObj obj = new MutableObj(10);
        obj.add(20);
        // -> 불변객체에서의 변경과 관련된 메서드들은 보통
        // 객체를 새로 생성하기 떄문에 반환객체값을 받아주는 처리를 해야함을 인지해야한다!
        //계산 이후의 기존 값은 사라짐
        System.out.println("obj = " + obj.getValue());
    }
}
