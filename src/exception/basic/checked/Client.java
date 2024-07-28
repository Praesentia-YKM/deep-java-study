package exception.basic.checked;

public class Client {
    public void call() throws MyCheckedException {
        //문제 상황
        throw new MyCheckedException("ex");
        // 예외를 터트린다(발생시킨다.) MyCheckedException ex = new MyCheckedException("ex");

        // 예외도 객체이기 때문에 new로 먼저 생성하고 예외를 발생시켜야한다.
        // throw : 예외를 발생시키는 것(폭탄을 터트리는 것)
        // throws : 발생시킨 예외를 메서드 밖으로 던질때 사용( 아 ~ 나 이거 해결 못해)
    }
}
