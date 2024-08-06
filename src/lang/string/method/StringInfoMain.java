package lang.string.method;

/**
 *  * 문자열 정보 조회
 *  * length() : 문자열의 길이를 반환한다.
 *  * isEmpty() : 문자열이 비어 있는지 확인한다. (길이가 0)
 *  * isBlank() : 문자열이 비어 있는지 확인한다. (길이가 0이거나 공백(Whitespace)만 있는 경우), 자바 11
 *  * charAt(int index) : 지정된 인덱스에 있는 문자를 반환한다.
 */
public class StringInfoMain {

    public static void main(String[] args) {
        String str = "Hello, Java!";
        System.out.println("문자열의 길이: " + str.length());
        System.out.println("문자열이 비어 있는지: " + str.isEmpty());
        System.out.println("isEmpty는 공백이 차있어도 빈 문자열이 아니다." + "     ".isEmpty());
        System.out.println("문자열이 비어 있거나 공백인지1: " + str.isBlank());
        System.out.println("isBlank는 공백이 차있어도 빈 문자열이다. " + "     ".isBlank());

        // charAt : 제일 앞이 0번째고 띄어쓰기도 한칸을 차지한다.
        char c = str.charAt(7);
        System.out.println("7번 인덱스의 문자 = " + c);
    }
}
