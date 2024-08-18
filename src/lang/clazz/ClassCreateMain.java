package lang.clazz;

public class ClassCreateMain {
    public static void main(String[] args) throws Exception {
        //Class helloClass = Hello.class;
        Class helloClass = Class.forName("lang.clazz.Hello");

        // Hello클래스가 가진 생성자를 얻어서 객체를 생성한다.
        // getDeclaredConstructor를 통해서 동적으로 객체를 만들 수 있다.(클래스정보 받아오는 forName부분을 입력받으면 되니까)
        Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance();
        String result = hello.hello();
        System.out.println("result = " + result);
    }
}
