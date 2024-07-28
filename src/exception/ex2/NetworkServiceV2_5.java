package exception.ex2;

/**
 * try - catch - finally 구조는 정상흐름과 예외흐름을 분리해서 코드 가독성을 높힌다.
 * 사용한 자원을 항상 반환할 수 있도록 보장해준다.
 */
public class NetworkServiceV2_5 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data); //추가

        try {
            client.connect();
            client.send(data);
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        } finally {
            // 예외가 터지던 뭐가 됐든 무.조.건 호출되어야하는 흐름
            // 예외가 터졌어도 finally를 실행한 다음 예외가 밖으로 던져진다.
            client.disconnect();
        }

    }
}
