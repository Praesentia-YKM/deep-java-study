package exception.basic.unchecked;

/**
 * 언체크 예외를 발생시키는 클라이언트
 * -> 메서드에 throws MyUncheckedException 라고 작성 안해줘도 알아서 던짐(생략가능)
 */
public class Client {
    public void call() {
        throw new MyUncheckedException("ex");
    }
}
