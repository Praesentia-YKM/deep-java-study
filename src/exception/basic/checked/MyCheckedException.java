package exception.basic.checked;

/**
 * Exception을 상속받은 예외는 체크 예외가 된다. -> 예외로 runtimeException을 상속받으면
 * 언체크 예외가 된다.
 *
 * Throwable클래스에 detailMessage라는 필드를 가지고 있다.
 */
public class MyCheckedException extends Exception {
    public MyCheckedException(String message) {
        super(message); // Exception 클래스에 메시지 담는 메서드가 있음
    }
}
