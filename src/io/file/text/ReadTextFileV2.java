package io.file.text;

import javax.xml.transform.Source;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadTextFileV2 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("== Write String ==");
        System.out.println(writeString);

        Path path = Path.of(PATH);

        // 파일에 쓰기
        Files.writeString(path, writeString, UTF_8);
        // 파일에서 읽기
        System.out.println("== Read String ==");
        List<String> lines = Files.readAllLines(path, UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }

        // 지연평가
        // 트래이드 오프
        // I/O
        Stream<String> stream = Files.lines(path, UTF_8);
        stream.forEach(System.out::println);

        System.out.println("=====Stream 시작 =====");
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5)
                .filter(i-> {
                    System.out.println("필터링!" + i);
                    return i % 2 == 0;
                })
                .map(i-> {
                    System.out.println("매핑!!" + i);
                    return i * 10;
                });
        System.out.println(integerStream.findFirst().orElseGet(
            () -> {
                System.out.println("값 없다");
                return -1;
            }
        ));


    /**
     소켓통신 소켓1 <-> 소켓2 tcp/ip

        송수신
        쌍방향
        세콤: db => 세콤 db 리소스 정보 ip 포트 => 올샵한테 알려줌 => db insert => select
        전자결재, 은행

        방화벽                 방화벽 우리꺼 열어주셈. ip, port 열어줘 : 인바운드
        인바운드 -<             아웃바운드.
        클라이언트              서버
        클라이언트 ip           서버 ip
        클라이언트 port         서버 port

        서버 ip              클라이언트 ip
        서버 port            클라이언트 port

        token -> jwt -> oauth2.0
        로그인           로그아웃

        data -> 프로시저에서 가지고 나와서 localstorage  clear

        <form post= 사용자명|나이|주소|직급| > </form> submit
        lnk_des
        ext_app_lnk

        url : http://allSharp.com:80/컨트롤러url.do
        https:// ip주소:443/receiveData.do

    */





        // 스트림 : 데이터 처리 연산을 지원하도록 추출된 연속의 요소
        // 지연평가(깔대기): filter 조건에 맞지 않는 데이터를 미리 걸러낸 뒤, 그 데이터를 변환하지 않음

         // 만약 즉시 평가면
        /**
         * Filtering 1
         * Mapping 1
         * Filtering 2
         * Mapping 2
         * Filtering 3
         * Mapping 3
         * Filtering 4
         * Mapping 4
         * Filtering 5
         * Mapping 5
         * Result: [4, 8]
         */
    }
    /**
     * 중간 연산: 스트림의 상태를 바꾸지만, 실제로는 데이터를 한 번에 읽어들이지 않고 실행되지 않습니다.
     * 예를 들어, filter()나 map()은 스트림의 데이터를 변환하는 과정만 정의하며, 최종 연산이 호출될 때까지 실제 변환 작업은 일어나지 않습니다.
     * 최종 연산: 스트림의 데이터를 하나씩 처리하며, 데이터를 실제로 읽고, 필터링된 결과를 계산합니다.
     * collect() 메서드가 실행되면, 데이터를 실제로 읽고 처리한 후 결과를 반환합니다.
     *
     * 스트림은 기본적으로 "on-demand" 방식으로 데이터를 처리합니다.
     * 즉, 각 데이터는 실제로 필요할 때마다 (예: forEach() 또는 collect()에서) 하나씩 처리됩니다.
     */
}
