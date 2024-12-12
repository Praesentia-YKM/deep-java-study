package homework.week2.kwonmo;

public class StringEqualsTest {
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
        // --> x==y로하면 개발자마다 new String으로 할냐 리터럴 변수로 하냐에 따라 결과가 달라질 수 있음
        return x.equals(y);
    }
}
