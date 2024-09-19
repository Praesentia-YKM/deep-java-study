package nested.nested.ex2;

public class Network {
    public void sendMessage(String text) {
        NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }

    // 아 NetworkMessage는 Network안에서만 쓰는 거구나. 내부에서 단독으로 쓰는 놈이네
    private static class NetworkMessage {
        private String content;

        public NetworkMessage(String content) {
            this.content = content;
        }

        public void print() {
            System.out.println(content);
        }
    }
}
