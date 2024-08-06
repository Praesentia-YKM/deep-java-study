package lang.string.method;

/**
 * 문자열 검색
 * contains(CharSequence s) : 문자열이 특정 문자열을 포함하고 있는지 확인한다.
 * indexOf(String ch) / indexOf(String ch, int fromIndex) : 문자열이 처음 등장하는 위치를
 * 반환한다.
 * lastIndexOf(String ch) : 문자열이 마지막으로 등장하는 위치를 반환한다.
 */
public class StringSearchMain {

    public static void main(String[] args) {
        String str = "Hello, Java! Welcome to Java world.";

        for (int i = 0; i < str.length(); i++) {
            System.out.println("Character '" + str.charAt(i) + "' is at index: " + i);
        }

        System.out.println("================예시 시작 ================");
        System.out.println("문자열에 'Java'가 포함되어 있는지: " + str.contains("Java"));
        System.out.println("'Java'의 첫 번재 인덱스: " + str.indexOf("Java")); // J가 시작하는 첫인덱스가 나옴
        System.out.println("인덱스 10부터 'Java'의 인덱스: " + str.indexOf("Java", 10)); // 10부터 J가 시작하는 첫인덱스가 나옴
        System.out.println("'Java'의 마지막 인덱스: " + str.lastIndexOf("Java"));
    }
}
