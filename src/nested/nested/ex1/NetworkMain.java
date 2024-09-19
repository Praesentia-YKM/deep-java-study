package nested.nested.ex1;

/**
 * Network 관련 라이브러리를 사용하기 위해서 ex1 패키지를 열어본 개발자는 아마도 두 클래스를 모두 확인해볼 것
 * 이다. 그리고 해당 패키지를 처음 확인한 개발자는 Network 와 NetworkMessage 를 둘다 사용해야 하나? 라고 생
 * 각할 것이다. NetworkMessage 에 메시지를 담아서 Network 에 전달해야 하나?와 같은 여러가지 생각을 할 것이
 * 다.
 *
 * 아니면 NetworkMessage 가 다른 여러 클래스에서 사용되겠구나 라고 생각할 것이다.
 * 두 클래스의 코드를 모두 확인하고 나서야 아~ Network 클래스만 사용하면 되는구나, NetworkMessage 는 단순히
 * Network 안에서만 사용되는구나 라고 이해할 수 있다.
 */
public class NetworkMain {
    public static void main(String[] args) {
        Network network = new Network();
        network.sendMessage("hello java");
    }
}
