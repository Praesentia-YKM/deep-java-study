package lang.string.equals;

/**
 * 문자열 비교는 항상 동일성이아닌 동등성 비교를 해줘야한다.
 */
public class StringEqualsMain2 {

    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println("메서드 호출 비교1: " + isSame(str1, str2));

        String str3 = "hello";
        String str4 = "hello";
        System.out.println("메서드 호출 비교2: " + isSame(str3, str4));
    }

    private static boolean isSame(String x, String y) {
        //return x == y;
        // --> x==y로하면 개발자마다 new String으로 할지 리터럴 변수로 바로 넣은 걸 쓸지 알 수가 없어 결고가 달라질 수 있음
        return x.equals(y);
    }
}
