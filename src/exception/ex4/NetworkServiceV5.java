package exception.ex4;

public class NetworkServiceV5 {

    public void sendMessage(String data) {
        String address = "http://example.com";

        //NetworkClientV5이 자원은 try블럭이 끝나면 자동으로 AutoColseable.close() 를
        // 호출하여 자원을 해제한다.

        // try를 빠져나가는 순간 autoColable을 사용했으면
        // 사용하지 않았을때와 다르게 예외가 catch되더라도 일단 finally를 먼저 호출한다.
        try (NetworkClientV5 client = new NetworkClientV5(address)) {
            client.initError(data); //추가
            client.connect();
            client.send(data);
        } catch (Exception e) {
            System.out.println("[예외 확인]: " + e.getMessage());
            throw e;
        }
    }
}
