package io.file.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.*;

/**
 * 문자 파일을 읽는걸 단순화 시켜준다.
 */
public class ReadTextFileV1 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("== Write String ==");
        System.out.println(writeString);

        Path path = Path.of(PATH);

        // 파일에 쓰기 -> 버퍼를 열고 다는 과정을 코딩할 필요가 없음
        Files.writeString(path, writeString, UTF_8);
        // 파일에서 읽기 -> 버퍼 열고 닫는 과정 코딩ㅎ
        String readString = Files.readString(path, UTF_8);

        System.out.println("== Read String ==");
        System.out.println(readString);
    }

    /** 기존 구린 방식
    // 파일에 쓰기
    FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
    BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
    bw.write(writeString);
    bw.close();

    // 파일에서 읽기
    StringBuilder content = new StringBuilder();
    FileReader fr = new FileReader(FILE_NAME, UTF_8);
    BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

    String line;
    while ((line = br.readLine()) != null) {
        content.append(line).append("\n");
    }
    br.close();
     */
}
