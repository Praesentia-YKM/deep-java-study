package exception.ex2;

public class NetworkServiceV2_4 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data); //추가

        try {
            client.connect();
            client.send(data);
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        }

        // disconnect는 무조건 호출 -> 어짜피 에러도 정상흐름으로 만들었으니까
        // 하지만 내가 잡아둔 에러 외적으로 발생해버리면?? disconnect가 절대 실행이 안됨..
        // 이런 구조로는 아무리 꼼꼼하게 예외를 다 catch하더라도 완벽하게 disconnect에 대한
        // 처리 보장을 할 수가 없다... 다른 방식이 필요하다..!! 이래서 finally가 등장!!
        client.disconnect();
    }
}
