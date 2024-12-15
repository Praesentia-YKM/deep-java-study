package homework.week3.kwonmo.domain;

import homework.week3.kwonmo.repository.BudgetDTO;
import homework.week3.kwonmo.repository.ExpenditureDTO;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    private final String department;       // 부서명 (불변)
    private final double allocatedBudget;  // 할당된 예산 (불변)
    private double spentBudget;            // 사용된 예산
    private final List<Expenditure> expenditures = new ArrayList<>(); // 지출 내역

    public Budget(String department, double allocatedBudget) {
        if (allocatedBudget <= 0) {
            throw new IllegalArgumentException("할당 예산은 0보다 커야 합니다.");
        }

        this.department = department;
        this.allocatedBudget = allocatedBudget;
        this.spentBudget = 0.0;
    }

    // 지출 등록 및 예산 사용 갱신
    public void recordExpenditure(String description, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("지출 금액은 0보다 커야 합니다.");
        }

        if (spentBudget + amount > allocatedBudget) {
            throw new IllegalStateException("예산 초과: 남은 예산은 " + getRemainingBudget() + "입니다.");
        }

        spentBudget += amount;
        expenditures.add(new Expenditure(description, amount));
    }

    // DTO로 변환
    public BudgetDTO toDTO() {
        return new BudgetDTO(
            department,
            allocatedBudget,
            spentBudget
        );
    }

    // 지출 내역 요약 반환
    public List<ExpenditureDTO> getExpendituresSummary() {
        List<ExpenditureDTO> summary = new ArrayList<>();

        for (Expenditure expenditure : expenditures) {
            summary.add(expenditure.toDTO());
        }

        return summary;
    }

    private double getRemainingBudget() {
        return allocatedBudget - spentBudget;
    }
}
