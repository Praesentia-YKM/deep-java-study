package nested.local;

import java.lang.reflect.Field;

/**
 * 지역변수 캡처 된 값을 수정하면 동기화 문제가 발생하므로 수정을 못하는 사실상 final 지역변수가 된다.
 * ##지역 클래스가 접근하는 지역 변수의 값은 변경하면 안된다. ##
 */
public class LocalOuterV4 {

    private int outInstanceVar = 3;

    // 사실상 final int paramVar
    public Printer process(int paramVar) {

        // 사실상 final int localVar
        int localVar = 1; //지역 변수는 스택 프레임이 종료되는 순간 함께 제거된다.

        class LocalPrinter implements Printer {

            int value = 0;

            @Override
            public void print() {
                System.out.println("value=" + value);

                //인스턴스는 지역 변수보다 더 오래 살아남는다.
                System.out.println("localVar=" + localVar);
                System.out.println("paramVar=" + paramVar);
                System.out.println("outInstanceVar=" + outInstanceVar);
            }
        }

        LocalPrinter printer = new LocalPrinter();
        // 만약 localVar의 값을 변경한다면? 다시 캡쳐해야 하나??
        // localVar = 10;
        // paramVar = 20;

        return printer;
    }

    public static void main(String[] args) {
        LocalOuterV4 localOuter = new LocalOuterV4();
        Printer printer = localOuter.process(2);
        //printer.print()를 나중에 실행한다. process()의 스택 프레임이 사라진 이후에 실행
        printer.print();

        //추가
        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
    }
}
