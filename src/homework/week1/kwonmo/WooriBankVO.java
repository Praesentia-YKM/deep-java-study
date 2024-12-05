package homework.week1.kwonmo;

public class WooriBankVO implements BankVO {
    private String customerName;
    private int amount;
    private String location;

    public WooriBankVO(String customerName, int amount, String location) {
        this.customerName = customerName;
        this.amount = amount;
        this.location = location;
    }

    @Override
    public String getId() {
        return customerName; // 고유 식별자로 고객 이름 반환
    }

    @Override
    public String toString() {
        return "WooriBankVO{" +
                "customerName='" + customerName + '\'' +
                ", amount=" + amount +
                ", location='" + location + '\'' +
                '}';
    }
}