package Stream;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class fianlOperation {
    public static void main(String[] args) {
        /**
         * forEach 예제
         */
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        Stream.of(strArr)
                .parallel() // 병렬로 처리
                .forEachOrdered(System.out::println);

        /**
         * ~match() 예제
         */
        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
        Optional<String> sWord = Stream.of(strArr)
                .filter(s -> s.charAt(0) == 's').findFirst();

        System.out.println("noEmptyStr = " + noEmptyStr);
        System.out.println("sWord = " + sWord.get());

        /**
         * reduce()예제
         */
        //Stream<String>을 Stream<Integer>로 변환
        Stream<Integer> intStream0= Stream.of(strArr).map(String::length);

        // Stream<String> -> IntStream으로 변환 : IntStream 은 기본형int를 다루는 스트림이라
        // 성능이 Stream<Integer>보다 더 빠름
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a, b) -> a + 1);
        int sum = intStream2.reduce(0, (a, b) -> a + b);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

        System.out.println("count = " + count);
        System.out.println("sum = " + sum);
        System.out.println("max = " + max.getAsInt());
        System.out.println("min = " + min.getAsInt());



        /**
         * collect() 예제
         */
        List<Student> students = Arrays.asList(
                new Student("Alice", 20, 85),
                new Student("Bob", 21, 75),
                new Student("Charlie", 22, 90),
                new Student("David", 20, 80),
                new Student("Eve", 21, 95)
        );

        // 1. 스트림을 컬렉션으로 변환 (toList, toSet, toMap, toCollection)
        List<String> studentNames = students.stream()
                .map(Student::getName)
                .collect(toList()); // List로 변환
        System.out.println("Student Names: " + studentNames);

        Set<Integer> ages = students.stream()
                .map(Student::getAge)
                .collect(toSet()); // Set으로 변환
        System.out.println("Ages: " + ages);

        Map<String, Integer> studentNameToScore = students.stream()
                .collect(toMap(Student::getName, Student::getScore)); // Map으로 변환
        System.out.println("Name to Score Map: " + studentNameToScore);

        Collection<Student> studentCollection = students.stream()
                .collect(toCollection(ArrayList::new)); // 특정한 컬렉션 타입으로 변환
        System.out.println("Student Collection: " + studentCollection);

        // 2. 스트림을 배열로 변환 (toArray)
        Student[] studentArray = students.stream().toArray(size -> new Student[size]); // Student 배열로 변환
        System.out.println("Student Array: " + Arrays.toString(studentArray));

        // 3. 그룹별 통계 (Collectors.counting, summingInt, reducing)
        Map<Integer, Long> countByAge = students.stream()
                .collect(groupingBy(Student::getAge, counting())); // 나이별로 학생 수 세기
        System.out.println("Count by Age: " + countByAge);

        Map<Integer, Integer> totalScoreByAge = students.stream()
                .collect(groupingBy(Student::getAge, summingInt(Student::getScore))); // 나이별로 총 점수 계산
        System.out.println("Total Score by Age: " + totalScoreByAge);

        Map<Integer, Optional<Student>> topScorerByAge = students.stream()
                .collect(groupingBy(Student::getAge, reducing((s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2))); // 나이별 최고 득점자
        System.out.println("Top Scorer by Age: " + topScorerByAge);

        // 4. 문자열 스트림의 joining()
        String studentNamesJoined = students.stream()
                .map(Student::getName)
                .collect(joining(", ")); // 이름을 쉼표로 연결
        System.out.println("Joined Names: " + studentNamesJoined);

    }
}


class Student {
    String name;
    int age;
    int score;

    Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + "(" + age + ", " + score + ")";
    }
}
