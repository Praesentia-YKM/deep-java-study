package homework.week3.kwonmo.repository;

public class ExpenditureDTO {
    private final String description; // 지출 내용
    private final double amount;      // 지출 금액

    public ExpenditureDTO(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("지출 내용: %s, 금액: %.2f", description, amount);
    }
}
