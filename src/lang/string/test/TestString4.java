package lang.string.test;

public class TestString4 {

    // 자바 substring ( start, end) 는 start는 0부터 시작, end는 뒤에서 하나 뺀거까지
    public static void main(String[] args) {
        String str = "hello.txt";
        String filename = str.substring(0, 5);
        String be = str.substring(5);
        String extName = str.substring(5, 9);
        System.out.println("filename = " + filename);
        System.out.println("extName = " + extName);
        System.out.println("begin = " +  be);
    }
}
