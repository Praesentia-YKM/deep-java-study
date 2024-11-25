package generic.ex3;

import generic.animal.Animal;

/**
 * 타입 매개변수 제한 기법
 * -> 타입매개변수 T를 Animal 과 그 자식만 받을 수 있도록 제한한다.
 * "T의 상한선 제한"
 *
 * 이로 인하여 자바 컴파일러는 T의 타입을 미리 예측할 수 있게 된다.
 */
public class AnimalHospitalV3<T extends Animal> {

    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound();
    }

    public T getBigger(T target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }

}