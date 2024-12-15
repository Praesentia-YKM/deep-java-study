package homework.week3.kwonmo;

import homework.week3.kwonmo.repository.BudgetDTO;
import homework.week3.kwonmo.repository.ExpenditureDTO;
import homework.week3.kwonmo.service.BudgetService;

import java.util.List;
import java.util.Scanner;

public class ErpMain {
    private static final BudgetService service = new BudgetService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== 예산-지출 관리 시스템 ===");
            System.out.println("1. 예산 등록");
            System.out.println("2. 예산 조회");
            System.out.println("3. 지출 등록");
            System.out.println("4. 지출 내역 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: registerBudget(); break;
                    case 2: displayAllBudgets(); break;
                    case 3: registerExpenditure(); break;
                    case 4: displayExpenditureSummary(); break;
                    case 5: System.out.println("시스템 종료."); return;
                    default: System.out.println("잘못된 입력입니다. 다시 시도해주세요.");

//                    switch (choice) { // java 14
//                        case 1 -> registerBudget();
//                        case 2 -> displayBudgetSummary();
//                        case 3 -> registerExpenditure();
//                        case 4 -> displayExpenditureSummary();
//                        case 5 -> {
//                            System.out.println("시스템 종료.");
//                            return;
//                        }
//                        default -> System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
//                    }
                }
            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void registerBudget() {
        System.out.print("부서명: ");
        String department = scanner.next();
        System.out.print("할당 예산: ");
        double amount = scanner.nextDouble();

        service.registerBudget(department, amount);
    }

    private static void displayAllBudgets() {
        List<BudgetDTO> budgetList = service.getAllBudgets();
        for (BudgetDTO dto : budgetList) {
            System.out.println(dto);
        }
    }

    private static void registerExpenditure() {
        System.out.print("부서명: ");
        String department = scanner.next();
        System.out.print("지출 내용: ");
        String description = scanner.next();
        System.out.print("지출 금액: ");
        double amount = scanner.nextDouble();

        service.recordExpenditure(department, description, amount);
    }

    private static void displayExpenditureSummary() {
        System.out.print("조회할 부서명: ");
        String department = scanner.next();

        try {
            List<ExpenditureDTO> expenditures = service.getExpenditures(department);
            for (ExpenditureDTO dto : expenditures) {
                System.out.println(dto);
            }
        } catch (Exception e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
