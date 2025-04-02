package youtube_lamda.lamda;

public class ex0 {
    public static void main(String[] args) {
        // 람다식은 이렇게 객체지만 참조를 반환할 수 없다. 이를 위해 함수형 인터페이스로 다뤄야한다.
        // Object obj1 = (a,b) -> a > b ? a:b;


        // 람다식은 실제로 이렇게 생긴 익명 객체다. (자바에서 메서드는 객체에 감싸져야 하기 때문에 익명클래스로 감싸져있다)
        Object obj = new Object() {
            int max(int a, int b) {
                return a > b ? a : b;
            }
        };
        //int value = obj.max(3,5); // 하지만 실제 obj에는 max라는 메서드가 들어있는게 아니라서 호출 불가능하다.
        // -> 함수형 인터페이스를 통하여 해결할 수 있따.

        // 함수형 인터페이스 X, 단순 익명클래스를 통하여 메서드 세팅하기
        myInterface ex1 = new myInterface() {
            @Override
            public void fly() {
                System.out.println("날아올라~");
            }

            @Override
            public void eat() {
                System.out.println("밥 먹자~");
            }
        };

        ex1.fly();
        ex1.eat();

        // 함수형 인터페이스는 람다로 구현이 가능하므로 굳이 이렇게 익명클래스처럼 사용 안해도됨
        functionalInter f1 = new functionalInter() {
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        // 람다로 구현(= 동적으로 인터페이스를 구현할 수 있는 간단한 방법을 제공한다. 원래는 익명클래스로
        // 오버라이딩하여 사용해야하는데 ㅇㅇ;)
        functionalInter f2 = ( a,  b) -> a > b ? a : b;

        int value1 = f1.max(3,5);
        int value2 = f2.max(3,5);
        System.out.println("value1 = " + value1);
        System.out.println("value2 = " + value2);
    }
}
