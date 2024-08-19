package lang.system;

import java.util.Arrays;
import java.util.Map;

public class SystemMain {

    public static void main(String[] args) {
        // 현재 시간(밀리초)를 가져온다.
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        // 현재 시간(나노초)를 가져온다.
        long currentTimeNano = System.nanoTime();
        System.out.println("currentTimeNano = " + currentTimeNano);

        // 환경 변수를 읽는다.
        System.out.println("getenv= " + System.getenv());

        // 시스템 속성을 읽는다.
        System.out.println("properties = " + System.getProperties());
        System.out.println("Java version: " + System.getProperty("java.version"));

        // 배열을 고속으로 (값으로 인한) 복사한다.
        // 자바코드로 for문 루프돌면서 복사하는게 아니고 운영체제 레벨에서 하드웨어 상에서 그냥 값을 강제로 하나 더 만들어서 매우 빠르다.
        // 원래는 for문으로 인덱스별로 하나하나 값을 넣어줘야함
        char[] originalArray = {'h', 'e', 'l', 'l', 'o'};
        char[] copiedArray = new char[5];
        char[] copiedArray2 = new char[5];
        System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);
        copiedArray2 = originalArray;

        copiedArray[4] = 'Z';   // arraycopy로 복사한건 값만 복사된 상태라 copiedArray만 바뀜
        originalArray[4] = 'A'; // 주소값을 할당하여 참조복사를 한 상태는 원본과 참조하는 배열 둘다 값이 바뀜

        System.out.println(Arrays.toString(originalArray));
        System.out.println(Arrays.toString(copiedArray));
        System.out.println(Arrays.toString(copiedArray2));
        // 배열 출력
        System.out.println("copiedArray = " + copiedArray);
        System.out.println("Arrays.toString = " + Arrays.toString(copiedArray));

        // 프로그램 강제 종료(가급적 사용x)
        System.exit(0); // 0 : 정상 종료, 0이 아니면 예외적 종료
    }
}
