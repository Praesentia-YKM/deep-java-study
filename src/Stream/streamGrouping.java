package Stream;


import java.util.*;
import java.util.stream.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class streamGrouping {
    public static void main(String[] args) {
        Student2[] stuArr = {
                new Student2("나자바", true, 1, 1, 300),
                new Student2("김지미", false, 1, 1, 250),
                new Student2("김자바", true, 1, 1, 200),
                new Student2("이지미", false, 1, 2, 150),
                new Student2("남자바", true, 1, 2, 100),
                new Student2("안지미", false, 1, 2, 50),
                new Student2("황지미", false, 1, 3, 100),
                new Student2("최자바", true, 1, 3, 300),
                new Student2("김자바", true, 2, 1, 200),
                new Student2("이지미", false, 2, 1, 150),
                new Student2("남자바", true, 2, 1, 100),
                new Student2("안지미", false, 2, 2, 50),
                new Student2("황지미", false, 2, 2, 100),
                new Student2("나자바", true, 2, 3, 300),
                new Student2("김지미", false, 2, 3, 250),
                new Student2("김자바", true, 2, 3, 200),
                new Student2("이지미", false, 2, 3, 150),
                new Student2("남자바", true, 2, 3, 100),
                new Student2("안지미", false, 2, 3, 50),
                new Student2("황지미", false, 2, 3, 100),
                new Student2("강지미", false, 2, 3, 150),
                new Student2("이자바", true, 2, 3, 200)
        };
        // 성별로 분할 출력
        System.out.printf("1. 단순분할 (성별로 분할)%n");
        Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale));

        List<Student2> maleStudent = stuBySex.get(true);
        List<Student2> femaleStudent = stuBySex.get(false);

        for (Student2 s : maleStudent)
            System.out.println(s);
        for (Student2 s : femaleStudent)
            System.out.println(s);

        System.out.printf("%n2. 단순분할 + 통계 (성별 학생수)%n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale, counting()));

        System.out.println("남학생 수: " + stuNumBySex.get(true));
        System.out.println("여학생 수: " + stuNumBySex.get(false));

        System.out.printf("%n3. 단순분할 + 통계 (성별 1등)%n");
        Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale,
                        maxBy(comparingInt(Student2::getScore))));

        System.out.println("남학생 1등: " + topScoreBySex.get(true));
        System.out.println("여학생 1등: " + topScoreBySex.get(false));

        Map<Boolean, Student2> topScoreBySex2 = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale,
                        collectingAndThen(maxBy(comparingInt(Student2::getScore)), Optional::get)));


        /**
         * groupingBy
         */

        System.out.printf("1. 단순그룹화 (반별로 그룹화)%n");
        Map<Integer, List<Student2>> stuByBan = Stream.of(stuArr)
                .collect(groupingBy(Student2::getBan));

        for (List<Student2> ban : stuByBan.values()) {
            for (Student2 s : ban) {
                System.out.println(s);
            }
        }

        System.out.printf("%n2. 단순그룹화 (성적별로 그룹화)%n");
        Map<Student2.Level, List<Student2>> stuByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200) return Student2.Level.HIGH;
                    else if (s.getScore() >= 100) return Student2.Level.MID;
                    else return Student2.Level.LOW;
                }));

        TreeSet<Student2.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for (Student2.Level key : keySet) {
            System.out.println("[" + key + "]");

            for (Student2 s : stuByLevel.get(key))
                System.out.println(s);
            System.out.println();
        }


        System.out.printf("%n3. 단순그룹화 + 통계 (성적별 학생수)%n");
        Map<Student2.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200) return Student2.Level.HIGH;
                    else if (s.getScore() >= 100) return Student2.Level.MID;
                    else return Student2.Level.LOW;
                }, counting()));

        for (Student2.Level key : stuCntByLevel.keySet()) {
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
            System.out.println();
        }

        for (List<Student2> level : stuByLevel.values()) {
            System.out.println();
            for (Student2 s : level) {
                System.out.println(s);
            }
        }

        System.out.printf("%n4. 다중그룹화 (학년별, 반별)%n");
        Map<Integer, Map<Integer, List<Student2>>> stuByHakAndBan = Stream.of(stuArr)
                .collect(groupingBy(Student2::getHak,
                        groupingBy(Student2::getBan)));

        for (Map<Integer, List<Student2>> hak : stuByHakAndBan.values()) {
            for (List<Student2> ban : hak.values()) {
                System.out.println();
                for (Student2 s : ban) {
                    System.out.println(s);
                }
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계 (학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, Student2>> topStuByHakAndBan = Stream.of(stuArr)
                .collect(groupingBy(Student2::getHak,
                        groupingBy(Student2::getBan,
                                collectingAndThen(
                                        maxBy(comparingInt(Student2::getScore)),
                                        Optional::get))));

        for (Map<Integer, Student2> ban : topStuByHakAndBan.values()) {
            for (Student2 s : ban.values()) {
                System.out.println(s);
            }
        }

        System.out.printf("%n6. 다중그룹화 + 통계 (학년별, 반별 성적그룹)%n");
        Map<String, Set<Student2.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(groupingBy(s -> s.getHak() + "-" + s.getBan(),
                        mapping(s -> {
                            if (s.getScore() >= 200) return Student2.Level.HIGH;
                            else if (s.getScore() >= 100) return Student2.Level.MID;
                            else return Student2.Level.LOW;
                        }, toSet())));

        //
        Set<String> keySet2 = stuByScoreGroup.keySet();

        for (String key : keySet2) {
            System.out.println("[" + key + "]");
            for (Student2.Level level : stuByScoreGroup.get(key)) {
                System.out.println(level);
            }
        }

    }
}

// 자바에서 클래스 안에 정의된 enum은 해당 클래스의 멤버로 간주되며,
// 외부에서 접근할 때는 클래스 이름을 통해 enum에 접근할 수 있습니다.
class Student2 {
    String name;
    boolean isMale;   // 성별
    int hak;          // 학년
    int ban;          // 반
    int score;        // 점수

    // 생성자
    Student2(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    // Getter 메서드
    String getName() { return name; }
    boolean isMale() { return isMale; }
    int getHak() { return hak; }
    int getBan() { return ban; }
    int getScore() { return score; }

    // toString 메서드
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]",
                name, isMale ? "남" : "여", hak, ban, score);
    }

    // groupingBy()에서 사용
    enum Level { HIGH, MID, LOW }   // 성적을 상, 중, 하로 분류
}
