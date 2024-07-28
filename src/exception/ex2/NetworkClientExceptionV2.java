package exception.ex2;

public class NetworkClientExceptionV2 extends Exception {

    private String errorCode;

    public NetworkClientExceptionV2(String errorCode, String message) {
        super(message); // 이거떄매 throwable에 message가 쌓여있음 그래서 getMessage가능
        // Exception 의 생성자에 message setting하고 그 Exception에서 thrwoable에 던짐
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
