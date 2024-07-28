package exception.basic.unchecked;

public class UncheckedThrowMain {
    public static void main(String[] args) {
        Service service = new Service();
        //service.callThrow(); -> 최종 main에서 예외를 안 처리하면 터져버림

        try {
            service.callThrow();
        } catch (RuntimeException e) {
            System.out.println("잡았다~");
            System.out.println(e.getMessage());
        }

        System.out.println("정상 종료");
    }
}
