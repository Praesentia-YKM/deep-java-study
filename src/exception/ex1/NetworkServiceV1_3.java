package exception.ex1;

public class NetworkServiceV1_3 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data); //추가

        String connectResult = client.connect();
        if (isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + connectResult);
        } else {
            String sendResult = client.send(data);
            if (isError(sendResult)) {
                System.out.println("[네트워크 오류 발생] 오류 코드: " + sendResult);
            }
        }

        client.disconnect();
    }

    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }

    // 코드가 읽기 어렵다 왜? 정상흐름과 예외흐름이 전혀 분리되어있지않음
    // 코드자체가 정상흐름 + 예외흐름, 정상흐름 + 예외흐름 이런식으로 블록이 형성되어있다.

    /* 따라서 정상흐름과 예외흐름의 분리가 되면 더 좋은 코드가 될거다...
       하지만 이러한 반환값을 활용해서 확인한다는 행위 자체 떄문에 if else로 나뉘어서 정상흐름과 예외흐름이
       섞이는 구조가 될 수 밖에 없다!!  --> 이거 때매 예외처리라는게 등장함!
    */

}
