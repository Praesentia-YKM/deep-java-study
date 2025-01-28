package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Method;

public class MethodV1 {

    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;

        // 나와 부모로부터 상속받은 모든 메서드 중에서 public한 메서드만
        System.out.println("===== methods() =====");
        Method[] methods = helloClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        // 내가 선언한 모든 메서드 (상속받은거 빼고 public, private, default, protected..모두)
        System.out.println("===== declaredMethods() =====");
        Method[] declaredMethods = helloClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("declaredMethod = " + method);
        }
    }
}
