package youtube_lamda.lamda.Stream;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * map(), peek(), flatmap()
 */
public class middleOperationEx2 {
    public static void main(String[] args) {
        // 파일 스트림 생성
        Stream<File> fileStream = Stream.of(
            new File("Ex1.java"),
            new File("Ex1"),
            new File("Ex1.bak"),
            new File("Ex2.java"),
            new File("Ex1.txt")
        );

        // 파일 스트림에서 파일 이름을 추출하고, 확장자만 대문자로 변환하여 중복 없이 출력
        fileStream.map(File::getName) // youtube_lamda.lamda.Stream<File> -> youtube_lamda.lamda.Stream<String>
                .filter(s -> s.indexOf('.') != -1) // 확장자가 있는 파일만 필터링
                .map(s -> s.substring(s.indexOf('.') + 1)) // youtube_lamda.lamda.Stream<String> -> youtube_lamda.lamda.Stream<String> (확장자 추출)
                .map(String::toUpperCase) // youtube_lamda.lamda.Stream<String> -> youtube_lamda.lamda.Stream<String> (대문자로 변환)
                .distinct() // 중복 제거
                .forEach(System.out::println); // 결과 출력

        Stream<String[]> strArrStrm = Stream.of(
            new String[]{"abc","def","jkl"},
            new String[]{"ABC","DEF","JKL"}
        );

        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

        strStrm.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println();

        String[] lineArr = {
            "Believe or not It is true",
            "Do or do not There is no try",
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line->Stream.of(line.split(" +"))) // 하나이상의 공백을 의미하는 정규식
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
