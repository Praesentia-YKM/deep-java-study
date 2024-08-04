package exception.ex4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

    public void readFile(String filePath) throws IOException{
        BufferedReader reader = null;
        try {
            // FileReader에서 무조건 IOexception을 던지고 있어서 IOexceptino을 언체크 예외로
            // 감쌀 게 아니라면 무조건 catch 나 trhows를 해줘야함
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
        finally {
            if (reader != null) {
                reader.close(); // IOException을 던질 수 있습니다.
            }
        }
    }

    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        try {
            fileProcessor.readFile("example.txt");
        } catch (IOException e) {
            e.printStackTrace(); // IOException을 처리합니다.
        }
    }
}
