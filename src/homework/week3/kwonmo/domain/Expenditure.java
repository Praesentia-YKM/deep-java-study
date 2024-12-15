package homework.week3.kwonmo.domain;

import homework.week3.kwonmo.repository.ExpenditureDTO;

public class Expenditure {
    private final String description; // 지출 내용
    private final double amount;      // 지출 금액 (불변)

    public Expenditure(String description, double amount) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("지출 내용은 비어 있을 수 없습니다.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("지출 금액은 0보다 커야 합니다.");
        }

        this.description = description;
        this.amount = amount;
    }

    // DTO로 변환
    public ExpenditureDTO toDTO() {
        return new ExpenditureDTO(description, amount);
    }

    @Override
    public String toString() {
        return String.format("지출 내용: %s, 금액: %.2f", description, amount);
    }
}

