package exception.basic.checked;

public class Service {
    Client client = new Client();

    /**
     * 예외를 잡아서 처리하는 코드
     */
    public void callCatch() {
        try {
            client.call();
            // 이 메서드에서 발생하지 않는 예외를 잡고있으면 컴파일 에러가 뜸
            // call에서는 MyCheckedException만을 던지고 있음!
        } catch (MyCheckedException e) {
            //예외 처리 로직 -> 폭탄 잡기
            // catch는 해당 예외의 부모클래스로도 잡을 수 있다.(부모는 자식을 담을 수 있다)
            // getMessage(Throwable의 cause 메시지)로 에러 메시지 꺼낼 수 있음
            System.out.println("예외 처리, message=" + e.getMessage());

            // return;
            // -> return을 하지 않는 이상 catch를 했으니까 정상 구문으로 판단되어 아래 sysout 정상흐름을
            // 출력하게됨. 즉, 에러가 발생했음에도 다음 로직이 실행됨
        }
        System.out.println("정상 흐름");
    }

    /**
     * 체크 예외를 밖으로 던지는 코드
     * 체크 예외는 예외를 잡지 않고 밖으로 던지려면 throws 예외를 메서드에 필수로 선언해야 한다.
     */
    public void catchThrow() throws MyCheckedException {
        client.call();
    }

}
