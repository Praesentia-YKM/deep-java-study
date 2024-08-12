package lang.wrapper;

// 기본형은 항상 값을 가져야한다. 하지만 때로는 데이터가 "없음" 이라는 값을
// 보여주고 싶을 때도 있을 수 있다.
public class MyIntegerNullMain0 {

    public static void main(String[] args) {
        int[] intArr = {-1, 0, 1, 2, 3};
        System.out.println(findValue(intArr, -1)); //-1
        System.out.println(findValue(intArr, 0));
        System.out.println(findValue(intArr, 1));
        System.out.println(findValue(intArr, 100)); //-1
    }

    private static int findValue(int[] intArr, int target) {
        for (int value : intArr) {
            if (value == target) {
                return value;
            }
        }
        return -1; // 못 찾았어~라는것도 결국 숫자로 표현을 해줘야한다. 메서드의 반환이 int라서..
    }
}
