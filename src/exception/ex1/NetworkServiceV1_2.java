package exception.ex1;

public class NetworkServiceV1_2 {

    // 에러 발생 시 로그 남김
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data); //추가

        String connectResult = client.connect();
        if (isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + connectResult);
            return;
        }

        String sendResult = client.send(data);
        if (isError(sendResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + sendResult);
            return;
        }

        client.disconnect();
    }

    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }

    // 외부자원에 접속 (connect)를 했으면 오류발생 or 연결이 끝나면 disconnect까지 해주는게 필요
    // 현재 코드는 에러 발생시 바로 return을 하고있음.
}
