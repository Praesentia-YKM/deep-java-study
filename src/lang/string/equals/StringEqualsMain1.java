package lang.string.equals;

public class StringEqualsMain1 {

    public static void main(String[] args) {
        String str1 = new String("hello"); //x001
        String str2 = new String("hello"); //x002
        System.out.println("new String() == 비교: " + (str1 == str2)); // 동일성
        System.out.println("new String() equals 비교:" + (str1.equals(str2))); // 동등성

        // 문자열 최적화를 위해 자바에서 문자열 풀이라는 것을 제공(메모리 최적화 및 문자 생성시간 줄여줌)
        // new를 안쓰면 문자열 풀에 바로 String값을 넣어버린다.
        // -> 풀 안서 hello라는 값을 찾고(해쉬알고리즘사용해서 빠름) 이걸 계속 참조
        // 프로그래밍에서  Pool이란 말은 공용 자원을 모아둔 곳이라는 것을 의미한다. 재사용 개념, 힙영역 사용
        String str3 = "hello"; //x003
        String str4 = "hello"; //x004
        System.out.println("리터럴 == 비교: " + (str3 == str4));
        System.out.println("리터럴 equals 비교: " + (str3.equals(str4)));
    }
}
