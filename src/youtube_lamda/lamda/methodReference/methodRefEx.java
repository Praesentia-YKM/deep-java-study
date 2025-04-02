package youtube_lamda.lamda.methodReference;

import java.util.function.Function;
import java.util.function.Supplier;

public class methodRefEx {
    public static void main(String[] args) {
        // 람다 활용
        Function<String, Integer> f = (String s) -> Integer.parseInt(s);
        System.out.println(f.apply("100")+200);

        // 메서드 참조로 더 간단하게(함수형 인터페이스에 다 정보가 나와있으므로 생략 가능)
        Function<String, Integer> f1 = Integer::parseInt;
        System.out.println(f1.apply("100")+200);

        // 익명클래스로 변환 (이게 너무 길어서 람다가 생김)
        Supplier<MyClass> s1 = new Supplier<MyClass>() {
            @Override
            public MyClass get() {
                return new MyClass();
            }
        };
        System.out.println(s1.get());


        // Supllier는 입력x, 출력O
        Supplier<MyClass> s = () -> new MyClass();
        System.out.println(s.get());

        MyClass mc = s.get();
        System.out.println(mc);

        ///////// 커스텀 클래스의 생성자를 람다와 매서드 참조를 통해 호출 //////////
        Function<Integer, MyClass> f2 = (i) -> new MyClass();
        Function<Integer, MyClass> f3 = MyClass::new;
        System.out.println(f2.apply(100));
        System.out.println(f3.apply(3));

        Function<Integer,int[]> arr1 = (i) -> new int[i];
        Function<Integer,int[]> arr2 = int[]::new;

        int [] ex1 = arr1.apply(100);
        System.out.println("ex1.length="+ex1.length);

        int [] ex2 = arr2.apply(100);
        System.out.println("ex2.length="+ex2.length);
    }
}

class MyClass {
    int iv;

    MyClass(){
        this.iv=iv;
    }

    MyClass(int iv){
        this.iv=iv;
    }
}
