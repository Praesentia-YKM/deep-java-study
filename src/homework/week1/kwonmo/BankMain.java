package homework.week1.kwonmo;

import java.util.List;

public class BankMain {
    public static void main(String[] args) {
        // 농협 데이터 관리
        BankDataManager<NHBankVO> nhManager = new BankDataManagerArrayList<>();
        BankDataManager<NHBankVO> nhManager1 = new BankDataManagerLinkedList<>();

        // 우리은행 데이터 관리
        BankDataManager<WooriBankVO> wooriManager = new BankDataManagerLinkedList<>();

        // 농협 데이터 추가
        nhManager.addData(new NHBankVO("1234-5678-9012", 50000, "2024-11-21"));
        nhManager.addData(new NHBankVO("2345-6789-0123", 10000, "2024-11-22"));

        // 우리은행 데이터 추가
        wooriManager.addData(new WooriBankVO("양권모", 30000, "서울"));
        wooriManager.addData(new WooriBankVO("정태환", 15000, "부산"));

        // 농협 데이터 조회
        System.out.println("=== 농협 데이터 ===");
        printData(nhManager.getAllData());
        nhManager.getLatestData()
                 .ifPresentOrElse(
                         data -> System.out.println("가장 최근 데이터: " + data),
                         () -> System.out.println("데이터가 없습니다.")
                 );

        // 우리은행 데이터 조회
        System.out.println("\n=== 우리은행 데이터 ===");
        printData(wooriManager.getAllData());
        wooriManager.getLatestData()
                    .ifPresentOrElse(
                            data -> System.out.println("가장 최근 데이터: " + data),
                            () -> System.out.println("데이터가 없습니다.")
                    );

        // 농협 데이터 삭제
        System.out.println("\n농협 데이터 삭제:");
        nhManager.removeData(0); // 첫 번째 데이터 삭제
        printData(nhManager.getAllData());

        // 우리은행 데이터 삭제
        System.out.println("\n우리은행 데이터 삭제:");
        wooriManager.removeData(1); // 두 번째 데이터 삭제
        printData(wooriManager.getAllData());

        // 농협 데이터 검색
        nhManager.searchById("2345-6789-0123")
                 .ifPresentOrElse(
                         data -> System.out.println("\n검색된 농협 데이터: " + data),
                         () -> System.out.println("검색된 데이터가 없습니다.")
                 );

        // 우리은행 데이터 검색
        wooriManager.searchById("양권모")
                    .ifPresentOrElse(
                            data -> System.out.println("\n검색된 우리은행 데이터: " + data),
                            () -> System.out.println("검색된 데이터가 없습니다.")
                    );
    }

    private static <T extends BankVO> void printData(List<T> dataList) {
        for (T data : dataList) {
            System.out.println(data);
        }
        // dataList.forEach(System.out::println);
    }
}
