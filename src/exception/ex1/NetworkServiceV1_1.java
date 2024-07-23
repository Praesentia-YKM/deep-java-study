package exception.ex1;

public class NetworkServiceV1_1 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data); //추가

        client.connect();
        client.send(data);
        client.disconnect();
        
        // 연결이 실패하면 데이터를 전송하지 않아야하는데 데이터를 전송하고 있는 문제 해결 필요
        // 오류가 발생했을 때 어떤 오류가 발생했는지 자세한 내역을 남기면 이후 디버깅에 도움이 됨. 오류로그를 남겨야 함
    }
}
