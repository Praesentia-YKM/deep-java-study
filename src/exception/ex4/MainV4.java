package exception.ex4;

import exception.ex4.exception.SendExceptionV4;

import java.util.Scanner;

public class MainV4 {

    public static void main(String[] args) {
        //NetworkServiceV4 networkService = new NetworkServiceV4();
        NetworkServiceV5 networkService = new NetworkServiceV5();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("전송할 문자: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }

            try {
                networkService.sendMessage(input);
            } catch (Exception e) {
                // 공통으로 모든 exception을 잡는다.
                exceptionHandler(e);
            }
            System.out.println();
        }
        System.out.println("프로그램을 정상 종료합니다.");
    }

    //공통 예외 처리
    private static void exceptionHandler(Exception e) {
        //공통 처리
        System.out.println("사용자 메시지: 죄송합니다. 알 수 없는 문제가 발생했습니다.");
        System.out.println("==개발자용 디버깅 메시지==");
        e.printStackTrace(System.out); //스택 트레이스 출력
        //e.printStackTrace();  --> () 의 기본값 System.err [빨간색 글씨로 남는다]
        // 보통은 로그 라이브러리를 사용함 :Slf4j , logback

        //필요하면 예외 별로 별도의 추가 처리 가능
        if (e instanceof SendExceptionV4 sendEx) {
            // throw new ~ 로 예외를 넘기기 때문에 결국 넘어오는 Exception e 는 객체이다.
            // 다형성으로 e를 받고 구현체 클래스객체인지 여부에 대한 instanceof로 예외별 분기처리 가능
            System.out.println("[전송 오류] 전송 데이터: " + sendEx.getSendData());
        }
    }
}
