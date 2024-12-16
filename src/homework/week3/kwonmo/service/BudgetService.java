package homework.week3.kwonmo.service;

import homework.week3.kwonmo.domain.Budget;
import homework.week3.kwonmo.repository.BudgetDTO;
import homework.week3.kwonmo.repository.ExpenditureDTO;

import java.util.*;

public class BudgetService {
    // TODO 1 아래 코드를 보고 budgets이라는 명칭의 멤버변수 타입을 지정해보세요
    private final Map<String, Budget> budgets = new HashMap<>();

    // 예산 등록
    public void registerBudget(String department, double allocatedBudget) {
        budgets.put(department, new Budget(department, allocatedBudget));
        System.out.println("예산이 등록되었습니다: " + department);
    }

    // 특정 부서의 예산 조회
    public BudgetDTO getBudget(String department) {
        Budget budget = findBudget(department);
        return budget.toDTO();
    }

    // 모든 예산 조회
    public List<BudgetDTO> getAllBudgets() {
        List<BudgetDTO> budgetList = new ArrayList<>();
        budgets.values().forEach(budget -> budgetList.add(budget.toDTO()));
        return budgetList;
    }

    // 특정 부서에 지출 기록
    public void recordExpenditure(String department, String description, double amount) {
        Budget budget = findBudget(department);
        budget.recordExpenditure(description, amount);
        System.out.println("지출이 등록되었습니다.");
    }

    // TODO findBudget과 getExpendituresSummary 사용하여
    //  getExpenditures 메서드 작성 -> 특정 부서의 지출 내역 조회 (최대 5개)
    public Queue<ExpenditureDTO> getExpenditures(String department) {
        Budget budget = findBudget(department);
        return new LinkedList<>(budget.getExpendituresSummary());
    }

    // TODO 최다 지출 부서 조회메서드 나머지 작성
    // 구현1
//    public String getTopSpendingDepartment() {
//        if (budgets.isEmpty()) {
//            return "등록된 예산이 없습니다.";
//        }
//
//        String topDepartment = null;
//        double maxSpent = -1;
//
//        for (Budget budget : budgets.values()) {
//            if (budget.getSpentBudget() > maxSpent ||
//                (budget.getSpentBudget() == maxSpent && (topDepartment == null || budget.getDepartment().compareTo(topDepartment) < 0))) {
//                topDepartment = budget.getDepartment();
//                maxSpent = budget.getSpentBudget();
//            }
//        }
//
//        return topDepartment != null ? topDepartment : "등록된 예산이 없습니다.";
//    }

    // 구현2
    public String getTopSpendingDepartment() {
        if (budgets.isEmpty()) {
            return "등록된 예산이 없습니다.";
        }

        String topDepartment = null;
        double maxSpent = -1;

        for (Map.Entry<String, Budget> entry : budgets.entrySet()) {
            String department = entry.getKey();
            Budget budget = entry.getValue();

            if (budget.getSpentBudget() > maxSpent ||
                (budget.getSpentBudget() == maxSpent && (topDepartment == null || department.compareTo(topDepartment) < 0))) {
                topDepartment = department;
                maxSpent = budget.getSpentBudget();
            }
        }

        return topDepartment != null ? topDepartment : "등록된 예산이 없습니다.";
    }
    // 구현 3
//    public String getTopSpendingDepartment() {
//        if (budgets.isEmpty()) {
//            return "등록된 예산이 없습니다.";
//        }
//
//        return budgets.values().stream()
//                .max(Comparator.comparingDouble(Budget::getSpentBudget)
//                        .thenComparing(Budget::getDepartment))
//                .map(Budget::getDepartment)
//                .orElse("등록된 예산이 없습니다.");
//    }

    // 남은 예산 조회
    public double getRemainingBudget(String department) {
        Budget budget = findBudget(department);
        return budget.getRemainingBudget();
    }

    // 부서 존재 확인
    private Budget findBudget(String department) {
        if (!budgets.containsKey(department)) {
            throw new IllegalArgumentException("해당 부서 예산이 존재하지 않습니다: " + department);
        }

        return budgets.get(department);
    }
}
