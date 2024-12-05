package homework.week1.hyewon;

import generic.bank.NHBankVO;
import generic.bank.WooriBankVO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class BankMain {
    public static void main(String[] args) {
        // WooriBank
        BankDataManager<WooriBankVO> wooriManager = new BankDataManager<>(new ArrayList<>());
        wooriManager.addData(new WooriBankVO("이혜원", 100000, "서울"));
        wooriManager.addData(new WooriBankVO("홍길동", 300000, "인천"));
        System.out.println("WooriBank 모든 데이터: " + wooriManager.getAllData());
        System.out.println("WooriBank 최신 데이터: " + wooriManager.getLatestData());


        // NHBank =
        BankDataManager<NHBankVO> nhManager = new BankDataManager<>(new LinkedList<>());
        nhManager.addData(new NHBankVO("1234-5678-9101-1121", 100000, "2024-11-30"));
        nhManager.addData(new NHBankVO("1111-2222-3333-4444", 200000, "2024-12-02"));
        System.out.println("NHBank 모든 데이터: " + nhManager.getAllData());
        System.out.println("NHBank 최신 데이터: " + nhManager.getLatestData());
        // todo3 이 코드에서 만약에 nhManager.getLatestData().추가적인작업(); 을 한다면? -> NPE발생
        // Optional 로 하면 이런식으로 명시적인 처리가 가능
        Optional<NHBankVO> latestData = nhManager.getLatestData();

        latestData.ifPresentOrElse(
            data -> System.out.println("최신 데이터: " + data),
            () -> System.out.println("데이터가 없습니다.")
        );


        // 중간 데이터 삽입 및 삭제
        nhManager.addDataAt(1, new NHBankVO("2222-3333-4444-5555", 50000, "2024-12-01"));
        System.out.println("NHBank 모든 데이터 (삽입 후): " + nhManager.getAllData());
        nhManager.removeData(1);
        System.out.println("NHBank 모든 데이터 (삭제 후): " + nhManager.getAllData());
        
        
        // todo 불변성 예시
        List<String> initialData = new ArrayList<>();
        initialData.add("Data1");
        BankDataManager<String> manager = new BankDataManager<>(initialData);

        // getAllData로 반환된 리스트 수정
        List<String> externalList = manager.getAllData();
        externalList.add("MaliciousData"); // 외부에서 직접 수정!! new~

        System.out.println("========= 슛!!!`!!!!!!!!!!!!!!!! ==========");
        System.out.println("Manager 내부 데이터: " + manager.getAllData());
    }
}
