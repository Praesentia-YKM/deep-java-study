package homework.week3.kwonmo.service;

import homework.week3.kwonmo.domain.Budget;
import homework.week3.kwonmo.repository.BudgetDTO;
import homework.week3.kwonmo.repository.ExpenditureDTO;

import java.util.*;

public class BudgetService {
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
        for (Budget budget : budgets.values()) {
            budgetList.add(budget.toDTO());
        }
        return budgetList;
    }

    // 특정 부서에 지출 기록
    public void recordExpenditure(String department, String description, double amount) {
        Budget budget = findBudget(department);
        budget.recordExpenditure(description, amount);
        System.out.println("지출이 등록되었습니다.");
    }

    // 특정 부서의 지출 내역 조회
    public List<ExpenditureDTO> getExpenditures(String department) {
        Budget budget = findBudget(department);
        return budget.getExpendituresSummary();
    }

    // 부서 존재 확인
    private Budget findBudget(String department) {
        if (!budgets.containsKey(department)) {
            throw new IllegalArgumentException("해당 부서 예산이 존재하지 않습니다: " + department);
        }
        return budgets.get(department);
    }
}

