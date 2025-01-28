package reflection;

import reflection.data.User;

import java.lang.reflect.Field;

public class FieldV2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("id1", "userA", 20);
        System.out.println("기존 이름 = " + user.getName());

        // 클래스 객체 가져오기
        Class<? extends User> aClass = user.getClass();

        // name 필드 가져오기
        Field nameField = aClass.getDeclaredField("name");

        // private 필드 접근 허용
        nameField.setAccessible(true);

        // 객체 인스턴스(user)의 name 필드 값 가져오기
        Object o = nameField.get(user);
        System.out.println("필드 값 = " + o.toString());

        // name 필드 값 변경
        nameField.set(user, "userB");
        System.out.println("변경된 이름 = " + user.getName());
    }
}
