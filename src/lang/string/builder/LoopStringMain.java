package lang.string.builder;

public class LoopStringMain {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 100000; i++) {
            result += "Hello Java ";
        }
        long endTime = System.currentTimeMillis();

        System.out.println("result = " + result);
        System.out.println("time = " + (endTime - startTime) + "ms");

        // 약 2.5초가 걸렸다 왜지?
        // 반복횟수만큼 루프안에서 계속 객체 생성한거다(빌더로 바꾸고 toString하고를 10만번...약 10만개의 스트링빌더객체...)
    }
}
