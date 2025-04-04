package youtube_lamda.lamda.functionPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ex0 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int)(Math.random()*100) + 1;
        Consumer<Integer> c = i -> System.out.print(i+",");
        Predicate<Integer> p = i -> i%2 == 0;
        Function<Integer, Integer> f = i -> i/10*10;

        List<Integer> list = new ArrayList<>();
        makeRandomList(s,list);
        System.out.println(list);

        printEvenNum(p,c,list);
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
    }

    // 1의 자리를 없애는 Function을 받음
    static <T> List<T> doSomething(Function<T,T> f, List<T> list) {
        List<T> newList = new ArrayList<T>(list.size());

        for(T t : list) {
            newList.add(f.apply(t));    // 리스트의 값을 1의자리를 없애고 새로운 리스트 할당
        }

        return newList;
    }

    static <T> void printEvenNum(Predicate<T> P,Consumer<T> c, List<T> list) {
        System.out.print("[");

        for (T i : list) {
            if(P.test(i)) {     // 짝수인지 검사
                c.accept(i);    // 화면에 i 출력하는 소비자
            }
        }
    }
    
    static <T> void makeRandomList(Supplier<T> s, List<T> list){
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }
}
