package reflection;

import reflection.data.BasicData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodV2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 정적 메서드 호출 - 일반적인 메서드 호출
        BasicData helloInstance = new BasicData();
        helloInstance.call(); // 이 부분은 코드를 변경하지 않는 이상 정적이다. -> 죽었다꺠도 call이라는 메서드만 실행가능

        // 동적 메서드 호출 - 리플렉션 사용
        Class<? extends BasicData> helloClass = helloInstance.getClass();
        String methodName1 = "hello";
        String methodName2 = "staticMethod";

        // 메서드 이름을 변수로 변경할 수 있다.
        Method method1 = helloClass.getDeclaredMethod(methodName1, String.class); // 어떤 메서드이름으로 매개변수 타입이 String인
        Object returnValue1 = method1.invoke(helloInstance, "hi"); // 어떤 인스턴스의 메서드에 매개변수 뭐를 넣을지
        System.out.println("returnValue1 = " + returnValue1);

        Method method2 = helloClass.getDeclaredMethod(methodName2, Integer.class);
        method2.setAccessible(true);
        Object returnValue2 = method2.invoke(helloInstance, 3);
        Object returnValue3 = method2.invoke(null, 3); // static 메서드라 null이여도됨
        System.out.println("returnValue2 = " + returnValue2);
        System.out.println("returnValue3 = " + returnValue3);
    }
}
