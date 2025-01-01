package charset;

import java.nio.charset.Charset;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain1 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("== ASCII 영문 처리 ==");
        encoding("A", US_ASCII);
        encoding("A", ISO_8859_1); // ASCII와 호환됨
        encoding("A", EUC_KR); // ASCII와 호환됨
        encoding("A", UTF_8); // ASCII와 호환됨
        encoding("A", UTF_16BE); // ASCII와 호환 안 됨

        System.out.println("== 한글 지원 ==");
        encoding("가", EUC_KR);
        encoding("가", MS_949); // EUC_KR와 호환
        encoding("가", UTF_8); // EUC_KR와 호환 안 됨
        encoding("가", UTF_16BE); // EUC_KR와 호환 안 됨

        // 모든 문자를 바이트로 바꿀 때는 인코딩 방식을 정해줘야 한다. 정해주지 않으면 시스템 기본인코딩으로 들어간다. Charset.defaultCharset()
        String str = "A";
        byte[] bytes = str.getBytes();
        System.out.println("Arrays.toString(bytes) = " + Arrays.toString(bytes));
    }

    private static void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n", text, charset, Arrays.toString(bytes), bytes.length);
    }
}
