package io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class NewFilesPath {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("temp/..");
        System.out.println("path = " + path);

        // 절대 경로
        System.out.println("Absolute path = " + path.toAbsolutePath());
        // 정규 경로
        System.out.println("Canonical path = " + path.toRealPath());

        // Files에 있는 list로 Path스트림을 생성할 수 있음
        // 컬렉션 스트림은 자동으로 close되는데 파일에서 만드는 stream은 close가 안됨
        // 원래 stream이라는게 닫아줘야하는거임(네트워크던 파일이던 ㅇㅇ. 근데 컬렉션 스트림은 편의상 자동으로 닫아주는것)
        Stream<Path> pathStream = Files.list(path);
        List<Path> list = pathStream.toList();
        pathStream.close();

        for (Path p : list) {
            System.out.println( (Files.isRegularFile(p) ? "F" : "D") + " | " + p.getFileName());
        }
    }
}
