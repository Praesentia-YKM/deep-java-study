package lang.string.method;

/**
 * 문자열 조작 및 변환
 * substring(int beginIndex) / substring(int beginIndex, int endIndex) : 문자열의 부분문자열을 반환한다.
 * concat(String str) : 문자열의 끝에 다른 문자열을 붙인다.
 * replace(CharSequence target, CharSequence replacement) : 특정 문자열을 새 문자열로 대체한다.
 * replaceAll(String regex, String replacement) : 문자열에서 정규 표현식과 일치하는 부분을 새문자열로 대체한다.
 * replaceFirst(String regex, String replacement) : 문자열에서 정규 표현식과 일치하는 첫 번째 부분을 새 문자열로 대체한다.
 * toLowerCase() / toUpperCase() : 문자열을 소문자나 대문자로 변환한다.
 * trim() : 문자열 양쪽 끝의 공백을 제거한다. 단순 Whitespace 만 제거할 수 있다.
 * strip() : Whitespace 와 유니코드 공백을 포함해서 제거한다. 자바 11
 */
public class StringChangeMain1 {

    public static void main(String[] args) {
        String str = "Hello, Java! Welcome to Java";

        System.out.println("인덱스 7부터의 부분 문자열: " + str.substring(7));
        System.out.println("인덱스 7부터 12까지의 부분 문자열: " + str.substring(7,12));

        System.out.println("문자열 결합: " + str.concat("!!!"));

        System.out.println("'Java'를 'World'로 대체: " + str.replace("Java", "World"));
        System.out.println("첫 번째 'Java'를 'World'로 대체: " + str.replaceFirst("Java", "World"));
    }
}
