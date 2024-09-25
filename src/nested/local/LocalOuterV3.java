package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV3 {

    private int outInstanceVar = 3;

    public Printer process(int paramVar) {

        int localVar = 1; //지역 변수는 스택 프레임이 종료되는 순간 함께 제거된다.

        class LocalPrinter implements Printer {
            int value = 0;

            @Override
            public void print() {
                //인스턴스는 지역 변수보다 더 오래 살아남는다.
                System.out.println("value=" + value);

                // 지역변수
                System.out.println("localVar=" + localVar);
                System.out.println("paramVar=" + paramVar);

                // 인스턴스 변수
                System.out.println("outInstanceVar=" + outInstanceVar);
            }
        }

        LocalPrinter printer = new LocalPrinter();

        //printer.print();를 여기서 실행하지 않고 Printer 인스턴스만 반환한다.
        return printer;
    }

    public static void main(String[] args) {
        LocalOuterV3 localOuter = new LocalOuterV3();
        Printer printer = localOuter.process(2);
        //printer.print()를 나중에 실행한다. process()의 스택 프레임이 사라진 이후에 실행
        // process 메서드가 호출이 끝난 시점에 안에 지역변수들은 생명주기가 끝난 상태이지만 참조가 가능하다.
        // 왜 될까? : 지역변수 캡처
        printer.print();

        //지역변수 캡처 확인
        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
    }
}
