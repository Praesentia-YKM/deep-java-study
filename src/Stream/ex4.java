package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Person 객체가 포함된 리스트에서, 나이 기준으로 내림차순 정렬하고,
 * 같은 나이인 경우 이름을 기준으로 오름차순으로 정렬한 결과를 출력하세요.
 */
public class ex4 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Jane", 30),
                new Person("Jack", 25),
                new Person("Doe", 40)
        );

        // 이 스트림을 완성하여 조건에 맞는 결과를 출력하세요
        Stream<Person> stream = people.stream();
        stream.sorted(Comparator.comparingInt(Person::getAge).reversed()
                .thenComparing(Person::getName))
                .forEach(System.out::println);

    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }

        // Getters 추가

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
