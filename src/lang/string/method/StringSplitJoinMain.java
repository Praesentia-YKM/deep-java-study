package lang.string.method;

public class StringSplitJoinMain {

    public static void main(String[] args) {
        String str = "Apple,Banana,Orange";


//        String 객체는 문자의 시퀀스를 저장하는 클래스입니다.
//        내부적으로 char[] 배열을 사용하여 각 문자를 저장하며, 다양한 문자열 조작 메서드를 제공합니다.
//        예를 들어, String str = "Hello";는 "Hello"라는 문자열을 나타내는 하나의 String 객체입니다.
//        String[] (문자열 객체의 배열):
//
//        String[]는 여러 개의 String 객체를 저장하는 배열입니다. 즉, 각 배열 요소가 String 객체입니다.
//        예를 들어, String[] words = {"Hello", "World", "Java"};는
//        "Hello", "World", "Java"라는 세 개의 String 객체를 요소로 가지는 배열입니다.

        // split()
        String[] splitStr = str.split(",");
        for (String s : splitStr) {
            System.out.println(s);
        }

        // join()
        // 스태틱 메서드라 객체 호출 없이 부를 수 있음
        // 정적 메서드는 클래스 로더에 의해 클래스가 메모리에 로드될 때 생성되며,
        // 인스턴스화되지 않아도 호출할 수 있습니다.
        String joinedStr = String.join("-", "A", "B", "C");
        System.out.println("연결된 문자열 = " + joinedStr);

        // 문자열 배열 연결
        //join() 메서드는 Java 8부터 추가된 메서드로,
        // 주어진 구분자(delimiter)와 문자열 배열 또는 CharSequence 요소들을 사용하여
        // 하나의 문자열로 결합합니다.
        String result = String.join("", splitStr);
        System.out.println("result = " + result);

        // 굳이 concat으로 이어붙이려면 이렇게 되어야함...
        String result2 = "";
        for (String s : splitStr) {
            result2 = result2.concat(s);
        }
        System.out.println("result2 = " + result2);
    }
}
