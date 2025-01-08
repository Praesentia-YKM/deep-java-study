package io.file;

import java.io.File;
import java.io.IOException;

public class OldFilePath {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/.."); // ..은 상위폴더를 지칭 (temp의 위 = > 현재프로젝트 최상위폴더)
        System.out.println("path = " + file.getPath());

        // 절대 경로
        System.out.println("Absolute path = " + file.getAbsolutePath());
        // 정규 경로: .. 등 경로의 계산이 모두 끝난 경로, 정규경로는 무조건 하나만 존재가능
        System.out.println("Canonical path = " + file.getCanonicalPath());

        // 상대경로: 현재 자바프로그램 시작 지점부터의 경로 계산

        File[] files = file.listFiles(); // 파일경로를 파일 배열로 반환
        for (File f : files) {
            System.out.println( (f.isFile() ? "F" : "D")  + " | " + f.getName());
        }
    }
}
