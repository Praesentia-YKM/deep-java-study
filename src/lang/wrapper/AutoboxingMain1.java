package lang.wrapper;
// wrapper : 세팅할때`~ valueOf(박싱), 꺼낼때 xxxValue(언박싱)
// 오토도 있음
public class AutoboxingMain1 {

    public static void main(String[] args) {
        // Primitive -> Wrapper (박싱을 수동으로 하는 것)
        int value = 7;
        Integer boxedValue = Integer.valueOf(value);

        // Wrapper -> Primitive (언박싱을 수동으로 하는 것)
        int unboxedValue = boxedValue.intValue();

        System.out.println("boxedValue = " + boxedValue);
        System.out.println("unboxedValue = " + unboxedValue);
    }
}
