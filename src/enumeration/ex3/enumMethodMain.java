package enumeration.ex3;

import java.util.Arrays;

/** values() : Enum 클래스가 가지고 있는 모든 상수 값을 배열의 형태로 리턴 한다.
 *  참고로 단순히 String 의 형태로 단순 반환하는 것이 아니라 인스턴스를 반환
 *  (왜? enum은 클래스의 모든 필드를 상수로 선언하고 그 상수가 모두 하나의 인스턴스로 생성된다)
 * ==> 즉, Enum 클래스에서 선언한 상수들은 클래스가 로드될 때 하나의 인스턴스로 생성되어 싱글톤 형태로 어플리케이션 전체에서 사용된다.
 *
 * ordinal() : enum 상수 순서
 * name() : enum 상수 이름
 */
public class enumMethodMain {
    public static void main(String[] args) {
        // 모든 enum 반환
        // 베얄의 값
        Grade[] values = Grade.values();
        System.out.println("values = " + Arrays.toString(values));

        for(Grade value : values) {
            System.out.println("name=" + value.name() + " , ordinal=" + value.ordinal());
        }

        // String -> ENUM 변환 (String key값 넣으면 value로 인스턴스 반환)
        String input = "GOLD";
        Grade gold = Grade.valueOf(input);
        System.out.println("gold = " + gold);


        /*
        주요 enum 메서드
values():

설명: 열거형에 정의된 모든 상수를 배열 형태로 반환합니다.
예시:
java
코드 복사
enum Grade {
    A, B, C, D, F;
}

Grade[] grades = Grade.values();
결과: Grade.values()는 [Grade.A, Grade.B, Grade.C, Grade.D, Grade.F]와 같은 배열을 반환합니다.
valueOf(String name):

설명: 열거형에서 지정된 이름과 일치하는 상수를 반환합니다. 일치하는 상수가 없으면 IllegalArgumentException을 던집니다.
예시:
java
코드 복사
Grade grade = Grade.valueOf("A");
결과: Grade.A를 반환합니다.
ordinal():

설명: 열거형 상수가 정의된 순서를 반환합니다. 순서는 0부터 시작합니다.
예시:
java
코드 복사
int index = Grade.A.ordinal();
결과: 0을 반환합니다. (Grade.A는 첫 번째 위치)
name():

설명: 열거형 상수의 이름을 문자열로 반환합니다.
예시:
java
코드 복사
String name = Grade.A.name();
결과: "A"를 반환합니다.
toString():

설명: name() 메서드와 동일하게, 열거형 상수의 이름을 문자열로 반환합니다. Enum 클래스에서 toString() 메서드를 오버라이딩하여 원하는 대로 출력 형식을 변경할 수 있습니다.
예시:
java
코드 복사
String result = Grade.A.toString();
결과: "A"를 반환합니다.
         */
    }
}
