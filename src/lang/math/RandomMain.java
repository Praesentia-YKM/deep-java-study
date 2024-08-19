package lang.math;

import java.util.Random;

public class RandomMain {
    /**
     * Random은 seed라는 놈을 기준으로 난수를 생성한다.
     * 이떄 Random 객체를 만들때 seed를 무슨 값이던 하드코딩해서 두면
     * 계속 같은 값을 반환한다. (this.seed = null)
     *
     * @param args
     */
    // Random 은 java.util 패키지에 있다.
    public static void main(String[] args) {
        Random random = new Random();
//        Random random = new Random(3); //seed가 같으면 Random의 결과가 같다.

        // int에 맞는 random값 생성
        int randomInt = random.nextInt();
        System.out.println("randomInt: " + randomInt);

        // 0.0~1.0 사이 random 값 생성
        double randomDouble = random.nextDouble();//0.0d ~ 1.0d
        System.out.println("randomDouble: " + randomDouble);

        // true or false를 랜덤으로 생성
        boolean randomBoolean = random.nextBoolean();
        System.out.println("randomBoolean: " + randomBoolean);

        // 범위 조회
        // nextInt할떄 숫자를 매개변수로 주면 (0~ 넣은 숫자 : 무조건 양수로만) 까지 출력
        int randomRange1 = random.nextInt(10);//0 ~ 9까지 출력
        System.out.println("0 ~ 9: " + randomRange1);

        // 0~9가 아닌 1~10으로 랜덤 숫자 생성
        int randomRange2 = random.nextInt(10) + 1;// 1 ~ 10까지 출력
        System.out.println("1 ~ 10: " + randomRange2);
    }
}
