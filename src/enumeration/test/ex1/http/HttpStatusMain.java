package enumeration.test.ex1.http;

import java.util.Scanner;
import java.util.Optional;

public class HttpStatusMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("HTTP CODE: ");
        int httpCodeInput = sc.nextInt();

        HttpStatus status = HttpStatus.findByCode(httpCodeInput);

        Optional.ofNullable(status)
                .ifPresentOrElse(s -> {
                    System.out.println(s.getCode() + " " + s.getMessage());
                    System.out.println("isSuccess: " + s.isSuccess());
                }, () -> System.out.println("정의되지 않은 코드"));
    }
}
