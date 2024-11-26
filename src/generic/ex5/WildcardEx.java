package generic.ex5;

import generic.animal.Animal;

/**
 * wildcard는 제네릭을 더 쉽게 쓸 수 있게 도와주는 도구다.
 *
 * 이미 만들어진 제네릭 타입을 가지고 편하게 무슨 값이든 들어올 수 있어~라고 하는 기능
 *
 * 와일드카드인 ? 는 모든 타입을 다 받을 수 있다는 뜻이다.
 * ? == <? extends Object> 라고 볼 수 있다.
 */
public class WildcardEx {

    static <T> void printGenericV1(Box<T> box) {
        System.out.println("T = " + box.get());
    }

    static void printWildcardV1(Box<?> box) {
        System.out.println("? = " + box.get());
    }

    static <T extends Animal> void printGenericV2(Box<T> box) {
        T t = box.get();
        System.out.println("이름 = " + t.getName());
    }

    static void printWildcardV2(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
    }

    static <T extends Animal> T printAndReturnGeneric(Box<T> box) {
        T t = box.get();
        System.out.println("이름 = " + t.getName());
        return t;
    }

    static Animal printAndReturnWildcard(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
        return animal;
    }
}