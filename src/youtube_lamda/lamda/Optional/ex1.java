package youtube_lamda.lamda.Optional;

import java.util.Optional;

public class ex1 {
    public static void main(String[] args) {
        String sss="abc";
        Optional<String> optVal=Optional.of(sss);
        Optional<String> optVal1=Optional.of("abc");
        Optional<String> optVal12=Optional.of(null); // NullPointerException 발생
        Optional<String> optVal13=Optional.ofNullable(null); // 굿


        // int[] arr = null;
        int[] arr = new int[0];
        System.out.println("arr.length=" + arr.length);

        // youtube_lamda.lamda.Optional<String> opt = null; // OK. 하지만 바람직 X
        Optional<String> opt = Optional.empty();
        Optional<String> opt2 = Optional.of("abc");
        System.out.println("opt=" + opt);
        System.out.println("opt=" + opt.get());

        String str = "";

        try {
            str = opt.get();
        } catch (Exception e) {
            str = ""; // 예외가 발생하면 빈문자열("")로 초기화
        }

        // 예외 발생
        str = opt.orElse("EMPTY");  // Optional에 저장된 값이 null이면 "EMPTY" 반환
        str = opt.orElseGet(() -> new String());  // Optional에 저장된 값이 null이면 새로운 String 생성
        str = opt.orElseGet(String::new);  // Optional에 저장된 값이 null이면 새로운 String 생성
        System.out.println("str=" + str);
    }
}
