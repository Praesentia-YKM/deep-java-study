package generic.ex3;

/**
 * T타입을 사용함으로 인해 Object클래스의 메서드만 사용할 수 있다.
 * 런타임이 되지 않는 이상 무슨 타입이 들어오는지 알 수 없기 대문에
 *
 * @param <T>
 */
public class AnimalHospitalV2<T> {

    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void checkup() {
        // T의 타입을 메서드를 정의하는 시점에는 알 수 없다. Object의 기능만 사용 가능
        animal.toString();
        animal.equals(null);

        // 컴파일 오류
        //System.out.println("동물 이름: " + animal.getName());
        //animal.sound();
    }

    public T getBigger(T target) {
        // 컴파일 오류
        //return animal.getSize() > target.getSize() ? animal : target;
        return null;
    }
}