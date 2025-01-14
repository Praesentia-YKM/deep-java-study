package network.tcp.autocloseable;

// 1. 에러가 발생해도 try 시점에 자원부터 정리하고 catch블록을 호출한다 (V2)
// 2. close시점에 예외가 발생하면 아래 코드들은 예외를 닫을 수 없었다. (V2)
// 3. 변수 스코프를 억지로 늘리지 않아도 된다. (V2)
// 4. CLOSE 호출 순서를 고려하지 않아도 된다.(보통 자원 생성의 역순으로 닫아야함)
// 5. 실수로 인한 CLOSE를 호출 안해서 메모리 누수 방지
// 6. 부가예외도 포함한다.(CLOSE할 떄 발생되는 예외는 suppressed에 담아서 e.getSuppressed()로 반환가능함(V2)
public class ResourceCloseMainV4 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");

            Throwable[] suppressed = e.getSuppressed();
            for (Throwable throwable : suppressed) {
                System.out.println("suppressedEx = " + throwable);
            }

            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        try (ResourceV2 resource1 = new ResourceV2("resource1");
             ResourceV2 resource2 = new ResourceV2("resource2")) {

            resource1.call();
            resource2.callEx(); // CallException
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        }
    }
}
