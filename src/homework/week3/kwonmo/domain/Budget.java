package homework.week3.kwonmo.domain;

import homework.week3.kwonmo.repository.BudgetDTO;
import homework.week3.kwonmo.repository.ExpenditureDTO;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Budget {
    private final String department;       // 부서명 (불변)
    private final double allocatedBudget;  // 할당된 예산 (불변)
    private double spentBudget;            // 사용된 예산

    // TODO 1: 지출내역(expenditures) 에 대한 멤버변수 타입 지정해보기
    private final Deque<Expenditure> expenditures = new ArrayDeque<>(); // 지출 내역 (최대 5개)

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

        // TODO <지출 히스토리 제한>
        // TODO 2: 각 부서의 지출 내역은 최근 5개까지만 유지되도록 구현하세요.
        // TODO 3: 새로운 지출이 추가되면 가장 오래된 기록은 자동으로 삭제되어야 합니다.

        if (expenditures.size() == 5) {
            Expenditure oldest = expenditures.removeLast(); // 가장 오래된 지출 삭제
            spentBudget -= oldest.getAmount(); // 총 사용 예산에서 제거
        }

        expenditures.addFirst(new Expenditure(description, amount));
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

//    public List<ExpenditureDTO> getExpendituresSummary() {
//        return expenditures.stream()
//                .map(Expenditure::toDTO)
//                .collect(Collectors.toList());
//    }

    public String getDepartment() {
        return department;
    }

    public double getSpentBudget() {
        return spentBudget;
    }

    public double getRemainingBudget() {
        return allocatedBudget - spentBudget;
    }
}
