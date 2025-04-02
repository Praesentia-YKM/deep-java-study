package youtube_lamda.lamda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class collectionFraEx {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<10;i++) {
            list.add(i);
        }

        // 컬렉션 프레임워크와 람다 활용
        list.forEach(i->System.out.print(i + ","));

        // 기존방법1
        Iterator it = list.iterator();
        System.out.println();
        while(it.hasNext()) {
            System.out.print(it.next());
        }

        // 기존 방법 2
        System.out.println();
        for (Integer el : list) {
            System.out.print(el);
        }

        // removeIf
        list.removeIf(x-> x%2==0 || x%2==0);
        System.out.println(list);

        // replaceAll
        list.replaceAll(i -> i*10);
        System.out.println(list);

        // map의 요소 순회
        Map<String, String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        //foreach
        map.forEach((k,v) -> System.out.print("{" + k +","+ v + "},"));

        // 원래 맵을 순회하려면 엔트리셋 가져와서 순회했어야함 (기존 방법)
        Iterator iter = map.entrySet().iterator();

        while(iter.hasNext()) {
            System.out.println(it.next());
        }
    }
}
