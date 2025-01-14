package network.tcp.autocloseable;

public class ResourceCloseMainV3 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;

        try {
            // 여기서 객체를 생성해버리면 finally에서 사용할 수 없어져버림
            resource1 = new ResourceV1("resource1"); // EX
            resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callEx(); // CallException
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        } finally {
            if (resource2 != null) {
                try {
                    resource2.closeEx(); // CloseException 발생
                } catch (CloseException e) {
                    // 자원을 닫다가 발생한 정보는 throw new하지 않고 로깅하고 끝내버림
                    // close()에서 발생한 예외는 버린다. 필요하면 로깅 정도
                    System.out.println("close ex: " + e);
                }
            }
            if (resource1 != null) {
                try {
                    resource1.closeEx();
                } catch (CloseException e) {
                    // 자원을 닫다가 발생한 정보는 throw new하지 않고 로깅하고 끝내버림
                    // 이로인해 try에서 발생한 예외가 갈아쳐지지 않음
                    System.out.println("close ex: " + e);
                }
            }
        }

    }
}
