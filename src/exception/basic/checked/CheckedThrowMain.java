package exception.basic.checked;

/**
 * 체크 예외는 (Excpetion 상속, 런타임제외) try catch로 잡아서 처리하거나,
 * throws를 메서드 옆에 지정해서 예외를 밖으로 던진다는 선언을 필수로 해줘야함
 *
 * 체크예외 장점 ; 개발자가 실수로 예외를 누락하지 않도록 컴파일러를 통해 문제를 잡아주는 안전장치
 * 단점 : 크게 신경쓰고 싶지 않은 예외까지 모두 챙겨야한다.
 *
 */
public class CheckedThrowMain {

    public static void main(String[] args) throws MyCheckedException {
        Service service = new Service();
        service.catchThrow(); // 짬맞은 예외폭탄을 이 메서드에서 처리할 수 있어야함
        System.out.println("정상 종료");

        // 만약, 예외가 main밖으로 던져지면 stackTrace에러 문구가 발생함 메시지와 함께.
        // 그리고 예외가발생한 경로까지 보여줌(ex-> 1에서 던져서 2에서 던져서 3(main)에서 터짐
    }
}
