package exception.ex2;

/**
 * 하나의 try안에 정상흐름을 모두 담는다.
 * 예외부분은 catch에서 해결
 *
 * 이제 외부와 연결을 했으니 외부자원에 대한 반납처리만 신경써주면된다.
 * connect와 send에서 예외가 발생해버리면 disconnect가 호출이 안되기 때문.
 */
public class NetworkServiceV2_3 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data); //추가

        try {
            client.connect();
            client.send(data);
            client.disconnect();
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        }
    }
}
