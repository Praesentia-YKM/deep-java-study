package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {

    public static void main(String[] args) throws IOException {
        // 자바프로세스를 temp/hello.dat로 내보낸다!
        // (파일은 없으면 만들어줌, 디렉토리는 아님) -> 이거 때매 mkdir안해줘서 생기는 filenotfound에러많이남
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close(); // 외부의 자원을 끌어다 쓰면 꼳 스트림을 닫아줘야한다!!

        // 외부의 자원을 자바프로세스로 가져온다!
        FileInputStream fis = new FileInputStream("temp/hello.dat");
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
        fis.close();
    }
}
