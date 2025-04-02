package youtube_lamda.lamda.Stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  Employee 객체 리스트에서 나이를 기준으로 오름차순 정렬하고,
 *  동일한 나이인 경우 이름을 기준으로 내림차순으로 정렬하여,
 *  결과를 Map<Integer, List<Employee>> 형식으로 나이별 그룹으로 변환하세요.
 */
public class ex7 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 25),
                new Employee("Jane", 30),
                new Employee("Jack", 25),
                new Employee("Doe", 40)
        );

        // 그룹화된 결과를 TreeMap으로 저장하고, 각 나이별로 이름들을 리스트로 수집
        Map<Integer, List<String>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getAge,        // 1. 그룹화 기준 (나이) [classifier]
                        TreeMap::new,            // 2. TreeMap 사용 [mapFactory]
                        Collectors.mapping(Employee::getName, Collectors.toList())  // 3. 이름을 리스트로 수집 [downstream]
                ));

        //우리가 하는 작업에도 순서가 있는데, 먼저 해결해야 할 작업을 업스트림이라고 부르고 다음에 최종적으로 해결하고자 하는 작업을 Downstream task라고 합니다.
        result.forEach((age, names) -> {
            System.out.println("Age: " + age);
            names.forEach(System.out::println);
        });
    }

    static class Employee {
        String name;
        int age;

        Employee(String name, int age) {
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
