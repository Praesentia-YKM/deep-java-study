package lang.wrapper;
/** 오토박싱과 오토언박싱은 컴파일러가 개발자 대신 valueOf, xxxVlue()등
 * 코드를 추가해주는 기능이라고 보면 된다. */
public class AutoboxingMain2 {

    public static void main(String[] args) {
        // Primitive -> Wrapper : 오토오토~
        int value = 7;
        Integer boxedValue = value; // 오토 박싱(Auto-boxing)

        // Wrapper -> Primitive : 오토오토~
        int unboxedValue = boxedValue; // 오토 언박싱(Auto-Unboxing)

        System.out.println("boxedValue = " + boxedValue);
        System.out.println("unboxedValue = " + unboxedValue);
    }
}
