package annotation.basic;

import java.util.Arrays;

public class ElementData1Main {

    public static void main(String[] args) {
        Class<ElementData1> annoClass = ElementData1.class;

        // getAnnotation을 통해서 클래스 메타데이터에 붙은 어노테이션 정보를 가져올 수 있다.
        AnnoElement annotation = annoClass.getAnnotation(AnnoElement.class);

        // 어노테이션 클래스객체.프로퍼티() 로 접근 가능
        String value = annotation.value();
        System.out.println("value = " + value);

        int count = annotation.count();
        System.out.println("count = " + count);

        String[] tags = annotation.tags();
        System.out.println("tags = " + Arrays.toString(tags));
    }
}
