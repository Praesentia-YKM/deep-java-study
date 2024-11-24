package generic.bank;

/**
 * ArrayList가 적합한 경우
 * 데이터 조회가 빈번한 경우.
 * 데이터를 순차적으로 추가/삭제하는 경우.
 * 메모리 사용량이 중요한 경우.
 * LinkedList가 적합한 경우
 * 데이터의 중간 삽입/삭제가 빈번한 경우.
 * 데이터의 크기가 가변적이고, 배열 크기 조정을 피하고 싶은 경우.
 * 메모리 조각화나 크기 예측이 어려운 경우.
 */

public class BankDataManagerTest {
    // todo: arrayList가 중간데이터 삽입/삭제가 더 느려야하는데 데이터 수가 10000 정도밖에 안될땐
    //  arraylist가 예상치 못하게 더 빠르게 나오는 경우가 있다. 이는 ArrayList는 데이터 복사를 위한 System.arraycopy() 메서드를 사용하며,
    //  이는 네이티브 코드로 최적화되어 매우 빠르게 작동하기 때문
    public static void main(String[] args) {
        // 농협 ArrayList 성능 테스트
        System.out.println("=== 농협 ArrayList 성능 테스트 ===");
        BankDataManager<NHBankVO> nhArrayListManager = new BankDataManagerArrayList<>();
        runPerformanceTest(nhArrayListManager, "농협");

        // 농협 LinkedList 성능 테스트
        System.out.println("\n=== 농협 LinkedList 성능 테스트 ===");
        BankDataManager<NHBankVO> nhLinkedListManager = new BankDataManagerLinkedList<>();
        runPerformanceTest(nhLinkedListManager, "농협");

        // 우리은행 ArrayList 성능 테스트
        System.out.println("\n=== 우리은행 ArrayList 성능 테스트 ===");
        BankDataManager<WooriBankVO> wooriArrayListManager = new BankDataManagerArrayList<>();
        runPerformanceTest(wooriArrayListManager, "우리은행");

        // 우리은행 LinkedList 성능 테스트
        System.out.println("\n=== 우리은행 LinkedList 성능 테스트 ===");
        BankDataManager<WooriBankVO> wooriLinkedListManager = new BankDataManagerLinkedList<>();
        runPerformanceTest(wooriLinkedListManager, "우리은행");
    }

    private static <T> void runPerformanceTest(BankDataManager<T> manager, String bankName) {
        // 대량 데이터 추가
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            if (bankName.equals("농협")) {
                manager.addData((T) new NHBankVO("Card-" + i, i * 100, "2024-11-22"));
            } else if (bankName.equals("우리은행")) {
                manager.addData((T) new WooriBankVO("고객-" + i, i * 100, "도시-" + i));
            }
        }
        long endTime = System.nanoTime();
        System.out.println("대량 데이터 추가 시간: " + (endTime - startTime) / 1_000_000.0 + "ms");

        // 중간 데이터 삽입
        startTime = System.nanoTime();
        if (bankName.equals("농협")) {
            manager.addDataAt(50000, (T) new NHBankVO("MidCard", 99999, "2024-11-23"));
        } else if (bankName.equals("우리은행")) {
            manager.addDataAt(50000, (T) new WooriBankVO("중간고객", 99999, "중간도시"));
        }
        endTime = System.nanoTime();
        System.out.println("중간 데이터 삽입 시간: " + (endTime - startTime) / 1_000_000.0 + "ms");

        // 중간 데이터 삭제
        startTime = System.nanoTime();
        manager.removeData(50000);
        endTime = System.nanoTime();
        System.out.println("중간 데이터 삭제 시간: " + (endTime - startTime) / 1_000_000.0 + "ms");

        // 특정 데이터 조회
        startTime = System.nanoTime();
        manager.getAllData().get(50000);
        endTime = System.nanoTime();
        System.out.println("특정 데이터 조회 시간: " + (endTime - startTime) / 1_000_000.0 + "ms");
    }
}

