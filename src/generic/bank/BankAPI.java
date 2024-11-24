package generic.bank;

import java.util.ArrayList;

public class BankAPI {
    public static void main(String[] args) {
       // 농협 데이터 관리 (ArrayList)
       BankDataManager<NHBankVO> nhManager = new BankDataManager<>() {
           {
               dataList = new ArrayList<>();
           }
       };

       // 우리은행 데이터 관리 (ArrayList)
       BankDataManager<WooriBankVO> wooriManager = new BankDataManager<>() {
           {
               dataList = new ArrayList<>();
           }
       };

       // 농협 데이터 추가
       nhManager.addData(new NHBankVO("1234-5678-9012", 50000, "2024-11-21"));
       nhManager.addData(new NHBankVO("2345-6789-0123", 10000, "2024-11-22"));

       // 우리은행 데이터 추가
       wooriManager.addData(new WooriBankVO("홍길동", 30000, "서울"));
       wooriManager.addData(new WooriBankVO("김철수", 15000, "부산"));

       // 농협 데이터 출력
       System.out.println("=== 농협 데이터 ===");
       printData(nhManager.getAllData());
       System.out.println("가장 최근 데이터: " + nhManager.getLatestData());

       // 우리은행 데이터 출력
       System.out.println("\n=== 우리은행 데이터 ===");
       printData(wooriManager.getAllData());
       System.out.println("가장 최근 데이터: " + wooriManager.getLatestData());
   }

   private static <T> void printData(java.util.List<T> dataList) {
       for (T data : dataList) {
           System.out.println(data);
       }
   }
}
